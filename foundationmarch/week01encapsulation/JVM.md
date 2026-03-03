# JVM Architecture - Complete Guide

## 🎯 Overview

### What is JVM?
**Java Virtual Machine (JVM)** is a platform-dependent runtime environment that executes bytecode and converts it into machine code.

**Key Point:** Java is "Write Once, Run Anywhere" because JVM is platform-specific, not the Java code!

---

## 🔧 JVM Ecosystem

### JVM (Java Virtual Machine)
- Executes bytecode (.class files)
- Platform-dependent (different JVM for Windows/Linux/Mac)
- Handles memory management and garbage collection

### JRE (Java Runtime Environment)
- JVM + Standard Libraries (java.lang, java.util, etc.)
- Needed to **run** Java applications
- Users need JRE, not JDK

### JDK (Java Development Kit)
- JRE + Development Tools (javac, javadoc, debugger)
- Needed to **develop** Java applications
- Developers need JDK

```
JDK = JRE + Development Tools
JRE = JVM + Libraries
```

---

## 🏗️ JVM Architecture

The JVM has **3 main subsystems**:

### 1. Class Loader Subsystem
Loads `.class` files into memory through 3 steps:

#### **Loading:** 3 types of class loaders
- **Bootstrap Class Loader**: Loads core Java classes (`java.lang.*`)
- **Extension Class Loader**: Loads extension libraries (`lib/ext/`)
- **Application Class Loader**: Loads application classes (your code!)

#### **Linking:**
- **Verification**: Checks bytecode is valid
- **Preparation**: Allocates memory for static variables
- **Resolution**: Replaces symbolic references with actual memory addresses

#### **Initialization:**
- Executes static blocks
- Initializes static variables

---

### 2. Runtime Data Areas (Memory)

#### **📚 Method Area (Metaspace)**
- Stores class metadata, static variables, constant pool
- Shared among all threads
- Previously called "PermGen" (before Java 8)

#### **🗄️ Heap Memory**
- **Purpose**: Stores objects and instance variables
- **Allocation**: Dynamic (objects created with `new`)
- **Scope**: Global - accessible by all threads
- **Lifecycle**: Objects live until Garbage Collected
- **Size**: Larger than Stack

**Example:**
```java
User user = new User("John", "john@mail.com", "pass123");
// 'user' reference → Stack
// User object {"John", "john@mail.com", "pass123"} → Heap
```

#### **📦 Stack Memory**
- **Purpose**: Stores local variables, method calls, partial results
- **Structure**: LIFO (Last In, First Out)
- **Allocation**: Each thread has its own stack
- **Scope**: Method-level - destroyed when method exits
- **Lifecycle**: Variables live only during method execution
- **Size**: Smaller, fixed size

**Example:**
```java
public void calculate() {
    int x = 10;        // x → Stack
    int y = 20;        // y → Stack
    int sum = x + y;   // sum → Stack
} // x, y, sum destroyed when method exits
```

#### **🧵 PC Register (Program Counter)**
- Stores address of current instruction being executed
- Each thread has its own PC Register

#### **🔧 Native Method Stack**
- Stores native method (C/C++) information
- Used when calling JNI (Java Native Interface)

---

### 3. Execution Engine

#### **🔄 Interpreter**
- Reads bytecode line-by-line
- Executes instructions one at a time
- **Slow** for repeated code

#### **⚡ JIT Compiler (Just-In-Time)**
- Identifies "hot code" (frequently executed methods)
- Compiles bytecode → native machine code
- **Fast** - native code runs directly on CPU
- Example: Loop executed 10,000 times → JIT compiles it!

#### **🗑️ Garbage Collector**
- Automatically removes unused objects from Heap
- Reclaims memory
- Prevents memory leaks

---

## 💾 Memory Management Deep Dive

### Stack vs Heap Comparison

| Feature | Stack | Heap |
|---------|-------|------|
| **Stores** | Local variables, method calls | Objects, instance variables |
| **Structure** | LIFO (ordered) | Unordered |
| **Access** | Fast (direct) | Slower (via reference) |
| **Thread Safety** | Each thread has own stack | Shared across threads |
| **Size** | Small (1-2 MB) | Large (configurable) |
| **Allocation** | Automatic | Manual (`new` keyword) |
| **Deallocation** | Automatic (method exit) | Garbage Collection |
| **Error** | StackOverflowError | OutOfMemoryError |

### Visual Example:
```java
public class Example {
    public static void main(String[] args) {
        int a = 10;                    // → Stack
        String name = "John";          // → "John" reference in Stack
                                       //    String object in Heap (String Pool)
        User user = new User();        // → 'user' reference in Stack
                                       //    User object in Heap
        user.setName("Alice");         // → "Alice" stored in Heap
    }
}
```

**Memory Layout:**
```
STACK                           HEAP
─────                           ────────────────────
main() frame:                   User object:
  a = 10                          name = "Alice"
  name → ────────────────────→  [Memory Address: 0x1234]
  user → ────────────────────→  
                                String "John" (String Pool)
                                [Memory Address: 0x5678]
```

---

## 🗑️ Garbage Collection

### How GC Works:

#### **1. Mark Phase**
- GC identifies which objects are reachable (still in use)
- Starts from "GC Roots" (static variables, active threads, etc.)

#### **2. Sweep Phase**
- Removes unreachable objects
- Reclaims memory

#### **3. Compact Phase** (optional)
- Moves surviving objects together
- Reduces memory fragmentation

### Types of GC:
- **Serial GC**: Single thread (small apps)
- **Parallel GC**: Multiple threads (default)
- **G1 GC**: Large heaps, predictable pauses
- **ZGC**: Ultra-low latency (Java 15+)

### Example:
```java
public void createUser() {
    User user1 = new User("Alice");  // Heap allocation
    User user2 = new User("Bob");    // Heap allocation
    
    user1 = null;  // user1 object now eligible for GC!
    
    // GC will eventually remove Alice object
    // Bob object still referenced by user2
}
```

---

## 🔄 Pass by Value vs Pass by Reference

### ⚠️ Important: Java is ALWAYS Pass-by-Value!

But it can be confusing with objects...

### Primitive Types (Pass-by-Value):
```java
public void modify(int x) {
    x = 100;  // Only modifies local copy
}

int a = 10;
modify(a);
System.out.println(a);  // Still 10! Original unchanged
```

### Objects (Pass-by-Value... of the Reference!):
```java
public void modify(User user) {
    user.setName("Changed");  // DOES modify object
    user = null;              // Does NOT affect original reference
}

User user1 = new User("John");
modify(user1);
System.out.println(user1.getName());  // "Changed" - object modified
System.out.println(user1);            // Not null! Reference unchanged
```

**Explanation:**
- The **reference** (memory address) is passed by value
- You can modify the object it points to
- But you can't change what the original variable points to

**Analogy:**
```
Pass-by-Value is like giving someone a COPY of your house address.
They can:
  ✅ Go to your house and rearrange furniture (modify object)
  ❌ Change where YOUR address points to (can't change your reference)
```

---

## 📝 Summary

### Key Takeaways:
1. ✅ **JVM** executes bytecode, is platform-dependent
2. ✅ **JIT** optimizes hot code for performance
3. ✅ **Stack**: Local vars, fast, LIFO, small
4. ✅ **Heap**: Objects, slower, dynamic, large
5. ✅ **GC**: Automatic memory management
6. ✅ **Java**: Always pass-by-value (even for objects!)

### Common Interview Questions:
1. "Explain Stack vs Heap" → See comparison table above
2. "How does GC work?" → Mark, Sweep, Compact
3. "Is Java pass-by-reference?" → NO! Always pass-by-value
4. "What is JIT?" → Compiles hot code to native

---

## 🎯 Practice Questions (Test Yourself!)

1. Where is the `User` object stored in: `User u = new User()`?
   - **Answer:** Heap (object), Stack (reference 'u')

2. What happens to local variables when a method exits?
   - **Answer:** Destroyed/removed from Stack

3. Can you change what an object reference points to inside a method?
   - **Answer:** No - pass-by-value of reference!
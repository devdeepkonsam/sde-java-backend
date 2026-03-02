public class User {
    private String name;
    private String email;
    private String password;

    public String getName() { return name;}
    public String getEmail(){ return email;} 
    public String getPassword() { return password;}
    
    public void setName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name must be at least 2 characters");
        }
        this.name = name;
    }
    
    public void setEmail(String email) {
        if (!email.contains("@") || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }
    
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        this.password = password;
    }
    
    @SuppressWarnings(value = { "" })
    public User(String name, String email, String password) {
        setName(name);          // Uses validation
        setEmail(email);        // Uses validation
        setPassword(password);  // Uses validation
    }
    
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
    
    public void displayInfo() {
        System.out.println("=== User Information ===");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + "*".repeat(password.length()));
    }
}
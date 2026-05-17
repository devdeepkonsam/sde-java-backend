package dsasolutions.month2stacklinkedlists;

public class MinStack {
    int[] stack;
    int index;
    public MinStack() {
        stack = new int[100000];
        index = -1;
    }
    
    public void push(int val) {
        stack[++index] = val;
    }
    
    public void pop() {
        stack[index--] = 0;
    }
    
    public int top() {
        return stack[index];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= index; i++) {
            if (stack[i] < min) {
                min = stack[i];
            }
        }
        return min;
    }
}

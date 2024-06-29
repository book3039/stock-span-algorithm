public class MyStack {

    private static final int MAX_SIZE = 1000;

    private int[] stack;
    private int top;

    public MyStack() {
        stack = new int[MAX_SIZE];
        top = -1;
    }

    public void push(int i) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = i;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public int size() {
        return top + 1;
    }
}

package maksym.preparation.medium;

public class MinStack {
    protected static class ListF {
        public final int val;
        public final ListF next;
        public ListF(int val, ListF next) {
            this.val = val;
            this.next = next;
        }

    }

    private ListF head = null;
    private ListF minH = null;

    public MinStack() {}

    public void push(int val) {
        head = new ListF(val, head);
        updateMin(val);
    }

    public void pop() {
        if (head.val == minH.val) {
            minH = minH.next;
        }
        head = head.next;

    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minH.val;
    }

    private void updateMin(int num) {
        if (minH == null || num <= minH.val) {
            minH = new ListF(num, minH);
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.pop();
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(5);
        stack.push(-1);
        stack.push(0);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}

package maksym.preparation.medium;

import java.util.*;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                if (!str.equals(".") && !str.isEmpty()) {
                    deque.offerLast(str);
                }
            }
        }
        return "/" + String.join("/", deque);
    }

    public static void main(String[] args) {
        SimplifyPath instance = new SimplifyPath();

        System.out.println(instance.simplifyPath("/home/user/Documents///../Pictures/"));
        System.out.println(instance.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(instance.simplifyPath("/..//...//b/d//"));
    }
}

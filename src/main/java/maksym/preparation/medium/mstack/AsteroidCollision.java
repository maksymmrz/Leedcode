package maksym.preparation.medium.mstack;

import maksym.preparation.util.Util;

import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new LinkedList<>();

        for (int a : asteroids) {
            while (!st.isEmpty() && st.peek() > 0 && st.peek() < -a) st.pop();
            if (!st.isEmpty() && st.peek() > 0 && st.peek() == -a) {
                st.pop();
            } else if (st.isEmpty() || a > 0 || st.peek() < 0) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = 0; i < res.length && !st.isEmpty(); i++) {
            res[i] = st.pollLast();
        }

        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision o = new AsteroidCollision();
        Util.show(o.asteroidCollision(new int[]{5, 10, -5}));
        Util.show(o.asteroidCollision(new int[]{15, 5, 10, -11, 1}));
    }
}

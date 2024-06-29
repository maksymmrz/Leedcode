package maksym.preparation.easy;

public class SqrtX {

    public int mySqrt(int x) {
        long l = 1;
        long r = x;

        while (l < r) {
            long mid = (l + r) / 2;

            if (mid * mid < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        long res = (l + r) / 2;

        if (res * res > x) return (int) (res - 1);
        else return (int) res;
    }

    public static void main(String[] args) {
        SqrtX instance = new SqrtX();
        System.out.println(instance.mySqrt(69));
        System.out.println(instance.mySqrt(1));
        System.out.println(instance.mySqrt(900));
    }
}

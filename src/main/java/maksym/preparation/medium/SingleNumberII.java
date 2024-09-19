package maksym.preparation.medium;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            one = (num & ~two) ^ one;
            two = (num & ~one) ^ two;
        }
        return one;
    }

    public static void main(String[] args) {
        SingleNumberII instance = new SingleNumberII();
        System.out.println(instance.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(instance.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}

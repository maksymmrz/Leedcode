package maksym.preparation.hard.bsearch;

public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 0;
        int right = 0;

        for (int sw : sweetness) {
            right += sw;
        }

        while (left < right) {
            int minSw = (left + right + 1) / 2;
            if (countPeople(sweetness, minSw) < k + 1) right = minSw - 1;
            else left = minSw;
        }
        return left;
    }

    private int countPeople(int[] sweetness, int minSweet) {
        int people = 0;
        int sum = 0;

        for (int sw : sweetness) {
            sum += sw;

            if (sum >= minSweet) {
                people++;
                sum = 0;
            }
        }
        return people;
    }



    public static void main(String[] args) {
        DivideChocolate o = new DivideChocolate();
        System.out.println(o.maximizeSweetness(new int[]{1, 2, 2, 1, 2, 2, 1, 2, 2}, 2));
        System.out.println(o.maximizeSweetness(new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4}, 8));
        System.out.println(o.maximizeSweetness(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    }
}

package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {
    protected static class Data {
        public final int gen;
        public final int value;

        public Data(int value, int gen) {
            this.gen = gen;
            this.value = value;
        }
    }
    private final List<List<Data>> array;
    private final int size;
    private int generation;

    public SnapshotArray(int length) {
        array = new ArrayList<>(length);
        size = length;
        generation = 0;
        for (int i = 0; i < length; i++) {
            array.add(new ArrayList<>());
        }
    }

    public void set(int index, int val) {
        if (index < size) {
            array.get(index).add(new Data(val, generation));
        }
    }

    public int snap() {
        return generation++;
    }

    public int get(int index, int snap_id) {
        List<Data> gens = array.get(index);

        int l = 0;
        int r = gens.size() - 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (gens.get(m).gen > snap_id) r = m - 1;
            else l = m;
        }
        if (l < gens.size() && gens.get(l).gen <= snap_id) return gens.get(l).value;
        else return 0;
    }

    public static void main(String[] args) {
        SnapshotArray arr = new SnapshotArray(3);
        arr.set(0, 100);
        arr.set(1, 202);
        System.out.println("snapshot:" + arr.snap());
        arr.set(2, 303);
        arr.set(0, 103);
        System.out.println(arr.get(0, 2));
        System.out.println(arr.get(1, 2));
        System.out.println(arr.get(2, 2));
        System.out.println();

        SnapshotArray arr1 = new SnapshotArray(4);
        arr1.snap();
        arr1.snap();
        System.out.println(arr1.get(3, 1));
        arr1.set(2, 4);
    }
}

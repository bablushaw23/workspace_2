import java.util.ArrayList;
import java.util.List;

class PowerSet {
    public static List<List<Integer>> subSets(int[] nums) {
        /*
         * Logic
         * 1. Add empty subset: {}
         * 2. for each element of nums, add the elem to each available subsets but as a
         * new subset, like
         * available: {},{3,2} then add(1): {},{1},{3,2},{3,2,1}
         */
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<Integer>()); // add empty list

        for (int elem : nums) {
            int n = sets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newList = new ArrayList<>(sets.get(i));
                newList.add(elem);
                sets.add(newList);
            }
        }
        return sets;
    }

    public static void main(String[] args) {
        System.out.println(subSets(new int[] { 1, 2, 3 }).toString());
    }
}
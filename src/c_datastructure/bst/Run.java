package c_datastructure.bst;

public class Run {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] nums = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (Integer num : nums) {
            bst.insert(num);
        }

        for (Integer num : nums) {
            System.out.println(bst.find(num));
        }

        System.out.println(bst.find(99999));

    }
}

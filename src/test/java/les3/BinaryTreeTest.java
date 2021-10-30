package les3;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testNext() {
        BinaryTree tree = new BinaryTree();
        int[] arr = {20, 7, 4, 6, 9, 35, 31, 40, 28, 38, 52};
        for (int i : arr) {
            tree.insert(i);
        }

//        tree.printDeepRecursive();
//        System.out.println(" ========================================== ");
//        tree.printDeep();
//        System.out.println(" ========================================== ");
//        tree.printWide();
//        System.out.println(" ========================================== ");

        Assert.assertEquals(6, tree.next(4));
        Assert.assertEquals(7, tree.next(6));
        Assert.assertEquals(9, tree.next(7));
        Assert.assertEquals(20, tree.next(9));
        Assert.assertEquals(28, tree.next(20));
        Assert.assertEquals(38, tree.next(35));
        Assert.assertEquals(35, tree.next(31));
        Assert.assertEquals(31, tree.next(28));
        Assert.assertEquals(52, tree.next(40));
        Assert.assertEquals(40, tree.next(38));
        Assert.assertEquals(52, tree.next(52));
    }
}
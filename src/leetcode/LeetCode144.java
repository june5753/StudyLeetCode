package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的遍历总结
 */
public class LeetCode144 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
        }
    }

    /**
     * 生成二叉树 （练习难点）
     *
     * @param inputList
     * @return
     */
    private static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        //Removes and returns the first element from this list
        Integer data = inputList.removeFirst();

        //开始递归
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    //二叉树的前序遍历
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    //https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/di-gui-he-die-dai-by-powcai-5/

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        System.out.println(list);//[3, 1, 2]
        return list;

    }

    private static void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);

    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, null, 1, 2));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, null, 1, 2}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序排列：");
        preorderTraversal2(treeNode);
    }
}

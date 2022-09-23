package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer37 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    int index = 0;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        String s = "";
        s += root.val + ",";
        s += serialize(root.left);
        s += serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        return des(strs);
    }

    public TreeNode des(String[] data) {
        if (index == data.length) {
            return null;
        }
        TreeNode root = new TreeNode();
        if ("null".equals(data[index])) {
            index++;
            return null;
        }
        root.val = Integer.parseInt(data[index]);
        index++;
        root.left = des(data);
        root.right = des(data);
        return root;
    }

    @Test
    public void show() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;
        String data = serialize(r1);
        System.out.println(deserialize(data));
    }

}

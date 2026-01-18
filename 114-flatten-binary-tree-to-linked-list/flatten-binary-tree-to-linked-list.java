class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;

        // Flatten left and right subtrees
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        // If left subtree exists, rewire connections
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // Return the tail node
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}

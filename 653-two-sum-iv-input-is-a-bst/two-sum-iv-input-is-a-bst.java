import java.util.*;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {

        if (root == null) {
            return false;
        }

        int required = k - root.val;

        if (set.contains(required)) {
            return true;
        }

        set.add(root.val);

        return dfs(root.left, k, set) ||
               dfs(root.right, k, set);
    }
}
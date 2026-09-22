class Solution {
    static class Node {
        int[] pref;
        int product;

        Node(int k) {
            pref = new int[k];
        }
    }

    int n, k;
    int[][] pref;
    int[] product;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        pref = new int[4 * n][k];
        product = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.pref[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int rem = nums[l] % k;
            product[node] = rem;
            pref[node][rem] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node);
    }

    void update(int node, int l, int r, int idx, int value) {
        if (l == r) {
            for (int i = 0; i < k; i++) {
                pref[node][i] = 0;
            }

            int rem = value % k;
            product[node] = rem;
            pref[node][rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, value);
        }

        merge(node);
    }

    void merge(int node) {
        int left = node * 2;
        int right = node * 2 + 1;

        int leftProduct = product[left];

        product[node] = (leftProduct * product[right]) % k;

        for (int i = 0; i < k; i++) {
            pref[node][i] = pref[left][i];
        }

        for (int i = 0; i < k; i++) {
            int newRem = (leftProduct * i) % k;
            pref[node][newRem] += pref[right][i];
        }
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            Node res = new Node(k);

            res.product = product[node];

            for (int i = 0; i < k; i++) {
                res.pref[i] = pref[node][i];
            }

            return res;
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        Node res = new Node(k);

        res.product = (left.product * right.product) % k;

        for (int i = 0; i < k; i++) {
            res.pref[i] = left.pref[i];
        }

        for (int i = 0; i < k; i++) {
            int newRem = (left.product * i) % k;
            res.pref[newRem] += right.pref[i];
        }

        return res;
    }
}
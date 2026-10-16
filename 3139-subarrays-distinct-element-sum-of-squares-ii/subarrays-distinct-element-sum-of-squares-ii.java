
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    class SegmentTree {
        long[] sum, sq, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r) {
            long len = r - l + 1L;

            sq[node] = (sq[node] + 2L * sum[node] + len) % MOD;
            sum[node] = (sum[node] + len) % MOD;
            lazy[node]++;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            applyLazy(node * 2, l, mid, lazy[node]);
            applyLazy(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        void applyLazy(int node, int l, int r, long val) {
            long len = r - l + 1L;

            sq[node] = (sq[node] + 2L * val % MOD * sum[node] % MOD
                    + len % MOD * val % MOD * val % MOD) % MOD;
            sum[node] = (sum[node] + len % MOD * val % MOD) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void update(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r);
                return;
            }

            push(node, l, r);

            int mid = (l + r) / 2;
            update(node * 2, l, mid, ql, qr);
            update(node * 2 + 1, mid + 1, r, ql, qr);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int last = lastSeen.getOrDefault(nums[i], -1);
            tree.update(1, 0, n - 1, last + 1, i);
            ans = (ans + tree.sq[1]) % MOD;
            lastSeen.put(nums[i], i);
        }

        return (int) ans;
    }
}


import java.util.*;

class Solution {
    int n, timer;
    List<Integer>[] adj;
    int[] parent, depth, size, heavy, head, pos;
    int[] seg;
    int[] mask;

    public List<Boolean> palindromePath(int n, int[][] edges,
                                         String s, String[] queries) {
        this.n = n;
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        mask = new int[n];

        Arrays.fill(heavy, -1);

        dfs(0, -1);
        decompose(0, 0);

        seg = new int[4 * n];

        for (int i = 0; i < n; i++) {
            mask[pos[i]] = 1 << (s.charAt(i) - 'a');
        }

        build(1, 0, n - 1);

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);
                update(1, 0, n - 1, pos[u],
                       1 << (c - 'a'));
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int bits = pathQuery(u, v);
                ans.add((bits & (bits - 1)) == 0);
            }
        }

        return ans;
    }

    void dfs(int u, int p) {
        parent[u] = p;
        size[u] = 1;
        int maxSize = 0;

        for (int v : adj[u]) {
            if (v == p) continue;

            depth[v] = depth[u] + 1;
            dfs(v, u);
            size[u] += size[v];

            if (size[v] > maxSize) {
                maxSize = size[v];
                heavy[u] = v;
            }
        }
    }

    void decompose(int u, int h) {
        head[u] = h;
        pos[u] = timer++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : adj[u]) {
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    void build(int node, int l, int r) {
        if (l == r) {
            seg[node] = mask[l];
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, val);
        }

        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }

    int rangeQuery(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) return seg[node];

        int mid = (l + r) / 2;
        int result = 0;

        if (ql <= mid) {
            result ^= rangeQuery(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            result ^= rangeQuery(node * 2 + 1, mid + 1, r, ql, qr);
        }

        return result;
    }

    int pathQuery(int u, int v) {
        int result = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            result ^= rangeQuery(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        result ^= rangeQuery(1, 0, n - 1, pos[u], pos[v]);
        return result;
    }
}

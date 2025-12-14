class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tr = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> r = new ArrayList<>();
            r.add(1);
            for (int j = 1; j < i; j++) {
                int val = tr.get(i - 1).get(j - 1)
                        + tr.get(i - 1).get(j);
                r.add(val);
            }
            if (i > 0) {
                r.add(1);
            }
            tr.add(r);
        }
        return tr;
    }
}

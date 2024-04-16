class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];

        int idx = 1;
        while (idx < intervals.length) {
            int[] curr = intervals[idx];
            if (prev[1] < curr[0]) {
                res.add(prev);
                prev = curr;
            } else {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
            idx++;
        }
        res.add(prev);
        
        return res.toArray(new int[res.size()][2]);
    }
}
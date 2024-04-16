class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new LinkedList<>();

        int n = intervals.length;
        int[] newInterval = new int[2];
        newInterval[0] = intervals[0][0];
        newInterval[1] = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                newInterval = new int[2];
                newInterval[0] = intervals[i][0];
                newInterval[1] = intervals[i][1];
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        res.add(newInterval);

        return res.toArray(new int[res.size()][2]);
    }
}
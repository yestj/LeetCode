class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int st = i + 1;
            int ed = nums.length - 1;

            while (st < ed) {
                int sum = nums[i] + nums[st] + nums[ed];
                
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[st++], nums[ed--]));
                    while(nums[st] == nums[st - 1] && st < ed) st++;
                    while(nums[ed] == nums[ed + 1] && st < ed) ed--;
                } else if (sum > 0) {
                    ed--;
                } else {
                    st++;
                }
            }
        }

        return ans;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int numLen = nums.length - 1;

        for (int i = 0; i < numLen - 1; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = numLen;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(nums[left] == nums[left - 1] && left < right) left++;
                    while(nums[right] == nums[right + 1] && left < right) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
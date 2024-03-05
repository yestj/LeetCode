class Solution {
    public int[] searchRange(int[] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;

        int[] ans = {-1, -1};

        while (st <= ed) {
            int mid = (st + ed) / 2;

            if (nums[mid] == target) {
                // find starting, ending position
                int left = mid;
                int right = mid;
                while(left >= 0 && nums[left] == target) left--;
                while(right < nums.length && nums[right] == target) right++;

                ans[0] = left + 1;
                ans[1] = right - 1;

                break;                
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        return ans;
    }
}
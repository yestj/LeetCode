class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // binary search
        int partitionLen = (nums1.length + nums2.length + 1) / 2;
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        
        int st = 0;
        int ed = nums1.length;

        while (st <= ed) {
            int nums1Idx = (st + ed) / 2;
            int nums2Idx = partitionLen - nums1Idx;

            int nums1Left = nums1Idx - 1 >= 0 ? nums1[nums1Idx - 1] : Integer.MIN_VALUE;
            int nums1Right = nums1Idx < nums1.length ? nums1[nums1Idx] : Integer.MAX_VALUE;
            int nums2Left = nums2Idx - 1 >= 0 ? nums2[nums2Idx - 1] : Integer.MIN_VALUE;
            int nums2Right = nums2Idx < nums2.length ? nums2[nums2Idx] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums1Right >= nums2Left) {
                if (isEven) {
                    return ((Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0);
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                ed = nums1Idx - 1;
            } else {
                st = nums1Idx + 1;
            }
        }
        
        return 0;
    }
}
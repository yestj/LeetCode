class Solution {
    public int trap(int[] height) {
        
        int leftIdx = 0, rightIdx= height.length - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int result = 0;

        while (leftIdx < rightIdx) {
            leftMax = Math.max(leftMax, height[leftIdx]);
            rightMax = Math.max(rightMax, height[rightIdx]);
            result += (leftMax < rightMax) ? leftMax - height[leftIdx++] : rightMax - height[rightIdx--];
        }

        return result;

    }

}
class Solution {
    public int maxArea(int[] height) {
        int st = 0;                 // start index
        int ed = height.length - 1; // end index
        
        int leftLen = height[st];   // current left length
        int rightLen = height[ed];  // current right length

        int maxValue = (ed - st) * Math.min(leftLen, rightLen);

        while(st < ed) {
            
            if  (height[st] > leftLen || height[ed] > rightLen) {
                leftLen = height[st];
                rightLen = height[ed];
                maxValue = Math.max(maxValue, (ed - st) * Math.min(leftLen, rightLen));
            }

            if (leftLen >= rightLen) {
                ed--;
            } else {
                st++;
            }
        }

        return maxValue;
    }
}
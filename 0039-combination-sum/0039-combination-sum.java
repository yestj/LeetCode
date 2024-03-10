class Solution {

    List<List<Integer>> ans;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] inputCandidates, int inputTarget) {
        
        ans = new ArrayList<>();
        candidates = inputCandidates;
        target = inputTarget;

        Arrays.sort(inputCandidates);
        
        if (candidates[0] > target) return ans;
        
        Stack<Integer> numList = new Stack<>();
        findTargetSum (0, 0, numList);

        return ans;
    }

    public void findTargetSum (int idx, int currSum, Stack currList) {
        if (currSum == target) {
            List foundedList = new ArrayList(currList);
            ans.add(foundedList);
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            currSum += candidates[i];

            if (currSum > target) return;
            
            currList.push(candidates[i]);
            findTargetSum(i, currSum, currList);
            currList.pop();
            
            currSum -= candidates[i];
        }         
    }
}
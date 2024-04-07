class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> result = new ArrayList<>();        
        if (strs == null) return result;

        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String key = Arrays.toString(charArr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
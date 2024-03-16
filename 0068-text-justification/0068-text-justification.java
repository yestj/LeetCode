class Solution {

    String[] words;
    int maxWidth;

    public List<String> fullJustify(String[] inputWords, int inputMaxWidth) {
        
        ArrayList<String> ans = new ArrayList<>();

        words = inputWords;
        maxWidth = inputMaxWidth;

        int cnt = 0;
        int stIdx = 0;
        int edIdx = 0;

        for (int i = 0; i < words.length; i++) {
            cnt += words[i].length();
            edIdx = i;

            if (cnt > maxWidth) {
                ans.add(lineJustify(stIdx, edIdx - 1));
                stIdx = i;
                cnt = words[i].length() + 1;
            } else if (cnt == maxWidth) {
                ans.add(lineJustify(stIdx, edIdx));
                stIdx = i + 1;
                cnt = 0;
            } else {
                cnt++;
            }

            if (i == words.length - 1 && stIdx != i + 1) {
                ans.add(lineJustify(stIdx, edIdx));
            }

        }

        return ans;
    }

    private String lineJustify(int stIdx, int edIdx) {
        StringBuilder sb = new StringBuilder();

        if (edIdx == words.length - 1 || stIdx == edIdx) {
            for (int i = stIdx; i < edIdx; i++) {
                sb.append(words[i]).append(" ");
            }
            sb.append(words[edIdx]);
            while(sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            int space = 0;
            int addSpace = 0;
            int wordLen = 0;

            for (int i = stIdx; i <= edIdx; i++) {
                wordLen += words[i].length();
            }

            space = (maxWidth - wordLen) / (edIdx - stIdx);
            addSpace = (maxWidth - wordLen) % (edIdx - stIdx);

            for (int i = stIdx; i < edIdx; i++) {
                sb.append(words[i]);
                for (int j = 0; j < space; j++) {
                    sb.append(" ");
                }
                if(addSpace > 0) {
                    sb.append(" ");
                    addSpace--;
                }
            }
            sb.append(words[edIdx]);

            return sb.toString();

        }

    }
}
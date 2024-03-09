class Solution {

    char[][] board;
    boolean[][] visited;
    int wordLen;
    int M, N;
    String targetWord;

    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public boolean exist(char[][] inputBoard, String word) {
        
        // initialize 
        board = inputBoard;
        wordLen = word.length();
        targetWord = word;

        M = board.length;
        N = board[0].length;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == word.charAt(0)){
                    visited = new boolean[M][N];
                    visited[r][c] = true;
                    if (dfs(1, r, c)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int depth, int r, int c){
        if (depth == wordLen) {
            return true;
        }

        for (int d = 0; d < 4; d ++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
            if (!visited[nr][nc] && board[nr][nc] == targetWord.charAt(depth)) {
                visited[nr][nc] = true;
                if(dfs(depth + 1, nr, nc)) return true;
                else visited[nr][nc] = false;
            }
        }

        return false;
    }

}
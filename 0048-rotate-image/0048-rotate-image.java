class Solution {
    public void rotate(int[][] matrix) {
        
        int N = matrix.length;
        
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N - i - 1][j];
                matrix[N - i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
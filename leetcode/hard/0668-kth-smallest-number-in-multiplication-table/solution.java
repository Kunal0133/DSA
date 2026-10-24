class Solution {
    int func(int m, int n, int guess) {
        int count = 0;
        int row = m - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if ((row + 1) * (col + 1) <= guess) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int result = -1;
        while (low <= high) {
            int guess = low + (high - low) / 2;
            int ans = func(m, n, guess);
            if (ans < k) {
                low = guess + 1;
            } else {
                result = guess;
                high = guess - 1;
            }
        }
        return result;
    }
}
        
    

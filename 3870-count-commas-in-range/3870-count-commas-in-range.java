class Solution {
    public int countCommas(int n) {
        int total = 0;
        int lower = 1;
        int digits = 1;

        while (lower <= n) {
            long upper = (long) lower * 10 - 1;
            int rangeEnd = (int) Math.min(upper, n);

            int count = rangeEnd - lower + 1;
            int commasPerNumber = (digits - 1) / 3;

            total += count * commasPerNumber;

            if (upper >= n) break;
            lower = (int) (upper + 1);
            digits++;
        }
        return total;
    }
}

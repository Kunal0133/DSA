class Solution {
    public long findKthSmallest(int[] coins, int k) {
     
        int n = coins.length;
        long lo = 1, hi = (long) Arrays.stream(coins).min().getAsInt() * k;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countMultiples(coins, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private long countMultiples(int[] coins, long x) {
        int n = coins.length;
        long count = 0;

      
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = Integer.bitCount(mask);
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) continue;

            long term = x / lcm;
            if (bits % 2 == 1) {
                count += term;
            } else {
                count -= term;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
} 
    
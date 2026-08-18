class Solution {
    public int largestInteger(int[] nums, int k) {
    
        int n = nums.length;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int windowCount = 0;

            for (int start = 0; start <= n - k; start++) {
                boolean present = false;
                for (int j = start; j < start + k; j++) {
                    if (nums[j] == x) {
                        present = true;
                        break;
                    }
                }
                if (present) windowCount++;
                if (windowCount > 1) break;
            }

            if (windowCount == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}

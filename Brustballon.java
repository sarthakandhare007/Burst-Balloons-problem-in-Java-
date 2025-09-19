public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // len = length of interval
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left + len <= n + 1; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][k] + arr[left] * arr[k] * arr[right] + dp[k][right]);
                }
            }
        }

        return dp[0][n + 1];
    }

    // Quick test
    public static void main(String[] args) {
        BurstBalloons sol = new BurstBalloons();
        int[] nums = {3,1,5,8};
        System.out.println(sol.maxCoins(nums)); // Output: 167
    }
}

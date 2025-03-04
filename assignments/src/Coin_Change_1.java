import java.util.Arrays;
// Time: O(S*n), Space: O(S) where S = amount, n = denominations of the coins
public class Coin_Change_1 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int dp[] = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
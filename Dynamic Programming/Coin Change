// Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
// Note: Assume that you have an infinite supply of each type of coin. 


// Example 1:

// Input:
// sum = 4 , 
// N = 3
// coins[] = {1,2,3}
// Output: 4
// Explanation: Four Possible ways are:
// {1,1,1,1},{1,1,2},{2,2},{1,3}.
// Example 2:

// Input:
// Sum = 10 , 
// N = 4
// coins[] ={2,5,3,6}
// Output: 5
// Explanation: Five Possible ways are:
// {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
// and {5,5}.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function count() which accepts an array coins[ ] its size N and sum as input parameters and returns the number of ways to make change for given sum of money. 


// Expected Time Complexity: O(sum*N)
// Expected Auxiliary Space: O(sum)


// Constraints:
// 1 <= sum, N <= 103

//========================================================================
//--------------------(Recursive approach)--------------------------------
class Solution {
    public long count(int coins[], int n, int sum) {
        // code here.
        if(sum == 0) return 1;
        if(n == 0 || sum < 0) return 0;
        
        return count(coins, n-1, sum) + count(coins, n, sum - coins[n-1]);
    }
}
//Time Complexity = O(2^(n*sum))
//Space Complexity = O(1)

//--------------------(Dynamic approach[Top Down])------------------------
class Solution {
    static long countUtil(int coins[], int n, int sum, long[][] dp) {
        // code here.
        if(sum == 0) return dp[n][sum] = 1;
        if(n == 0 || sum < 0) return 0;
        if(dp[n][sum] != -1) return dp[n][sum];
        return dp[n][sum] = countUtil(coins, n-1, sum, dp) + countUtil(coins, n, sum - coins[n-1], dp);
    }
    public long count(int coins[], int n, int sum){
        
        long dp[][] = new long[n+1][sum+1];
        for(long[] a:dp)
            Arrays.fill(a, -1);
        
        return countUtil(coins, n, sum, dp);
    }
}
//Time Complexity = O(n*sum)
//Space Complexity = O(n*sum)

//--------------------(Dynamic approach[Bottom up])------------------------
class Solution {
    public long count(int coins[], int n, int sum){
            
        long dp[][] = new long[n+1][sum+1];
        
        for(int i = 0;i <= n;i++) dp[i][0] = 1;
        for(int j = 0;j <= sum;j++) dp[0][j] = 0;
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= sum;j++){
                dp[i][j] = dp[i-1][j];
                if(j - coins[i-1] >= 0) dp[i][j] += dp[i][j - coins[i-1]]; 
            }
        }
        
        return dp[n][sum];
    }
}
//Time Complexity = O(n*sum)
//Space Complexity = O(n*sum)

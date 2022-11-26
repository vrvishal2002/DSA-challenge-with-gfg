//Longest Increasing Subsequence

//===========Recursive_solution==============
class Solution
{
   //Function to find the length of longest common subsequence in two strings.
   static int lcs_util(String s1,String s2,int n,int m){
    
       if(m <= 0 || n <= 0) return 0;
        
       if(s1.charAt(n-1) == s2.charAt(m-1)) return 1 + lcs_util(s1,s2,n-1,m-1);
    
       return Math.max(lcs_util(s1,s2,n-1,m), lcs_util(s1,s2,n,m-1));
    
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int n = s1.length();
        int m = s2.length();
        return lcs_util(s1,s2,n,m);
    }
    
}
// Time complexity: O(2^n)
// Space complexity: O(n) (internal stack space)

//=================Dynamic_Programming(Memoization)==================

class Solution
{
   //Function to find the length of longest common subsequence in two strings.
   static int lcs_util(String s1,String s2,int n,int m,int[][] dp){
    
       if(m <= 0 || n <= 0) return 0;
    
       if(dp[n][m] != -1) return dp[n][m];
        
       if(s1.charAt(n-1) == s2.charAt(m-1)) return 1 + lcs_util(s1,s2,n-1,m-1,dp);
    
       return dp[n][m] = Math.max(lcs_util(s1,s2,n-1,m,dp), lcs_util(s1,s2,n,m-1,dp));
    
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++){
           for(int j = 1;j <= m;j++){
               dp[i][j] = -1;
           }
        }
        return lcs_util(s1,s2,n,m,dp);
    }
}
// Time complexity: O(n^2)
// Space complexity: O(n^2)

//=================Dynamic_Programming(Tabulation)==================

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}

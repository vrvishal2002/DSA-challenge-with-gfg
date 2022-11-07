//Longest Increasing Subsequence

//===========Recursive_solution==============
class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequenceUtil(int arr[],int n,int index,int prevIndex){
        if(index == n)return 0;
        
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        
        //current index value is not included
        a = longestSubsequenceUtil(arr, n, index + 1, prevIndex); 
        
        //including cur index value if greater than prevIndex value
        
        if(prevIndex == -1 || arr[index] > arr[prevIndex]) 
            b = 1 + longestSubsequenceUtil(arr,n,index + 1, index);
        
        return Math.max(a, b);
    }
  
    static int longestSubsequence(int size, int a[])
    {
        // code here
        return longestSubsequenceUtil(a,size,0,-1);
    }
} 
// Time complexity: O(2^n)
// Space complexity: O(n) (internal stack space)

//=================Dynamic_Programming(Memoization)==================

class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequenceUtil(int arr[],int n,int index,int prevIndex, int[][] dp){
        if(index == n)return 0;
        if(dp[index][prevIndex+1] != -1)return dp[index][prevIndex+1];
        
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        
        //current index value is not included
        a = longestSubsequenceUtil(arr, n, index + 1, prevIndex,dp); 
        
        //including cur index value if greater than prevIndex value
        
        if(prevIndex == -1 || arr[index] > arr[prevIndex]) 
            b = 1 ++ longestSubsequenceUtil(arr,n,index + 1, index,dp);
            
        dp[index][prevIndex+1] = Math.max(a, b);
        
        return dp[index][prevIndex+1];
    }
    static int longestSubsequence(int n, int a[])
    {
        // code here
        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                dp[i][j] = -1;
            }
        }
        return longestSubsequenceUtil(a,n,0,-1,dp);
    }
}
// Time complexity: O(n^2)
// Space complexity: O(n^2)

//=================Dynamic_Programming(Tabulation)==================

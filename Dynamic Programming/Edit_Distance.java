// Edit Distance

// Input: 
// s = "geek", t = "gesek"
// Output: 1
// Explanation: One operation is required 
// inserting 's' between two 'e's of str1.

//===========Recursive_solution==============
class Solution {
    static int c=0;
    static int editDistanceUtil(String s,String t,int n,int m){
        if(m == 0) return n;
        if(n == 0) return m;
        
        if(s.charAt(n-1) == t.charAt(m-1)) return  editDistanceUtil(s,t,n-1,m-1);
        
        int ans = Math.min(editDistanceUtil(s,t,n,m-1),editDistanceUtil(s,t,n-1,m));
        ans = Math.min(ans, editDistanceUtil(s,t,n-1,m-1));
        
        return ans + 1;
    }
    public int editDistance(String s, String t) {
        // Code here
        int n = s.length();
        int m = t.length();
        
        return editDistanceUtil(s,t,n,m);
    }
}
// Time complexity: O(2^max(n,m))
// Space complexity: O(max(n,m)) (internal stack space)

//=================Dynamic_Programming(Memoization)==================

class Solution {
    static int c=0;
    static int editDistanceUtil(String s,String t,int n,int m,int dp[][]){
        if(m == 0) return n;
        if(n == 0) return m;
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s.charAt(n-1) == t.charAt(m-1)) return dp[n][m] = editDistanceUtil(s,t,n-1,m-1,dp);
        
        int ans = Math.min(editDistanceUtil(s,t,n,m-1,dp),editDistanceUtil(s,t,n-1,m,dp));
        ans = Math.min(ans, editDistanceUtil(s,t,n-1,m-1,dp));
        
        return dp[n][m] = ans + 1;
    }
    public int editDistance(String s, String t) {
        // Code here
        int n = s.length();
        int m = t.length();
        
        int dp[][] = new int[n+1][m+1];
        
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                dp[i][j] = -1;
            }
        }
        
        return editDistanceUtil(s,t,n,m,dp);
    }
}
// Time complexity: O(n x m)
// Space complexity: O(n x m)

//=================Dynamic_Programming(Tabulation)==================

class Solution {
    
    public int editDistance(String s, String t) {
        // Code here
        int n = s.length();
        int m = t.length();
        
        int dp[][] = new int[n+1][m+1];
        
        for(int i = 0;i <= n;i++) dp[i][0] = i;
        for(int i = 0;i <= m;i++) dp[0][i] = i;
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        
        return dp[n][m];
    }
}
// Time complexity: O(n x m)
// Space complexity: O(n x m)

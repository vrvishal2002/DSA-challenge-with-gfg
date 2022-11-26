// Activity Selection

// Input:
// N = 2
// start[] = {2, 1}
// end[] = {2, 2}
// Output: 
// 1
// Explanation:
// A person can perform only one of the
// given activities.

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int[][] work = new int[n][2];
        
        for(int i = 0;i < n;i++){
            work[i][0] = end[i];
            work[i][1] = start[i];
        }
        Arrays.sort(work,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0] != b[0])return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        
        int ans = 1;
        int startcur = work[0][1],endcur = work[0][0];
        for(int i = 1;i < n;i++){
            
            if(work[i][1] > endcur) {
                ans++;
                startcur = work[i][1];
                endcur = work[i][0];
            }
        }
        return ans;
    }
}
// Time Complexity = O(nlog(n))
// space Complexity = O(n)

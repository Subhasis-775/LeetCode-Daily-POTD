class Solution {
    public int solve(int i,int j,int[] nums1,int[] nums2,int[][] dp){
        int m=nums1.length;
        int n=nums2.length;
        if(i==m || j==n){
            return -1000000000;
        }
        if(dp[i][j]!=-1000000000) return dp[i][j];
        int val=nums1[i]*nums2[j];
        int takeboth=solve(i+1,j+1,nums1,nums2,dp)+val;
        int takei=solve(i,j+1,nums1,nums2,dp);
        int takej=solve(i+1,j,nums1,nums2,dp);
        return dp[i][j]=Math.max(val,Math.max(takeboth,Math.max(takei,takej)));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp=new int[501][501];
        for(int[] row:dp){
            Arrays.fill(row,-1000000000);
        }
        return solve(0,0,nums1,nums2,dp);
    }
}
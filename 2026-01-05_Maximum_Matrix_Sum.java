class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        long sum=0;
        int zeroes=0;
        long min=Long.MAX_VALUE;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0) count++;
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]==0) zeroes++;
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(count%2==0 || zeroes>0) return sum;
        sum-=2*min;
        return sum;
    }
}
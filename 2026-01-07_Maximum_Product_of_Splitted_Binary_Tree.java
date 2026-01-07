class Solution {
    private long totalsum;
    private long maxsum;
    private int MOD = 1_000_000_007;
    public long getTotalsum(TreeNode root){
        if(root==null) return 0;
        return root.val+getTotalsum(root.left)+getTotalsum(root.right);
    }
    public long dfs(TreeNode root){
        if(root==null) return 0;
        long leftsum=dfs(root.left);
        long rightsum=dfs(root.right);
        long subtreesum=root.val+leftsum+rightsum;
        long product=subtreesum*(totalsum-subtreesum);
        maxsum=Math.max(maxsum,product);
        return subtreesum;
    }
    public int maxProduct(TreeNode root) {
        totalsum=getTotalsum(root);
        dfs(root);
        return (int)(maxsum%MOD);
    }
}
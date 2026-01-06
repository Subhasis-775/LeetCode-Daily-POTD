class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxsum=Integer.MIN_VALUE;
        int maxlevel=1,level=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode top=q.remove();
                sum+=top.val;
                if(top.left!=null) q.add(top.left);
                if(top.right!=null) q.add(top.right);
            }
            if(sum>maxsum){
                maxsum=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
    }
}
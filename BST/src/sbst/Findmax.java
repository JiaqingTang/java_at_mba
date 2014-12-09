package sbst;

public class Findmax {
	private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
    	int val = maxPathSum_helper( root);
        return max;
    }
    
    public int maxPathSum_helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = maxPathSum_helper(root.left);
        int rightMax = maxPathSum_helper(root.right);
        if(root.val > 0) {
            max = Math.max(max, leftMax + root.val);
            max = Math.max(max, rightMax + root.val);
            max = Math.max(max, root.val);
        }
        else {
            max = Math.max(max, leftMax);
            max = Math.max(max, rightMax);
        }
        max = Math.max(max, rightMax + leftMax + root.val);
        int cur = Math.max(leftMax, rightMax);
        return cur > 0 ? cur + root.val : root.val;
    }
    
    public static void main(String[] args) {
    	Findmax find = new Findmax();
    	TreeNode root = new TreeNode(-2);
    	root.left = new TreeNode(1);
    	System.out.print(find.maxPathSum(root));
    }
}

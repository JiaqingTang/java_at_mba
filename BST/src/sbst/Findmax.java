package sbst;

public class Findmax {    
    public int maxPathSum(TreeNode root) {
    	int[] max = {Integer.MIN_VALUE};
    	int val = maxPathSum_helper(root, max);
        return Math.max(max[0], val);
    }
    
    public int maxPathSum_helper(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int leftMax = maxPathSum_helper(root.left, max);
        int rightMax = maxPathSum_helper(root.right, max);
        int val = root.val;
        int max_sub = Math.max(leftMax, rightMax);
        val += max_sub > 0 ? max_sub : 0;
        max[0] = Math.max(Math.max(max[0], val), rightMax + leftMax + root.val);
        return val;
    }
    
    public static void main(String[] args) {
    	Findmax find = new Findmax();
    	TreeNode root = new TreeNode(-2);
    	root.left = new TreeNode(1);
    	System.out.print(find.maxPathSum(root));
    }
}

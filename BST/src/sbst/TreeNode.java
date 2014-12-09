package sbst;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	TreeNode(int val) {
		this(val, null, null);
	}
	
	public TreeNode getLeft() {
		return this.left;
	}
	
	public TreeNode getRight() {
		return this.right;
	}
	
	public void setLeft(TreeNode leftNode) {
		this.left = leftNode;
	}
	
	public void setRight(TreeNode rightNode) {
		this.right = rightNode;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return this.val;
	}
}

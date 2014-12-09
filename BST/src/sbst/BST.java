package sbst;

public class BST {
	TreeNode root;
	BST(int val) {
		root = new TreeNode(val);
	}
	
	public TreeNode search(int val) {
		if(this.root == null) {
			return null;
		}
		return search_helper(root, val);
	}
	
	private TreeNode search_helper(TreeNode root, int val) {
		if(root == null) {
			return null;
		}
		if(root.getVal() == val) {
			return root;
		}
		else if(root.getVal() > val) {
			return search_helper(root.getLeft(), val);
		}
		else {
			return search_helper(root.getRight(), val);
		}
	}
	
	public boolean insert(int val) {
		if(this.root == null) {
			this.root = new TreeNode(val);
			return true;
		}
		else {
			return insert_helper(root, val);
		}
	}
	
	private boolean insert_helper(TreeNode root, int val) {
		if(root == null) {
			return false;
		}
		if (root.getVal() == val) {
			System.out.print("This BST cannot hold duplicate");
			return false;
		}
		else if(root.getVal() > val) {
			if(root.getLeft() == null) {
				root.setLeft(new TreeNode(val));
				return true;
			}
			return insert_helper(root.getLeft(), val);
		}
		else {
			if(root.getRight() == null) {
				root.setRight(new TreeNode(val));
				return true;
			}
			return insert_helper(root.getRight(), val);
		}
	}
	
	public TreeNode delete(int val) {
		if(root == null) {
			return null;
		}
		return delete_helper(root, val);
	}
	
	private TreeNode delete_helper(TreeNode root, int val) {
		if(root == null) {
			return null;
		}
		if(root.getVal() == val) {
			if(root.getLeft() == null) {
				return root.getRight();
			}
			if(root.getRight() == null) {
				return root.getLeft();
			}
			int min = getMin(root.getRight());
			root.setVal(min);
			root.setRight(delete_helper(root.getRight(), min));
			return root;
		}
		else if(root.getVal() > val) {
			return delete_helper(root.getLeft(), val);
		}
		else {
			return delete_helper(root.getRight(), val);
		}
	}
	
	private int getMin(TreeNode root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		while(root.getLeft() != null) {
			root = root.getLeft();
		}
		return root.getVal();
	}
	
	private TreeNode getSuccessor(TreeNode root, int val) {
		if(root == null) {
			return null;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			return root;
		}
		if(root.getVal() == val) {
			System.out.print("duplicate");
			return null;
		}
		
		else if(root.getVal() > val) {
			return getSuccessor(root.getLeft(), val);
		}
		else {
			return getSuccessor(root.getRight(), val);
		}
	}
}

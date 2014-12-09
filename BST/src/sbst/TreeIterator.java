package sbst;

import java.util.Stack;
public class TreeIterator {
	TreeNode next = null;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeIterator(TreeNode root) {
		if(root == null) {
			return;
		}
		next = root;
		while(next.left != null) {
			stack.push(next);
			next = next.left;
		}
	}
	
	public boolean hasNext() {
		return null != next;
	}
	
	public TreeNode next() {
		return successor();
		
	}
	
	public TreeNode successor() {
		TreeNode result = next;
		if(next.right != null) {
			next = next.right;
			while(next.left != null) {
				stack.push(next);
				next = next.left;
			}
		}
		else {
			if(stack.isEmpty()) {
				next = null;
			}
			else {
				next = stack.pop();
			}
		}
		return result;
	}
	
}


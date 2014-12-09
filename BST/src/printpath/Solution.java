package printpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	int pos;
	TreeNode(int v) {
		val = v;
		pos = 0;
	}
}

public class Solution {
	public void printAllPaths(TreeNode root) {
		if(root == null) return;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(root.val, 0);
		dfs_plus_plus(root, new ArrayList<Integer>(), map);
	}
	
	public void dfs(TreeNode root, List<Integer> path) {
		if(root == null) {	
			return;
		}
		path.add(root.val);
		if(root.left == null && root.right == null) {
			System.out.println(path);
			path.remove(path.size()-1);
			return;
		}
		dfs(root.left, path);
		dfs(root.right, path);
		path.remove(path.size()-1);
	}
	
	public void dfs_plus(TreeNode root, List<TreeNode> path) {
		if(root == null) {	
			return;
		}
		path.add(root);
		if(root.left == null && root.right == null) {
			if(path.size() == 0) return;
			int min = path.get(0).val;
			for(int i = 1; i < path.size(); ++i) {
				min = Math.min(min, path.get(i).pos);
			}
			for(TreeNode v : path) {
				for(int i = min; i < v.pos; ++i) {
					System.out.print(" ");
				}
				System.out.println(v.val);
			}
			path.remove(path.size()-1);
			return;
		}
		if(root.left != null) {
			root.left.pos = root.pos - 1;
			dfs_plus(root.left, path);
		}
		if(root.right != null) {
			root.right.pos = root.pos + 1;
			dfs_plus(root.right, path);
		}
		path.remove(path.size()-1);
	}
	
	public void dfs_plus_plus(TreeNode root, List<Integer> path, Map<Integer, Integer> map) {
		if(root == null) {	
			return;
		}
		path.add(root.val);
		if(root.left == null && root.right == null) {
			if(path.size() == 0) return;
			int min = 0;
			Set<Integer> keyset = map.keySet();
			for(int i : keyset) {
				min = Math.min(min, map.get(i));
			}
			for(int v : path) {
				for(int i = min; i < map.get(v); ++i) {
					System.out.print(" ");
				}
				System.out.println(v);
			}
			path.remove(path.size()-1);
			return;
		}
		if(root.left != null) {
			map.put(root.left.val, map.get(root.val) - 1);
			dfs_plus_plus(root.left, path, map);
			map.remove(root.left.val);
		}
		if(root.right != null) {
			map.put(root.right.val, map.get(root.val) + 1);
			dfs_plus_plus(root.right, path, map);
			map.remove(root.right.val);
		}
		path.remove(path.size()-1);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		s.printAllPaths(root);
	}
}

package sbst;

public class Test {
	public static void main(String[] args) {
		BST mybst = new BST(4);
		mybst.insert(2);
		mybst.insert(1);
		mybst.insert(3);
		mybst.insert(6);
		mybst.insert(5);
		mybst.insert(7);
		TreeIterator iter = new TreeIterator(mybst.root);
		while(iter.hasNext()){
			TreeNode node = iter.next();
			System.out.println(node.val);
		}
			
	}
}

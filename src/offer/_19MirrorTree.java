package offer;

public class _19MirrorTree {
	
	public static void mirror(TreeNode root){
		if(root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		print(root);
		mirror(root);
		System.out.println();
		print(root);
	}
	
	public static void print(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.val+" ");
		print(root.left);
		print(root.right);
	}

}

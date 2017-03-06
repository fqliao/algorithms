package offer;

public class _18Subtree {
	
	public boolean subtree(TreeNode root1, TreeNode root2){
		boolean result = false;
		if(root1 != null && root2 != null){
			result = DoesTree1HasTree2(root1, root2);
			if(!result){
				result = subtree(root1.left, root2);
			}
			if(!result){
				result = subtree(root1.right, root2);
			}
		}
		return result;
	}

	private boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 != null)
			return false;
		if(root2 == null)
			return true;
		if(root1.val != root2.val)
			return false;
		return DoesTree1HasTree2(root1.left, root2.right) && DoesTree1HasTree2(root1.right, root2.right);
	}
}

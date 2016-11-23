package search.binarySearchTree;


public class BinarySearchTree {
	
    private  Node root;  
    //内部节点类
    private class Node
    {  
        private Node left;  
        private Node right;  
        private int data;  
        public Node(int data)
        {  
            this.left = null;  
            this.right = null;  
            this.data = data;  
        }
		@Override
		public String toString() 
		{
			return "Node [data=" + data+ "]";
		} 
    }
    
    public BinarySearchTree()
    {  
        root = null;  
    }
    
	public static void main(String[] args) {
		int[] nums = {62,88,58,47,35,73,51,99,37,93};
		BinarySearchTree bTree = new BinarySearchTree();
		for (int i = 0; i < nums.length; i++) 
			bTree.insert(bTree.root, nums[i]);
		bTree.InOrder(bTree.root);
		System.out.println();
		System.out.println(bTree.search(bTree.root, 100));
	}

	/**二叉搜索树的
	 * @param T
	 * @param key
	 * @param f
	 * @param p
	 * @return
	 */
	public Node search(Node root, int key) 
	{
		if(root == null)
		{
			return null;
		}
		else if(key == root.data)
		{
			return root;
		}
		else if(key < root.data)
			return search(root.left, key);
		else
			return search(root.right, key);
	}
	
	/** 二叉搜索树的插入
	 * @param T
	 * @param key
	 * @return
	 */
    public void insert(Node node,int data){  
        if(root == null){  
            root = new Node(data);  
        }
        else
        {  
            if(data < node.data)
            {  
                if(node.left == null)
                {  
                    node.left = new Node(data);  
                }
                else
                {  
                	insert(node.left,data);  
                }  
            }
            else
            {  
                if(node.right == null)
                {  
                    node.right = new Node(data);  
                }
                else
                {  
                	insert(node.right,data);  
                }  
            }  
        }  
    }
    
    /**中序遍历搜索二叉树就是从小到大的顺序
     * @param root
     */
    public void InOrder(Node root)
    {
    	if(root != null)
    	{
    		InOrder(root.left);
    		System.out.print(root.data + " ");
    		InOrder(root.right);
    	}
    }

}

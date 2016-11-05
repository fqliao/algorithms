package tree.rebuildTree;

import tree.Node;

/**
 * @decription:重建二叉树
 * @version:1.0
 * @date: 2016年11月5日下午3:27:01
 * @author: lfq
 * 
 */
public class rebuildTree {
	
	public static void main(String[] args) 
	{
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		int[] pos = {7,4,2,5,8,6,3,1};
		
		//根据前序+中序重建二叉树
//		Node root = rebuildByPreAndIn(pre, in);
//		posOrder(root);
//		System.out.println();
//		print(root, 0);
		
		//根据中序+后序重建二叉树
		Node root = rebulidByInAndPos(in, pos);
		preOrder(root);
		System.out.println();
		print(root, 0);
	}
	
	
	/**根据前序+中序重建二叉树
	 * @param pre
	 * @param in
	 * @return
	 */
	public static Node rebuildByPreAndIn(int[] pre,int[] in)
	{
		if(pre == null || in == null)
			return null;
		Node root = new Node(pre[0]);
		int len = pre.length;
		//当只有一个数的时候
		if(len == 1)
		{
			return root;
		}
		//找到中序中的根位置
		int data = root.getData();
		int i = 0;
		for (; i < in.length; i++) 
		{
			if(in[i] == data)
				break;
		}
		//创建左子树
		if(i > 0)
		{
			int[] subPre = new int[i];
			int[] subIn = new int[i];
			for (int j = 0; j < i; j++) 
			{
				subPre[j] = pre[j+1];
				subIn[j] = in[j];
			}
			root.setLeft(rebuildByPreAndIn(subPre, subIn));
		}
		else
		{
			root.setLeft(null);
		}
		
		//创建右子树
		if(i < len-1)
		{
			int[] subPre = new int[len-i-1];
			int[] subIn = new int[len-i-1];
			for (int j = 0; j < len-i-1; j++) 
			{
				subPre[j] = pre[j+i+1];
				subIn[j] = in[j+i+1];
			}
			root.setRight(rebuildByPreAndIn(subPre, subIn));
		}
		else
		{
			root.setRight(null);
		}
		return root;
	}
	
	/**根据中序+后序重建二叉树
	 * @param in
	 * @param pos
	 * @return
	 */
	public static Node rebulidByInAndPos(int[] in,int[] pos)
	{
		if(in == null || pos == null)
			return null;
		int len = pos.length;
		Node root = new Node(pos[len-1]);
		if(len == 1)
			return root;
		//在中序遍历中找到根的位置
		int i = 0;
		for (; i < len; i++) 
		{
			if(in[i] == root.getData())
				break;
		}
		
		//创建左子树
		if(i > 0)
		{	
			int[] subIn = new int[i];
			int[] subPos = new int[i];
			for (int j = 0; j < i; j++) 
			{
				subIn[j] = in[j];
				subPos[j] =pos[j];
			}
			root.setLeft(rebulidByInAndPos(subIn, subPos));
		}
		//创建右子树
		if(i < len-1)
		{
			int[] subIn = new int[len-i-1];
			int[] subPos = new int[len-i-1];
			for (int j = 0; j < len-i-1; j++) 
			{
				subIn[j] = in[j+i+1];
				subPos[j] =pos[j+i];
			}
			root.setRight(rebulidByInAndPos(subIn, subPos));
		}
		return root;
	}
	
	//前序遍历二叉树
 	public static void preOrder(Node root)
	{
		if(root != null)
		{
			System.out.print(root.getData()+" ");
			if(root.getLeft() != null)
				preOrder(root.getLeft());
			if(root.getRight() != null)
				preOrder(root.getRight());
		}
	}
	//中序遍历二叉树
	public static void inOrder(Node root)
	{
		if(root != null)
		{
			if(root.getLeft() != null)
				inOrder(root.getLeft());
			System.out.print(root.getData()+" ");
			if(root.getRight() != null)
				inOrder(root.getRight());
		}
	}
	//后序遍历二叉树
	public static void posOrder(Node root)
	{
		if(root != null)
		{
			if(root.getLeft() != null)
				posOrder(root.getLeft());
			if(root.getRight() != null)
				posOrder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	
	//打印二叉树 右根左
	public static void print(Node root, int level)
	{
		if(root != null)
		{
			if(root.getRight() != null)
			{
				print(root.getRight(), level+1);
			}
			if(level != 0)
			{
				for (int i = 0; i < 6*(level-1); i++) 
				{
					System.out.print(" ");
				}
				System.out.print("-------");
			}
			
			System.out.println(root.getData());
			
			if(root.getLeft() != null)
			{
				print(root.getLeft(), level+1);
			}
		}
	}
}

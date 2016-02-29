package Q1;



import java.util.Scanner;

public class A3_Q1<T> {

	//Starting Node
	Node<T> rootStart;
	
	public static void main(String[] args) 
	{
		//Binary Search Tree of Integer Type
		BST<Integer> tree = new BST<Integer>();
		
		//Trip to stop loop if user is done.
		boolean loopProgram = true;
		while(loopProgram)
		{
			//Get user input.
			Scanner scan = new Scanner(System.in);
			//The user's input number.
			int n = 0;
			//To make sure user can stop the loop.
			while(n != -10000)
			{
				//Request the number to add.
				System.out.println("Enter a number or -10000 to quit: ");
				n = scan.nextInt();
				tree.add(n);
			}
			//Check if the user input tree is valid.
			System.out.println("The result is:");
			System.out.println(String.valueOf(new A3_Q1<Integer>().isValidBST(tree)));
			scan.close();
		}
		
	}
	
	/**
	 * Checks if the tree is a valid binary search tree.
	 * @param Tree The binary search tree you are curious about.
	 * @return true if the tree is valid, false if it is not.
	 */
	@SuppressWarnings("unchecked")
	boolean isValidBST( BST<Integer> Tree )
	{
		try
		{
			rootStart = (Node<T>) Tree.getRoot();
		}
		catch (Exception e)
		{
			throw e;
		}
		return isValid(rootStart);
	}
	
	/**
	 * Begins the recursion method with the root and basis parameters.
	 * @param root The root node of the tree.
	 * @return true if the tree is valid, false if it is not.
	 */
	public boolean isValid(Node<T> root) 
	{
		//Pass the information off to recursive method
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * Checks if the node and it's children are valid. Recursion method.
	 * @param node Node that is being examined.
	 * @param minimum value the node can be.
	 * @param maximum value the node can be.
	 * @return true if the node and it's children is valid and false if they are not.
	 */
	private boolean isValidBST(Node<T> node, int minimum, int maximum) 
	{
		//Check if node exists
	    if(node == null)
	    {
	    	//if the node doesn't exist then it must be the end of the tree or an empty tree so must be true
	    	return true;
	    }	
	    //Check if the node is below max and above min values
	    if(node.getValue() > minimum && node.getValue() < maximum)
	    {
	    	//Check if the node's left child and tree is valid.
	    	if(isValidBST(node.getLeft(), minimum, Math.min(node.getValue(),maximum)))
	    	{
	    		//Check if the node's right child is valid.
	    		if(isValidBST(node.getRight(), Math.max(node.getValue(),minimum), maximum))
	    		{	 
	    			//Must be a valid tree
	    			return true;
	    		}
	    		else
	    		{
	    			//Right child is not valid
	    			return false;
	    		}
	    	}
	    	else
	    	{
	    		//Left child is not valid
	    		return false;
	    	}
	    }
	    else 
	    {
	    	//This node is not valid and does not fit between min and max values.
	        return false;
	    }
	}
}

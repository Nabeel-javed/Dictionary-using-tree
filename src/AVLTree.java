import java.io.*;

public class AVLTree {
	Node root;

	public int height(Node node) {
		if(node == null) {
			return(-1);
		}
		else {
			int leftHeight = height(node.left); 
			int rightHeight = height(node.right);
			if(node.left != null) 
			{
					return(leftHeight+1);
			}
			else {
					return(rightHeight+1);
				}
			}
		}
	
	boolean isBalanced(Node node)
	{
	    int left_height;
	    int right_height;
	    if (node == null)
	    {
	    	 return true;
	    }
	       
	    left_height = height(node.left);
	    right_height = height(node.right);

	    if (Math.abs(left_height - right_height) <= 1 && isBalanced(node.left) && isBalanced(node.right))
	    {
	    	   return false;
	    }
	     
	    	return true;
	}

	public int Max(int height1, int height2) {
		if(height1>height2) 
		{
			return(height1);
		}
		else {
			return(height2);}
	}

	public Node rightRotation(Node word) {
		Node change = word.left;
		if(change!=null) {
			Node k3 = change.right;

			change.right = word;
			word.left = k3;

			word.height = Max(height(word.left), height(word.right)) + 1;
			change.height = Max(height(change.left), height(change.right)) + 1;

			return(change);
		}
		return(word);
	}

	Node leftRotation(Node word) {
		Node change = word.right;
		if(change!=null) {
			Node k3 = change.left;

			change.left = word;
			word.right = k3;

			word.height = Max(height(word.left), height(word.right)) + 1;
			change.height = Max(height(change.left), height(change.right)) + 1;

			return change;
		}
		return(word);
	}

	
	public int getBalance(Node node) {
		if(node == null) {
			return(0);
		}
		else {
			return(height(node.left) - height(node.right));
		}
	}
	

	Node Insert(Node node, Dictionary value) {
		if (node == null) {
			Node newNode = new Node();
			newNode.data = value;
			newNode.left = newNode.right = null;
			return(newNode);
		}
		else {
			String word = value.getWord();
			
			if((word.toUpperCase()).compareTo(node.data.getWord().toUpperCase())<0) {
				node.left = Insert(node.left, value);
			}
			else if((word.toUpperCase()).compareTo(node.data.getWord().toUpperCase())>0) {
				node.right = Insert(node.right, value);
			}
			else {
				return(node);
			}
			
			node.height = Max(height(node.left), height(node.right)) + 1;
			
			int balance = getBalance(node);
			
			if((balance>1) && (word.compareTo(node.left.data.getWord())<0)) {
				return(rightRotation(node));
			}
			if((balance<-1) && (word.compareTo(node.right.data.getWord())>0)) {
				return(leftRotation(node));
			}
			
			if((balance>1) && (word.compareTo(node.left.data.getWord())>0)) {
				node.left = leftRotation(node.left);
				return(rightRotation(node));
			}
			if((balance<-1) && (word.compareTo(node.right.data.getWord())<0)) {
				node.right = rightRotation(node.right);
				return(leftRotation(node));
			}			
		}
		
		return(node);
	}

	

	public Node MinimumValueNode(Node node) {
		Node currNode = node;
		while(currNode.left != null) {
			currNode = currNode.left;
		}
		return(currNode);
	}



	Node delete(Node node, String word)
    {
        if (node == null)
            return node;
        if (word.compareTo(node.data.getWord()) < 0 )
            node.left = delete(node.left, word);
        else if (word.compareTo(node.data.getWord())>0)
            node.right = delete(node.right, word);

           
        else
        {
        	if ((node.left == null) || (node.right == null))
            {
                Node temp = null;
                if (temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null)
                {
                    temp = node;
                    node = null;
                }
                else
                    node = temp; 
            }
            else
            {
            	Node temp = MinimumValueNode(node.right);
            	node.data = temp.data;
            	node.right = delete(node.right, temp.data.getWord());
            }
        }

        if (node == null)
            return node;

        node.height = Max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0)
        {
        	 return rightRotation(node);
        }
           
        if (balance > 1 && getBalance(node.left) < 0)
        {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotation(node);

        if (balance < -1 && getBalance(node.right) > 0)
        {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }
	
	
	

	public void DisplayPreOrder(Node node) {
		if(node != null) {
			System.out.println("  "+node.data.getWord()+" : "+node.data.getMeaning());
			DisplayPreOrder(node.left);
			DisplayPreOrder(node.right);
		}
	}
	
	public void DisplayPostOrder(Node node) {
		if(node != null) {
			DisplayPreOrder(node.left);
			DisplayPreOrder(node.right);
			System.out.println("  "+node.data.getWord()+" : "+node.data.getMeaning());
		}
	}

	
	public void DisplayInOrder(Node node) {
		if(node != null) {
			DisplayPreOrder(node.left);
			System.out.println("  "+node.data.getWord()+" : "+node.data.getMeaning());
			DisplayPreOrder(node.right);
		}
	}

	public Node Search(Node node, String word) {
		if(node == null) {
			return(null);
		}
		else {
			while(node != null) {
				if((word.compareToIgnoreCase(node.data.getWord()))<0){
					node = node.left;
				}
				else if((word.compareToIgnoreCase(node.data.getWord()))>0) {
					node = node.right;
				}
				else {
					return(node);
				}
			}
		}
		return(null);
	}
	
}
		



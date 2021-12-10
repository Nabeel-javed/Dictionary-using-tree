
import java.util.*;
import java.io.*;
public class Main {

	
		
		public static void main(String[] args) {
			
			AVLTree tree= new AVLTree();
			File_Write sc = new File_Write();
			sc.readFile(tree);

		
			
		while(true)
			{
				System.out.println("Please select any option");
				{
					System.out.println("1): Display (Pre-Order)");
					System.out.println("2): Display (Post-Order)");
					System.out.println("3): Display (In-Order)");
					System.out.println("4): Search for the Word and its Meaning");
					System.out.println("5): Delete a Word");
					System.out.println("6): Write to File (Pre-Order) ");
					System.out.println("7): Write to File (Post-Order) ");
					System.out.println("8): Write to File (In-Order) ");
					System.out.println("9): Is tree Balanced?");
					
					Scanner input = new Scanner(System.in);
					int choice=input.nextInt();
					
					switch(choice)
					{
					
					
					case 1:
					{
						tree.DisplayPreOrder(tree.root);
						break;
					}
					
					case 2:
					{
						tree.DisplayPostOrder(tree.root);
						break;
					}
					
					case 3:
					{
						tree.DisplayInOrder(tree.root);
						break;
					}
					
					case 4:
					{
						System.out.println("Enter the word");
						String word=input.next();
						System.out.print(tree.Search(tree.root, word).data.getWord());
						System.out.println(":" + tree.Search(tree.root, word).data.getMeaning());
						break;
					}

					
					case 5:
					{
						System.out.println("Enter the word to delete");
						String word=input.next();
						tree.delete(tree.root, word);
						break;
					}
					
					case 6:
					{
						File_Write obj = new File_Write();
						obj.WritePreOrder(tree);
						break;
					}
					
					case 7:
					{
						File_Write obj = new File_Write();
						obj.WritePostOrder(tree);
						break;
					}
					
					case 8:
					{
						File_Write obj = new File_Write();
						obj.WriteinOrder(tree);
						break;
					}
					case 9:
					{
						if (tree.isBalanced(tree.root))
				            System.out.println("Tree is balanced");
				        else
				            System.out.println("Tree is not balanced");
						break;
					}
					}
				}
			}
		}
			}

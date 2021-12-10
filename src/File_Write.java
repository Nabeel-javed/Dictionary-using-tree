import java.io.*;
import java.util.Scanner;

public class File_Write {

	AVLTree tree;
	
	
	public void WritePostOrder(AVLTree tree) {
		
			try {
				File myfile = new File("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\PostOrderAlpha.txt");
				if(myfile.createNewFile()) {
					System.out.println("Saved to New File Created successfully.");
				}
				else {
					System.out.println("File Aleady Exixts.");
				}
				FileWriter mywriter = new FileWriter("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\PostOrderAlpha.txt");
				BufferedWriter bw = new BufferedWriter(mywriter);
				Write_postorder_recursive(tree.root, mywriter);
				mywriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	
	
	
	public void Write_postorder_recursive(Node ptrNode, FileWriter bw) {
		if(ptrNode != null) {
			Write_postorder_recursive(ptrNode.left, bw);
			Write_postorder_recursive(ptrNode.right, bw);
			
			try {
				bw.write(ptrNode.data.getWord() + " " + ptrNode.data.getMeaning());
				bw.write("\n");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			return;
		}
	}
	
	

	/*------------------------------------------------
	--------------------------------------------------
	------------------------------------------------*/
	public void WritePreOrder(AVLTree tree) {
		
		try {
			File myfile = new File("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\PreOrderAlpha.txt");
			if(myfile.createNewFile()) {
				System.out.println("Saved to New File Created successfully.");
			}
			else {
				System.out.println("File Aleady Exixts.");
			}
			FileWriter mywriter = new FileWriter("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\PreOrderAlpha.txt");
			BufferedWriter bw = new BufferedWriter(mywriter);
			Write_preorder_recursive(tree.root, mywriter);
			mywriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}



public void Write_preorder_recursive(Node ptrNode, FileWriter bw) {
	if(ptrNode != null) {
		
		try {
			bw.write(ptrNode.data.getWord() + " " + ptrNode.data.getMeaning());
			bw.write("\n");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Write_preorder_recursive(ptrNode.left, bw);
		Write_preorder_recursive(ptrNode.right, bw);
		
	}
	else {
		return;
	}
}


/*------------------------------------------------
--------------------------------------------------
------------------------------------------------*/

public void WriteinOrder(AVLTree tree) {
	
	try {
		File myfile = new File("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\InOrderAlpha.txt");
		if(myfile.createNewFile()) {
			System.out.println("Saved to New File Created successfully.");
		}
		else {
			System.out.println("File Aleady Exixts.");
		}
		FileWriter mywriter = new FileWriter("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\InOrderAlpha.txt");
		BufferedWriter bw = new BufferedWriter(mywriter);
		Write_Inorder_recursive(tree.root, mywriter);
		mywriter.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}



public void Write_Inorder_recursive(Node ptrNode, FileWriter bw) {
if(ptrNode != null) {
	Write_postorder_recursive(ptrNode.left, bw);
	
	try {
		bw.write(ptrNode.data.getWord() + " " + ptrNode.data.getMeaning());
		bw.write("\n");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	Write_postorder_recursive(ptrNode.right, bw);
}
else {
	return;
}
}
	



public static void readFile(AVLTree tree) {
	try {
		File myFile = new File("C:\\Users\\Nabeel Javed\\Pictures\\Screenshots\\Alpha.txt");
		Scanner myReader= new Scanner(myFile);
		while(myReader.hasNextLine()) {
			Dictionary sc = new Dictionary();
			String line = myReader.nextLine();
			if(line!="") {
				String[] term = line.split(" ");
				int length = term.length;
				
				String word = term[0];
				int i = 0;
				
				
				String meaning = "";
				while(i<(length-1)) {
					i++;
					meaning = meaning.concat(" ").concat(term[i]);
				}

				sc.setWord(word);
				sc.setMeaning(meaning);
				tree.root = tree.Insert(tree.root, sc);
			}
		}
		myReader.close();
	}
	catch(FileNotFoundException e) {
		System.out.println("Error Occured.");
		e.printStackTrace();
		System.out.println("File Not Found.");
	}
}

}

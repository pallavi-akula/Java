import java.io.*;
public class FileReaderExample {

	
		   public static void main(String args[])throws IOException {
		      File file = new File("Welcome.txt");
		      file.createNewFile();  
		      FileWriter writer = new FileWriter(file); 
		      writer.write("Hello\n welcome \n"); 
		      writer.flush();
		      writer.close();  
		      FileReader fr = new FileReader(file); 
		      char [] a = new char[50];
		      fr.read(a);   // reads the content to the array  
		      for(char c : a)
		         System.out.print(c);   
		      fr.close();
		   }
		


	}



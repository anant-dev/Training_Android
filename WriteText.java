import java.io.*;
public class WriteText{
	public static void main(String args []) throws IOException{

		File file = new File("textfile.txt");
		file.createNewFile();
		String s="This is \n a \n dummy text \n data";
				
		FileWriter writer = new FileWriter(file);
		writer.write(s);
		writer.flush();
		writer.close();
	}
}
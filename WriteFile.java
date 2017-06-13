import java.io.*;
public class WriteFile{
	public static void main(String args []) throws IOException{

		File file = new File("bytefile.txt");
		file.createNewFile();
		String s="This is \n a \n dummy text \n data";
				
		FileOutputStream writer= new FileOutputStream( file );
		writer.write(s.getBytes());
		writer.flush();
		writer.close();
	}
}
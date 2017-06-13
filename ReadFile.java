import java.io.*;
public class ReadFile {
	public static void main(String args[]) throws IOException{
		BufferedReader br= new BufferedReader(new FileReader("textfile.txt"));
		String cline;
		while((cline=br.readLine()) != null){
			System.out.println(cline);
		}
		br.close();
		
	}

}
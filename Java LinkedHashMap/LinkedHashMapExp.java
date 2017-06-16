package test;
import java.util.*;

public class LinkedHashMapExp {
	public static void main(String args[]) throws Exception{
		LinkedHashMap<Integer,Book> lmap=new LinkedHashMap<Integer, Book>();
		Book b1=new Book(101,"Let us C","BPB");  
		Book b2=new Book(102,"Data Communications & Networking","Mc Graw Hill");  
		Book b3=new Book(103,"Operating System","Wiley");  
		lmap.put(2, b1);
		lmap.put(1, b2);
		lmap.put(3, b3);
		for (Map.Entry<Integer,Book> entry: lmap.entrySet()){
			int key=entry.getKey();
			Book b= entry.getValue();
			System.out.println("key :  "+key+"  Details : Id = "+b.getmId()+" , Title =  "+b.getmName()+" , Publisher =  "+b.getmPublisher());
		}
		lmap.remove(2);
		System.out.println("\nHash Map after deletion of entry\n");
		for (Map.Entry<Integer,Book> entry: lmap.entrySet()){
			int key=entry.getKey();
			Book b= entry.getValue();
			System.out.println("key :  "+key+"  Details : Id = "+b.getmId()+" , Title =  "+b.getmName()+" , Publisher =  "+b.getmPublisher());
		}
		
		
	}
}

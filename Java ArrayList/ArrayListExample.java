package test;
import java.util.*;  

public class ArrayListExample {  
public static void main(String[] args) {  
    //Creating list of Books  
    List<Book> list=new ArrayList<Book>();  
    //Creating Books  
    Book b1=new Book(101,"Let us C","BPB");  
    Book b2=new Book(102,"Data Communications & Networking","Mc Graw Hill");  
    Book b3=new Book(103,"Operating System","Wiley");  
    //Adding Books to list  
    list.add(b1);  
    list.add(b2);  
    list.add(b3);  
    //Traversing list  
    for(Book b:list){  
        System.out.println(b.getmId()+" "+b.getmName()+" "+" "+b.getmPublisher());  
    }  
}  
}  

package test;
import java.util.*;  
public class LinkedListExamp {
	public static void main(String[] args) {
		List <Employee> ls= new LinkedList<Employee>();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		e1.insertData(101, "John", 25000);
		e2.insertData(103, "Harshit", 50000);
		e3.insertData(108, "Kavya", 38000);
		ls.add(e1);
		ls.add(e2);
		ls.add(e3);
		e1.display();
		e2.display();
		e3.display();
		
	}

}

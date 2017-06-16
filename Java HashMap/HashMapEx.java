package test;
import java.util.*;
public class HashMapEx {
	public static void main(String args[])throws Exception{
		HashMap <Integer,Employee> map= new HashMap<Integer,Employee>();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		e1.insertData(101, "John", 25000);
		e2.insertData(103, "Harshit", 50000);
		e3.insertData(108, "Kavya", 38000);
		map.put(1, e1);
		map.put(2, e2);
		map.put(3, e3);
		for(Map.Entry<Integer, Employee> entry: map.entrySet()){
			int key=entry.getKey();
			Employee e= entry.getValue();
			System.out.println("key :  "+key+"  Details :  ");
			e.display();
			
		}
	}

}

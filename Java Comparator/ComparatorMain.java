package test;
import java.util.*;
public class ComparatorMain {
	public static void main(String args[])throws Exception{
		ArrayList<Employee> ae=new ArrayList<Employee>();
		
		Employee e1=new Employee();
		Employee e2=new Employee();
		Employee e3=new Employee();
		Employee e4=new Employee();
		e1.insertData(101, "John", 30000);
		e2.insertData(103, "Charles", 45000);
		e3.insertData(105, "Harry", 25000);
		e4.insertData(100, "Zyan", 100000);
		
		ae.add(e1);
		ae.add(e2);
		ae.add(e3);
		ae.add(e4);
		
		System.out.println("Original List ");
		for(Employee e:ae){  
	        System.out.println(e.getmId()+" "+e.getmName()+" "+" "+e.getmSalary());  
	    }  
		
		System.out.println("Sorting by Name...");  
		  
		Collections.sort(ae,new NameComparator()); 
		for(Employee e:ae){  
	        e.display();
	    }  
		
		System.out.println("Sorting by Salary...");  
		  
		Collections.sort(ae,new SalaryComparator()); 
		for(Employee e:ae){  
	        e.display();
	    }  
		
	
	}

}

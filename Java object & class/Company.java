package test;

public class Company {
	public static void main (String args[]) throws Exception{
		Employee e1= new Employee();
		Employee e2= new Employee();
		Employee e3= new Employee();
		e1.insertData(101, "Anant", 30000);
		e2.insertData(102, "Shweta", 33000);
		e3.insertData(103, "Kanishk", 34000);
		e1.display();
		e2.display();
		e3.display();
	}
}

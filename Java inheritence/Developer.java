package test;

public class Developer extends Employee{
	public static void main(String args []) throws Exception{
		Employee e1= new Employee();
		Employee e2= new Employee();
		e1.insertData(101, "Anant", 30000);
		e2.insertData(102, "Shweta", 33000);
		e1.display();
		e2.display();
		e1.bonus(1000);
		e2.bonus(2000);
	}
}

package test;

public class Employee {
	private int mId;
	private String mName;
	private float mSalary;
	
	public void insertData(int id, String name, float salary ) {
		mId=id;
		mName=name;
		mSalary=salary;
	}
	
	public void display(){
		System.out.println("Employee Id =  "+mId+",  Employee name =  "+mName+",  Employee salary =  "+mSalary);
	}
}

package test;

public class Encapsulation {
	public static void main(String args[]) throws Exception{
		Student s=new Student();
		s.setmName("Anant");
		s.setmBranch("Information Technology");
		s.setmRollno(123);
		s.setmPercentage((float) 75.65);
		System.out.println("Name :  "+s.getmName()+", Branch :  "+s.getmBranch()+", Roll numb :  "+s.getmRollno()+", Percentage :  "+s.getmPercentage()); 
	}
}

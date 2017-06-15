package test;

public class Sum {
	// function overloading
	public int sum(int a, int b){
		return (a+b);
	}
	public int sum(int a, int b,int c){
		return (a+b+c);
	}
	public double sum(double a, double b){
		return (a+b);
	}
	public double sum(double a, double b, double c){
		return (a+b+c);
	}
	
	public static void main(String args[]) throws Exception{
		Sum s=new Sum();
		System.out.println("int and two parameter -  "+ s.sum(10,12));
		System.out.println("int and three parameter -  "+ s.sum(38,12,99));
		System.out.println("double and two parameter -  "+ s.sum(8.9,4.5));
		System.out.println("double and three parameter -  "+ s.sum(9.3,4.4,1.2));
	}
}

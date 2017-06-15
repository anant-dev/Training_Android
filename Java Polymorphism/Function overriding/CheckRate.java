package test;

public class CheckRate {
	public static void main(String args[]){  
		Sbi s=new Sbi();  
		Icici i=new Icici();  
		Axis a=new Axis(); 
		Hdfc h =new Hdfc();
		System.out.println("SBI Rate of Interest: "+s.getRateOfInterest());  
		System.out.println("ICICI Rate of Interest: "+i.getRateOfInterest());  
		System.out.println("AXIS Rate of Interest: "+a.getRateOfInterest());  
		System.out.println("AXIS Rate of Interest: "+h.getRateOfInterest()); 
		}  
}
 
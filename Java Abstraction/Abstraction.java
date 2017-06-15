package test;
// bike is the abstract class
abstract class Bike{
	abstract void run();
	abstract void checkup();
}

class Honda extends Bike{
	void run(){
		System.out.println("Honda bike is Running Great");
	}
	void checkup(){
		System.out.println("no need for checkup");
	}
}

class TVS extends Bike{
	void run(){
		System.out.println("TVS bike is Running decent ");
	}
	void checkup(){
		System.out.println("needs checkup within 10 days");
	}
}
public class Abstraction {
	public static void main(String args []) throws Exception{
		Honda h= new Honda();
		TVS t=new TVS();
		h.run();
		h.checkup();
		t.run();
		t.checkup();
	}
	
	
}

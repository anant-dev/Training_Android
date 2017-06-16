package test;

public class Employee {
	private int mId;
	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public float getmSalary() {
		return mSalary;
	}

	public void setmSalary(float mSalary) {
		this.mSalary = mSalary;
	}

	private String mName;
	private float mSalary;
	private float mBonus;
	
	public void insertData(int id, String name, float salary ) {
		mId=id;
		mName=name;
		mSalary=salary;
	}
	
	public void display(){
		System.out.println("Employee Id =  "+mId+",  Employee name =  "+mName+",  Employee salary =  "+mSalary);
	}
	
	public void bonus(float bonus){
		mBonus=bonus;
		float tsalary= bonus+mSalary;
		System.out.println("Bonus is =  "+mBonus+",  Salary after adding bonus =  "+tsalary);
	}
}

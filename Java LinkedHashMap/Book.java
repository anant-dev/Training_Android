package test;
class Book {  
	private int mId;  
	private String mName;  
	private String mPublisher; 
	// function to put values in data members
	public Book(int id, String name, String publisher) {  
	    mId = id;  
	    mName = name;  
	    mPublisher = publisher;  
	}  
	
	// Getter setter functions to access private data members
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
	
	public String getmPublisher() {
		return mPublisher;
	}
	
	public void setmPublisher(String mPublisher) {
		this.mPublisher = mPublisher;
	}
}  

import java.util.Comparator;

public class Message {
		String message,timestamp;
		String Uid;
		public Message(String Uid, String message, String timestamp){
			 //System.out.println("msg see"+Uid+message+timestamp);
			this.Uid=Uid;
			this.message=message;
			this.timestamp=timestamp;
		}
		
		
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getUid() {
			return Uid;
		}
		public void setUid(String uid) {
			Uid = uid;
		}
		
		
		
		
		
		//Getter and setter methods same as the above examples
	    /*Comparator for sorting the list by Student Name*/
	    public static Comparator<Message> TimestampComparator = new Comparator<Message>() {

		public int compare(Message m1, Message m2) {
		   String timestamp1 = m1.getTimestamp().toUpperCase();
		   String timestamp2 = m2.getTimestamp().toUpperCase();

		   //ascending order
		   return timestamp2.compareTo(timestamp1);

		   //descending order
		   //return StudentName2.compareTo(StudentName1);
	    }};

	    /*Comparator for sorting the list by roll no*/
	    public static Comparator<Message> Uidcomparator = new Comparator<Message>() {
		public int compare(Message m1, Message m2) {

		   String uid1 = m1.getUid().toUpperCase();
		   String uid2 = m2.getUid().toUpperCase();

		   /*For ascending order*/
		   return uid1.compareTo(uid2);

		   /*For descending order*/
		   //rollno2-rollno1;
	   }};
	    @Override
	    public String toString() {
	        return Uid + ", " + message + ", " + timestamp;
	    }		
		
}


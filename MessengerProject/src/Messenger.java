import java.text.SimpleDateFormat;
import java.util.*;
 

public class Messenger {
	 ArrayList<Message> a =new ArrayList<Message>();
	 Scanner sc=new Scanner(System.in); 
	 
	 public static void main(String args[]){
		 int state = 1;
		 Messenger mr= new Messenger();
		 while(state!=2){
			 mr.getDetails();			 
			 System .out.print("\n\nPress 1 to send a message or  press 2 to exit\n");
			 state =  mr.sc.nextInt();
		 }
		 
		 for (Message b : mr.a) {
			    System.out.println(b );
			}
		 
		 
		
		   System.out.println("\n\n \n\n Sorting based on TimeStamp");
		   Collections.sort(mr.a, Message.TimestampComparator);

		   for(Message str: mr.a){
				System.out.println(str);
		   }

		   System.out.println("\n\n \n\nGrouping based on Uid");
		   
		   Collections.sort(mr.a, Message.Uidcomparator);
		   for(Message str: mr.a){
				System.out.println(str);
		   }
		 
		 
		 
		 
		 
		 mr.sc.close();
	 }  
	 
	 public void getDetails(){
		
		 System .out.print("Enter your user ID\n");
		 String id=  new Messenger().sc.next();
		 System.out.println("Enter your Message\n");
		 String msg=  new Messenger().sc.nextLine();
		 Message m=new Message(id,msg,new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(Calendar.getInstance().getTime()));
		 a.add(m);
		 
		 
		 
		 
		 }
	 
}



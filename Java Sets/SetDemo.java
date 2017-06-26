package test;
import java.util.*;

public class SetDemo {
	public static void main(String args[]) throws Exception{
		int values[]={22,39,88,1,47,76,94};
		Set<Integer> set = new HashSet<Integer>();
				
		for(int i=0;i<7;i++){
			set.add(values[i]);
		}
		
		System.out.println(set);
	}

}

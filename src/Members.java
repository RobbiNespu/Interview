import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Members {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member mary = new Member("mary", "mary.gamil.com", null);
		Member mark = new Member("mark", "mark.gamil.com", null);
		ArrayList<Member> krissfriends = new ArrayList<Member>();
		krissfriends.add(mary);
		krissfriends.add(mark);
				
		Member kris = new Member("kris", "kris.gamil.com", krissfriends);
		Member fang = new Member("fang", "fang.gamil.com", null);
		
		ArrayList<Member> mellonsfriends = new ArrayList<Member>();
		mellonsfriends.add(kris);
		mellonsfriends.add(fang);
		Member mellon = new Member("mellon", "mellon@gmail.com", mellonsfriends);
		printSocialGraph(mellon);
	}

	 static class Member {
	    public  String name;
	    public  String email;
	    public  ArrayList<Member> friends = null;
	    
	    public Member(String name, String email, ArrayList<Member> friends){
	    	this.name =name;
	    	this.email = email;
	    	this.friends = friends;
	    }
	}
	
	public static void printSocialGraph(Member m) {
	    Queue<Member> queue = new LinkedList<Member>();
	    queue.add(m);
	
		while(!queue.isEmpty()) {
			Member currentMember = queue.remove();
			if (currentMember == null)
	            continue;
			
			if(currentMember.friends != null){
				for(Member friend : currentMember.friends){
					queue.add(friend);
	            	System.out.println("Name:"+friend.name+"\t Email:"+ friend.email);
	            }
			}
	    }
	}
}


public class LinkedList {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    List list = new List();
	    list.insertList(5);
	    list.insertList(7);
	    list.insertList(8);
	    //list.visitList();
	    
	    list.deleteList(8);
	    list.visitList();
	}
	
}

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		next = null;
	}
}

class List{
	Node head;
	public List()
	{
		head = null;
	}
	
	public void insertList(int data){
		Node new_node, p, q;
		new_node = new Node(data);
		p = q = head;
		while(p!=null&&p.data< data){
			q = p;
			p = p.next;
		}
		new_node.next = p;
		if(p == head)
			head = new_node;
		else
		    q.next = new_node;
	};
	
	public void deleteList(int data){
		Node p, q;
		p = q = head;
		while(p!=null && p.data != data){
			q=p;
			p=p.next;
		}
		
		if(p!=null){
			if(p==head){
				head = p.next;
			}else{
				q.next = p.next;		
			}
		}	
	};
	
	public void visitList(){
		Node p = head;
		while(p!=null){
			System.out.println(p.data + "\t");
			p = p.next;
		}
	};
}

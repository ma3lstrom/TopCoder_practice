package ch2;

public class CustomLinkedList {
	
	class Node{
		Node next; 
		int value;
		
		Node(Node next, int value){
			this.next = next; 
			this.value = value;
		}
		
		Node(int value){
			this.value = value;
		}
		
		public Node getNext(){
			return next;
		}
		
		public int getValue(){
			return value; 
		}
	}
	
	Node head; 
	
	public void addToHead(int value){
		head = new Node(head, value); 
	}
	
	public void addToTail(int value){
		Node end = new Node(value);
		Node temp = head;
		if (temp == null){
			head = end;
			return;
		}
		while (temp.next!=null){
			temp = temp.next;
		}
		temp.next = end;
	}
	
	public boolean remove(int value){
		Node temp = head; 
		if (temp.value == value)
			head = head.next;
		
		while(temp.next!=null){
			if (temp.next.value == value){
				temp.next = temp.next.next;
				return true; 
			}
			else 
				temp = temp.next;
		}
		return false; 
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public boolean checkCycle(CustomLinkedList ll){
		Node walker = ll.head;
		Node runner = ll.head.next;
		if (runner == null|| walker == null)
			return false;
		while (walker!=runner){
			if (runner == null|| walker == null)
				return false;
			walker = walker.next;
			runner = runner.next.next;
		}
		return true;
	}
	
	public Node getStartCycle(CustomLinkedList ll){
		Node walker = ll.head;
		Node runner = ll.head.next;
		if (runner == null|| walker == null)
			return null;
		while (walker!=runner){
			if (runner == null|| walker == null)
				return null;
			walker = walker.next;
			runner = runner.next.next;
		}
		walker = ll.head; 
		while (walker!=runner){
			walker = walker.next;
			runner = runner.next;
		}
		return walker;
	}
	
	public static boolean isPalindrome(CustomLinkedList ll){
		Node front = ll.head;
		if (front == null)
			return false;
		Node run = front.next;
		if (run == null)	// one value is always a palindrom
			return true;
		Node end = run.next;
		while (end != null){
			end = end.next;
		}
		while (front != end || run !=end){

			System.out.print(front.value+":"+end.value);
			if (run.next == end){
				if (front.value != run.value)
					return false;
				else{
					end = run;
					front = front.next;
					run = front.next;
				}
			}
			else 
				run = run.next;
		}
		return true;
	}
	 
	public String toString(){
		StringBuffer buf = new StringBuffer();
		while (head!=null){
			if (head.next != null)
				buf.append(head.value + ",");
			else 
				buf.append(head.value); 
			head = head.next;
		}
		return buf.toString();
	}
	

	public static void main(String[] args) {
		CustomLinkedList ll = new CustomLinkedList();
		ll.addToHead(1);
		ll.addToHead(2);
		ll.addToHead(2);
		ll.addToHead(1);
		//ll.remove(3);
		System.out.println(ll);
		if (isPalindrome(ll))
			System.out.println("Palindrome");
		else 
			System.out.println("Not palindrome");
	}

}

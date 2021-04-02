/// By: Merna Alghannam

import java.util.*; 
import java.io.*;
class Llist{
  static class Node {

    int data;
    Node next;

    Node(int d)
    {
      data = d;
      next = null;
    }
  }

  static class LinkedList {

    static Node head, head1, head2; 
    // prints content of double linked list
    void printList(Node node)
    {
      while (node != null) {
        System.out.print(node.data + " ");
        node = node.next;
      }
    }

  }  
     
  /* Function to reverse the linked list */
  static Node reverse(Node node)
  {
    Node prev = null;
    Node current = node;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  static Node detectAndRemoveLoop(Node head){
    // If list is empty or has 
    // only one node without loop
    if (head == null || head.next == null)
      return null;

    Node slow = head, fast = head;

    // Move slow and fast 1 
    // and 2 steps ahead 
    // respectively.
    slow = slow.next;
    fast = fast.next.next;

    // Search for loop using 
    // slow and fast pointers
    while (fast != null && 
            fast.next != null) 
    {
      if (slow == fast)
        break;
      slow = slow.next;
      fast = fast.next.next;
    }

    // If loop does not exist
    if (slow != fast)
      return null;

    // If loop exists. Start slow from
    // head and fast from meeting point.
    slow = head;
    while (slow != fast) 
    {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  /* function to insert a new_node in a list. */
  static Node sortedInsert(Node head, int node_data) 
  { 
      Node current; 
      Node new_node = new Node(node_data);

      /* Special case for head node */
      if (head == null || head.data  >= new_node.data) { 
          new_node.next = head; 
          head = new_node; 
          return head;
      } 
      else { 

          /* Locate the node before point of insertion. */
          current = head; 

          while (current.next != null && current.next.data < new_node.data) 
              current = current.next; 

          new_node.next = current.next; 
          current.next = new_node; 
      }

      return head; 
  } 

    // function to find the intersection of two node 
  public static Node MegeNode(Node n1, Node n2) { 
    // define hashset 
    HashSet<Node> hs = new HashSet<Node>(); 
    while (n1 != null) { 
        hs.add(n1); 
        n1 = n1.next; 
    } 
    while (n2 != null) { 
        if (hs.contains(n2)) { 
            return n2; 
        } 
        n2 = n2.next; 
    } 
    return null; 
  } 

    // function to print the list 
  public static void Print(Node n) 
  { 
      Node cur = n; 
      while (cur != null) { 
          System.out.print(cur.data + "  "); 
          cur = cur.next; 
      } 
      System.out.println(); 
  } 

	// Driver Code
	public static void main(String[] args)
	{

    // for reversing a linked list
    Node head1;
		LinkedList list = new LinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
    list.printList(list.head);
		head1 = reverse(list.head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head1);
    System.out.println();
    
    // for finding a loop
    Node head = new Node(50);
    head.next = new Node(20);
    head.next.next = new Node(15);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(10);
  
    // Create a loop for testing
    head.next.next.next.next.next = head.next.next;
  
    Node res = detectAndRemoveLoop(head);
    if (res == null)
      System.out.println("Loop does not exist");
    else
      System.out.println("Loop starting node is " +  res.data);

    // for the sorting list method
		LinkedList llist = new LinkedList();
		llist.head = new Node(2);
		llist.head.next = new Node(9);
		llist.head.next.next = new Node(12);
		llist.head.next.next.next = new Node(20);
    System.out.println("Created list "); 
    llist.printList(llist.head); 
    System.out.println();
    
    Node head2 = sortedInsert(llist.head, 15); 
    System.out.println("Sorted list "); 
    llist.printList(head2); 
    System.out.println();

    // for the function for finding merge point
    LinkedList llist1 = new LinkedList();
    //list 1
    llist1.head1 = new Node(1); 
    llist1.head1.next = new Node(2); 
    llist1.head1.next.next = new Node(3); 
    llist1.head1.next.next.next = new Node(4); 
    llist1.head1.next.next.next.next = new Node(5); 
    llist1.head1.next.next.next.next.next = new Node(6); 
    llist1.head1.next.next.next.next.next.next = new Node(7); 
    // list 2 
    llist1.head2 = new Node(10); 
    llist1.head2.next = new Node(9); 
    llist1.head2.next.next = new Node(8); 
    llist1.head2.next.next.next = llist1.head1.next.next.next; 

    System.out.println("List 1 "); 
    llist1.printList(llist1.head1);
    System.out.println("\nList 2 ");
    llist1.printList(llist1.head2); 
    System.out.println("\nThe merge point: " + MegeNode(llist1.head1, llist.head2).data); 
	}
}

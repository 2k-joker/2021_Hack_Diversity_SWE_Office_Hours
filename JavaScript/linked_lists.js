class LinkedListNode {
  constructor(data) {
    this.data = data
    this.next = null
  }
}

class LinkedList {
  head = null;
  tail = null;

  constructor(head = null) {
    this.head = head
  }

  append = (value) => {
    const item = new LinkedListNode(value);

    if (!this.head) {
      this.head = item
      this.tail = item

      return
    }

    this.tail.next = item
    this.tail = item
  }

  printAll = () => {
    let curr = this.head;

    while (!!curr) {
      console.log(curr.data);
      curr = curr.next;
    }
  }
}

/**
 * Reverse a LinkedList
 * 
 * Write a function that takes the head of a linkedlist, reverses it and returns the new head. Assume the head will never be null.
 * 
 * Example: input => 1->2->3->4->5 | output => 5->4->3->2->1
 */

function reverseLinkedList(linkedList) {
  let previous = null;
  let current = linkedList.head;

  while (current !== null) {
    let next = current.next;
    current.next = previous;
    previous = current;
    current = next;
  }

  return previous;
}

/**
 * Find the Loop
 * 
 * Given a linkedlist, identify whether it has a loop or not. If it does, return the data of the node at the start of the loop. If it does not, return null.
 * 
 * Example: input => 1->2->3->4->5->3 | output => 3
Example: input => 1->2->3->4->5->6 | output => null
 */

function findTheLoop(linkedList) {
  let set = new Set();
  let temp = linkedList.head;

  while (temp) {
    if (set.has(temp.data)) {
      return temp.data;
    }

    set.add(temp.data);
    temp = temp.next;
  }

  return null;
}

/**
 * Sorted Insert Node
 * 
 * Given the head of a sorted LinkedList and an integer, create a new Node with the integer as its data, and insert the node into the LinkedList, so that the list remains sorted.
 * 
 * Example: input => 1->2->4->5, 3 | output => 1->2->3->4->5
 */

function sortedInsertNode(linkedList, int) {
  let newNode = new LinkedListNode(int);

  if (!linkedList.head || linkedList.head.data >= int) {
    newNode.next = linkedList.head;
    linkedList.head = newNode;
    return linkedList;
  } else {
    let current = linkedList.head;

    while (!!current.next && current.next.data < newNode.data) {
      current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
  }

  linkedList.printAll();

  return linkedList;
}

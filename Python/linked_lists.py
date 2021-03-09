### By: Khalil Kum ###

#########################################################################
# useful linkedlist objects/methods
class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self, head=None):
        self.head = head

    def insertTail(self, data):
        newNode = Node(data)
        if self.head is None:
            self.head = newNode
        else:
            lastNode = self.head
            while True:
                if lastNode.next is None:
                    break
                lastNode = lastNode.next
            lastNode.next = newNode

    def getNodeAt(self, index):
        if self.head is None:
            return None
        counter = 1
        currentNode = self.head
        while counter < index:
            if currentNode is None:
                return None
            currentNode = currentNode.next
            counter += 1
        return currentNode

    def print_list(self):
        if self.head is None:
            return "List is empty"
        currentNode = self.head
        result = []
        while True:
            if currentNode is None:
                break
            result.append(currentNode.data)
            currentNode = currentNode.next
        return print(f"LinkedListData: {(' -> ').join(result)}")


def createLinkedList(data_arr):
    llist = LinkedList()

    for i in data_arr:
        llist.insertTail(i)

    return llist

#####################################################################

# 'Reverse a linkedlist' problem
# Average runtime: O(n)
def reverseLinkedList(head):
    if head.next is None:
        return head

    currentPointer = head
    previousPointer = None

    while currentPointer:
        holder = currentPointer.next
        currentPointer.next = previousPointer
        previousPointer = currentPointer
        currentPointer = holder

    return previousPointer

# 'Find the loop' problem
# Average runtime: O(n)
def findLoop(head):
    if head is None:
        return None

    slowRunner = fastRunner = head

    while fastRunner is not None and fastRunner.next is not None:
        fastRunner = fastRunner.next.next
        slowRunner = slowRunner.next

        if fastRunner == slowRunner:
            break

    if fastRunner is None or fastRunner.next is None:
        return None

    slowRunner = head

    while slowRunner != fastRunner:
        slowRunner = slowRunner.next
        fastRunner = fastRunner.next

    return fastRunner

# 'Insert sorted node' problem
# Average runtime: O(n)
def insertSortedNode(head, data):
    newNode = Node(data)
    currentNode = head

    if currentNode.data > newNode.data:
        newNode.next = currentNode
        head = newNode
        return head

    while True:
        if currentNode.next is None:
            currentNode.next = newNode
            break
        elif currentNode.next.data >= newNode.data:
            newNode.next = currentNode.next
            currentNode.next = newNode
            break
        currentNode = currentNode.next

    return head

# 'Find merge point' bonus problem
# Average runtime:O(n)
def findMergeNode(head1, head2):
    node1 = head1
    node2 = head2
    count1 = count2 = 0

    while node1:
        count1 += 1
        node1 = node1.next
    
    while node2:
        count2 += 1
        node2 = node2.next
    
    node1 = head1
    node2 = head2
    
    if count1 > count2:
        d = count1 - count2
        i =0
        while i < d:
            node1 = node1.next
            i += 1
        while node1 and node2:
            if node1 == node2:
                return node1.data
            node1 = node1.next
            node2 = node2.next
    elif count2 > count1:
        d = count2 - count1
        i =0
        while i < d:
            node2 = node2.next
            i += 1
        while node1 and node2:
            if node1 == node2:
                return node1.data
            node1 = node1.next
            node2 = node2.next
    else:
        while node1 and node2:
            if node1 == node2:
                return node1.data
            node1 = node1.next
            node2 = node2.next
        
    return None
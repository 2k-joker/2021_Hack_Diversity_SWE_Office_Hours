### By: Khalil Kum ###

############################ Helpers ##################################
from collections import defaultdict 

class Graph(): 
    def __init__(self,vertices): 
        self.graph = defaultdict(list) 
        self.V = vertices 
  
    def addEdge(self,u,v): 
        self.graph[u].append(v) 

def createGraph(vertex_count, vertex_pairs):
  graph = Graph(vertices=vertex_count)

  for pair in vertex_pairs:
    graph.addEdge(pair[0], pair[1])

  return graph


class Node:
  def __init__(self, data = None):
    self.data = data
    self.left = None
    self.right = None

class BinaryTree:
  def __init__(self, root=None):
    self.root = root

  def createNode(self, data):
    if not self.root:
      self.root = Node(data)
    else:
      currentNode = self.root

      while True:
        if data < currentNode.data:
          if currentNode.left:
            currentNode = currentNode.left
          else:
            currentNode.left = Node(data)
            break
        elif data > currentNode.data:
          if currentNode.right:
            currentNode = currentNode.right
          else:
            currentNode.right = Node(data)
            break
        else:
          break

def createBinaryTree(values):
  bst = BinaryTree()

  for v in values:
    bst.createNode(v)

  return bst

##############################################################################

# 'Detect Loop in Graph' Problem
def hasLoop(graph): 
    visited = [False] * graph.V 
    recStack = [False] * graph.V 
    for node in range(graph.V): 
        if visited[node] == False: 
            if loopDetectionHelper(graph,node,visited,recStack) == True: 
                return True
    return False

# recurssion helper method for finding loops in graph
def loopDetectionHelper(graph_object, node, visited, recStack): 

    # Mark current node as visited and  
    # adds to recursion stack 
    visited[node] = True
    recStack[node] = True

    # Recur for all neighbours 
    # if any neighbour is visited and in  
    # recStack then node is cyclic 
    for neighbour in graph_object.graph[node]: 
        if visited[neighbour] == False: 
            if loopDetectionHelper(graph_object,neighbour, visited, recStack) == True: 
                return True
        elif recStack[neighbour] == True: 
            return True

    # The node needs to be poped from  
    # recursion stack before function ends 
    recStack[node] = False
    return False


# 'Binary Search Tree Validation' problem
def validateBST(root):
  if not root:
    return False
  
  def check(node, lv, rv):
    if not node:
      return True
    if lv >= node.data or rv <= node.data:
      return False
    return check(node.left, lv, node.data) and check(node.right, node.data, rv)

  return check(root, -float('inf'), float('inf'))

# 'Find The Least Common Ancestor' problem
def leastCommonAncestor(root, v1, v2):
  while root:
    if max(v1, v2) < root.info:
      root = leastCommonAncestor(root.left, v1, v2)
    elif min(v1,v2) > root.info:
      root = leastCommonAncestor(root.right, v1, v2)
    else:
      break
    
  return root

### By: Khalil Kum ###

#################### Helper objects/methods ##################
class Stack(object):
  def __init__(self):
    self.data = []

  def isEmpty(self):
    return (len(self.data) == 0)     
  
  def peek(self):
    if self.isEmpty():
      return None
    return self.data[-1]        
 
  def pop(self):
    if self.isEmpty():
      return None
    return self.data.pop()        
      
  def push(self, value):
    self.data.append(value)

def createStack(values):
  stack = Stack()

  for value in values:
    stack.push(value)

  return stack

###################################################################

# 'Balanced Brackets' problem
# Average runtime: O(n)
def isBalanced(brackets):
  if len(brackets) < 2:
    return False

  d = {'}':'{', ']':'[', ')':'('}
  case = "{(["
  temp = []
  for i in brackets:
    if i in case:
      temp.append(i)
    else:
      if  not len(temp):
        return False
      c = temp.pop()
      if c != d[i]:
        return False
  if len(temp)!=0:
      return False
  else:
      return True

# 'Sort a Stack' problem
# Average runtime: O(n^2)
def sortStack(stack):
  if not len(stack.data):
    return stack.data

  temp_stack = Stack()

  while not stack.isEmpty():
    top = stack.pop()

    while (not temp_stack.isEmpty()) and (top > temp_stack.peek()):
      temp_top = temp_stack.pop()
      stack.push(temp_top)

    temp_stack.push(top)

  return temp_stack

# 'A Tale of Two Stacks' problem
# Average runtime: O(n)
class Queue(object):
  def __init__(self):
    self.data_in = []
    self.data_out = []
  
  def peek(self):
    if not self.data_out:
      self.data_out = list(reversed(self.data_in))
      self.data_in = []
    return self.data_out[-1]         
      
  def pop(self):
    head = self.peek()
    del self.data_out[-1]
    return head
      
  def put(self, value):
    self.data_in.append(value)

def runQueries(queries):
  q = Queue()

  if not queries or not len(queries):
    print("INFO: No queries to run")
    exit(1)
  
  for query in queries:
    query = query.split(' ')

    if (len(query) == 2) and (query[0] == '1'):
      q.put(query[1])
    elif (len(query) == 1) and (query[0] == '2'):
      if not q.data_out:
        print("INFO: Nothing to pop()")
      else:
        q.pop()
    elif (len(query) == 1) and (query[0] == '3'):
      print(q.peek())
    else:
      print("ERROR: Invalid query")
    print(f"In-Queue: {q.data_in}")
    print(f"Out-Queue: {q.data_out}")

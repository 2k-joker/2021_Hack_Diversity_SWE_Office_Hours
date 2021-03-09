### By: Khalil Kum ###

# swap is always a handy function when dealing with arrays
def swap(i, j, array):
    temp = array[i]
    array[i] = array[j]
    array[j] = temp

    return array

# 'Maximum Number of tickets purchasable' problem
# Average runtime: O(nlogn)
def maximumTickets(prices, k):
  if len(prices) == 0 or k <= 0:
    return 0
  k_and_under = []

  for x in prices:
    if x <= k:
      k_and_under.append(x)

  k_and_under.sort()
  max_tickets = 0

  for i in range(len(k_and_under)):
    k -= k_and_under[i]
    if k < 0:
      return max_tickets
    i += 1
    max_tickets += 1

  return max_tickets

# 'Minimum swaps' problem
# Average runtime: O(nlogn)
def minimumSwaps(arr):
  if len(arr) <= 1:
    return 0

  count = 0
  min_value = min(arr)
  arr = list(map(lambda x: x - min_value, arr))

  for i in range(0, len(arr)):
    while arr[i] != i:
      arr = swap(i, arr[i], arr)
      count += 1

  return count

# 'Pangrams' problem
# Average runtime: O(n)
def isPangram(string):
  if len(string) < 26:
    return False

  arr = [0]*26
  
  for char in string:
    char = char.lower()
    index = ord(char) - ord('a')
    if (index <= 25) & (index >= 0):
      arr[index] = 1
      if sum(arr) == 26:
        return True

  return False

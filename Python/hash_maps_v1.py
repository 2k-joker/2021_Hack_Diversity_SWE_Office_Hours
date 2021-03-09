### By: Jeff Listfield ###

def PairsOfSocks(values):
  ''' Given an array of socks (integers), find the number of pairs of socks
  '''
  # Tracks whether we've seen a sock like this yet.
  # This could just be a set too.
  seen_sock = {}

  # Track the number of pairs of socks to return at the end.
  num_pairs = 0
  for value in values:
    # If we have a match
    if value in seen_sock:
      # We can remove from the map, if we see another we'll add it back.
      seen_sock.pop(value)
      num_pairs += 1
    else:
      seen_sock[value] = True

  return num_pairs

def LengthOfRange(ranges, key):
  # Key will be the beginning of the range, so value will always be greater or equal.
  return ranges[key] - key

def LongestRange(numbers):
  '''Given an array, find the longest range of consecutive integers in that array
  '''
  # Contains lower -> higher and higher -> lower for every consecutive range we've found so far. 
  ranges = {}
  # Beginning of the longest range seen so far.
  longest = None
  for number in numbers:
    # Start with number being the end.
    high = number

    # See if number + 1 is in ranges, and update end of range.
    if number + 1 in ranges:
      high = ranges[number + 1]
      # number + 1 is no longer an end of a range.
      del ranges[number + 1]

    # Start with number being the beginning.
    low = number
    # See if number - 1 is in ranges, and update beginning of range.
    if number - 1 in ranges:
      low = ranges[number-1]
      # number - 1 is no longer an end of a range.
      del ranges[number - 1]

    # Update the map pointing in both directions.
    ranges[low] = high
    ranges[high] = low

    # Update the longest range if needed.
    if longest is None or LengthOfRange(ranges, low) > LengthOfRange(ranges, longest):
      longest = low

  # Return a list with the beginning and end of the longest range.
  return [longest, ranges[longest]]

def SherlogAnagram(input):
  '''Two strings are anagrams of each other if the letters of one string can be rearranged
  to form the other string. Given a string, find the number of pairs of substrings of the
  string that are anagrams of each other.'''
  substrings = {}
  # Find all possible substrings that exist within the input string.
  for start_index in range(0,len(input)+1):
    for end_index in range(start_index+1,len(input)+1):
      # I'm not sure sorting this here is the most efficient approach. Generating a
      # histogram is probably better, but that then needs to be turned into something
      # to put into the dictionary.
      substring = str(sorted(input[start_index:end_index]))
      if substring in substrings:
        substrings[substring] = substrings[substring]+1
      else:
        substrings[substring] = 1

  total_anagrams = 0
  for value in substrings.values():
    # Find all possible pairs that can be created from the number of matching substrings.
    total_anagrams += int((value^2-value)/2)

  return total_anagrams

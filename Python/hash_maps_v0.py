### By: Khalil Kum ###

# 'Pairs of socks' problem
# Average runtime: O(n)
def maxSockPairs(socks):
    if len(socks) <= 1:
        return 0

    dictionary = dict()
    pairs = 0

    for i in socks:
        if i in dictionary:
            dictionary[i] += 1
            if dictionary[i] % 2 == 0:
                pairs += 1
        else:
            dictionary[i] = 1

    return pairs


# 'Longest Range' problem
# Average runtime: O(nlogn)
def longestRange(array):
    table = dict()
    longestRange = 0

    for n in array:
        table[n] = False

    for n in array:
        if not table[n]:  # check if n has already been visited
            upper = n + 1  # the number after the current number
            lower = n - 1  # the number before the current number
            while upper in table:
                table[upper] = True
                upper += 1
            while lower in table:
                table[lower] = True
                lower -= 1
            currentRange = upper - lower
            if currentRange > longestRange:
                longestRange = currentRange
                max = upper - 1
                min = lower + 1

        return [min, max]


# 'Sherlock and Anagrams' problem
# Average runtime: O(n^3)
def sherlockAndAnagrams(s):
    if len(s) <= 1:
        return 0

    keys = dict()

    for start in range(len(s)):
        for finish in range(start, len(s)):
            key = [0] * 26

            for char in s[start : finish + 1]:
                char = char.lower()
                key[ord(char) - ord("a")] += 1

            # tuples are hashable in contrast to lists
            # because lists can be mutilated
            key = tuple(key)
            keys[key] = keys.get(key, 0) + 1

    result = 0

    for value in keys.values():
        result += int(value * (value - 1) / 2)

    return result

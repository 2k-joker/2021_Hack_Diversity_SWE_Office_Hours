// By: Erica Kangas //

/**
 * Pairs of Socks
 * 
 * Given an array of socks (integers), find the number of pairs of socks
 * 
 * Example: input -> [5, 25, 5, 10, 15, 5, 10] | output -> 2
 */

function pairsOfSocks(array) {
  // taking care of edge cases
  if (array.length === 0) {
    return 0;
  }

  // initialize object to track how many socks of each type we have
  let sockTracker = {};

  // iterate to organize socks by type
  array.forEach(sock => {
    if (!!sockTracker[sock]) {
      sockTracker[sock] += 1;
    } else {
      sockTracker[sock] = 1;
    }
  });

  // initialize our final count of pairs of socks
  let pairCount = 0;

  // count the number of pairs we have
  Object.keys(sockTracker).forEach(sockType => {
    pairCount += Math.floor(sockTracker[sockType] / 2);
  });

  return pairCount;
}

/**
 * Longest Range
 * 
 * Given an array, find the longest range of consecutive integers in that array
 * 
 * Example: input -> [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6] | output -> [0, 7]
 */

function longestRange(array) {
  // taking care of edge cases
  if (array.length <= 1) {
    return array;
  }

  // initialize set to track integers, maxRange, and final range value.
  let set = new Set();
  let maxRange = 0;
  let range = [];

  // convert array values to a set
  array.forEach(int => set.add(int));

  array.forEach((int, i) => {
    // if the integer is the starting point for a sequence
    if (set.has(int)) {
      let nextInt = array[i];

      while (set.has(nextInt)) {
        nextInt += 1;
      }

      // get the max range value
      maxRange = Math.max(maxRange, nextInt - int);

      // if we have a new max range, track the range values
      if (maxRange <= nextInt - int) {
        range = [int, maxRange - 1];
      }
    }
  });

  return range;
}

/**
 * Sherlock and Anagrams
 * 
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other
 * 
 * Example: input -> “mom” | output -> 2 ([m, m], [mo, om])
 */
function allSubstrings(str) {
  let result = [];

  [...str].forEach((_, i) => {
    [...str].forEach((_, j) => {
      result.push(str.slice(i, j + 1));
    })
  });

  // don't return empty strings
  return result.filter(s => !!s);
}

function isAnagram(str1, str2) {
  let charTracker = {};

  [...str1].forEach(letter => {
    if (charTracker[letter]) {
      charTracker[letter] += 1;
    } else {
      charTracker[letter] = 1;
    }
  });

  let result = true;

  // use a for loop here so we can break out early
  for (let i = 0; i < str2.length; i++) {
    let letter = str2[i];

    if (charTracker[letter]) {
      charTracker[letter] -= 1;
    } else {
      result = false;
      break;
    }
  }

  return result;
}

function countAnagrams(index, array) {
  let str = array[index];
  let remainingArray = array.slice(index + 1);
  let anagramCount = 0;

  remainingArray.forEach(strToCheck => {
    if (str.length === strToCheck.length && isAnagram(str, strToCheck)) {
      anagramCount += 1;
    }
  })

  return anagramCount;
}

function sherlockAnagrams(str) {
  // taking care of edge cases - no duplicate letters, no anagrams
  let duplicateCount = str
    .split('')
    .filter((letter, index) => str.indexOf(letter) !== index)
    .length

  if (duplicateCount === 0) {
    return 0;
  }

  // initialize our count value
  let anagramCount = 0;

  // get all substrings
  let substrings = allSubstrings(str);

  // count anagrams
  substrings.forEach((substring, i) => {
    anagramCount += countAnagrams(i, substrings)
  });

  return anagramCount;
}

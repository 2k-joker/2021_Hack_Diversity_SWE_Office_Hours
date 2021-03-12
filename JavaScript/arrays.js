/**
 * Maximum No. Tickets Purchasable

Given an array of concert ticket prices and a target budget, find the maximum number of tickets that can be purchased without exceeding the target budget.

Example: input -> [10, 25, 30, 40], 90 | output -> 3
 */

function maxTicketsPurchasable(ticketPrices, budget) {
  // taking care of edge cases
  if (ticketPrices.length === 0 || budget <= 0) {
    return 0;
  }

  // let's rule out tickets we already know aren't w/in budget
  let ticketPricesInBudget = [];

  ticketPrices.forEach(price => {
    if (price <= budget) {
      ticketPricesInBudget.push(price);
    }
  });

  // sort tickets so we can pull from the lowest prices upwards
  let sortedTicketPricesInBudget = ticketPricesInBudget.sort((a, b) => a - b);

  // initialize our max ticket count
  let maxTickets = 0;

  // initialize value to track budget - don't modify the input value!
  let budgetRemaining = budget;

  // grab as many tickets as we can until we hit the budget
  // why use a for loop here? gives us the ability to break out of the loop so we don't unecessarily loop through values.
  for (let i = 0; i < sortedTicketPricesInBudget.length; i++) {
    budgetRemaining -= sortedTicketPricesInBudget[i];

    if (budgetRemaining < 0) {
      break;
    }

    maxTickets += 1;
  }

  return maxTickets;
}

// ****************************************

/**
 * Minimum Swaps

Given an unsorted array of consecutive distinct integers, find the minimum number of swaps required to sort the array in ascending order.

Example: input -> [1, 5, 4, 3, 7, 6, 2]  | output -> 3
 */

function swap(i, j, array) {
  // switch values in an array at indices i and j
  let temp = array[i];
  array[i] = array[j];
  array[j] = temp;

  return array;
}

function minSwaps(array) {
  // taking care of edge cases
  if (array.length <= 1) {
    return 0;
  }

  // initialize count value
  let count = 0;

  // initialize array for what will be our sorted values - don't modify the input value!
  // why use the spread operator (...)? We want to create a brand new array of values, not just point to the original array.
  let sortedArray = [...array];

  // go through the array and swap!
  for (let i = 0; i < sortedArray.length; i++) {
    while (sortedArray[i] !== i + 1) {
      sortedArray = swap(i, sortedArray[i] - 1, sortedArray);
      count += 1;
    }
  }

  return count;
}

// ****************************************

/**
 * Pangrams

A pangram is a string that contains every letter of the alphabet. Given a string, write a method that determines if that string is a pangram or not

Example: input -> “Brown jars prevented the mixture from freezing too quickly“  | output -> true
 */

function isPangram(string) {
  // taking care of edge cases
  if (string.length < 26) {
    return false;
  }

  // initialize array with 26 zeroes, each representing a letter in the alphabet
  let array = [...new Array(26)].map(() => 0);

  // initialize return value
  let result = false;

  // go through string's characters and turn array's value to 1 for the associated index (e.g. a = 0, b = 1, etc.)
  for (let i = 0; i < string.length; i++) {
    let character = string.charAt(i).toLowerCase();
    let index = character.charCodeAt(0) - 'a'.charCodeAt(0);

    if (index <= 25 && index >= 0) {
      array[index] = 1;

      if (array.reduce((a, b) => a + b, 0) === 26) {
        result = true;
        break;
      }
    }
  }

  return result;
}

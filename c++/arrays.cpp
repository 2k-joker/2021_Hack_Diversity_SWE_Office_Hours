// By: Jeff Listfield //

#include <iostream>
#include <bits/stdc++.h>

int NumberOfTicketsToBuy(int ticket_prices[], int number_of_tickets, int budget)
{
  // We're assuming no negative priced tickets.
  if (ticket_prices == nullptr || budget <= 0)
  {
    return 0;
  }

  // FYI, ticket_prices will be modified by this.
  std::sort(ticket_prices, ticket_prices + number_of_tickets);
  int remaining_budget = budget;
  int tickets_to_buy = 0;
  int ticket_index = 0;
  while (ticket_index < number_of_tickets && ticket_prices[ticket_index] < remaining_budget)
  {
    // Do this before incrementing ticket_index.
    remaining_budget -= ticket_prices[ticket_index];
    tickets_to_buy++;
    ticket_index++;
  }

  return tickets_to_buy;
}

void swap_in_place(int unsorted_array[], int index_a, int index_b)
{
  int temp = unsorted_array[index_a];
  unsorted_array[index_a] = unsorted_array[index_b];
  unsorted_array[index_b] = temp;
}

int NumberOfSwaps(int unsorted_array[], int array_length)
{
  int number_of_swaps = 0;
  int index = 0;
  while (index < array_length)
  {
    if (unsorted_array[index] != index + 1)
    {
      // This moves the item at index to the right place. It does not
      // guarantee that the item moved in to index is in the right spot.
      // We might need to swap this again.
      swap_in_place(unsorted_array, index, unsorted_array[index] - 1);
      number_of_swaps++;
    }
    else
    {
      // Item is in the right spot, move on to the next one.
      index++;
    }
  }
  return number_of_swaps;
}

bool IsPangram(std::string input_string)
{
  // Don't forget to initialize this. (I did.)
  bool character_present[26] = {false};
  int num_characters;
  for (int index = 0; index < input_string.length(); index++)
  {
    char character = input_string[index];
    // Only deal with alphabetical characters.
    if (isalpha(character))
    {
      // Remember to offset this from lowercase 'a'.
      int character_index = tolower(character) - 'a';
      if (!character_present[character_index])
      {
        num_characters++;
        if (num_characters == 26)
        {
          // Once we hit 26 characters, we can return true.
          return true;
        }
      }
      // Make sure we don't double count any character.
      character_present[character_index] = true;
    }
  }
  return false;
}

int main()
{
  int ticket_prices[] = {10, 25, 30, 40};
  int budget = 90;
  int tickets_to_buy = NumberOfTicketsToBuy(ticket_prices, 4, budget);
  std::cout << "You can purchase " << tickets_to_buy << " tickets.\n";

  int unsorted_array[] = {1, 5, 4, 3, 7, 6, 2};
  int number_of_swaps = NumberOfSwaps(unsorted_array, 7);
  std::cout << "Minimum number of swaps is " << number_of_swaps << ".\n";

  std::string string_to_check = "Brown jars prevented the mixture from freezing too quickly";
  bool is_pangram = IsPangram(string_to_check);
  std::cout << "Is the string '" << string_to_check << "' a pangram? " << (is_pangram ? "yes" : "no") << ".\n";
}

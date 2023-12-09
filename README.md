# Java-MultiAccessList-ADT

## Overview

**MultiAccessKeyList** is a powerful Keyed Abstract Data Type (ADT) designed for sequential access. It employs a hashing mechanism to generate indices based on keys, resolving collisions through linked chaining. The `hashTable` array is utilized for storing hashed key values and forming linked chains for identical indices. Simultaneously, the `positionAccess` array is updated to maintain sequential access.

## Features

- **Access:** The ADT seamlessly supports sequential and hash table access, providing flexibility in how you interact with the data.
- **CSV Data Storage:** The ADT can store information from CSV files, allowing manipulation such as item removal and existence checks.

- **Automatic Capacity Handling:** The list has a default minimum capacity of ten items. Any requested capacity below 10 is automatically set to this minimum, ensuring a stable base.

- **Capacity Limit:** While the list capacity can be customized, it must not exceed 10,000. An exception is triggered if the requested capacity surpasses this limit, preventing list generation.

- **Some Methods:**
  - **Print Keys:** Efficiently prints the keys' values without traversing the entire list.
  - **Existence Checks:** Allows checking if a key's value exists in the list.
  - **Direct Value Checks:** Provides a method to check the value directly.

## Big O Analysis Of Used Methods

- **Adding Entries at the end of the list:** **O(1)** in the worst case since the time taken to add an entry remains constant.
  
- **Adding Entries at a specified position:** **O(n)** in the worst case since we have to invoke the 'makeRoom' method when adding an item to the 'positionAccess' list (sequential list). However, adding to the hashTable remains a constant time operation with **O(1)** efficiency.

- **Removing an entry based on its Key:** **O(n)** in the worst case as it involves traversing the entire linked chain at a particular index.
  
- **Removing an entry based on its position:** **O(n^2)** in the worst case since removing an item from a specified position involves a gap removal operation with O(n) time complexity. If the key is unavailable for direct removal from the hashTable, a method with nested loops is invoked, resulting in a O(n^2) time complexity.

- **Empty list Checks:** **O(1)** in the worst case because it has a constant time operation.
  
- **Clearing list:** **O(n)** in the worst case since it involves entering a loop to clear both lists.

- **Determining If Maximum Capacity is Reached:** **O(1)** in the worst case because it has a constant time operation.

- **Printing Values From hashTable List:** **O(n^2)** in the worst case because it enters nested loops to traverse through the linked chain.

- **Key-Value Printing:** **O(n)** in the worst case because the method gracefully enters a loop to search for the specified key.

- **Printing Values From PositionAccess List:** **O(n)** in the worst case because it enters loops to traverse through the list.
  
- **Contains Key-Value:** **O(n)** in the worst case because the method enters a loop to search for the specified key.
  
- **Contains Value:** **O(n)** in the worst case because the method enters a loop to search for the desired value.
  
- **Determining list Size:** **O(1)** in the worst case because it has a constant time operation.

- **Printing Value based on given position:** **O(1)** in the worst case because it has a constant time operation.

- **CSV Data Loading:** **O(n)** in the worst case since it enters a loop to insert all key-value pairs from the file.

## How To Use

To use **MultiAccessKeyList**, follow these steps:

1. **Methods Implementation:**
   Read how each method operates in the given interface.
2. **Instantiate MultiAccessKeyList:**
   ``` Java
   list= new MultiAccessList();
     

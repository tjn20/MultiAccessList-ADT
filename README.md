# MultiAccessList-ADT

## Overview

**MultiAccessKeyList** is a powerful Keyed Abstract Data Type (ADT) designed for sequential access. It employs a hashing mechanism to generate indices based on keys, resolving collisions through linked chaining. The `hashTable` array is utilized for storing hashed key values and forming linked chains for identical indices. Simultaneously, the `positionAccess` array is updated to maintain sequential access.

## Features

- **CSV Data Storage:** The ADT can store information from CSV files, allowing manipulation such as item removal and existence checks.

- **Automatic Capacity Handling:** The list has a default minimum capacity of ten items. Any requested capacity below 10 is automatically set to this minimum, ensuring a stable base.

- **Capacity Limit:** While the list capacity can be customized, it must not exceed 10,000. An exception is triggered if the requested capacity surpasses this limit, preventing list generation.

- **Efficient Methods:**
  - **Print Keys:** Efficiently prints the keys' values without traversing the entire list.
  - **Existence Checks:** Allows checking if a key's value exists in the list.
  - **Direct Value Checks:** Provides a method to check the value directly.

## Big O Analysis

- **Key-Value Printing:** **O(n)** - Linear time complexity as it involves traversing the entire list.
  
- **Existence Checks:** **O(1)** on average, **O(n)** in the worst case due to potential linked chaining in the hash table.

- **Direct Value Checks:** **O(1)** on average, **O(n)** in the worst case due to potential linked chaining in the hash table.

- **CSV Data Loading:** **O(m + n)** - Linear time complexity, where **m** is the number of items in the CSV file and **n** is the current number of items in the list.

## Getting Started

To use **MultiAccessKeyList**, follow these steps:

1. **Instantiate MultiAccessKeyList:**
   ```python
   my_list = MultiAccessKeyList()

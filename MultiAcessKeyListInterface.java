/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author tjnla
 */
public interface MultiAcessKeyListInterface <K,V> {

/**
   Adds to the end of the position access list and to the hashTable list 
      Entries currently in the list are unaffected.
       The list's size is increased by 1.
*/    
public void add(K key,V value);

/**
 Adds a new value at a specified position within this list.
       Entries originally at and above the specified position
       are at the next higher position within the list.
        The key is hashed and added in the hashTable list.
        The list's size is increased by 1.
 
 * @param newPosition Determines the position the value to be added in.
 * @param key This key is to be hashed and adds its value in the hashTable list.
 * @param value The object to be added as a new value.
 */
public void add(int newPosition,K key,V value);

/**
 Removes the value for the given key from the hashTable list,
       it also removes it from the position access list,
       and the list's size is decreased by 1.
 * @param key the key to be hashed are its value to be removed.
 * @return if key is not found it returns null else it removes the value of the entered key.
 * @throws IllegalArgumentException if the input to be removed == null or IndexOutOfBoundsException if he tries 
 * to remove from an empty list.
 */
public V remove(K key);
/**
Removes the value at a given position from position access list.
       Entries originally at positions higher than the given
       position are at the next lower position within the list,
       its also removes it from the hashTable list,
       and the list's size is decreased by 1.
       @param givenPosition  An integer that indicates the position of
                             the value to be removed.
       @return  A reference to the removed value.
       @throws  IndexOutOfBoundsException if either 
                givenPosition < 1 or givenPosition > getLength(). 
*/
public V remove(int givenPosition);

 /** Sees whether this list is empty.
       @return  True if the list is empty, or false if not. */
public boolean isEmpty();

 /** Removes all entries from this list. */
public void clear();

/** Sees whether this is list is full (reaches its entered capacity).
  @return True if the list is full,or false if not.
 */
public boolean isFull();
/**
 It prints the values in the hashTable list. 
 */
public void printHash();

/**
 It prints the value of the given key
 * @param key its the given key to be hashed so its value is printed.
 *  @throws  IllegalArgumentException if key is null. 
 */
public void printKey(K key);

/**
 Retrieves all value that are in position access list in the order in which
       they occur in the list.
       @return  A newly allocated array of all the value in the list.
                If the list is empty, the returned array is empty. 
*/
public V [] printPositionValue();

/**
  Sees whether this list contains the value of a given key.
   @param key The object that is the desired key to check its value
   @return True if the list contains the value, or false if not.
   @throws IllegalArgumentException if desired value is null.
   
 */
public boolean contains(K key);

/**
 Sees whether this list contains a given value.
       @param value  The object that is the desired entry.
       @return  True if the list contains anEntry, or false if not and if the list is empty. 
       @throws IllegalArgumentException if desired value is null.
 */
public boolean containsValue(V value);

/**
 It adds keys and its values from an Excel file.
   @param list the desired list object to have the desired entries from excel file.
 * @param path the path of the desired excel file.
 */
public void addFromExcelFile(MultiAcessKeyListInterface list,String path);

/**
 It prints the value in the position access list.
  @param position the desired position of the value.
  @throws  IndexOutOfBoundsException if either 
                givenPosition < 1 or givenPosition > getLength()
 @throws IllegalArgumentException if givenPostion is within the length but its value is null.
 */
public void printGivenPosition(int position);

/**
 check the current size of the list.
 * @return the number of entries in the list.
 */
public int currentSize();
}

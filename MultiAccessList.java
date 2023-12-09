/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author tjnla
 */
public class MultiAccessList <K,V> implements MultiAcessKeyListInterface<K,V>{
private Object [] hashTable;
    private int numberOfEntries;
   private V [] position_Access;
   private  static final int  MAX_CAPACITY=10000;
   private  static final int  DEFAULT_CAPACITY=10;

public MultiAccessList()
{
    this(DEFAULT_CAPACITY);
}
public MultiAccessList(int desiredCapacity)
{
    if(desiredCapacity>MAX_CAPACITY)
        throw new IllegalStateException("Please enter a desired size that is less than "+MAX_CAPACITY);
    else if(desiredCapacity < DEFAULT_CAPACITY)
        desiredCapacity =DEFAULT_CAPACITY;

        @SuppressWarnings("unchecked")
      V[] tempList = (V[])new Object[desiredCapacity + 1];
      position_Access = tempList;
        hashTable= new Object[desiredCapacity];
        numberOfEntries=0;                                    
}
 private void addHash(K key,V value)
    {
       if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to List.");
       else if(numberOfEntries+1>hashTable.length)
            throw new ArrayIndexOutOfBoundsException("The array is full");
       else
       {
       int index=getHashIndex(key);
       Node newNode= new Node(key,value);
       if(getValue(index)==null)
        hashTable[index]=newNode;
       else              
           newNode.next=(Node) hashTable[index];
       hashTable[index]=newNode;
       }
      

    }
    public void add(K key,V value)
    {
    	addHash(key,value);
        position_Access[numberOfEntries+1]=value;
        numberOfEntries++;
    }
 
 public void add(int newPosition,K key,V value)
	{
	addHash(key,value);
           
      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
      {
         if (newPosition <= numberOfEntries)
            makeRoom(newPosition);
         position_Access[newPosition] = value;
         numberOfEntries++;
      }
      else
         throw new IndexOutOfBoundsException(
                   "Given position of add's new entry is out of bounds.");
	} 
 private void makeRoom(int newPosition)
	{
	   assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
	  
	   int newIndex = newPosition;
	   int lastIndex = numberOfEntries;

      // Move each entry to next higher index, starting at end of
      // list and continuing until the entry at newIndex is moved
      for (int index = lastIndex; index >= newIndex; index--)
	      position_Access[index + 1] = position_Access[index];
	}
  
  private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a list " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
   }
  
  public V remove(K key)
  {
      if(key==null)
           throw new IllegalArgumentException("Cannot remove null from List.");
      else if(numberOfEntries==0)
          throw new IndexOutOfBoundsException("Illegal given key to remove operation.");
      V removed=null;
   int index=getHashIndex(key);
        Node current=(Node) hashTable[index];
        if(current.next==null && current.key.equals(key)){
            removed=current.value;
        hashTable[index]=null;
        }
while(current.next!=null && removed==null){
       if(current.key.equals(key)){
           removed=current.value;
       hashTable[index]=current=current.next;
       }
       else if(current.next.key.equals(key)){
       removed=current.next.value;
       current.next=current.next.next;
       }
       else
           current=current.next;
           
}
if(removed!=null)
remove(key,removed);
return removed;
  }
  private void remove(K key,V value)
  {
      int givenPosition=0;
  for(int i=1;i<=position_Access.length;i++){
  if(value.equals(position_Access[i])){
  givenPosition=i;
  break;
  }   
  }
  if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         V result = position_Access[givenPosition]; // Get entry to be removed

         // Move subsequent entries towards entry to be removed,
         // unless it is last in list
         if (givenPosition < numberOfEntries)
            removeGap(givenPosition);
         
        numberOfEntries--;
      }
      else
         throw new IndexOutOfBoundsException(
                   "Illegal position given to remove operation.");
  }
  public V remove(int givenPosition)
	{
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         V result = position_Access[givenPosition]; // Get entry to be removed

         // Move subsequent entries towards entry to be removed,
         // unless it is last in list
         if (givenPosition < numberOfEntries)
            removeGap(givenPosition);
         removeHash(result);
        numberOfEntries--;
         return result;
      }
      else
         throw new IndexOutOfBoundsException(
                   "Illegal position given to remove operation.");
 	} 
  public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}
  
  private void removeHash(V value){
      V removed=null;
for(int i=0;i<hashTable.length;i++){
    Node current=(Node) hashTable[i];
 if(current!=null){
        if(current.next==null && value.equals(current.value)){
            hashTable[i]=null;
        break;
        }
       else if(current!=null &&current.next!=null){
while(current.next!=null && removed==null ){
       if(current.value.equals(value)){
           removed=current.value;
       hashTable[i]=current=current.next;

       }
       else if(current.next.value.equals(value)){
       removed=current.next.value;
       current.next=current.next.next;

       }
       else
           current=current.next;
}
        }
 }
   if(removed!=null && removed.equals(value))
       break;
   
  }

  }
  
  
  public void clear()
	{

   
		for (int index = 1; index <= numberOfEntries; index++){ 
			hashTable[index-1] = null;
                position_Access[index]=null;
                }
		numberOfEntries = 0;
	} 
  private void removeGap(int givenPosition)
	{
      assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

      int removedIndex = givenPosition;
      int lastIndex = numberOfEntries;

      for (int index = removedIndex; index < lastIndex; index++)
         position_Access[index] = position_Access[index + 1];
	} 
public boolean isFull(){
if(numberOfEntries==hashTable.length && numberOfEntries==position_Access.length-1)
    return true;
else
    return false;
}
  
  public void printHash(){
  
  for(int i=0;i<hashTable.length;i++){
  Node current=(Node) hashTable[i];
   while(current!=null){
    System.out.println("The key is "+current.key+" , its value is: "+current.value+" , at the index:  "+i);
    current=current.next;
  }
  }
  }
 private V getValue(int index)
    {
    return (V)hashTable[index];
    }
public void printKey(K key){
if(key==null)
             throw new IllegalArgumentException("Cannot print null keys");


    int index=getHashIndex(key);
    Node current=(Node) hashTable[index];
    while(current!=null){
        if(key.equals(current.key))
    System.out.println("the key is "+key+" ,its value is: "+current.value+",its index:  "+index);
    current=current.next;
    }
}    
public void printGivenPosition(int position){
if ((position >= 1) && (position <= numberOfEntries))
    if(position_Access[position]!=null)
    System.out.println(position_Access[position]);
    else
    throw new IllegalArgumentException(
                   "Given position has no values.");    
else
 throw new IndexOutOfBoundsException(
                   "Given position is out of bounds.");    
}

 public V [] printPositionValue(){
V[] result = (V[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = position_Access[index + 1];
      } 
      
      return result;
 }   
private int getHashIndex(K key)
    {
        int hashIndex = key.hashCode() % hashTable.length;
        if (hashIndex < 0)
        hashIndex = hashIndex + hashTable.length;
        return hashIndex;
    } 
public boolean contains(K key)
{
    if(key==null)
       throw new IllegalArgumentException("Enter a proper key");
    boolean found=false;
    int index=getHashIndex(key);
   Node current=(Node)hashTable[index];
   if(current==null)
       return false;
   else if(current.next==null && current.key.equals(key))
       found=true;
   else if(current.next!=null && found==false){
   while(current.next!=null&& found==false){
   if(current.key.equals(key))
      found=true;
   else if(current.next.key.equals(key))
      found=true;
   else
       current=current.next;
   }
   }
       return found;
}
public boolean containsValue(V value)
{
    if(value==null)
               throw new IllegalArgumentException("Enter a proper value");

   boolean found = false;
      int index = 1;
		while (!found && (index <= numberOfEntries))
		{
			if (value.equals(position_Access[index])){
				found = true;
                        break;
                        }
         index++;
      } 
                return found;
}
private int getLength()
    {
        return hashTable.length;
    }
public int currentSize()
    {
return this.numberOfEntries;
    }
 public void addFromExcelFile(MultiAcessKeyListInterface table,String filePath){
    BufferedReader br = null;
String line = "";
String cvsSplitBy = ",";

int index=0;
try {
        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null && index<getLength()) {

            String [] read = line.split(cvsSplitBy);
            String personName =read[0];
            String address = read[1];
            table.add(personName, address);
index++;
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch ( Exception e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
 

// Node class
 private class Node{
    private K key;
    private V value;
    private Node next;
    private Node(K key,V value){
    this(key,value,null);
    }
    private Node(K key,V value,Node next){
    this.key=key;
    this.value=value;
    this.next=next;
    }
   
 }    
}

package v1;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 02/02/02/2017
 * Submitted:  02/02/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 2017.02.02
 */

public class ListArrayBased <T> implements ListInterface <T>
{

    private static final int MAX_LIST = 3;
    protected T []items;  
    protected int numItems;  

    public ListArrayBased()
    {
        items = (T[])new Object[MAX_LIST];
        numItems = 0;
    }  

    public boolean isEmpty()
    {
        return (numItems == 0);
    } 

    public int size()
    {
        return numItems;
    }  

    public void removeAll()
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    } 

    public void add(int index, T item)throws  ListIndexOutOfBoundsException
    {
        if (numItems == items.length) // fix implementation errors + //fix programming style
        {
            throw new ListException("ListException on add");
        }  
        if (index >= 0 && index <= numItems)
        {
        	   for (int pos = numItems-1; pos >= index; pos--)  
               {
                   items[pos+1] = items[pos];
               } 
            items[index] = item;
            numItems++;
        }
        else
        {

            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
        } 
    } 
    public Object get(int index)throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {

            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
        }  
    } 

    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            for (int pos = index+1; pos < numItems; pos++) 
            {
                items[pos-1] = items[pos];
            }  
            items [numItems - 1] = null; // fix memory leak
            numItems--;
        }
        else
        {       
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
        }  
    } 
    
 
}
package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: [REDO] Complete and thoroughly tested
 * Last update: 02/17/2017
 * Submitted:  02/20/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 2017.02.17
 */
public class ListArrayBasedPlus<T> extends ListArrayBased <T>
{
	
	public ListArrayBasedPlus()
	{
		super();
		
	}
	
	public void add(int i, T o)
	{
		if (i == items.length)
		{
			resize();
		}
			super.add(i, o);
	}
	
	public void resize()
	{
		T items2 [ ] =(T[]) new Object [items.length *2];
		for (int c = 0; c < items.length; c++)
		{
			items2[c] = items[c];
		}
		items = items2;
	}
	
	public void reverse ()
	{
		T i;
		for (int c = 0; c < items.length/2; c++)
		{
			i = items[c];
			items[c] = items[items.length-1 - c];
			items[items.length-1-c] = i;
		}
	}
	
	public String toString()
	{
		Object o;
		String s = "";
		
		for (int c = 0; c < numItems; c++)
		{
			o = items [c];
			s +=  o + " " ;
			
		}
		return s;
	}

}

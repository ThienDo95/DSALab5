package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: 
 * Last update: 02/26/2017
 * Submitted: 02/27/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.27
 */

public class StackBasedWithResizableArray<T> implements StackInterface<T>
{
	private T [] arrayVariable;
	protected int top;

	public StackBasedWithResizableArray()
	{
		arrayVariable = (T[]) new Object[3];
		top = -1;
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}


	public void popAll()
	{
		arrayVariable = (T[]) new Object[3];
		top = -1;
	}


	public void push(T newItem) throws StackException
	{
		if (top == arrayVariable.length-1)
		{
			resize();
			
		}
		arrayVariable [++top] = newItem;
	}

	public void resize()
	{
		T [] resize = (T[]) new Object[arrayVariable.length *2];
		for(int c = 0; c < arrayVariable.length; c++)
		{
			resize[c] = arrayVariable[c];
		}
		arrayVariable = resize;
	}
	
	public T pop() throws StackException
	{
		T remove;
		if(top >= 0)
		{
			remove = arrayVariable[top];
			arrayVariable[top] = null;
			top--;
			return remove;
		}
		else 
		{
			throw new StackException("Cannot pop due to empty stack");
		}
	}


	public T peek()throws StackException 
	{
		if(top >= 0) 
		{
			return arrayVariable[top];
		}
		else 
		{
			throw new StackException("Cannot peek due to empty stack");
		}
	}
	
	public String toString()
	{
		String s="";
		for(int c = 0; c <= top; c++)
		{
			s += arrayVariable[c] + " ";
		}
		
		return s;
	}
}

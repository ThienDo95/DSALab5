package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 2
 * Status: Complete and thouroughly test
 * Last update: 02/26/2017
 * Submitted: 02/27/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.27
 */
 
public class Item
{
	private double weight;
	private int layer;
	
	public Item(double weight, int layer)
	{
		this.weight = weight;
		this.layer = layer;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public int getLayer()
	{
		return layer;
	}

	public void setLayer(int layer)
	{
		this.layer = layer;
	}
}

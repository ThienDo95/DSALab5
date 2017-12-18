package v1;
//Fix memory waste [ Item -> Double ]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver
{

	static BufferedReader stdin = new BufferedReader ( new  InputStreamReader (System.in));

	public static void main(String[] args) throws IOException
	{
		StackBasedWithResizableArray<Item> bag = new StackBasedWithResizableArray<Item>();
		StackBasedWithResizableArray<Double> sampleBag = new StackBasedWithResizableArray<>();
		int i;

		int currLayer = 0;
		int numberLayer = 0;
		double bagWeight = 0;
		double sampleBagWeight = 0;
		
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Place a layer of item(s) in the bag");
			System.out.println("2. Remove a layer of item(s) from the bag");
			System.out.println("3. Display the weight of the bag");
			System.out.println("4. Display the number of layers in the bag");
			System.out.println("5. Display the number of items and the weight of the sample bag");
			System.out.println("6. Remove an item from the sample bag");
			System.out.println("7. Empty the sample bag");
			System.out.println("8. Exit");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 9)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter the amount of item to put into bag: ");
						String item = stdin.readLine().trim();
						int nItem = Integer.parseInt(item);
						System.out.println("Enter the weight of the item(s): ");
						String weight = stdin.readLine().trim();
						double nWeight = Double.parseDouble(weight);
						
						for (int c = 0; c < nItem; c++)
						{
							bag.push(new Item(nWeight, nItem));
						}
						System.out.println(nItem + " item(s) weight " + nWeight  + " is(are) placed in the bag.");
						bagWeight += nWeight * nItem;
						currLayer = nItem;
						numberLayer ++;
						break;
					case 2:
						if (numberLayer > 0)
						{
							bagWeight  -= currLayer * bag.peek().getWeight();
							Item sItem = bag.peek();
							for(int c = 0; c < currLayer; c++)
							{
								bag.pop();
							}
							System.out.println(currLayer + " item(s) has/have been removing from the list");
							System.out.println("Do you want to put the removed item into the sample bag?(yes/no)");
							String answer = stdin.readLine().trim();
							if(answer.equalsIgnoreCase("yes"))
							{
								sampleBag.push(sItem.getWeight());
								sampleBagWeight += sItem.getWeight();
								System.out.println("Removed item(s) is/are now stored as sample item in the sample bag.");
							}
							if(numberLayer > 1)
							{
								currLayer = bag.peek().getLayer();
								numberLayer --;
								break;
							}
							else
							{
								numberLayer --;
								currLayer = 0;
							}
							break;
						}
						else
						{
							System.out.println("It's an empty bag. Cannot remove anything.");
							break;
						}
					case 3:
						if(bagWeight > 0)
						{
							System.out.println("Bag is weighted " + bagWeight);
						}
						else
						{
							System.out.println("Bag is weighted 0 due to emptiness.");
						}
						break;
					case 4:
						if (numberLayer == 1)
						{
							System.out.println("This bag has item(s):" + numberLayer + " Layer(s)");
						}
						else
						{
							System.out.println("This bag has item(s):" + numberLayer + " Layer(s)");
						}
						break;
					case 5:
						if(sampleBag.top == -1)
						{
							System.out.println("The sample bag is empty: No items");
						}
						else if (sampleBag.top == 0)
						{
							System.out.println("The sample bag has one item");
						}
						else if (sampleBag.top >= 1)
						{
							System.out.println("The sample bag has " + (sampleBag.top + 1));
						}
						System.out.println("Sample is weighted " + sampleBagWeight);
						break;
					case 6:
						if(sampleBag.top > 0)
						{
							double w = sampleBag.peek();
							sampleBagWeight -= w;
							sampleBag.pop();
							System.out.println("An item that is weighted " + w + " has been removed from the sample bag.");
							break;
						}
						else
						{
							System.out.println("Sample bag is empty. Nothing to pop.");
							break;
						}
					case 7:
						sampleBag.popAll();
						sampleBagWeight = 0;
						System.out.println("Sample bag has been empty");
						break;
					case 8:
						System.out.println("Have a good day.");
						break;
				}
			}
		}while(i < 8 || i > 8);
	}
}




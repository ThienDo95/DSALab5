package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver2
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException
	{
		StackBasedWithResizableArray<String> bag = new StackBasedWithResizableArray<String>();
		int i;
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display top items");
			System.out.println("4. Display items in stack");
			System.out.println("5. Clear stack");
			System.out.println("6. Exit");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 7)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter an item: ");
						String item = stdin.readLine().trim();
						bag.push(item);
						break;
					case 2:
						bag.pop();
						break;
					case 3:
						System.out.println(bag.peek() + " is your top item");
						break;
					case 4:
						System.out.println(bag.toString() );
						break;
					case 5:
						bag.popAll();
						break;
					case 6:
						System.out.println("PEACE");
						break;				
				}
			}
		}while(i < 6 || i > 6);
	}
}

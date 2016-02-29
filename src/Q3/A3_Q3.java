package Q3;

import java.util.ArrayList;
import java.util.Scanner;

public class A3_Q3 
{
	private static ArrayList<Integer> a = new ArrayList<Integer>();
	
	public static void main(String[] args) 
	{
		//Test Cases
		System.out.println("Test Case 1: 1,1,1,2,3,4");
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(String.valueOf(checkEqual(0,a.size()/2,a.size()-1)));
		a.clear();
		System.out.println("Test Case 2: 1,0,1,2,3,4");
		a.add(1);
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(String.valueOf(checkEqual(0,a.size()/2,a.size()-1)));
		a.clear();
		System.out.println("Test Case 3: 1,2,3,4,5,5");
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(5);
		System.out.println(String.valueOf(checkEqual(0,a.size()/2,a.size()-1)));
		a.clear();
		System.out.println("Test Case 4: 0,2,3,4,5,6");
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(5);
		System.out.println(String.valueOf(checkEqual(0,a.size()/2,a.size()-1)));
		a.clear();
		//Get user's input
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while(n != -10000)
		{
			System.out.println("Enter a number or -10000 to quit: ");
			n = scan.nextInt();
			a.add(n);
		}
		System.out.println("The result is:");
		System.out.println(String.valueOf(checkEqual(0,a.size()/2,a.size()-1)));
		a.clear();
		scan.close();
	}
	/**
	 * Method used to check if an index has a value equal to index number.
	 * The method uses the idea of dividing the problem into segments to get the problem done in half to time or ln(n)/ln(2) or log base 2 of n.
	 * The method will check the middle number for certain cases to see if the middle number meets certain criteria. From there, the number range is
	 * then continuously halved till a solution is found or returns false if there is no solution which thus halves the time, aka divide and conquer.
	 * @param first The first slot of the selected range.
	 * @param mid The mid slot of the selected range.
	 * @param last The last slot of the selected range.
	 * @return True if there is a slot who's index number is equal to it's value, false if there is not.
	 */
	public static boolean checkEqual(int first, int mid, int last) //O(log(n))
	{
		int midV = a.get(mid);// c1
		if(midV == mid) //c2
		{
			return true;//c3
		}
		else if(mid == last || mid == first)//c4
		{
			if(a.get(first) == first || a.get(last) == last)//c5
			{
				return true;//c6
			}
			else
			{
				return false;//c7
			}
		}
		else if(midV < mid)//c8
		{
			return checkEqual(first, (first + mid)/2, mid);//O/2 = O(Log(n)) or c9
		}
		else if(!(mid == last)) //c10
		{
			return checkEqual(mid, (mid+last)/2, last); //O/2 = O(Log(n)) or c11
		}
		else //c12
		{
			return false;
		}
	}

}

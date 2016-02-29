package Q2;



public class A3_Q2 
{

	public static void main(String[] args) 
	{
		MyPriorityQueue q = new MyPriorityQueue();
		System.out.println("Test 2");
		q.enqueue(9);
		q.enqueue(7);
		q.enqueue(10);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println("Test 3");
	}

}

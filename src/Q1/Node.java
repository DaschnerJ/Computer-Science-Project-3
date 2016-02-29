package Q1;



public class Node<T>
{
   private T data;
   private Node<T> left;
   private Node<T> right;

   public Node(T data, Node<T> l, Node<T> r)
   {
      setLeft(l); 
      setRight(r);
      this.setData(data);
   }

   public Node(T data)
   {
      this(data, null, null);
   }

   public String toString()
   {
      return getData().toString();
   }

   public Node<T> getRight() 
   {
	   return right;
   }

   public void setRight(Node<T> right) 
   {
	   this.right = right;
   }

   public Node<T> getLeft() 
   {
	   return left;
   }

   public void setLeft(Node<T> left) 
   {
	   this.left = left;
   }

   public T getData() 
   {
	   return data;
   }

   public void setData(T data) 
   {
	   this.data = data;
   }
   
   public Integer getValue()
   {
	   Object d = (Object)data;
	   if(d instanceof String)
	   {
		   return Integer.valueOf((String) d);
	   }
	   else if(d instanceof Integer)
	   {
		   return (Integer)d;
	   }
	   else if(d instanceof Double)
	   {
		   return ((Double)d).intValue();
	   }
	   else if(d instanceof Boolean)
	   {
		   boolean b = ((Boolean)d);
		   if(b)
			   return 1;
		   else
			   return 0;
	   }
	   else
	   {
		   return 0;
	   }
   }
} 

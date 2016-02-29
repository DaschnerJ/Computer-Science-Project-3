package Q1;

import java.util.*;

public class BST <T extends Comparable<T>> implements Iterable<T>
{

   private Node<T> root;
   private Comparator<T> comparator;
   
   public Node<T> getRoot()
   {
	   return root;
   }

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator<T> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(T x, T y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return comparator.compare(x,y);
   }

   public void add(T data)
   {
      root = insert(root, data);
   }
   
   private Node<T> insert(Node<T> p, T t)
   {
      if (p == null)
         return new Node<T>(t);

      if (compare(t, p.getData()) == 0)
      	return p;

      if (compare(t, p.getData()) < 0)
         p.setLeft(insert(p.getLeft(), t));
      else
         p.setRight(insert(p.getRight(), t));

      return p;
   }

   public boolean search(T t)
   {
      return search(root, t);
   }
   
   private boolean search(Node<T> p, T t)
   {
      if (p == null)
         return false;
      else
      if (compare(t, p.getData()) == 0)
      	return true;
      else
      if (compare(t, p.getData()) < 0)
         return search(p.getLeft(), t);
      else
         return search(p.getRight(), t);
   }
   
   public void delete(T toDelete)
   {
      root = remove(root, toDelete);
   }
   
   private Node<T> remove(Node<T> p, T t)
   {
      if (p == null)  throw new RuntimeException();
      else
      if (compare(t, p.getData()) < 0)
      p.setLeft(remove (p.getLeft(), t));
      else
      if (compare(t, p.getData())  > 0)
      p.setRight(remove (p.getRight(), t));
      else
      {
         if (p.getLeft() == null) return p.getRight();
         else
         if (p.getRight() == null) return p.getLeft();
         else
         {
            p.setData(getData(p.getLeft()));
            p.setLeft(remove(p.getLeft(), p.getData())) ;
         }
      }
      return p;
   }
   
   private T getData(Node<T> p)
   {
      while (p.getRight() != null) p = p.getRight();

      return p.getData();
   }

   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      for(T data : this) sb.append(data.toString());

      return sb.toString();
   }

   public Iterator<T> iterator()
   {
      return new BSTIterator();
   }
   
   private class BSTIterator implements Iterator<T>
   {
      Stack<Node<T>> stk = new Stack<Node<T>>();

      public BSTIterator()
      {
         if(root != null) stk.push(root);
      }
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      public T next()
      {
         Node<T> cur = stk.peek();
         if(cur.getLeft() != null)
         {
            stk.push(cur.getLeft());
         }
         else
         {
            Node<T> tmp = stk.pop();
            while( tmp.getRight() == null )
            {
               if(stk.isEmpty()) return cur.getData();
               tmp = stk.pop();
            }
            stk.push(tmp.getRight());
         }

         return cur.getData();
      }

      public void remove()
      {

      }
   }
}

class BSTComparator implements Comparator<Integer>
{
   public int compare(Integer x, Integer y)
   {
        return y-x;
   }
}
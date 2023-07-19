import java.util.EmptyStackException;

public class ArrayStack <Item> implements Stack <Item>
{
    Item container[];
    int top;
 
public ArrayStack ()
    {
        this(10);
    }
 
public ArrayStack (int initialCapacity)
    {
		if (initialCapacity<1)
			throw new IllegalArgumentException
				("initialCapacity must be >=1");
        container = (Item[]) new Object [initialCapacity];
        top = -1;
    }
//returns the top item from the stack
public Item peek()
    {
        if (isEmpty()) throw new EmptyStackException();
        return container[top];
    }
//returns true if the stack is empty
public boolean isEmpty()
    {
        return (top == -1);
    }
//returns the top item from the stack and removes it 
public Item pop()
    {
    if (top ==-1)
        return null;
 
    Item theItem = container[top];
    container[top--] = null;
 
    if(top > 0 && top == container.length/4)
        resize (container.length/2);
 
    return theItem;
   }
//adds the item to the stack
public void push(Item theItem)
    {		
    if (top == container.length-1)
        resize(container.length*2);
 
    container[++top] = theItem;
    }
//gets the size of stack (amount of items)
public int getSize()
    {
        return (top + 1);
    }

//increases or decreases the size of the ArrayStack to save memory
private void resize (int newSize)
    {
    Item t[] = (Item[]) new Object[newSize];
    for (int j = 0; j <= top; j++)
       t[j] = container[j];
    container = t;
   }
}
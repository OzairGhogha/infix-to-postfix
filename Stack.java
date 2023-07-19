
public interface Stack<Item> 
{
    Item peek();
    Item pop(); 
    void push(Item theItem); 
    boolean isEmpty();
    int getSize();
}

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public void addFirst(T item){
        items[nextFirst] = item;
        nextFirst = (nextFirst-1)%items.length;
        size++;
    }

    public void addLast(T item){
        items[nextLast] = item;
        nextLast = (nextLast+1)% items.length;
        size++;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int count = size;
        int first = (nextFirst + 1) % items.length;
        while(count > 0){
            System.out.println(items[first]);
            first = (first + 1) % items.length;
            count--;
        }
    }

    public T removeFirst(){
        nextFirst = (nextFirst + 1) % items.length;
        T tmp = items[nextFirst];
        items[nextFirst] = null;
        return tmp;
    }

    public T removeLast(){
        nextLast = (nextLast - 1) % items.length;
        T tmp = items[nextLast];
        items[nextLast] = null;
        return tmp;
    }

    public T get(int index){
        return items[(nextFirst+index+1)%items.length];
    }
}

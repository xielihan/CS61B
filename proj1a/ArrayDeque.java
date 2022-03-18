import static java.lang.Math.floorMod;

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
        if (size == items.length)
            resize(4);
        items[nextFirst] = item;
        nextFirst = floorMod((nextFirst-1),(items.length));
        size++;
    }

    public void addLast(T item){
        if(size == items.length)
            resize(4);
        items[nextLast] = item;
        nextLast = floorMod((nextLast+1), (items.length));
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
        int first = floorMod(nextFirst + 1, items.length);
        while(count > 0){
            System.out.print(items[first]+" ");
            first = floorMod(first + 1, items.length);
            count--;
        }
    }

    public T removeFirst(){
        if(usageFactor())
            resize(1);
        if(isEmpty())
            return null;
        nextFirst = floorMod(nextFirst + 1, items.length);
        T tmp = items[nextFirst];
        items[nextFirst] = null;
        size --;
        return tmp;
    }

    public T removeLast(){
        if(usageFactor())
            resize(1);
        if(isEmpty())
            return null;
        nextLast = floorMod(nextLast - 1, items.length);
        T tmp = items[nextLast];
        items[nextLast] = null;
        size --;
        return tmp;
    }

    public T get(int index){
        return items[floorMod(nextFirst+index+1, items.length)];
    }

    private void resize(int x){
        T[] a = (T[]) new Object[(items.length*x)/2];
        int first = size/2;
        for(int i = 0; i < size; i++){
            a[(first+i)%(a.length)] = items[floorMod(nextFirst+1+i, items.length)];
        }
        nextFirst = floorMod(first - 1, a.length);
        nextLast = floorMod(first + size, a.length);
        items = a;
    }

    private boolean usageFactor(){
        double factor = (double)size/(double)items.length;
        if(items.length >=16 && factor < 0.25)
            return true;
        return false;
    }
}

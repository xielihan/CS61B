public class LinkedListDeque <T> {

    private class node{
        public T item;
        public node next ;
        public node prev;

        public  node(T x,node i,node j){
            item = x;
            next = i;
            prev = j;
        }
    }

    private node senitinel;
    private int size;

    public  LinkedListDeque(){
        senitinel = new node((T) "a",null,null);
        senitinel.next = senitinel;
        senitinel.prev = senitinel;
        size = 0;
    }

    public void addFirst(T item){
        node firstNode = new node(item,senitinel.next,senitinel);
        senitinel.next.prev = firstNode;
        senitinel.next = firstNode;
        size += 1;
    }

    public void addLast(T item){
        node lastNode = new node(item,senitinel,senitinel.prev);
        senitinel.prev.next = lastNode;
        senitinel.prev = lastNode;
        size += 1;
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
        node p = senitinel.next;
        while(p != senitinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst(){
        if (isEmpty())
            return null;
        else{
            T tmp = senitinel.next.item;
            senitinel.next = senitinel.next.next;
            senitinel.next.prev = senitinel;
            size -= 1;
            return tmp;

        }
    }

    public T removeLast(){
        if(isEmpty())
            return  null;
        else{
            T tmp = senitinel.prev.item;
            senitinel.prev = senitinel.prev.prev;
            senitinel.prev.next = senitinel;
            size -= 1;
            return tmp;
        }
    }

    public T get(int index){
        if(index > size -1 )
            return null;
        node p =senitinel.next;
        int count = index;
        while(count > 0){
            p = p.next;
            count--;
        }
        return  p.item;
    }

    public T getRecursiveHelp(int index,node p){
        if(index == 0)
            return p.item;
        return getRecursiveHelp(index-1,p.next);
    }

    public T getRecursive(int index){
        if(index > size -1 )
            return null;
        return getRecursiveHelp(index,senitinel.next);

    }


}

public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addLast(0);
        lld1.addFirst(1);
        lld1.removeFirst();
        int x = lld1.get(0);
        int y = lld1.removeFirst();
        lld1.addFirst(5);
        y = lld1.removeFirst();
        lld1.addFirst(7);
        y = lld1.removeLast();      //==> 7
        lld1.addLast(9);
        x = lld1.get(0) ;//     ==> 9
        y = lld1.removeFirst() ;//    ==> 9
        lld1.addFirst(12);
        lld1.addLast(13);
        lld1.addLast(14);
        lld1.addFirst(15);
        x = lld1.get(2);//      ==> 13
        x = lld1.get(2);//      ==> 13
        lld1.addLast(18);
        lld1.addLast(19);
        lld1.addFirst(20);
        lld1.addLast(21);
        lld1.addFirst(22);
        y = lld1.removeFirst();
        System.out.println(lld1.get(10));
    }
}

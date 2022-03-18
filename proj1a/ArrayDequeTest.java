public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for(int i = 0; i < 10; i++)
            lld1.addFirst(i);
        for(int i = 0; i < 10; i++)
            lld1.removeFirst();
        for(int i = 0; i < 4; i++)
            lld1.addFirst(i);
        for(int i = 0; i < 10; i++)
            lld1.removeFirst();
        for(int i = 0; i < 4; i++)
            lld1.addFirst(i);
        int x = 0;
    }
}

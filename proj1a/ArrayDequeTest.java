public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for(int i = 0; i < 14; i++)
            lld1.addFirst(i);
        lld1.printDeque();
    }
}

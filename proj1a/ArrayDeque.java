public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }
    
    private int minusOne(int index) {
        if (index - 1 < 0) {
            index = items.length - 1;
        } else {
            index--;
        }
        return index;
    }

    private int plusOne(int i) {
        if (i +1 > items.length- 1) {
            i = 0;
        } else {
            i++;
        }
        return i;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
    }
    
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(nextFirst)) {
            System.out.print(items[nextFirst] + " ");
        }
    }

    public T removeFirst() {
        
    }

    public T removeLast() {
        
    }

    public T get(int index) {
        
    }
}
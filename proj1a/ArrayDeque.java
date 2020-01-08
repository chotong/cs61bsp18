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
    
    private int minusOne(int i) {
        if (i - 1 < 0) {
            i = items.length - 1;
        } else {
            i--;
        }
        return i;
    }

    private int plusOne(int i) {
        if (i +1 > items.length- 1) {
            i = 0;
        } else {
            i++;
        }
        return i;
    }

    private void resize(int i) {
        Item[] a = (Item[]) new Object[i];
        int p = plusOne(nextFirst);
        for (int j = 0; j < size; j++) {
            a[j] = items[p];
            p = plusOne(p);
            items = a;
            nextFirst = i - 1;
            nextLast = size;
        }
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
        if (items[plusOne(nextFirst)] == null) {
            return null;
        }
        
        T a = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        size--;
        nextFirst = plusOne(nextFirst);
        if (items.length >= 16 && size < items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }
        return a;
    }

    public T removeLast() {
        if (items[minusOne(nextLast)] = null) {
            return null;
        }
        
        T a = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        size--;
        nextLast = minusOne(nextLast);
        if (items.length >= 16 && size < items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }
        return a;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            int diff = size - 1 - index;
            int last = nextLast;
            for (int i = 0; i < diff; i++) {
                last = minusOne(last);
            }
            return items[last];
        }
    }
}
public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        Node pre;
        T item;
        Node next;
        Node(Node l, T f, Node r) {
            pre = l;
            item = f;
            next = r;
        }
    } 

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node node = new Node(sentinel, item, sentinel.next);
        sentinel.next.pre = node;
        sentinel.next = node;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(sentinel.pre, item, sentinel);
        sentinel.pre.next = node;
        sentinel.pre = node;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node node = sentinel.next;
        while (node != sentinel) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.pre = sentinel;
            size -= 1;
            return first;
        }
    }
    
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T first = sentinel.pre.item;
            sentinel.pre = sentinel.pre.pre;
            sentinel.pre.next = sentinel;
            size -= 1;
            return first;
        }
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        } else {
            Node node = sentinel.next;
            for (int i = index; i > 0; i--) {
                node = node.next;
            }
            return node.item;
        }
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    private T getRecursiveHelper(Node curr, int index) {
        if (index == 0) {
            return curr.item;
        } else {
            // curr = curr.next;
            return getRecursiveHelper(curr.next, index - 1);
        }
    }
}

package skasaher.alg.ds;

import java.util.Iterator;

/**
 * 下压堆栈（链表）
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()) throw new RuntimeException();
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class StackIterator implements Iterator<Item> {
        Node p = first;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Item next() {
            Item item = p.item;
            p = p.next;
            return item;
        }
    }
}

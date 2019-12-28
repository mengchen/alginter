package skasaher.alg.ds;

import java.util.Iterator;

/**
 * 先进先出队列
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException();
        Item item = first.item;
        first = first.next;
        if (first == null) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class QueueIterator implements Iterator<Item> {
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

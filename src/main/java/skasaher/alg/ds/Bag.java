package skasaher.alg.ds;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Objects;

/**
 * 背包(链式)
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator<>(first);
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private static class BagIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public BagIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (Objects.equals(item, "#")) break;
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}

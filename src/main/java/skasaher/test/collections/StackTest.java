package skasaher.test.collections;

import java.util.Stack;
import java.util.stream.IntStream;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        IntStream.range(0, 100).forEach((int value) -> stack.push(String.valueOf(value)));
        while (!stack.empty()) System.out.println(stack.pop());
    }
}

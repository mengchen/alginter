package skasaher.test.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> paths = new ArrayList<>();
        IntStream.range(0, 100).forEach(paths::add);
        Integer s = paths.stream().reduce(0, Integer::sum);
        System.out.println(s);
    }
}

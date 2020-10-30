import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.stream(args)
                .filter(s -> s.length() <= 2)
                .collect(Collectors.toList());

        IntStream
                .of(12, 120, 50, 45, 20, 150)
                .filter(x -> x < 100)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-----");
        Stream
                .of(120, 150, 50, 20, 35)
                .filter(x -> x < 100)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("--------");

        ArrayList<Integer> list3 = new ArrayList<>(
                Arrays.asList(20, 40, 50, 15, 80, 150, 120));

        list3.parallelStream()
                .filter(x -> x > 30)
                .map(x -> x * 2)
                .forEach(System.out::println);

        IntStream.range(0, 10)
                .parallel()
                .map(x -> x * 10)
                .sum();

        System.out.println("---------");

        Stream.generate(() -> 6)
                .limit(6)
                .forEach(System.out::println);

        System.out.println("-------");

        Stream.iterate(1, x -> x + 6)
                .limit(6)
                .forEach(System.out::println);

        System.out.println("----------");

        Stream.concat(
                Stream.of(2, 3, 4, 51),
                Stream.of("a", "b", "c"))
                .forEach(System.out::println);

        System.out.println("-----");

        Stream.Builder<Integer> streamBuilder = Stream.<Integer>builder()
                .add(1)
                .add(2);

        for (int i = 3; i < 9; i++) {
            streamBuilder.accept(i);
        }

        streamBuilder
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);

        System.out.println("Range generation");
        IntStream.range(0, 10)
                .forEach(System.out::println);

        LongStream.range(-10L, 10L)
                .forEach(System.out::println);

        System.out.println("Intermediate operators");

        Stream.of(3, 5, 2, 5, 9, 10)
                .filter(x -> x > 5)
                .forEach(System.out::println);

        System.out.println("---");
        IntStream.range(0, 20)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        System.out.println("Map");

        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(System.out::print);

        Stream.of(120, 150, 50, 25, 90)
                .map(x -> x + 100)
                .forEach(System.out::println);

        System.out.println("CC16");
        Stream.of("25", "71", "192")
                .map(x -> Integer.parseInt(x, 16))
                .forEach(System.out::println);

        System.out.println("FlatMap");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(1, x))
                .forEach(System.out::println);

        System.out.println("++++");
        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    switch (x % 2) {
                        case 0:
                            return Stream.of(x, x * x, x * x * x);
                        case 1:
                            return Stream.of(x);
                        case 2:
                        default:
                            return Stream.empty();
                    }
                })
                .forEach(System.out::println);

        System.out.println("Sorted");

        IntStream.range(0, 500)
                .limit(5)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorted 2");
        Stream.of(34, 10, 65, 23, 1, 3)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Distinct");

        Stream.of(1, 1, 1, 5, 3, 6)
                .distinct()
                .forEach(System.out::println);

        System.out.println("Peek");

        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));

        System.out.println("Take while");

        DoubleStream.of(0.1, Math.PI)
                .boxed()
                .map(Object::getClass)
                .forEach(System.out::println);

        System.out.println("Terminal operators");

        Stream.of(120, 35, 10, 55, 80)
                .forEach(s -> System.out.format("%s ", s));

        System.out.println();

        System.out.println("forEachOrdered");

        IntStream.range(0, 10000)
                .parallel()
                .filter(x -> x % 1000 == 0)
                .map(x -> x / 1000)
                .forEach(x -> System.out.format("%s ", x));

        System.out.println();

        IntStream.range(0, 10000)
                .parallel()
                .filter(x -> x % 1000 == 0)
                .map(x -> x / 1000)
                .forEachOrdered(x -> System.out.format("%s ", x));

        System.out.println("count");
        long count = IntStream.range(0, 10)
                .flatMap(x -> IntStream.range(0, x))
                .count();
        System.out.println(count);

        System.out.println(
                IntStream.range(-3, 10)
                        .count()
        );

        System.out.println(
                Stream.of(0, 2, 4, 5, 1, 9, 4)
                        .map(x -> x + 1)
                        .filter(x -> x % 2 == 1)
                        .count()
        );

        System.out.println("Collect");

        List<Integer> list4 = Stream.of(1, 2, 3)
                .collect(Collectors.toList());

        String s = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", ">"));

        System.out.println("Reduce");

        int sum = IntStream.of(1, 2, 3, 4, 5)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println("Optional reduce");

        Optional<Integer> sum2 = Stream.of(1, 2, 3, 4, 5)
                .reduce(Integer::sum);
        System.out.println(sum2.get());

        List<String> kek = new ArrayList<>();
        
    }
}

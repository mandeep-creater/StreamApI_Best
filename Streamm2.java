import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streamm2 {
    public static void main(String[] args) {
        // stream is a featire intriduce in java 8
        // process collection of data in a functional and declarative manner
        //Stream Simply data Processing
        // Using the Fucntional Programming
        //Improve Readabaility and Maintainability
        //Enable Easy Parallelism

        //How to use Stram?
        //A sequence of Element supporting functional and declarative  programming
        //Source ,intermediate operations & treminal Operations

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(num.stream().filter(x->x%2==0).count());

//        Creating Stream
        //1. From Collections
        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream = num1.stream();

        //2.From Arrays
        String[] array ={"a","b","c"};
        Stream<String> stream1 = Arrays.stream(array);

        //3. Using Stream.of()
        Stream<String> a = Stream.of("a", "b");


    }
}

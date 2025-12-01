import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Warmup1 {
    public static void main(String[] args) {
        System.out.println("Hello world");

        //Prdicate -->Functional Interface
        Predicate<Integer> isEven =  x->x%2==0;
        System.out.println(isEven.test(6) ? "Haha Haha":"Nanan");

        //Function -->work for You
        Function<Integer,Integer> doubleit=x->x*x;
        Function<Integer,Integer> tripleit=x->3*x;
        System.out.println(doubleit.andThen(tripleit).apply(20));
        System.out.println(doubleit.apply(100));

        //Consumer
        Consumer<Integer> p= x -> System.out.println(x);
        p.accept(5);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> pl = x->{
            for(int i:x){
                System.out.println(i);
            }
        };
        pl.accept(list);

        //Supplier --> leta kuch nhi bs dega
        Supplier<String> supply =()-> "Hello World";
        System.out.println(supply.get());

        //combined Example

        Predicate<Integer> predicate = x->x%2==0;
        Function<Integer,Integer>function=x->x*x;
        Consumer<Integer> consumer= x-> System.out.println(x);
        Supplier<Integer>supplier=()->90;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        //Method refrence ---> use  method without invoking & in place of lambda expression
        List<String> stu = Arrays.asList("mandeep", "rohan", "Mohan");
            stu.forEach(System.out::println);
    }
}

interface MathOps{
    int operation(int a, int b);
}

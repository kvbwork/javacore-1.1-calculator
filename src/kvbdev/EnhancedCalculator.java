package kvbdev;

import java.util.function.*;

public class EnhancedCalculator {

    public static Supplier<EnhancedCalculator> instance = EnhancedCalculator::new;

    public BiFunction<Number, Number, Double> plus = (x, y) -> x.doubleValue() + y.doubleValue();
    public BiFunction<Number, Number, Double> minus = (x, y) -> x.doubleValue() - y.doubleValue();
    public BiFunction<Number, Number, Double> multiply = (x, y) -> x.doubleValue() * y.doubleValue();
    public BiFunction<Number, Number, Double> devide = (x, y) -> x.doubleValue() / y.doubleValue();

    public Function<Number, Double> pow = x -> multiply.apply(x, x);
    public Function<Number, Double> abs = x -> x.doubleValue() > 0 ? x.doubleValue() : multiply.apply(x, -1);

    public Predicate<Number> isPositive = x -> x.doubleValue() > 0.0;

    public Consumer<Number> println = System.out::println;
}

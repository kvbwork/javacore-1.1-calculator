package kvbdev;

public class Main {

    public static void main(String[] args) {

        /*
            В определенной заданием реализации происходит выбрасывание ошибки ArithmeticException
            при делении на ноль: a = 3, b = 0, c = 3 / 0

            Считаю это правильным и единственно возможным поведением при точных расчетах.
            Прерывание программы сообщением об ошибке поможет своевременно узнать что входные
            данные могут быть заданы некорректно.
        */

        /*
            Решение 1:
            Как результат деления на 0 можем использовать определенное значение, например
            Integer.MAX_VALUE. То же поведение получаем при Double.valueOf(1.0 / 0.0).intValue()
         */

        Calculator calc = Calculator.instance.get();
        calc.devide = (x, y) -> y == 0 ? Integer.MAX_VALUE : x / y;

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);

        /*
            Решение 2:
            Переписать класс калькулятора c использованием класса поддерживающего значение
            'бесконечность', например Double. Тогда результатом деления на 0 будет 'Infinity'
         */

        EnhancedCalculator ecalc = EnhancedCalculator.instance.get();

        double v1 = ecalc.plus.apply(1, 2);
        double v2 = ecalc.minus.apply(1, 1);
        double v3 = ecalc.devide.apply(v1, v2);

        ecalc.println.accept(v3);

    }
}

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceSample {

    private void sumaSample(List<Integer> l) {
        Optional<Integer> opt = l.stream().reduce(Integer::sum);

        opt.ifPresentOrElse(System.out::println, () -> System.out.println("La lista esta vacia"));

    }

    private int factorial(int n) {
        return Stream.iterate(1, x -> x + 1)
                .limit(n)
                .reduce(1, (a, b) -> a * b);
    }

    private void pruebaAcumulador() {
        String texto = "Estamos aprendiendo Java Functional";

        int cantidadLetras = List.of(texto.split(" "))
                .stream()
                .reduce(0, (longitud, palabra) -> longitud + palabra.length(),
                        (longAcum, l) -> longAcum + l);

        System.out.println("El texto [" + texto + "] tiene " + cantidadLetras +  " letras");
    }

    public static void main(String[] args) {

        ReduceSample reduceSample = new ReduceSample();

        reduceSample.sumaSample(List.of(1, 2, 3, 4, 5));
        reduceSample.sumaSample(List.of());


        System.out.println("Factorial de 5 ==> " + reduceSample.factorial(5));

        reduceSample.pruebaAcumulador();
    }
}

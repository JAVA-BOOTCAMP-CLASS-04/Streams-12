import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreamLambda {

	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, null, 5, 6, 7);
		
		System.out.println("Cantidad de pares No nulos " + stream.filter(Objects::nonNull)
			  													 .filter(x -> x % 2 == 0)
			  													 .count());
		
		/**
		 * Lambdas & Streams en Collections
		 */
		
		List<Integer> l = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7});
		
		l.stream()                        // Creamos un Stream a partir de la lista
		 .map(Integer::intValue)          // Generamos otro Stream transformando los Integer en int
		 .map(x -> x + 10)                // Generamos otro Stream sumandole 10 a cada elemento
		 .filter(x -> x % 2 == 0)         // Filtramos los pares
		 .forEach(System.out::println);   // Imprimimos los resultados
		
		
		// El segundo paso, generar un Stream de Int lo podemos hacer de otra manera.
		
		l.stream()                        // Creamos un Stream a partir de la lista
		 .mapToInt(x -> x)          // Generamos otro Stream transformando los Integer en int
		 .map(x -> x + 10)                // Generamos otro Stream sumandole 10 a cada elemento
		 .filter(x -> x % 2 == 0)         // Filtramos los pares
		 .forEach(System.out::println);   // Imprimimos los resultados
		
		// Realicemos el mapeo x -> x + 10 directamente en mapToInt que es una especializacion de map
		
		l.stream()                        // Creamos un Stream a partir de la lista
		 .mapToInt(x -> x + 10)          // Generamos otro Stream transformando los Integer en int y apliando la suma
		 .filter(x -> x % 2 == 0)         // Filtramos los pares
		 .forEach(System.out::println);   // Imprimimos los resultados
		
		Integer[] arr = Stream.of(1, 2, 3, 4, 5).toArray(Integer[]::new);
		
		System.out.println(Arrays.asList(arr));
		
		int reduceResult = Stream.of(1, 2, 3, 4, 5).reduce(0, (subtotal, elemento) -> subtotal + elemento);
		
		System.out.println("La suma de " + Arrays.asList(1, 2, 3, 4, 5) + " es " + reduceResult);

		Stream.of(1, 2, 3, 4, 5).reduce(100, Integer::sum);
		
		reduceResult = Stream.of(1, 2, 3, 4, 5).reduce(100, Integer::sum); // el acumulador se puede escribir asi
		
		System.out.println("La suma de " + Arrays.asList(1, 2, 3, 4, 5) + " + 100 es " + reduceResult);
		
		/**
		 * Obtener el maximo par
		 */
		Integer maximo = l.stream().mapToInt(x -> x).filter(x -> x % 2 == 0).reduce(Integer::max).getAsInt();
		
		System.out.println("Maximo --> " + maximo);
		
		maximo = l.stream().mapToInt(x -> x).filter(x -> x % 2 == 0).max().getAsInt();
		
		System.out.println("Maximo --> " + maximo);
		
		
		/**
		 * Utilizar collectors
		 */
		System.out.println("La lista tiene " + l.stream().collect(Collectors.counting()) + " elementos.");
		
		System.out.println("{" + l.stream().map(x -> x.toString()).collect(Collectors.joining(",")) + "}");
		
		
		/**
		 * AnyMatch / AllMatch
		 */
		
		boolean cond = Stream.of("Andres", "juan", "Pedro").allMatch(x -> Character.isUpperCase(x.charAt(0)));
		
		System.out.println((cond ? "Todos empiezan con mayuscula" : "NO todos empiezan con mayuscula"));
		
		cond = Stream.of("Andres", "juan", "Pedro").noneMatch(x -> x.length() > 6);

		System.out.println((cond ? "Todos tienen 6 o menos caracteres" : "Todos tienen mas de 6 caracteres"));
		
	}

}

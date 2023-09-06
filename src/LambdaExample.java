import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample {

	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		lista.stream().map(new Function<Integer, Integer>() {

							@Override
							public Integer apply(Integer t) {
								return t * 10;
							}
						}).filter(new Predicate<Integer>() {
				
									@Override
									public boolean test(Integer t) {
										return t > 20 && t < 50;
									}
								}).forEach(new Consumer<Integer>() {

									@Override
									public void accept(Integer t) {
										System.out.println("[" + t + "]");
									}
								});
		
		System.out.println();
		
		lista.stream().map(x -> x * 10)
					  .filter(t -> t > 20 && t < 50)
					  .forEach(t -> System.out.println("[" + t + "]"));
		
	}

}

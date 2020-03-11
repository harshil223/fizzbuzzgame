package game.fizzbuzz;

import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Fizz Buzz application client
 */

public class FizzBuzzClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private String uri = "http://localhost:8080/fizzbuzz/";

    public static void main(String[] args) {
        FizzBuzzClient fizzBuzzClient = new FizzBuzzClient();
        fizzBuzzClient.sayTheWord();
    }

    public void sayTheWord() {
        List<String> results = IntStream.rangeClosed(1, 100)
            .boxed()
            .map(i -> restTemplate.getForEntity(uri + i, String.class).getBody())
            .collect(Collectors.toList());

        System.out.println("--Numbers--");
        results.stream().forEach(System.out::println);
    }
}
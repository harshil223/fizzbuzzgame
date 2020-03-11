package game.fizzbuzz.service;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzGameServiceTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFizzGetMethod() {
        ResponseEntity<String> fizzBuzzEntity=restTemplate.getForEntity("/fizzbuzz/6", String.class);
        assertNotNull(fizzBuzzEntity.getStatusCode().is2xxSuccessful());
        assertTrue(fizzBuzzEntity.getBody().equals("Fizz"));
    }

    @Test
    public void testBuzzGetMethod() {
        ResponseEntity<String> fizzBuzzEntity=restTemplate.getForEntity("/fizzbuzz/10", String.class);
        assertNotNull(fizzBuzzEntity.getStatusCode().is2xxSuccessful());
        assertTrue(fizzBuzzEntity.getBody().equals("Buzz"));
    }

    @Test
    public void testFizzBuzzGetMethod() {
        ResponseEntity<String> fizzBuzzEntity=restTemplate.getForEntity("/fizzbuzz/15", String.class);
        assertNotNull(fizzBuzzEntity.getStatusCode().is2xxSuccessful());
        assertTrue(fizzBuzzEntity.getBody().equals("FizzBuzz"));
    }

    @Test
    public void testFizzBuzzGetMethodIllegalArgument() {
        ResponseEntity<String> fizzBuzzEntity=restTemplate.getForEntity("/fizzbuzz/a", String.class);
        assertTrue(fizzBuzzEntity.getStatusCode().value() == HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
}

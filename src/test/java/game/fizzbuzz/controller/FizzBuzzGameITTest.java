package game.fizzbuzz.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Integration test of application
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzGameITTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetMethod() {
        int number = 10;
        ResponseEntity<String> returnValue=restTemplate.getForEntity("/fizzbuzz/"+number,String.class);
        assertTrue(returnValue.getStatusCode().is2xxSuccessful());
        assertTrue(returnValue.getBody().equals("Buzz"));
    }

    @Test
    public void testServerError() {
        String number = "1a0";
        ResponseEntity<String> returnValue=restTemplate.getForEntity("/fizzbuzz/"+number,String.class);
        assertTrue(returnValue.getStatusCode().is5xxServerError());
    }
}

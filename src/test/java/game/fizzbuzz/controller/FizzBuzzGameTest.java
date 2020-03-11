package game.fizzbuzz.controller;

import game.fizzbuzz.service.FizzBuzzGameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test using MockMVC where the service is mocked
 */

public class FizzBuzzGameTest {
    private MockMvc mockMvc;

    @Mock
    private FizzBuzzGameService fizzBuzzGameService;

    @InjectMocks
    private FizzBuzzGame fizzBuzzGame;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(fizzBuzzGame)
                .build();
    }

    @Test
    public void testSaveNewShop() throws Exception {
        int number = Integer.MAX_VALUE;
        when(fizzBuzzGameService.play(number))
                .thenReturn(String.valueOf(any(String.class)));

        mockMvc.perform(
                get("/fizzbuzz/"+number))
                .andExpect(status().is2xxSuccessful());

        verify(fizzBuzzGameService, times(1)).play(number);
        verifyNoMoreInteractions(fizzBuzzGameService);
    }
}

package stos.experiments.sunupsundown.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@WebFluxTest(TwilightController.class)
public class TwilightControllerFluxTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void should_return_a_message_using_mvc_flux() {
        webTestClient.get().uri("/sunupdown/day").exchange().expectStatus().isOk().expectBody()
                .consumeWith(response ->
                        assertThat(new String(response.getResponseBody()), is(equalTo("long day"))));
    }
}

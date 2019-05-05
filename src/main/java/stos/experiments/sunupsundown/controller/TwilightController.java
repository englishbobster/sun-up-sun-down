package stos.experiments.sunupsundown.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sunupdown")
public class TwilightController {

    @GetMapping("/day")
    private Mono<String> getLengthOfDay() {
        return Mono.just("long day");
    }

}

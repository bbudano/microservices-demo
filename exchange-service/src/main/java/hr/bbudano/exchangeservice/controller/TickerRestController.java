package hr.bbudano.exchangeservice.controller;

import hr.bbudano.exchangeservice.service.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/exchange/ticker")
@RequiredArgsConstructor
public class TickerRestController {

    private final TickerService tickerService;

    @GetMapping
    public ResponseEntity<?> getTickerData(final @RequestParam(name = "pair", required = false) String pair) {
        return tickerService.getTickerData(pair);
    }

}

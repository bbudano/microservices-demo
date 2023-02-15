package hr.bbudano.exchangeservice.service;

import hr.bbudano.exchangeservice.dto.KrakenPairDto;
import hr.bbudano.exchangeservice.dto.KrakenTickerInfoResponse;
import hr.bbudano.exchangeservice.dto.TickerDto;
import hr.bbudano.exchangeservice.model.Ticker;
import hr.bbudano.exchangeservice.repository.TickerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TickerService {

    @Value("${appprops.api.kraken.url}")
    private String krakenApiUrl;

    @Value("${appprops.api.kraken.pairs}")
    private String pairs;

    private final TickerRepository tickerRepository;
    private final RestTemplate restTemplate;

    // REST methods

    @Transactional(readOnly = true)
    public ResponseEntity<?> getTickerData(final String pair) {
        List<Ticker> tickers = pair != null ? tickerRepository.findAllByPairOrderByTimestampDesc(pair) :
                tickerRepository.findAllByOrderByTimestampDesc();
        List<TickerDto> tickerDtoList = tickers.stream().map(TickerDto::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok().body(tickerDtoList);
    }

    // Scheduled methods

    @Transactional
    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void getKrakenTickerInfo() {
        String url = krakenApiUrl + "/0/public/Ticker?pair=" + pairs;

        KrakenTickerInfoResponse response = restTemplate.getForObject(url, KrakenTickerInfoResponse.class);

        if (response != null) {
            for (String key : response.getResult().keySet()) {
                KrakenPairDto krakenPairDto = response.getResult().get(key);

                Ticker ticker = new Ticker();
                ticker.setPair(key);
                ticker.setA(krakenPairDto.getA());
                ticker.setB(krakenPairDto.getB());
                ticker.setC(krakenPairDto.getC());
                ticker.setV(krakenPairDto.getV());
                ticker.setP(krakenPairDto.getP());
                ticker.setT(krakenPairDto.getT());
                ticker.setL(krakenPairDto.getL());
                ticker.setH(krakenPairDto.getH());
                ticker.setO(krakenPairDto.getO());

                tickerRepository.save(ticker);
            }
        }
    }

}

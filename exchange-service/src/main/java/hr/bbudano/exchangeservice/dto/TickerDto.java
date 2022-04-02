package hr.bbudano.exchangeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hr.bbudano.exchangeservice.model.Ticker;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class TickerDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("pair")
    private String pair;

    @JsonProperty("timestamp")
    private ZonedDateTime timestamp;

    @JsonProperty("a")
    private List<BigDecimal> a;

    @JsonProperty("b")
    private List<BigDecimal> b;

    @JsonProperty("c")
    private List<BigDecimal> c;

    @JsonProperty("v")
    private List<BigDecimal> v;

    @JsonProperty("p")
    private List<BigDecimal> p;

    @JsonProperty("t")
    private List<Long> t;

    @JsonProperty("l")
    private List<BigDecimal> l;

    @JsonProperty("h")
    private List<BigDecimal> h;

    @JsonProperty("o")
    private BigDecimal o;

    public static TickerDto fromEntity(final Ticker ticker) {
        TickerDto tickerDto = new TickerDto();
        tickerDto.setId(ticker.getId());
        tickerDto.setPair(ticker.getPair());
        tickerDto.setTimestamp(ticker.getTimestamp());
        tickerDto.setA(ticker.getA());
        tickerDto.setB(ticker.getB());
        tickerDto.setC(ticker.getC());
        tickerDto.setV(ticker.getV());
        tickerDto.setP(ticker.getP());
        tickerDto.setT(ticker.getT());
        tickerDto.setL(ticker.getL());
        tickerDto.setH(ticker.getH());
        tickerDto.setO(ticker.getO());
        return tickerDto;
    }

}

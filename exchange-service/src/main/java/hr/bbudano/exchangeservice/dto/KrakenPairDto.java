package hr.bbudano.exchangeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class KrakenPairDto {

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

}

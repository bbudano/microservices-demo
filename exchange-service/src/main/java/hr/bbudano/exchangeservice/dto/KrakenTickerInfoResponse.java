package hr.bbudano.exchangeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class KrakenTickerInfoResponse {

    @JsonProperty("error")
    private List<String> error = new ArrayList<>();

    @JsonProperty("result")
    private Map<String, KrakenPairDto> result = new HashMap<>();

}

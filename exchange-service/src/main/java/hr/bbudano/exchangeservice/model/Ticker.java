package hr.bbudano.exchangeservice.model;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ticker")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class Ticker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticker_id_seq_generator")
    @SequenceGenerator(name = "ticker_id_seq_generator", sequenceName = "ticker_id_seq", allocationSize = 10,
            initialValue = 10)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "pair")
    private String pair;

    @CreationTimestamp
    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @Type(type = "list-array")
    @Column(name = "a", columnDefinition = "numeric[]")
    private List<BigDecimal> a = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "b", columnDefinition = "numeric[]")
    private List<BigDecimal> b = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "c", columnDefinition = "numeric[]")
    private List<BigDecimal> c = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "v", columnDefinition = "numeric[]")
    private List<BigDecimal> v = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "p", columnDefinition = "numeric[]")
    private List<BigDecimal> p = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "t", columnDefinition = "bigint[]")
    private List<Long> t = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "l", columnDefinition = "numeric[]")
    private List<BigDecimal> l = new ArrayList<>();

    @Type(type = "list-array")
    @Column(name = "h", columnDefinition = "numeric[]")
    private List<BigDecimal> h = new ArrayList<>();

    @Column(name = "o")
    private BigDecimal o;

}

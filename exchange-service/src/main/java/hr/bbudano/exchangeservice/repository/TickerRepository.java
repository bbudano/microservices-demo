package hr.bbudano.exchangeservice.repository;

import hr.bbudano.exchangeservice.model.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TickerRepository extends JpaRepository<Ticker, Long> {

    List<Ticker> findAllByOrderByTimestampDesc();

    List<Ticker> findAllByPairOrderByTimestampDesc(String pair);

}

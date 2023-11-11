package GreenGrow.API.repositories;

import GreenGrow.API.entities.PlotsWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotsWeatherRepository extends JpaRepository<PlotsWeather, Long> {
}

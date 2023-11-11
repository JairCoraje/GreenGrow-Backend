package GreenGrow.API.repositories;

import GreenGrow.API.entities.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<Plot, Long> {

}

package GreenGrow.API.repositories;

import GreenGrow.API.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    Plant findByName(String name);
}

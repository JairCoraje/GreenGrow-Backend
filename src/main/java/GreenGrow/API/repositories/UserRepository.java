package GreenGrow.API.repositories;

import GreenGrow.API.entities.Event;
import GreenGrow.API.entities.Plant;
import GreenGrow.API.entities.Plot;
import GreenGrow.API.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    //buscar por email
    Optional<User> findByEmail(String email);

    //find by premium
    List<User> findByPremium(boolean premium);

    //find by no premium
    List<User> findByPremiumFalse(  );

    @Query("SELECT u.plants FROM User u WHERE u.id = ?1")
    List<Plant> getPlantsByUserId(Long id);

    @Query("SELECT u.events FROM User u WHERE u.id = ?1")
    List<Event> getEventsByUserId(Long id);
    @Query("SELECT u.plots FROM User u WHERE u.id = ?1")
    List<Plot> getPlotsByUserId(Long id);
}

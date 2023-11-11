package GreenGrow.API.services;

import GreenGrow.API.entities.Event;
import GreenGrow.API.entities.Plant;
import GreenGrow.API.entities.Plot;
import GreenGrow.API.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends CrudService<User>{
    Optional<User> findByEmail(String email) throws Exception;
    List<User> findByPremium(Boolean premium) throws Exception;

    List<User> findByNoPremium(Boolean premium) throws Exception;

    List<Plant> getPlantsByUserId(Long id) throws Exception;
    List<Event> getEventsByUserId(Long id) throws Exception;
    List<Plot> getPlotsByUserId(Long id) throws Exception;
}

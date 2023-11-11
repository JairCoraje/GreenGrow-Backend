package GreenGrow.API.services.impl;

import GreenGrow.API.entities.Event;
import GreenGrow.API.entities.Plant;
import GreenGrow.API.entities.Plot;
import GreenGrow.API.entities.User;
import GreenGrow.API.repositories.UserRepository;
import GreenGrow.API.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ImplUserService implements UserService {
    private final UserRepository userRepository;

    public ImplUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByPremium(Boolean premium) throws Exception {
        return userRepository.findByPremium(premium);
    }

    @Override
    public List<User> findByNoPremium(Boolean premium) throws Exception {
        return userRepository.findByPremiumFalse();
    }


    @Override
    public List<Plant> getPlantsByUserId(Long id) throws Exception {
        return userRepository.getPlantsByUserId(id);
    }

    @Override
    public List<Event> getEventsByUserId(Long id) throws Exception {
        return userRepository.getEventsByUserId(id);
    }

    @Override
    public List<Plot> getPlotsByUserId(Long id) throws Exception {
        return userRepository.getPlotsByUserId(id);
    }

}

package GreenGrow.API.services.impl;

import GreenGrow.API.entities.Plant;
import GreenGrow.API.repositories.PlantRepository;
import GreenGrow.API.services.PlantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ImplPlantService implements PlantService {

    private final PlantRepository plantRepository;

    public ImplPlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    @Transactional
    public Plant save(Plant plant) throws Exception {
        return plantRepository.save(plant);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        plantRepository.deleteById(id);
    }

    @Override
    public List<Plant> getAll() throws Exception {
        return plantRepository.findAll();
    }

    @Override
    public Optional<Plant> getById(Long id) throws Exception {
        return plantRepository.findById(id);
    }

    @Override
    public Plant findByName(String name) throws Exception {
        return plantRepository.findByName(name);
    }

}

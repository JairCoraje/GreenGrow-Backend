package GreenGrow.API.services;

import GreenGrow.API.entities.Plant;

public interface PlantService extends CrudService<Plant>{

    Plant findByName(String name) throws Exception;
}
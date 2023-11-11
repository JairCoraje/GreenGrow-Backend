package GreenGrow.API.services.impl;

import GreenGrow.API.entities.PlotsWeather;
import GreenGrow.API.repositories.PlotsWeatherRepository;
import GreenGrow.API.services.PlotsWeatherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ImplPlotsWeatherService implements PlotsWeatherService {

    private final PlotsWeatherRepository plotsWeatherRepository;

    public ImplPlotsWeatherService(PlotsWeatherRepository plotsWeatherRepository) {
        this.plotsWeatherRepository = plotsWeatherRepository;
    }


    @Override
    @Transactional
    public PlotsWeather save(PlotsWeather plotsWeather) throws Exception {
        return plotsWeatherRepository.save(plotsWeather);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        plotsWeatherRepository.deleteById(id);
    }

    @Override
    public List<PlotsWeather> getAll() throws Exception {
        return plotsWeatherRepository.findAll();
    }

    @Override
    public Optional<PlotsWeather> getById(Long id) throws Exception {
        return plotsWeatherRepository.findById(id);
    }
}

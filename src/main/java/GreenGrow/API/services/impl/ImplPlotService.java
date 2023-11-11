package GreenGrow.API.services.impl;

import GreenGrow.API.entities.Plot;
import GreenGrow.API.repositories.PlotRepository;
import GreenGrow.API.services.PlotService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ImplPlotService implements PlotService {
    private final PlotRepository plotRepository;

    public ImplPlotService(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    @Override
    @Transactional
    public Plot save(Plot plot) throws Exception {
        return plotRepository.save(plot);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        plotRepository.deleteById(id);
    }

    @Override
    public List<Plot> getAll() throws Exception {
        return plotRepository.findAll();
    }

    @Override
    public Optional<Plot> getById(Long id) throws Exception {
        return plotRepository.findById(id);
    }
}

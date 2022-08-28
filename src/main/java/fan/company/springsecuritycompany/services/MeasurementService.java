package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Measurement;
import fan.company.springsecuritycompany.payload.MeasurementDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;


    public Result add (MeasurementDto measurementDto){
        Measurement measurement = new Measurement();
        measurement.setName(measurementDto.getName());
        measurement.setActive(measurement.isActive());
        measurementRepository.save(measurement);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update (Long id, MeasurementDto measurementDto){
        Optional<Measurement> measurementRepositoryById = measurementRepository.findById(id);
        if (!measurementRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Measurement measurement = measurementRepositoryById.get();
        measurement.setName(measurementDto.getName());
        measurement.setActive(measurement.isActive());
        measurementRepository.save(measurement);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Measurement> getAll (Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return measurementRepository.findAll(pageable);
    }


    public Measurement getById (Long id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent())
            return new Measurement();
        return byId.get();
    }

    public Result delete(Long id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        measurementRepository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }



}

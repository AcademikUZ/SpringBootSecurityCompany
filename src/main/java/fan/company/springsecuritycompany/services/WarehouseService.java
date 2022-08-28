package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Warehouse;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.payload.WarehouseDto;
import fan.company.springsecuritycompany.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {


    @Autowired
    WareHouseRepository wareHouseRepository;


    public Result add (WarehouseDto warehouseDto){
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouse.isActive());
        wareHouseRepository.save(warehouse);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update (Long id, WarehouseDto warehouseDto){
        Optional<Warehouse> wareHouseRepositoryById = wareHouseRepository.findById(id);
        if (!wareHouseRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Warehouse warehouse = wareHouseRepositoryById.get();
        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouse.isActive());
        wareHouseRepository.save(warehouse);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Warehouse> getAll (Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return wareHouseRepository.findAll(pageable);
    }


    public Warehouse getById (Long id) {
        Optional<Warehouse> byId = wareHouseRepository.findById(id);
        if (!byId.isPresent())
            return new Warehouse();
        return byId.get();
    }

    public Result delete(Long id){
        Optional<Warehouse> byId = wareHouseRepository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        wareHouseRepository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }



}

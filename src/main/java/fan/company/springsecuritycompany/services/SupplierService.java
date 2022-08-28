package fan.company.springsecuritycompany.services;


import fan.company.springsecuritycompany.entity.Supplier;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.payload.SupplierDto;
import fan.company.springsecuritycompany.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {


    @Autowired
    SupplierRepository repository;


    public Result add(SupplierDto dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.getName());
        supplier.setActive(dto.isActive());
        supplier.setPhoneNumber(dto.getPhoneNumber());
        repository.save(supplier);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Long id, SupplierDto dto) {
        Optional<Supplier> optionalSupplier = repository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Supplier supplier = optionalSupplier.get();
        supplier.setName(dto.getName());
        supplier.setActive(dto.isActive());
        supplier.setPhoneNumber(dto.getPhoneNumber());
        repository.save(supplier);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Supplier> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAll(pageable);
    }


    public Supplier getById(Long id) {
        Optional<Supplier> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Supplier();
        return byId.get();
    }

    public Result delete(Long id) {
        Optional<Supplier> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        repository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }


}

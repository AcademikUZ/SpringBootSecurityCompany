package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.*;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.payload.InputDto;
import fan.company.springsecuritycompany.repository.CurrencyRepository;
import fan.company.springsecuritycompany.repository.InputRepository;
import fan.company.springsecuritycompany.repository.SupplierRepository;
import fan.company.springsecuritycompany.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository repository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    public Result add(InputDto dto) {


        Optional<Warehouse> wareHouseRepositoryById = wareHouseRepository.findById(dto.getWarehouseId());
        if (!wareHouseRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Supplier> supplierRepositoryById = supplierRepository.findById(dto.getSupplierId());
        if (!supplierRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(dto.getCurrencyId());
        if (!currencyRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Input input = new Input();

        input.setDate(dto.getDate());
        input.setWarehouse(wareHouseRepositoryById.get());
        input.setCurrency(currencyRepositoryById.get());
        input.setSupplier(supplierRepositoryById.get());
        input.setFactureNumber(dto.getFactureNumber());
        Input findTopByOrderByIdDesc = repository.findTopByOrderByIdDesc();
        String code;
        if (findTopByOrderByIdDesc.getId() != null) {
            code = String.valueOf(findTopByOrderByIdDesc.getId() + 1);
        } else {
            code = "1";
        }
        input.setCode(code);

        repository.save(input);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Long id, InputDto dto) {

        Optional<Warehouse> wareHouseRepositoryById = wareHouseRepository.findById(dto.getWarehouseId());
        if (!wareHouseRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Supplier> supplierRepositoryById = supplierRepository.findById(dto.getSupplierId());
        if (!supplierRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(dto.getCurrencyId());
        if (!currencyRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Optional<Input> repositoryById = repository.findById(id);
        if (!repositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Input input = repositoryById.get();
        input.setDate(dto.getDate());
        input.setWarehouse(wareHouseRepositoryById.get());
        input.setCurrency(currencyRepositoryById.get());
        input.setSupplier(supplierRepositoryById.get());
        input.setFactureNumber(dto.getFactureNumber());
        Input findTopByOrderByIdDesc = repository.findTopByOrderByIdDesc();
        String code;
        if (findTopByOrderByIdDesc.getId() != null) {
            code = String.valueOf(findTopByOrderByIdDesc.getId() + 1);
        } else {
            code = "1";
        }
        input.setCode(code);

        repository.save(input);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Input> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAll(pageable);
    }


    public Input getById(Long id) {
        Optional<Input> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Input();
        return byId.get();
    }

    public Result delete(Long id) {
        Optional<Input> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        repository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }


}

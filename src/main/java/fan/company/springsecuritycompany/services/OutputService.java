package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.*;
import fan.company.springsecuritycompany.payload.OutputDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository repository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    public Result add(OutputDto dto) {


        Optional<Warehouse> wareHouseRepositoryById = wareHouseRepository.findById(dto.getWarehouseId());
        if (!wareHouseRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Client> clientRepositoryById = clientRepository.findById(dto.getClientId());
        if (!clientRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(dto.getCurrencyId());
        if (!currencyRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Output output = new Output();

        output.setDate(dto.getDate());
        output.setWarehouse(wareHouseRepositoryById.get());
        output.setCurrency(currencyRepositoryById.get());
        output.setClient(clientRepositoryById.get());
        output.setFactureNumber(dto.getFactureNumber());
        Output findTopByOrderByIdDesc = repository.findTopByOrderByIdDesc();
        String code;
        if (findTopByOrderByIdDesc.getId() != null) {
            code = String.valueOf(findTopByOrderByIdDesc.getId() + 1);
        } else {
            code = "1";
        }
        output.setCode(code);

        repository.save(output);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Long id, OutputDto dto) {

        Optional<Warehouse> wareHouseRepositoryById = wareHouseRepository.findById(dto.getWarehouseId());
        if (!wareHouseRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Client> clientRepositoryById = clientRepository.findById(dto.getClientId());
        if (!clientRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(dto.getCurrencyId());
        if (!currencyRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Optional<Output> repositoryById = repository.findById(id);
        if (!repositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Output output = repositoryById.get();
        output.setDate(dto.getDate());
        output.setWarehouse(wareHouseRepositoryById.get());
        output.setCurrency(currencyRepositoryById.get());
        output.setClient(clientRepositoryById.get());
        output.setFactureNumber(dto.getFactureNumber());
        Output findTopByOrderByIdDesc = repository.findTopByOrderByIdDesc();
        String code;
        if (findTopByOrderByIdDesc.getId() != null) {
            code = String.valueOf(findTopByOrderByIdDesc.getId() + 1);
        } else {
            code = "1";
        }
        output.setCode(code);

        repository.save(output);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Output> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAll(pageable);
    }


    public Output getById(Long id) {
        Optional<Output> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Output();
        return byId.get();
    }

    public Result delete(Long id) {
        Optional<Output> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        repository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }


}

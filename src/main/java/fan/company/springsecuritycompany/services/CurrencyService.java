package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Currency;
import fan.company.springsecuritycompany.payload.CurrencyDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;


    public Result add (CurrencyDto currencyDto){
        Currency currency = new Currency();
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.isActive());
        currencyRepository.save(currency);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update (Long id, CurrencyDto currencyDto){
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(id);
        if (!currencyRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Currency currency = currencyRepositoryById.get();
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.isActive());
        currencyRepository.save(currency);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Currency> getAll (Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return currencyRepository.findAll(pageable);
    }


    public Currency getById (Long id) {
        Optional<Currency> byId = currencyRepository.findById(id);
        if (!byId.isPresent())
            return new Currency();
        return byId.get();
    }

    public Result delete(Long id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        currencyRepository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }



}

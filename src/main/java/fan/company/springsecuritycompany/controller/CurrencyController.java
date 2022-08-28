package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.entity.Currency;
import fan.company.springsecuritycompany.payload.CurrencyDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping("/add")
    public Result add(@RequestBody CurrencyDto currencyDto){
        return currencyService.add(currencyDto);
    }


    @PutMapping("/update/{id}")
    public Result add(@PathVariable Long id, @RequestBody CurrencyDto currencyDto){
        return currencyService.update(id, currencyDto);
    }

    @GetMapping("/getById/{id}")
    public Currency getById(@PathVariable Long id){
        return currencyService.getById(id);
    }

    @GetMapping("/getall")
    public Page<Currency> getAll(@RequestParam Integer page){
        return currencyService.getAll(page);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return currencyService.delete(id);
    }





}

package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.entity.Input;
import fan.company.springsecuritycompany.payload.InputDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService service;

    @PostMapping("/add")
    public Result add(@RequestBody InputDto dto){
        return service.add(dto);
    }

    @PutMapping("/update/{id}")
    public Result add(@PathVariable Long id, @RequestBody InputDto dto){
        return service.update(id, dto);
    }

    @GetMapping("/getById/{id}")
    public Input getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/getall")
    public Page<Input> getAll(@RequestParam Integer page){
        return service.getAll(page);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }



}

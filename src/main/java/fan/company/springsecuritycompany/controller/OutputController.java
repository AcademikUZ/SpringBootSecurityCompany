package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.entity.Output;
import fan.company.springsecuritycompany.payload.OutputDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputService service;

    @PostMapping("/add")
    public Result add(@RequestBody OutputDto dto){
        return service.add(dto);
    }

    @PutMapping("/update/{id}")
    public Result add(@PathVariable Long id, @RequestBody OutputDto dto){
        return service.update(id, dto);
    }

    @GetMapping("/getById/{id}")
    public Output getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/getall")
    public Page<Output> getAll(@RequestParam Integer page){
        return service.getAll(page);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }




}

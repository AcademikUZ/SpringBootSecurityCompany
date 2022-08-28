package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.entity.Output_product;
import fan.company.springsecuritycompany.payload.Output_productDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.Output_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/output_product")
public class Output_productController {

    @Autowired
    Output_productService service;

    @PostMapping("/add")
    public Result add(@RequestBody Output_productDto dto){
        return service.add(dto);
    }

    @PutMapping("/update/{id}")
    public Result add(@PathVariable Long id, @RequestBody Output_productDto dto){
        return service.update(id, dto);
    }

    @GetMapping("/getById/{id}")
    public Output_product getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/getall")
    public Page<Output_product> getAll(@RequestParam Integer page){
        return service.getAll(page);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }


}

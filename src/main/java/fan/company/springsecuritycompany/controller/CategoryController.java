package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.entity.Category;
import fan.company.springsecuritycompany.payload.CategoryDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @PostMapping
    public Result add(@RequestBody CategoryDto dto){
        return service.add(dto);
    }

    @PutMapping("/{id}")
    public Result add(@PathVariable Long id, @RequestBody CategoryDto dto){
        return service.update(id, dto);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    public Page<Category> getAll(@RequestParam Integer page){
        return service.getAll(page);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }

}

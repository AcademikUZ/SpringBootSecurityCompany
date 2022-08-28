package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Category;
import fan.company.springsecuritycompany.payload.CategoryDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;


    public Result add(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        if (categoryDto.getParrentCategory() != null)
            category.setParrentCategory(categoryRepository.findById(categoryDto.getParrentCategory()).get());
        categoryRepository.save(category);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Long id, CategoryDto categoryDto) {
        Optional<Category> categoryRepositoryById = categoryRepository.findById(id);
        if (!categoryRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Category category = categoryRepositoryById.get();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        if (categoryDto.getParrentCategory() != null)
            category.setParrentCategory(categoryRepository.findById(categoryDto.getParrentCategory()).get());
        categoryRepository.save(category);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Category> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return categoryRepository.findAll(pageable);
    }


    public Category getById(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent())
            return new Category();
        return byId.get();
    }

    public Result delete(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        categoryRepository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }


}

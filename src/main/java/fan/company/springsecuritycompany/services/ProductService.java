package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Attachment;
import fan.company.springsecuritycompany.entity.Category;
import fan.company.springsecuritycompany.entity.Measurement;
import fan.company.springsecuritycompany.entity.Product;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.payload.ProductDto;
import fan.company.springsecuritycompany.repository.*;
import fan.company.springsecuritycompany.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;



    public Result add(ProductDto dto) {

        Optional<Category> categoryRepositoryById = categoryRepository.findById(dto.getCategoryId());
        if (!categoryRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Attachment> attachmentRepositoryById = attachmentRepository.findById(dto.getPhotoId());
        if (!attachmentRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Measurement> measurementRepositoryById = measurementRepository.findById(dto.getMeasurementId());
        if (!measurementRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Product product = new Product();
        product.setName(dto.getName());
        product.setActive(dto.isActive());
        product.setCategory(categoryRepositoryById.get());
        product.setMeasurement(measurementRepositoryById.get());
        product.setPhotoId(attachmentRepositoryById.get());
        Product findTopByOrderByIdDesc = repository.findTopByOrderByIdDesc();
        String code;
        if(findTopByOrderByIdDesc.getId() != null) {
            code = String.valueOf(findTopByOrderByIdDesc.getId() + 1);
        } else {
            code = "1";
        }
        product.setCode(code);
        repository.save(product);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Long id, ProductDto dto) {
        Optional<Category> categoryRepositoryById = categoryRepository.findById(dto.getCategoryId());
        if (!categoryRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Attachment> attachmentRepositoryById = attachmentRepository.findById(dto.getPhotoId());
        if (!attachmentRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Measurement> measurementRepositoryById = measurementRepository.findById(dto.getMeasurementId());
        if (!measurementRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);


        Optional<Product> repositoryById = repository.findById(id);
        if (!repositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Product product = repositoryById.get();
        product.setName(dto.getName());
        product.setActive(dto.isActive());
        product.setCategory(categoryRepositoryById.get());
        product.setMeasurement(measurementRepositoryById.get());
        product.setPhotoId(attachmentRepositoryById.get());
        Product findTopByOrderByIdDesc = repository.findTopByOrderByIdDesc();
        String code;
        if(findTopByOrderByIdDesc.getId() != null) {
            code = String.valueOf(findTopByOrderByIdDesc.getId() + 1);
        } else {
            code = "1";
        }
        product.setCode(code);
        repository.save(product);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Product> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAll(pageable);
    }


    public Product getById(Long id) {
        Optional<Product> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Product();
        return byId.get();
    }

    public Result delete(Long id) {
        Optional<Product> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        repository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }


}

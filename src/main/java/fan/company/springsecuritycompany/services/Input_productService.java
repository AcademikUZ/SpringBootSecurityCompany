package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Input;
import fan.company.springsecuritycompany.entity.Input_product;
import fan.company.springsecuritycompany.entity.Product;
import fan.company.springsecuritycompany.payload.Input_productDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.repository.*;
import fan.company.springsecuritycompany.repository.Input_productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Input_productService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;
    @Autowired
    Input_productRepository repository;


    public Result add(Input_productDto dto) {
        Optional<Product> productRepositoryById = productRepository.findById(dto.getProductId());
        if (!productRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Input> inputRepositoryById = inputRepository.findById(dto.getProductId());
        if (!inputRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Input_product input_product = new Input_product();
        input_product.setProduct(productRepositoryById.get());
        input_product.setInput(inputRepositoryById.get());
        input_product.setAmount(dto.getAmount());
        input_product.setPrice(dto.getPrice());
        input_product.setExpire_date(dto.getExpire_date());
        repository.save(input_product);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Long id, Input_productDto dto) {
        Optional<Product> productRepositoryById = productRepository.findById(dto.getProductId());
        if (!productRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Optional<Input> inputRepositoryById = inputRepository.findById(dto.getInputId());
        if (!inputRepositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);

        Optional<Input_product> repositoryById = repository.findById(id);
        if (!repositoryById.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        Input_product input_product = repositoryById.get();
        input_product.setProduct(productRepositoryById.get());
        input_product.setInput(inputRepositoryById.get());
        input_product.setAmount(dto.getAmount());
        input_product.setPrice(dto.getPrice());
        input_product.setExpire_date(dto.getExpire_date());
        repository.save(input_product);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Page<Input_product> getAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAll(pageable);
    }


    public Input_product getById(Long id) {
        Optional<Input_product> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Input_product();
        return byId.get();
    }

    public Result delete(Long id) {
        Optional<Input_product> byId = repository.findById(id);
        if (!byId.isPresent())
            return new Result("Bunday idlik ma'lumot yo'q", false);
        repository.deleteById(id);
        return new Result("Ma'lumot o'chirildi", true);
    }


}

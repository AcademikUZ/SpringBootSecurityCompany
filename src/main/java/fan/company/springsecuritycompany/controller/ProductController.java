package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.config.XavfsizlikniSozlash;
import fan.company.springsecuritycompany.entity.Product;
import fan.company.springsecuritycompany.payload.ProductDto;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService service;


    //MODERATOR, SUPER_ADMIN

    /**
     * Role Based orqali hodisalarni boshqarish
     * @param  @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'MODERATOR')")
     * @return
     */
    //@PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'MODERATOR')")

    /**
     * hasAuthority orqali hodisalarni boshqarish
     * @param dto
     * @return
     */
    @PreAuthorize(value = "hasAuthority('ADD')")
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody ProductDto dto){
        Result result = service.add(dto);
        return ResponseEntity.status(result.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(result) ;
    }

    //MODERATOR, SUPER_ADMIN
   // @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'MODERATOR')")

    @PreAuthorize(value = "hasAuthority('EDIT')")
    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@Valid @PathVariable Long id, @RequestBody ProductDto dto){
        Result result = service.update(id, dto);
        return ResponseEntity.status(result.isSuccess()? HttpStatus.OK:HttpStatus.CONFLICT).body(result) ;
    }

    //OPERATOR, MODERATOR, SUPER_ADMIN
   // @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'OPERATOR', 'MODERATOR')")

    @PreAuthorize(value = "hasAuthority('GET_ONE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Product product = service.getById(id);
        return ResponseEntity.status(product!=null ? HttpStatus.OK:HttpStatus.BAD_REQUEST).body(product) ;
    }

    //OPERATOR, MODERATOR, SUPER_ADMIN
   // @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN', 'OPERATOR', 'MODERATOR')")

    @PreAuthorize(value = "hasAuthority('GET_ALL')")
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Integer page){
        Page<Product> productPage = service.getAll(page);
        return ResponseEntity.status(!productPage.isEmpty() ? HttpStatus.OK:HttpStatus.CONFLICT).body(!productPage.isEmpty()?productPage:null) ;
    }

    //SUPER_ADMIN
    //@PreAuthorize(value = "hasRole('SUPER_ADMIN')")

    @PreAuthorize(value = "hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//Huquqni k'rish uchun ishlatsa bo'adi

        Result result = service.delete(id);
        return ResponseEntity.status(result.isSuccess()? HttpStatus.NO_CONTENT:HttpStatus.CONFLICT).body(result) ;
    }


}

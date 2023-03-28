package com.example.pcthanhcongserver.controllers;

import com.example.pcthanhcongserver.base.BaseController;
import com.example.pcthanhcongserver.contants.Common;
import com.example.pcthanhcongserver.dto.pagination.PaginateDTO;
import com.example.pcthanhcongserver.entity.Product;
import com.example.pcthanhcongserver.filters.ProductFilter;
import com.example.pcthanhcongserver.forms.UpdateProductForm;
import com.example.pcthanhcongserver.services.IProductService;
import com.example.pcthanhcongserver.specifications.GenericSpecification;
import com.example.pcthanhcongserver.specifications.SearchCriteria;
import com.example.pcthanhcongserver.specifications.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
public class ProductController extends BaseController<Product> {
    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<?> getAllProducts(ProductFilter productFilter, HttpServletRequest request){
        GenericSpecification<Product> specification = new GenericSpecification<Product>().getBasicQuery(request);

        if(productFilter.getStartId() != null)
            specification.add(new SearchCriteria("id", productFilter.getStartId(), SearchOperation.GREATER_THAN_EQUAL));

        if (productFilter.getEndId() != null)
            specification.add(new SearchCriteria("id", productFilter.getEndId(),SearchOperation.LESS_THAN_EQUAL));

        if (productFilter.getSearch() != null)
            specification.add(new SearchCriteria("title",productFilter.getSearch(),SearchOperation.LIKE));

        if (productFilter.getSearch() != null)
            specification.add(new SearchCriteria("specifications",productFilter.getSearch(),SearchOperation.LIKE));

        if(productFilter.getMnOPrice() != null)
            specification.add(new SearchCriteria("originalPrice", productFilter.getMnOPrice(), SearchOperation.GREATER_THAN_EQUAL));

        if(productFilter.getMxOPrice() != null)
            specification.add(new SearchCriteria("originalPrice", productFilter.getMxOPrice(), SearchOperation.LESS_THAN_EQUAL));

        PaginateDTO<Product> paginateProducts = service.getAllProducts(productFilter.getPage(), productFilter.getPerPage(), specification);
        return this.resPagination(paginateProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id){
        Product product = service.getProductById(id);
        if (product == null)
            throw new NotFoundException(Common.MSG_NOT_FOUND);
        return this.resSuccess(product);
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<?> getProductByTitle(@PathVariable("title") String title){
        Product product = service.getProductByTitle(title);
        if (product == null)
            throw new NotFoundException(Common.MSG_NOT_FOUND);
        return this.resSuccess(product);
    }
    @GetMapping(value = "/existsTitle/{title}")
    public ResponseEntity<?> existedByProductTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(service.existsProductByTitle(title), HttpStatus.OK);
    }

    @GetMapping(value = "/specifications/{specifications}")
    public ResponseEntity<?> getProductBySpecifications(@PathVariable("specifications") String specifications){
        Product product = service.getProductByTitle(specifications);
        if (product == null)
            throw new NotFoundException(Common.MSG_NOT_FOUND);
        return this.resSuccess(product);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<?> UpdateProduct(@PathVariable("id") Integer id, @RequestBody UpdateProductForm form){
        service.updateProduct(id,form);
        return new ResponseEntity<>("Update Successful", HttpStatus.OK);
    }

    @PutMapping(value = "/unlock/{id}")
//    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> unLockProduct(@PathVariable("id") Integer id){
        service.unLockProductStatus(id);
        return new ResponseEntity<>("Unlock Product Successfull",HttpStatus.OK);
    }

    @PutMapping(value = "/lock/{id}")
//    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> lockProduct(@PathVariable("id") Integer id){
        service.lockProductStatus(id);
        return new ResponseEntity<>("Lock Product Successfull",HttpStatus.OK);
    }


    @GetMapping(value = "/count")
    public ResponseEntity<?> getProductCount(){
        return new ResponseEntity<>(service.getProductCount() , HttpStatus.OK);
    }
}

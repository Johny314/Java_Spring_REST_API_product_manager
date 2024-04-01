package com.example.projectmanager.controller;

import com.example.projectmanager.dto.ProductDTO;
import com.example.projectmanager.entity.Product;
import com.example.projectmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private  final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO){
        return mappingResponseProduct(productService.create(productDTO));
    }
    @GetMapping
    public ResponseEntity<List<Product>>readAll(){
        return mappingResponseListProduct(productService.readALL());
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id){
        return mappingResponseListProduct(productService.readByCategoryId(id));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product ){
        return mappingResponseProduct(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        productService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product){
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products){
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

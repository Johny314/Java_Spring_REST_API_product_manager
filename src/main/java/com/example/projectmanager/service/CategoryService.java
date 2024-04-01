package com.example.projectmanager.service;

import com.example.projectmanager.entity.Category;
import com.example.projectmanager.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> readAll(){
        return categoryRepository.findAll();
    }

    public Category readById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found - " + id ));
    }
}

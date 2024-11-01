package com.example.android_backend.controller;

import com.example.android_backend.model.Category;
import com.example.android_backend.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all-category")
    public List<Category> getAllCategory() {
        return categoryService.getAll();
    }
}

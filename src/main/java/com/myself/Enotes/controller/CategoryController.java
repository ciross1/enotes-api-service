package com.myself.Enotes.controller;

import com.myself.Enotes.dto.CategoryDto;
import com.myself.Enotes.dto.CategoryResponse;
import com.myself.Enotes.model.Category;
import com.myself.Enotes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save-category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        Boolean saveCategory = categoryService.saveCategory(categoryDto);
        if(saveCategory){
            return new ResponseEntity<>("saved", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/show-category")
    public ResponseEntity<?> getAllCategory() {
        List<CategoryDto> allCategory = categoryService.getAllCategory();
        if (CollectionUtils.isEmpty(allCategory)) {
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(allCategory, HttpStatus.OK);
        }
    }

    @GetMapping("/show-active-category")
    public ResponseEntity<?> getActiveCategory() {
        List<CategoryResponse> allCategory = categoryService.getActiveCategory();
        if (CollectionUtils.isEmpty(allCategory)) {
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(allCategory, HttpStatus.OK);
        }
    }

}

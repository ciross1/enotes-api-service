package com.myself.Enotes.controller;

import com.myself.Enotes.dto.CategoryDto;
import com.myself.Enotes.dto.CategoryResponse;
import com.myself.Enotes.model.Category;
import com.myself.Enotes.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
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

    @GetMapping("/{id}")
    public ResponseEntity<?>getCategoryDetailsById(@PathVariable  Integer id){
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        if(ObjectUtils.isEmpty(categoryDto)){
            return new ResponseEntity<>("Category not found with id=" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteCategoryById(@PathVariable  Integer id){
     Boolean deleted = categoryService.deleteCategory(id);
        if(deleted){
            return new ResponseEntity<>("Category deleted SUCCESS=" + id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Category not  deleted", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @DeleteMapping("delete-complete/{id}")
    public ResponseEntity<?>deleteCompletelyById(@PathVariable Integer id){
        Boolean deleted = categoryService.deleteCompleted(id);

                if(deleted){
                    return new ResponseEntity<>("Category deleted completely SUCCESS=" + id, HttpStatus.OK);
                }

        return new ResponseEntity<>("Category not  deleted", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

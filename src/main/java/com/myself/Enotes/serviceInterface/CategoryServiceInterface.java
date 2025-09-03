package com.myself.Enotes.serviceInterface;

import com.myself.Enotes.dto.CategoryDto;
import com.myself.Enotes.dto.CategoryResponse;
import com.myself.Enotes.model.Category;

import java.util.List;


public interface CategoryServiceInterface {
    public Boolean saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getAllCategory();
    public List<CategoryResponse> getActiveCategory();
    public CategoryDto getCategoryById(Integer id);
    public Boolean deleteCategory(Integer id);
}

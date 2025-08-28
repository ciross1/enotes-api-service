package com.myself.Enotes.serviceInterface;

import com.myself.Enotes.model.Category;

import java.util.List;


public interface CategoryServiceInterface {
    public Boolean saveCategory(Category category);
    public List<Category> getAllCategory();
}

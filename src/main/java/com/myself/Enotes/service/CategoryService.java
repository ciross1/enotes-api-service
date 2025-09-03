package com.myself.Enotes.service;

import com.myself.Enotes.dto.CategoryDto;
import com.myself.Enotes.dto.CategoryResponse;
import com.myself.Enotes.model.Category;
import com.myself.Enotes.repository.CategoryRepository;
import com.myself.Enotes.serviceInterface.CategoryServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;



    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {

//        Category category = new Category();
//        category.setName(categoryDto.getName());
//        category.setDescription(categoryDto.getDescription());
//        category.setIsActive(categoryDto.getIsActive());

        //Machen wir es kürzer:
        // ModelMapper übernimmt das Mapping automatisch:
        //Er schaut sich die Property-Namen an (name, description, isActive)
        //Er erkennt, dass sie in beiden Klassen vorkommen
        //Er kopiert die Werte vom CategoryDto ins neue Category-Objekt.

       Category category=  mapper.map(categoryDto, Category.class);


        category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());

        Category saveCategory = categoryRepository.save(category);
        if(ObjectUtils.isEmpty(saveCategory)){
            return false;
        }

        return true;
    }

    @Override
    public List<CategoryDto> getAllCategory() {

        List<Category> categories = categoryRepository.findByIsDeletedFalse();

            List<CategoryDto> categoryDtoList =
                    categories.stream().map(cat ->mapper.map(cat, CategoryDto.class)).toList();


        return categoryDtoList;
    }





    // findByIsActiveTrue() gibt dir alle Kategorien zurück, bei denen isActive = true ist.
    // du wandelst die Liste in einen Stream um (damit kannst du funktional damit arbeiten).
    // → für jedes Element (cat) im Stream wird der ModelMapper verwendet:
    //cat ist ein Category-Entity-Objekt (aus der DB).
    // Mit Stream + ModelMapper transformieren (Category → CategoryResponse).

    @Override
    public List<CategoryResponse> getActiveCategory() {

        List<Category> categories = categoryRepository.findByIsActiveTrueAndIsDeletedFalse();

        List<CategoryResponse> categoryList =
                categories.stream().map(cat->mapper.map(cat, CategoryResponse.class)).toList();

        return categoryList;
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        Optional<Category> findByCategory = categoryRepository.findByIdAndIsDeletedFalse(id);

        if(findByCategory.isPresent()){
            Category category = findByCategory.get();

            // Der Mapper kopiert die Werte von der Quellklasse
            // (Category) in die Zielklasse (CategoryDto).
            return mapper.map(category, CategoryDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteCategory(Integer id) {

        Optional<Category> findByCategory = categoryRepository.findById(id);

        if(findByCategory.isPresent()){
            Category category = findByCategory.get();
            category.setIsDeleted(true);
            categoryRepository.save(category);

            return true;

        }
        return false;
    }


}

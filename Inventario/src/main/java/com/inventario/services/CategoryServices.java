package com.inventario.services;

import com.inventario.dtos.CategoryDTO;
import com.inventario.entities.CategoryEntity;

import java.util.List;

public interface CategoryServices {

    List<CategoryDTO> findAll();
    CategoryDTO findById(long id);
    void deleteById(long id);
    void save(CategoryDTO category);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, long id);

//    List<CategoryEntity> findAll();
//    CategoryEntity findById(long id);
//    void deleteById(long id);
//    void save(CategoryEntity category);
//    CategoryEntity updateCategory(CategoryEntity category, long id);
}

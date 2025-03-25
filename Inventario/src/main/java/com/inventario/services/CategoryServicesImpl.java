package com.inventario.services;

import com.inventario.dtos.CategoryDTO;
import com.inventario.entities.CategoryEntity;
import com.inventario.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImpl implements CategoryServices {

    private final ModelMapper categoryMapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional(readOnly = true)
    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream().map(category -> categoryMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

    //sin mapeo
//    @Transactional(readOnly = true)
//    @Override
//    public List<CategoryEntity> findAll() {
//        return categoryRepository.findAll();
//    }

    @Transactional(readOnly = true)
    @Override
    public CategoryDTO findById(long id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.map(category, CategoryDTO.class);
    }

//    //sin mapeo
//    @Transactional(readOnly = true)
//    @Override
//    public CategoryEntity findById(long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }

    @Transactional
    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void save(CategoryDTO categoryDTO) {
        CategoryEntity category = categoryMapper.map(categoryDTO, CategoryEntity.class);
        categoryRepository.save(category);
    }

// //    sin mapeo
//    @Transactional
//    @Override
//    public void save(CategoryEntity category) {
//        categoryRepository.save(category);
//    }

    @Transactional
    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, long id) {
        CategoryDTO categoryFound = findById(id);
        categoryFound.setId(id);
        categoryFound.setName(categoryDTO.getName());
        categoryFound.setDescription(categoryDTO.getDescription());

        CategoryEntity category = categoryMapper.map(categoryFound, CategoryEntity.class);

        categoryRepository.save(category);
        return categoryFound;
    }

//    @Transactional
//    @Override
//    public CategoryEntity updateCategory(CategoryEntity categoryEntity, long id) {
//        CategoryEntity categoryFound = findById(id);
//        categoryFound.setId(id);
//        categoryFound.setName(categoryEntity.getName());
//        categoryFound.setDescription(categoryEntity.getDescription());
//
//        categoryRepository.save(categoryFound);
//        return categoryFound;
//    }
}

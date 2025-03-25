package com.inventario.services;

import com.inventario.dtos.CategoryDTO;
import com.inventario.dtos.ProductDTO;
import com.inventario.entities.CategoryEntity;
import com.inventario.entities.ProductEntity;
import com.inventario.repositories.CategoryRepository;
import com.inventario.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServicesImpl implements ProductServices {

    ModelMapper productMapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(p -> productMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDTO findById(long id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        return productMapper.map(product, ProductDTO.class);
//        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void save(ProductDTO productDTO) {
        ProductEntity product = productMapper.map(productDTO, ProductEntity.class);
        Optional<CategoryEntity> category = categoryRepository.findById(product.getCategory().getId());
        category.ifPresent(product::setCategory);
        productRepository.save(product);
    }

    @Transactional
    @Override
    public ProductDTO update(long id, ProductDTO productDTO) {
       CategoryEntity category = categoryRepository.findById(productDTO.getCategory().getId()).orElse(null);
        CategoryDTO categoryDTO = productMapper.map(category, CategoryDTO.class);
        ProductDTO productUpdate = findById(id);

        productUpdate.setId(id);
        productUpdate.setName(productDTO.getName());
        productUpdate.setPrice(productDTO.getPrice());
        productUpdate.setCategory(categoryDTO);
        ProductEntity product = productMapper.map(productUpdate, ProductEntity.class);

        productRepository.save(product);
        return productUpdate;
    }

}

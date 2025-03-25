package com.inventario.services;

import com.inventario.dtos.ProductDTO;
import com.inventario.entities.ProductEntity;

import java.util.List;

public interface ProductServices {
    List<ProductDTO> findAll();
    ProductDTO findById(long id);
    void deleteById(long id);
    void save(ProductDTO product);
    ProductDTO update(long id, ProductDTO product);

//    List<ProductEntity> findAll();
//    ProductEntity findById(long id);
//    void deleteById(long id);
//    void save(ProductEntity product);
//    ProductEntity update(long id, ProductEntity product);
}

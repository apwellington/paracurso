package com.inventario.services;

import com.inventario.dtos.StockDTO;
import com.inventario.entities.StockEntity;

import java.util.List;

public interface StockServices {

    List<StockDTO> findAll();
    StockDTO findById(long id);
    void deleteById(long id);
    void save(StockDTO stock);
    StockDTO updateStock(StockDTO stock, long id);

//    List<StockEntity> findAll();
//    StockEntity findById(long id);
//    void deleteById(long id);
//    void save(StockEntity stock);
//    StockEntity updateStock(StockEntity stock, long id);
}

package com.inventario.services;

import com.inventario.dtos.ProductDTO;
import com.inventario.dtos.StockDTO;
import com.inventario.entities.ProductEntity;
import com.inventario.entities.StockEntity;
import com.inventario.repositories.ProductRepository;
import com.inventario.repositories.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServicesImpl implements StockServices {

    ModelMapper stockMapper = new ModelMapper();

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<StockDTO> findAll() {
        return stockRepository.findAll().stream().map(s -> stockMapper.map(s, StockDTO.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public StockDTO findById(long id) {
        StockEntity stock = stockRepository.findById(id).orElse(null);
        return stockMapper.map(stock, StockDTO.class);
    }


    @Transactional
    @Override
    public void deleteById(long id) {
        stockRepository.deleteById(id);
    }

    @Transactional
    @Override
    public StockDTO updateStock(StockDTO stockDTO, long id) {
        ProductEntity product = productRepository.findById(stockDTO.getProduct().getId()).orElse(null);
        ProductDTO productDTO = stockMapper.map(product, ProductDTO.class);
        StockDTO stockFound = findById(id);
        stockFound.setId(id);
        stockFound.setQuantity(stockDTO.getQuantity());
        stockFound.setDate(stockDTO.getDate());
        stockFound.setProduct(productDTO);

        StockEntity stock = stockMapper.map(stockFound, StockEntity.class);

        stockRepository.save(stock);
        return stockFound;
    }

    @Transactional
    @Override
    public void save(StockDTO stockDTO) {
        StockEntity stock = stockMapper.map(stockDTO, StockEntity.class);
        Optional<ProductEntity> product = productRepository.findById(stockDTO.getProduct().getId());
        product.ifPresent(stock::setProduct);
        stockRepository.save(stock);
    }
}

package com.project.backend.services;

import com.project.backend.mapper.StockMapper;
import com.project.backend.model.Stock;
import com.project.backend.model.dto.StockDTO;
import com.project.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    public StockDTO save(StockDTO dto) {
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);

        return mapper.toDto(stock);

    }
}

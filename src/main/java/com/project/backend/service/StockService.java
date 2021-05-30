package com.project.backend.service;

import com.project.backend.exception.BusinessException;
import com.project.backend.mapper.StockMapper;
import com.project.backend.model.Stock;
import com.project.backend.model.dto.StockDTO;
import com.project.backend.repository.StockRepository;
import com.project.backend.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if (optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);

        return mapper.toDto(stock);

    }
}

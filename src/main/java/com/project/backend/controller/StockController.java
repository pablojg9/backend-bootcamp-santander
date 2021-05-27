package com.project.backend.controller;

import com.project.backend.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {
        List<StockDTO> list = new ArrayList<>();

        StockDTO dto = new StockDTO();

        dto.setId(1L);
        dto.setName("Pablo");
        dto.setPrice(100.00D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());

        list.add(dto);

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable long id) {
        List<StockDTO> list = new ArrayList<>();

        StockDTO stock = new StockDTO();

        stock.setId(1L);
        stock.setName("Casas Bahia");
        stock.setPrice(100.20D);
        stock.setVariation(10.1);
        stock.setDate(LocalDate.now());

        StockDTO stock2 = new StockDTO();

        stock2.setId(2L);
        stock2.setName("santander");
        stock2.setPrice(50);
        stock2.setVariation(12.2);
        stock2.setDate(LocalDate.now());

        list.add(stock);
        list.add(stock2);

        StockDTO dtoSelect = list.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();

        return ResponseEntity.ok(dtoSelect);

    }



}

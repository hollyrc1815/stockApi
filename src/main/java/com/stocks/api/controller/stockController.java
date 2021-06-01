package com.stocks.api.controller;


import com.stocks.api.exception.ResourcesNotFoundException;
import com.stocks.api.model.Stock;
import com.stocks.api.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class stockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") String stockId)
            throws ResourcesNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourcesNotFoundException("Stock not found for this id :: " + stockId));
        return ResponseEntity.ok().body(stock);
    }

    @PostMapping("/stocks")
    public Stock createStock(@Valid @RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateEmployee(@PathVariable(value = "id") String stockId,
                                                   @Valid @RequestBody Stock stockDetails) throws ResourcesNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourcesNotFoundException("Stock not found for this id :: " + stockId));
        stock.setId(stockDetails.getId());
        stock.setName(stockDetails.getName());
        stock.setWebsite(stockDetails.getWebsite());
        stock.setStockexchange(stockDetails.getStockexchange());
        stock.setPrice(stockDetails.getPrice());
        stock.setTurnover(stockDetails.getTurnover());
        stock.setCeo(stockDetails.getCeo());
        final Stock updatedStock = stockRepository.save(stock);
        return ResponseEntity.ok(updatedStock);
    }

    @DeleteMapping("/stocks/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String stockId)
            throws ResourcesNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourcesNotFoundException("Stock not found for this id :: " + stockId));

        stockRepository.delete(stock);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

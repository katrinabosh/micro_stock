package ru.test.stock.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.stock.model.StockInfo;

@RestController
@RequestMapping(value = "/api/v1")
public class StockController {

    private StockIntegrator stockIntegrator;

    public StockController(StockIntegrator stockIntegrator) {
        this.stockIntegrator = stockIntegrator;
    }

    @GetMapping(value = "/info/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StockInfo> getStockInfo(@PathVariable("code") String code) {
        var stockInfo = stockIntegrator.getStockInfo(code);
        return stockInfo.isPresent() ? ResponseEntity.ok(stockInfo.get()) : ResponseEntity.notFound().build();
    }

    // mock. for test
    @PostMapping(value = "/info", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void  updateStockInfo(StockInfo stockInfo) {
        stockIntegrator.updateStockInfo(stockInfo);
    }
}

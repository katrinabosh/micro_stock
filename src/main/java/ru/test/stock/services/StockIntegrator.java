package ru.test.stock.services;

import org.springframework.stereotype.Component;
import ru.test.stock.model.StockInfo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Сервис, обращающийся за данными в стороннюю систему
 */
@Component
public class StockIntegrator {

    private Set<StockInfo> stocks = new HashSet<>();

    public Optional<StockInfo> getStockInfo(String code) {
        return stocks.stream()
                .filter(stockInfo -> stockInfo.getStockCode().equals(code))
                .findAny();
    }

    public void updateStockInfo(StockInfo stockInfo) {
        stocks.remove(stockInfo);
        stocks.add(stockInfo);
    }

}

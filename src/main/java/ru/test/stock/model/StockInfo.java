package ru.test.stock.model;

import java.math.BigDecimal;
import java.util.Objects;

public class StockInfo {

    private final String stockCode;
    private final int stockCount;
    private final BigDecimal price;

    public StockInfo(String stockCode, int stockCount, BigDecimal price) {
        this.stockCode = stockCode;
        this.stockCount = stockCount;
        this.price = price;
    }

    public String getStockCode() {
        return stockCode;
    }

    public int getStockCount() {
        return stockCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockInfo stockInfo = (StockInfo) o;
        return stockCode.equals(stockInfo.stockCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockCode);
    }
}

package ru.test.stock.model.command;

import java.math.BigDecimal;
import java.util.UUID;

public class BuyStock {

    private final UUID requestId;
    private final String stockCode;
    private final int stockCount;
    private final BigDecimal price;

    public BuyStock(UUID requestId, String stockCode, int stockCount, BigDecimal price) {
        this.requestId = requestId;
        this.stockCode = stockCode;
        this.stockCount = stockCount;
        this.price = price;
    }

    public UUID getRequestId() {
        return requestId;
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


}

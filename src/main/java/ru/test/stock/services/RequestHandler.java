package ru.test.stock.services;

import org.springframework.stereotype.Component;
import ru.test.stock.model.StockInfo;
import ru.test.stock.model.command.BuyStock;
import ru.test.stock.model.event.StocksBought;
import ru.test.stock.model.event.StocksRequestCanceled;

import java.math.BigDecimal;

@Component
public class RequestHandler {

    private final StockIntegrator stockIntegrator;
    private final EventSender eventSender;

    public RequestHandler(StockIntegrator stockIntegrator, EventSender eventSender) {
        this.stockIntegrator = stockIntegrator;
        this.eventSender = eventSender;
    }

    public void buyStock(BuyStock command) {
        var stock = stockIntegrator.getStockInfo(command.getStockCode());
        if (stock.isEmpty()) {
            eventSender.send(new StocksRequestCanceled(command.getRequestId(),
                    "Бумага " + command.getStockCode() + "не найдена"));
        } else if (stock.get().getPrice().compareTo(command.getPrice()) > 0) {
            eventSender.send(new StocksRequestCanceled(command.getRequestId(),
                    "Цена изменилась до " + stock.get().getPrice().longValue()
                    + ". Допустимый порог для сделки " + command.getPrice().longValue()));
        } else {
            stockIntegrator.updateStockInfo(new StockInfo(stock.get().getStockCode(),
                    stock.get().getStockCount() - command.getStockCount(), stock.get().getPrice()));
            eventSender.send(new StocksBought(command.getRequestId(),
                    // сумма потраченая на покупку
                    stock.get().getPrice().multiply(BigDecimal.valueOf(command.getStockCount()))));
        }
    }
}

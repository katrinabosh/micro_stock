package ru.test.stock.services;

import org.springframework.stereotype.Component;
import ru.test.stock.model.event.StocksBought;
import ru.test.stock.model.event.StocksRequestCanceled;

@Component
public class EventSender {

    public void send(StocksRequestCanceled event) {
        // todo
    }



    public void send(StocksBought event) {
        // todo
    }

}

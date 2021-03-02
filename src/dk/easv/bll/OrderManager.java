package dk.easv.bll;

import java.io.Closeable;
import java.io.IOException;

public class OrderManager implements Closeable {

    private LogManager log = LogManager.getInstance();

    public void placeOrder() {
        log.write("Order placed");
    }

    public void sendInvoice() {
        log.write("Invoice has been sent");
    }

    public void completeOrder() {
        log.write("Order completed");
    }

    @Override
    public void close() {
        log.close();
    }
}

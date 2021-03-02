package dk.easv;

import dk.easv.bll.LabelManager;
import dk.easv.bll.LogManager;
import dk.easv.bll.OrderManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Main {

    private static OrderManager orderManager = new OrderManager();
    private static LabelManager labelManager = new LabelManager();

    public static void main(String[] args) {
        pruneLog();

        orderManager.placeOrder();
        labelManager.printLabel();
        orderManager.sendInvoice();
        orderManager.completeOrder();
        labelManager.scanLabel();

        orderManager.close();
        labelManager.close();

        for(String log : LogManager.read()) {
            System.out.println(log);
        }

        pruneLog();
    }

    private static void pruneLog() {
        try {
            Files.delete(Path.of("my.log"));
        } catch(NoSuchFileException e) {
            // Ignore it - it's already gone
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package dk.easv;

import dk.easv.bll.LabelManager;
import dk.easv.bll.LogManager;
import dk.easv.bll.OrderManager;

public class Main {

    private static OrderManager orderManager = new OrderManager();
    private static LabelManager labelManager = new LabelManager();

    public static void main(String[] args) {
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
    }
}

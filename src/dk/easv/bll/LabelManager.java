package dk.easv.bll;

import java.io.Closeable;
import java.io.IOException;

public class LabelManager implements Closeable {

    private LogManager log = LogManager.getInstance();

    public void printLabel() {
        log.write("Label printed");
    }

    public void scanLabel() {
        log.write("Label scanned");
    }

    @Override
    public void close() {
        log.close();
    }
}

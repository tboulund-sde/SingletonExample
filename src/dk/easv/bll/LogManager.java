package dk.easv.bll;

import dk.easv.models.LogEntry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;

public class LogManager {

    private static LogManager instance;
    private LinkedList<LogEntry> buffer;

    private LogManager() {
        try {
            Files.delete(Path.of("my.log"));
        } catch(NoSuchFileException e) {
            // Ignore it - it's already gone
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer = new LinkedList<>();
    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }

        return instance;
    }

    public void write(String message) {
        buffer.add(new LogEntry(message));
    }

    public void close() {
        flush();
    }

    private void flush() {
        try {
            FileWriter fw = new FileWriter("my.log", true);
            BufferedWriter bw = new BufferedWriter(fw);

            Iterator<LogEntry> iterator = buffer.iterator();
            while (iterator.hasNext()) {
                LogEntry le = buffer.pop();
                bw.write(le.getId() + ") " + le.getMessage());
                bw.newLine();
            }

            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> read() {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of("my.log")));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}

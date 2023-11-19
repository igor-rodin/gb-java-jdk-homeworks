package ru.rodin.gb.jdk.chat.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChatLogger {
    private static final String LOG_FILE = "chat.log";

    public static void saveLog(String message) {
        try {
            Files.writeString(Path.of(LOG_FILE), message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLog() {
        try {
            return Files.readString(Path.of(LOG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

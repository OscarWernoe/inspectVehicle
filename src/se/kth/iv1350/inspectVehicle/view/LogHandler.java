package se.kth.iv1350.inspectVehicle.view;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is responsible for writing to the log.
 */
public class LogHandler {
  private static final String LOG_FILE_NAME = "inspectVehicle-log.txt";
  private final PrintWriter logFile;
  
  public LogHandler() throws IOException {
      logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
  }
  
  /**
   * Writes a log entry for an exception.
   * @param exception The exception to log.
   */
  public void logException(Exception exception) {
      StringBuilder logMsgBuilder = new StringBuilder();
      logMsgBuilder.append(createTime());
      logMsgBuilder.append(", Exception was thrown: ");
      logMsgBuilder.append(exception.getMessage());
      logFile.println(logMsgBuilder);
      exception.printStackTrace(logFile);
  }
  
  private String createTime() {
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.
              ofLocalizedDateTime(FormatStyle.MEDIUM);
      return now.format(formatter);
  }
}

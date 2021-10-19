import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.TreeSet;

public final class Application {

    private final @NotNull LogPrototype consoleLogger, fileLogger;
    private final TreeSet<Integer> indices = new TreeSet<>();
    static int index = 1;

    @Inject
    public Application(@NotNull LogPrototype consoleLogWriter, @NotNull @FileAnnotat LogPrototype fileLogWriter) {
        this.consoleLogger = consoleLogWriter;
        this.fileLogger = fileLogWriter;
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter your string: ");
                String string = scanner.next();

                System.out.print("Enter tag for logging: ");
                String tag = scanner.next();

                System.out.print("""
                        Choose logging method:
                        1 - console logging
                        2 - logging into file
                        3 - composite logging
                        0 - exit
                        """);
                int variant = scanner.nextInt();

                switch (variant) {
                    case 1:
                        consoleLogger.log(index, string, tag);
                        index++;
                        break;
                    case 2:
                        fileLogger.log(index, string, tag);
                        index++;
                        break;
                    case 3:
                        consoleLogger.log(index, string, tag);
                        index++;
                        fileLogger.log(index, string, tag);
                        index++;
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Try again, please.");
                        waitForInput();
                }

            }
        } catch (IllegalStateException exception) {
            exception.printStackTrace();
        }
    }
}

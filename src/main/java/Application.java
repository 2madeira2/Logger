import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public final class Application {

    private final @NotNull LogPrototype consoleLogger, fileLogger;
    static int index = 1;

    @Inject
    public Application(@NotNull LogPrototype consoleLogWriter, @NotNull @FileAnnotat LogPrototype fileLogWriter) {
        this.consoleLogger = consoleLogWriter;
        this.fileLogger = fileLogWriter;
    }

    public void waitForInput(String variant, String tag) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                Thread.sleep(200);
                System.out.print("Enter your string or enter 'exit' to exit the program: ");
                String string = scanner.next();
                if (string.equals("exit")){
                    break;
                }
                else{
                    switch (variant) {
                        case "console":
                            consoleLogger.log(index, string, tag);
                            index++;
                            break;
                        case "file":
                            fileLogger.log(index, string, tag);
                            index++;
                            break;
                        case "composite":
                            consoleLogger.log(index, string, tag);
                            index++;
                            fileLogger.log(index, string, tag);
                            index++;
                            break;
                        default:
                            System.out.println("Try again, please.");
                    }
                }

            }
        } catch (IllegalStateException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

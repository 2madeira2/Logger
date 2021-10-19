import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import java.util.logging.Logger;

public class ConsoleLogger implements LogPrototype {

    @Inject
    private @NotNull Logger logger;

    @Override
    public void log(int index, String inputStr, String tag) {
        String resultStr = index + ". <" + tag + ">" + inputStr +
                "</" + tag + ">";
        logger.info(resultStr);
    }
}

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class FileLogger implements LogPrototype {

    @Inject
    private @NotNull Logger logger;

    private final String filePath = "src/main/java/LogResults.log";
    private final FileHandler fh = new FileHandler(filePath);

    public FileLogger() throws IOException {
    }


    @Override
    public void log(int index, String string, String tag) {

        String resultStr = index + ". <" + tag + ">" + string +
                "</" + tag + ">";
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.setUseParentHandlers(false);
        logger.info(resultStr);
    }
}






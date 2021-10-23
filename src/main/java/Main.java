import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


public class Main {
    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new MyModule());
        String[] valid_methods = {"console", "file", "composite"};
        if(args.length != 2 || !(Arrays.asList(valid_methods).contains(args[0]))){
            System.out.println("Sorry, invalid arguments");
        }
        else {
            injector.getInstance(Application.class).waitForInput(args[0], args[1]);
        }
    }
}

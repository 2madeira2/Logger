import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LogPrototype.class).to(ConsoleLogger.class);
        bind(LogPrototype.class).annotatedWith(FileAnnotat.class).to(FileLogger.class);
    }
}

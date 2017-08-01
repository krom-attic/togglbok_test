import lombok.Toggle;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static lombok.Toggle.ToggleState.OFF;

public class App {
    public App(Map<String, Boolean> toggles) {
        this.toggles = toggles;
    }

    private Map<String, Boolean> toggles;

    @SuppressWarnings("unused")
    public boolean getToggleState(String toggleName) {
        Boolean toggleState = toggles.get(toggleName);
        out.println(String.format("State of %s is %s", toggleName, toggleState));
        return toggleState;
    }

    public void doTheJob() {
        foo();
    }

    @Toggle("hello")
    public void foo() {
        out.println("Hello, World!");
    }

    @Toggle(value = "hello", state=OFF)
    @SuppressWarnings("unused")
    public void bar() {
        out.println("Hello, Kitty!");
    }

    public static void main(String... args) {
        if (args.length != 2)
            throw new RuntimeException("Toggle name and value are required");
        String toggleName = args[0];
        Boolean toggleState = Boolean.valueOf(args[1]);
        HashMap<String, Boolean> toggles = new HashMap<String, Boolean>();
        toggles.put(toggleName, toggleState);
        App app = new App(toggles);
        app.doTheJob();
    }
}

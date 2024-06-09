# Documentation

This file provides general overview of the project. Further information can be found inside the code.

## Structure

All relevant code is inside `src/main/java/ornit/haxtest/client`. `HaxtestClient.java` is the "entry point" for the utility client.

### HaxtestClient.java

The entry point for the client. It:
- defines all keybinds
- calls the modules's run functions according to the pressed keybind
- Draws HUD elements and lines (they are stored in a list) at the end of world render event.
- Stops all modules if world is unloaded (to avoid crashing)

### Utils.java

A utility class that holds a thing or two.
```java
// only kinda relevant field
public static final MinecraftClient MC = MinecraftClient.getInstance();
```

### modules/

Contains all of the hac-- utility mods. Each mod is a class that follow the structure presented in `modules/Template.java`:
```java
package ornit.haxtest.client.modules;

import ornit.haxtest.client.render.RenderUtils;

public class Template {

    public static boolean active = false;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        RenderUtils.setModActive("Template");
        // stuff to do once per tick
    }
}
```

This is a bit bloated to have to include in every class but I'm not good enough at Java to fix it and not bothered enough to care.

## render/

The most complicated and shitty part of the project. I will document this when I am less tired.

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
java/ornit/haxtest/client is where all the good stuff happens.

HaxtestClient.java is the "entry point" for the client. It defines keybinds, does the needed rendering,
and calls the necessary modules.

modules/ contains all the modules (hacks). Each module has three parts:
- Module.active (bool)
- Module.Toggle() (toggles module.active)
- Module.Run() (runs the module, once) (HaxtestClient.java runs Module.Run() each tick if Module.active is true)

render/ contains a bunch of functions for rendering.

For even more info check the code lol
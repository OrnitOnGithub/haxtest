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

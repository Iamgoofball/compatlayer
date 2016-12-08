package mcjty.lib;

public class CompatLayer {

    public static final String VERSION = "0.1.3";
    public static final String OWNER = "McJty", PROVIDES = "compatlayer";

    public static boolean isV10() {
        return false;
    }

    public static boolean isV11() {
        return true;
    }
}

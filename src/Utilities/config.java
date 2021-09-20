package Utilities;
public class config {
    
    public static final String APP_TITLE = "Sorting Algorithm Visualizer";

    public static final int APP_WIDTH = 1280;
    public static final int APP_HEIGHT = APP_WIDTH * 9 / 16;

    public static final int BUTTON_PANEL_WIDTH = config.APP_WIDTH / 5;
    public static final int BUTTON_PANEL_HEIGHT = config.APP_HEIGHT;

    public static final int DISPLAY_PANEL_WIDTH = config.APP_WIDTH * 4 / 5;
    public static final int DISPLAY_PANEL_HEIGHT = config.APP_HEIGHT;

    public static final int MINIMUM_DELAY = 0;
    public static final int MAXIMUM_DELAY = 200;

    public static int currentDelay = MAXIMUM_DELAY / 2;

    public static String[] algorithmStrings = {"Bubble Sort",
                                         "Quick Sort",
                                         "Merge Sort",
                                        };
    
    public static final int MAXIMUM_SIZE = 200;
    public static final int MINIMUM_SIZE = 2;                                    
    public static int SIZE = 100;
}

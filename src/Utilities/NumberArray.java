package Utilities;
public class NumberArray {
    
    public static float BAR_HEIGHT[];
    public static float BAR_WIDTH;

    public static int size = config.SIZE;
    
    public static void initBars(){
        BAR_WIDTH = (float)config.DISPLAY_PANEL_WIDTH / NumberArray.size;
        BAR_HEIGHT = new float[NumberArray.size];
        float interval = (float)config.DISPLAY_PANEL_HEIGHT / NumberArray.size;
        for(int i = 0;i < NumberArray.size;i++){
            BAR_HEIGHT[i] = interval * i;
        }
    }

    public static void setSize(int size){
        NumberArray.size = size;
        initBars(); 
    }

    public static int getSize(){
        return size;
    }

    public static float[] getArray(){
        setSize(size);
        return BAR_HEIGHT;
    }
}

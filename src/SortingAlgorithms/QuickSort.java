package SortingAlgorithms;
import javax.swing.JPanel;

import Utilities.PaintSurface;
import Utilities.config;

public class QuickSort implements SortingAlgorithm{

    public static volatile boolean isPaused = false;
    public int speed = config.currentDelay;
    
    @Override
    public String getName(){
        return "QuickSort";
    }

    @Override
    public void sort(float[] BAR_HEIGHT, JPanel disPanel) throws InterruptedException{
        quicksort(BAR_HEIGHT, 0, BAR_HEIGHT.length - 1, disPanel);
    }

    private void quicksort(float[] arr, int low, int high, JPanel disPanel) throws InterruptedException{
        if(low < high){

            // if(isPaused){
            //     pausedAction();
            // }
            int partitionIndex = partition(arr, low, high, disPanel);
            PaintSurface.pivot = partitionIndex;
            PaintSurface.itr = low;
            PaintSurface.jtr = high;            
            quicksort(arr, low, partitionIndex - 1, disPanel);
            quicksort(arr, partitionIndex + 1, high, disPanel);
            Thread.sleep(getSpeed());
            disPanel.repaint();
        } 
    }

    private int partition(float[] arr, int low, int high, JPanel disPanel) throws InterruptedException{
        float pivot = arr[high];
        int i = low;
        for(int j = low;j < high;j++){
            if(arr[j] <= pivot){
                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                Thread.sleep(getSpeed());
                disPanel.repaint();
            }
        }

        float temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }

    @Override
    public final synchronized void pausedAction(){

    }

    @Override
    public void setCurrSpeed(int speed){

    }

    @Override
    public int getSpeed(){
        return speed;
    }
}

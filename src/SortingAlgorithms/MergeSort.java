package SortingAlgorithms;

import javax.swing.JPanel;

import Utilities.PaintSurface;
import Utilities.config;

public class MergeSort implements SortingAlgorithm{

    public static volatile boolean isPaused = false;
    public int speed = config.currentDelay;

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public void sort(float[] arr, JPanel disPanel) throws Exception {
        mergesort(arr, 0, arr.length - 1, disPanel);        
    }

    private void mergesort(float[] arr, int low, int high, JPanel disPanel) throws InterruptedException{
        if(low < high){
            int mid = low + (high - low) / 2;
            PaintSurface.itr = low;
            PaintSurface.jtr = high;
            PaintSurface.pivot = mid;
            mergesort(arr, low, mid, disPanel);
            mergesort(arr, mid + 1, high, disPanel);
            merge(arr, low, mid, high, disPanel);
            Thread.sleep(getSpeed());
            disPanel.repaint();
        }
    }

    private void merge(float[] arr, int low, int mid, int high, JPanel disPanel) throws InterruptedException{
        float[] temp = new float[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        PaintSurface.itr = low;
        PaintSurface.jtr = high;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
            Thread.sleep(getSpeed());
            disPanel.repaint();
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= high){
            temp[k++] = arr[j++];
        }

        for(i = low;i <= high;i++){
            arr[i] = temp[i - low];
        }
    }

    @Override
    public final synchronized void pausedAction() {        
        
    }

    @Override
    public void setCurrSpeed(int speed) {
        this.speed = speed;        
    }    
    
    @Override
    public int getSpeed(){
        return speed;
    }

}

package SortingAlgorithms;
import javax.swing.JPanel;

import Utilities.NumberArray;
import Utilities.PaintSurface;
import Utilities.config;

public class BubbleSort implements SortingAlgorithm{

    public static volatile boolean isPaused = false;
    public int speed = config.currentDelay;

    @Override
    public String getName(){
        return "Bubble Sort";
    }    

    @Override
    public void sort(float[] BAR_HEIGHT, JPanel disPanel) throws InterruptedException{
        
            for(PaintSurface.itr = 0;PaintSurface.itr < NumberArray.BAR_HEIGHT.length;PaintSurface.itr++){
                for(PaintSurface.jtr = PaintSurface.itr;PaintSurface.jtr < NumberArray.BAR_HEIGHT.length;PaintSurface.jtr++){

                    if(isPaused){
                        pausedAction();
                    }

                    if(NumberArray.BAR_HEIGHT[PaintSurface.itr] > NumberArray.BAR_HEIGHT[PaintSurface.jtr]){
                        float temp = NumberArray.BAR_HEIGHT[PaintSurface.itr];
                        NumberArray.BAR_HEIGHT[PaintSurface.itr] = NumberArray.BAR_HEIGHT[PaintSurface.jtr];
                        NumberArray.BAR_HEIGHT[PaintSurface.jtr] = temp;
                        Thread.sleep(getSpeed());
                        disPanel.repaint();
                    }
                }
            }           
        PaintSurface.itr = 0;
        PaintSurface.jtr = 0;
    }

    @Override
    public final synchronized void pausedAction(){
        while(isPaused) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// interrupts the sleep without crashing the program
				System.out.println("Thread Closed");
			}
		}
    }

    @Override
    public int getSpeed(){
        return speed;
    }

    @Override
    public void setCurrSpeed(int speed){
        this.speed = speed;        
    }
}

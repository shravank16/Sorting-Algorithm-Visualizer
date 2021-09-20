package SortingAlgorithms;
import javax.swing.JPanel;

public abstract interface SortingAlgorithm{

    public String getName();

    public void sort(float[] arr, JPanel disPanel) throws Exception;

    public void pausedAction();

    public void setCurrSpeed(int speed);

    public int getSpeed();
}
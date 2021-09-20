package Utilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SortingAlgorithm;

public class PaintSurface extends JPanel{
    
    //private static float BAR_HEIGHT[] = NumberArray.getArray();

    private static SwingWorker<Void, Void> shuffler;
    private static SwingWorker<Void, Void> sorter;

    public static boolean shuffle = false;
    public boolean isShufflerDone = false;
    public boolean isSorting = false;

    public int speed = config.currentDelay;

    public static int itr = 0;
    public static int jtr = 0;
    public static int pivot = 0;

    public static SortingAlgorithm algorithm;

    public PaintSurface(){
        this.setPreferredSize(new Dimension(config.DISPLAY_PANEL_WIDTH, config.DISPLAY_PANEL_HEIGHT));
        this.setBackground(Color.BLACK);        
    }      

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.green);
        Rectangle2D.Float bar;
        
        for(int i = 0;i < NumberArray.getSize();i++){
            bar = new Rectangle2D.Float(i * NumberArray.BAR_WIDTH, config.DISPLAY_PANEL_HEIGHT - NumberArray.BAR_HEIGHT[i], NumberArray.BAR_WIDTH, NumberArray.BAR_HEIGHT[i]);
            g2d.draw(bar);
        }


        //Points the ith bar of the numbers.
        g2d.setColor(Color.RED);
        bar = new Rectangle2D.Float(itr * NumberArray.BAR_WIDTH, config.DISPLAY_PANEL_HEIGHT - NumberArray.BAR_HEIGHT[itr], NumberArray.BAR_WIDTH, NumberArray.BAR_HEIGHT[itr]);
        g2d.fill(bar); 
        
        //Points the jth bar of the numbers.
        g2d.setColor(Color.ORANGE);
        bar = new Rectangle2D.Float(jtr * NumberArray.BAR_WIDTH, config.DISPLAY_PANEL_HEIGHT - NumberArray.BAR_HEIGHT[jtr], NumberArray.BAR_WIDTH, NumberArray.BAR_HEIGHT[jtr]);
        g2d.fill(bar);

        //Points the pivot bar for Quicksort.
        g2d.setColor(Color.PINK);
        bar = new Rectangle2D.Float(pivot * NumberArray.BAR_WIDTH, config.DISPLAY_PANEL_HEIGHT - NumberArray.BAR_HEIGHT[pivot], NumberArray.BAR_WIDTH, NumberArray.BAR_HEIGHT[pivot]);
        g2d.fill(bar);
    }   

    public void initSorter(JPanel displayPanel, String selectedAlgorithm){
        sorter = new SwingWorker<>(){
            @Override
            public Void doInBackground() throws InterruptedException{
                //Testing bubble sort algorithm for now later add the interface
                //implementation for all different sorts of algorithms.
                switch(selectedAlgorithm){
                    case "Bubble Sort" :
                        algorithm = new BubbleSort();
                        break;
                    case "Quick Sort" :
                        algorithm = new QuickSort();
                        break;
                    case "Merge Sort" : 
                        algorithm = new MergeSort();
                        break;
                }                
                try{
                    if(algorithm != null){
                        algorithm.sort(NumberArray.BAR_HEIGHT, displayPanel);
                    }                    
                }catch(Exception e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void done(){
                isSorting = false;
            }
        };
        sorter.execute();
    }

    public void initshuffler(){
        shuffler = new SwingWorker<>(){

            @Override
            public Void doInBackground() throws InterruptedException{
                
                int size = NumberArray.getSize();
                int middle = size / 2;
                for(int i = 0, j = middle;i < middle;i++,j++){
                    int randomIndex = new Random().nextInt(size);
                    swap(i, randomIndex);
                    randomIndex = new Random().nextInt(size);
                    swap(j, randomIndex);

                    Thread.sleep(30);
                    repaint();
                }
                return null;
            }

            @Override
            public void done(){
                isShufflerDone = true;
            }
        };
        shuffler.execute();
    }   

    private static void swap(int i, int j){
        float temp = NumberArray.BAR_HEIGHT[i];
        NumberArray.BAR_HEIGHT[i] = NumberArray.BAR_HEIGHT[j];
        NumberArray.BAR_HEIGHT[j] = temp;
    }

    public void setSpeed(int currSpeed){
        algorithm.setCurrSpeed(currSpeed);
    }
}

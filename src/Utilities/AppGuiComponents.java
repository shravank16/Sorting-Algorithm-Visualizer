package Utilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import SortingAlgorithms.BubbleSort;

import java.awt.event.ActionEvent;

public class AppGuiComponents {
    
    public static JPanel buttonPanel, displayPanel;

    private static JButton menuButton;
    private static JButton randomizeArrayButtom;
    private static JButton sortButton;
    private static JButton pauseButton;

    private static JSlider delaySlider;
    private static JSlider sizeSlider;

    private static JComboBox<String> allSortsComboBox;

    private static JLabel titleLabel = new JLabel("Sorting Algorithm Visualizer ");
    private static JLabel sortingDelayLabel = new JLabel("Speed ");
    private static JLabel arraySizeLabel = new JLabel("Array Size ");

    public static int size = config.SIZE;

    public static boolean shuffle = false;
    public static PaintSurface ps;

    static{
        initButtonPanel();
        NumberArray.initBars();
        ps = new PaintSurface();
        displayPanel = ps;
    }

    public static void initButtonPanel(){
        buttonPanel = new JPanel();

        buttonPanel.setPreferredSize(new Dimension(config.BUTTON_PANEL_WIDTH, config.BUTTON_PANEL_HEIGHT));
        buttonPanel.setBackground(Color.DARK_GRAY);

        initMenuButton();
        initRandomizeArrayButton();
        initDelaySlider();
        initSizeSlider();
        initSortButton();
        initPauseButton();
        initSortComboBox();

        titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        titleLabel.setForeground(Color.GREEN);
        buttonPanel.add(titleLabel);

        sortingDelayLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        sortingDelayLabel.setForeground(Color.GREEN);
        buttonPanel.add(sortingDelayLabel);
        buttonPanel.add(delaySlider);

        arraySizeLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        arraySizeLabel.setForeground(Color.GREEN);
        buttonPanel.add(arraySizeLabel);
        buttonPanel.add(sizeSlider);

        buttonPanel.add(randomizeArrayButtom);

        buttonPanel.add(sortButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(allSortsComboBox);

        buttonPanel.add(menuButton);

        randomizeArrayButtom.setVisible(false);
        delaySlider.setVisible(false);
        sizeSlider.setVisible(false);
        sortButton.setVisible(false);
        pauseButton.setVisible(false);
        allSortsComboBox.setVisible(false);
        sortingDelayLabel.setVisible(false);
        arraySizeLabel.setVisible(false);
    }

    public static void initSortComboBox(){
        allSortsComboBox = new JComboBox<String>(config.algorithmStrings);
    }

    public static void initMenuButton(){
        menuButton = new JButton("Menu");
        menuButton.setPreferredSize(new Dimension(200, 50));
        menuButton.addActionListener((ActionEvent e) -> {
            if(menuButton.getText().equals("Menu")){
                randomizeArrayButtom.setVisible(true);
                delaySlider.setVisible(true);
                sizeSlider.setVisible(true);
                sortButton.setVisible(true);
                pauseButton.setVisible(true);
                allSortsComboBox.setVisible(true);
                sortingDelayLabel.setVisible(true);
                arraySizeLabel.setVisible(true);
                menuButton.setText("Hide Menu");
            }else if(menuButton.getText().equals("Hide Menu")){
                randomizeArrayButtom.setVisible(false);
                delaySlider.setVisible(false);
                sizeSlider.setVisible(false);
                sortButton.setVisible(false);
                pauseButton.setVisible(false);
                allSortsComboBox.setVisible(false);
                sortingDelayLabel.setVisible(false);
                arraySizeLabel.setVisible(false);
                menuButton.setText("Menu");
            }   
            
        });
    }

    public static void initRandomizeArrayButton(){
        randomizeArrayButtom = new JButton("Shuffle");

        randomizeArrayButtom.addActionListener((ActionEvent e) -> {
            ps.initshuffler();
        });
    }

    public static void initDelaySlider(){
        delaySlider = new JSlider(JSlider.HORIZONTAL, config.MINIMUM_DELAY, config.MAXIMUM_DELAY, config.currentDelay);
        
        delaySlider.addChangeListener((ChangeEvent e) -> {
            if(ps.isSorting){
                int currSpeed = delaySlider.getValue();
                ps.setSpeed(currSpeed);
            }            
        });
    }

    public static void initSizeSlider(){
        sizeSlider = new JSlider(JSlider.HORIZONTAL, config.MINIMUM_SIZE, config.MAXIMUM_SIZE, size);

        sizeSlider.addChangeListener((ChangeEvent e) -> {
            if(!ps.isSorting){
                size = sizeSlider.getValue();
                NumberArray.setSize(size);
                displayPanel.repaint();
            }            
        });
    }
    
    public static void initSortButton(){
        sortButton = new JButton("Sort");
        sortButton.addActionListener((ActionEvent e) -> {
            if(ps.isShufflerDone){
                ps.isSorting = true;
                ps.initSorter(displayPanel, (String)allSortsComboBox.getSelectedItem());
            }
        });
    }

    public static void initPauseButton(){
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener((ActionEvent e) -> {
            if(pauseButton.getText().equals("Pause")){
                SortingAlgorithms.BubbleSort.isPaused = true;
                pauseButton.setText("Resume");
            }else if(pauseButton.getText().equals("Resume")){
                BubbleSort.isPaused = false;
                pauseButton.setText("Pause");
            }
            
        });
    }
}

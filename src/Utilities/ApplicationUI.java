package Utilities;
import javax.swing.JFrame;

import java.awt.FlowLayout;

public class ApplicationUI {
    
    public ApplicationUI(){
        initGui();
    }

    public void initGui(){

        JFrame window = new JFrame();

        //Setting up the Button panel and Display panel.
        window.getContentPane().setLayout(new FlowLayout());
        window.getContentPane().add(AppGuiComponents.buttonPanel);
        window.getContentPane().add(AppGuiComponents.displayPanel);

        //Setting up the JFRAME.
        window.setTitle(config.APP_TITLE);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

}

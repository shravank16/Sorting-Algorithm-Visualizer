package Main;
import javax.swing.SwingUtilities;

import Utilities.ApplicationUI;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(ApplicationUI::new);
    }
}

package main;

import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(() -> {
            new LogInWindow().setVisible(true);
        });
    }

}

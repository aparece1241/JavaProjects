
import javax.swing.*;
public class ReadInput {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Please enter your name: ");
        String surname = JOptionPane.showInputDialog("Please enter your surname: ");

        JOptionPane.showMessageDialog(null, name + " "+ surname);

    }
}

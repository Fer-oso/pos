package utils.ux;

import javax.swing.JOptionPane;

public class FormValidatonInputsMessage {

    private FormValidatonInputsMessage() {
    }

    public static void validationInputMessage() {

        JOptionPane.showMessageDialog(null, "All fields required");
    }

    public static void searchValidationInputMessage() {

        JOptionPane.showMessageDialog(null, "Input search value");
    }

}

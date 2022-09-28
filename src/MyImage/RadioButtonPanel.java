package MyImage;

import javax.swing.*;
import java.awt.*;

public class RadioButtonPanel extends JPanel {
    public String[] buttonText = {"사과", "배", "체리", "포도"};

    public JRadioButton[] jRadioButtons = new JRadioButton[buttonText.length];

    public RadioButtonPanel(Gallery gallery) {
        this.setBackground(Color.GRAY);

        ButtonGroup buttonGroup = new ButtonGroup(); //RadioButton Grouping

        for (int i = 0; i < buttonText.length; i++) {
            jRadioButtons[i] = new JRadioButton(buttonText[i]);
            this.add(jRadioButtons[i]);
            buttonGroup.add(jRadioButtons[i]);
        }
    }
}

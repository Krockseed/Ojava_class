package MyImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ContentPanel extends JPanel implements ItemListener {
    ImageIcon[] imageIcons = {
            new ImageIcon("Object_img/apple.png"),
            new ImageIcon("Object_img/pear.jpg"),
            new ImageIcon("Object_img/cherry.png"),
            new ImageIcon("Object_img/grape.jpg") };
    public JLabel jLabel = new JLabel(imageIcons[0]); // default apple
    public JRadioButton[] jRadioButtons; // gallery.RadioButtonPanel.jRadioButtons 배열 받아옴

    public ContentPanel(Gallery gallery) {
        this.setBackground(Color.GREEN);

        this.add(jLabel);

        jRadioButtons = gallery.radioButtonPanel.jRadioButtons;

        jRadioButtons[0].setSelected(true);

        for (int i = 0; i < jRadioButtons.length; i++) {
            jRadioButtons[i].addItemListener(this);
        }
    }

    //grouping 되어있는 상태에서 변한다면
    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < jRadioButtons.length; i++) {
            if (jRadioButtons[i].isSelected()) {
                jLabel.setIcon(imageIcons[i]);
            }
        }
    }
}

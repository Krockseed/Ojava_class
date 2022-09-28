package MyCalc_Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextPanel extends JPanel implements ActionListener {
    String[] labelStr = {"원금 입력", "이율 입력"};
    String[] btnStr = {"변환", "리셋"};
    int[] textFieldSize = {5, 5, 7};

    public JLabel[] labels = new JLabel[labelStr.length];
    public JButton[] buttons = new JButton[btnStr.length];
    public JTextField[] jTextFields = new JTextField[textFieldSize.length];

    public TextPanel(Calc calc) {
        for (int i = 0; i < labels.length; i++)
            labels[i] = new JLabel(labelStr[i]);
        for (int i = 0; i < buttons.length; i++)
            buttons[i] = new JButton(btnStr[i]);
        for (int i = 0; i < jTextFields.length; i++)
            jTextFields[i] = new JTextField(textFieldSize[i]);

        this.setLayout(new FlowLayout());
        this.add(labels[0]);
        this.add(jTextFields[0]);

        this.add(labels[1]);
        this.add(jTextFields[1]);
        this.add(buttons[0]);
        this.add(jTextFields[2]);
        this.add(buttons[1]);

        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            double res = Double.parseDouble(jTextFields[0].getText())
                    * Double.parseDouble(jTextFields[1].getText());
            jTextFields[2].setText(String.valueOf(res));
        }
        if (e.getSource() == buttons[1]) {
            for (int i = 0; i < jTextFields.length; i++)
                jTextFields[i].setText("");
        }
    }
}

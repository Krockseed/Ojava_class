package MyCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ButtonPanel extends JPanel implements ActionListener, FocusListener {
    String[] keyPadText = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."};
    JButton[] keyPadBtn = new JButton[keyPadText.length];
    int flag = 0;

    public Calc calc;

    public ButtonPanel(Calc calc) {
        this.calc = calc;

        this.setLayout(new GridLayout(4, 4));

        //insert btn
        for (int i = 0; i < keyPadText.length; i++) {
            keyPadBtn[i] = new JButton(keyPadText[i]);
            this.add(keyPadBtn[i]);
            keyPadBtn[i].addActionListener(this);
        }

        calc.jTextFields[0].addFocusListener(this);
        calc.jTextFields[1].addFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < keyPadText.length; i++) {
            if (e.getSource() == keyPadBtn[i]) {
                calc.jTextFields[flag].setText(calc.jTextFields[flag].getText() + keyPadText[i]);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == calc.jTextFields[0]) flag = 0;
        else flag = 1;
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}

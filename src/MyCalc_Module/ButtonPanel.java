package MyCalc_Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ButtonPanel extends JPanel implements ActionListener, FocusListener {
    String[] keyPadText = {"1","2","3","4","5","6","7","8","9","0","."};
    JButton[] keyPadBtn = new JButton[keyPadText.length];
    int jTextFieldSwitch = 0;

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

        calc.textPanel.jTextFields[0].addFocusListener(this);
        calc.textPanel.jTextFields[1].addFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < keyPadText.length; i++) {
            if (e.getSource() == keyPadBtn[i]) {
                calc.textPanel.jTextFields[jTextFieldSwitch].setText(
                        calc.textPanel.jTextFields[jTextFieldSwitch].getText() + keyPadText[i]);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        jTextFieldSwitch = (e.getSource() == calc.textPanel.jTextFields[0]) ? 0 : 1;
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}

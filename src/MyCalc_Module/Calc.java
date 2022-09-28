package MyCalc_Module;

import javax.swing.*;
import java.awt.*;

public class Calc extends JFrame {
    TextPanel textPanel;
    ButtonPanel buttonPanel;
    public Calc() {
        this.setSize(550, 200);
        this.setTitle("myCalc");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textPanel = new TextPanel(this);
        buttonPanel = new ButtonPanel(this);

        this.add(textPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}

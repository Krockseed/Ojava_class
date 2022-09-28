package MyImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FooterPanel extends JPanel implements ActionListener {
    String[] btnText = {"Previous", "Next"};
    public JButton[] jButtons = new JButton[btnText.length];
    public static int imgNumber = 0;
    public ContentPanel contentPanel;

    public FooterPanel(Gallery gallery) {
        this.setBackground(Color.cyan);

        this.contentPanel = gallery.contentPanel;

        for (int i = 0; i < btnText.length; i++) {
            jButtons[i] = new JButton(btnText[i]);
            this.add(jButtons[i]);
            jButtons[i].addActionListener(this);
        }
    }

    //e.getActionCommand 버튼 안에 있는 String 리턴
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Previous")) {

        }
        if (e.getActionCommand().equals("Next")) {
            ++imgNumber;
            contentPanel.jRadioButtons[imgNumber].setSelected(true);
            contentPanel.jLabel.setIcon(contentPanel.imageIcons[imgNumber]);
        }
    }
}

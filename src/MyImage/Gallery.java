package MyImage;

import javax.swing.*;
import java.awt.*;

public class Gallery extends JFrame {
    RadioButtonPanel radioButtonPanel;
    ContentPanel contentPanel;
    FooterPanel footerPanel;

    public Gallery() {
        this.setSize(300, 450);
        this.setTitle("MyGallery");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.setLocation(100, 100);
        radioButtonPanel = new RadioButtonPanel(this);
        contentPanel = new ContentPanel(this);
        footerPanel = new FooterPanel(this);

        this.add(radioButtonPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}

package MyCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame implements ActionListener {
    // 라벨, 버튼, 텍스트필드에 들어가는 글, 크기
    String[] labelStr = {"원금 입력", "이율 입력"};
    String[] btnStr = {"변환", "리셋"};
    int[] textFieldSize = {5, 5, 7};
    //

    //라벨, 버튼, 텍스트필드 생성
    public JLabel[] labels = new JLabel[labelStr.length];
    public JButton[] buttons = new JButton[btnStr.length];
    public JTextField[] jTextFields = new JTextField[textFieldSize.length];

    JPanel[] panels = new JPanel[2]; //라벨, 버튼, 텍스트필드 부분 / 버튼부분 0~9 .
    public Calc() {
        this.setSize(550, 200);
        this.setTitle("myCalc");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //패널 생성
        for (int i = 0; i < panels.length; ++i) {
            panels[i] = new JPanel();
        }
        //첫번째 패널 만드는 과정.
        for (int i = 0; i < labels.length; i++)
            labels[i] = new JLabel(labelStr[i]);
        for (int i = 0; i < buttons.length; i++)
            buttons[i] = new JButton(btnStr[i]);
        for (int i = 0; i < jTextFields.length; i++)
            jTextFields[i] = new JTextField(textFieldSize[i]);

        //component insert
        panels[0].setLayout(new FlowLayout());
        panels[0].add(labels[0]);
        panels[0].add(jTextFields[0]);

        panels[0].add(labels[1]);
        panels[0].add(jTextFields[1]);
        panels[0].add(buttons[0]);
        panels[0].add(jTextFields[2]);
        panels[0].add(buttons[1]);
        //

        //두번째 패널 생성
        panels[1] = new ButtonPanel(this);

        this.add(panels[0], BorderLayout.NORTH);
        this.add(panels[1], BorderLayout.CENTER);

        //Frame 다 만들고 채워넣기.

        //add eventListener
        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);

        this.setVisible(true);
    }

    //override 위에 있는 함수를 재정의 한다.
    //double
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) { //convert
            double res = Double.parseDouble(jTextFields[0].getText())
                    * Double.parseDouble(jTextFields[1].getText());
            //jTextFields[2].setText("" + res); or
            jTextFields[2].setText(String.valueOf(res));
        }
        if (e.getSource() == buttons[1]) { //reset
            for (int i = 0; i < jTextFields.length; i++)
                jTextFields[i].setText("");
        }
    }
}

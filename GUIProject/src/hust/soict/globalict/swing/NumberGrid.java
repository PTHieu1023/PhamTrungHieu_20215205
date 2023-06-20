package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {
    private JButton[] btnNumber = new JButton[10];
    private JButton btnDel, btnRes;
    private JTextField display;

    public NumberGrid() {
        display = new JTextField(10);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panel = new JPanel(new GridLayout(4, 3));
        addButtons(panel);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(display, BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panel) {
        ButtonListener btnListener = new ButtonListener();

        for(int i = 1; i < 10; i++) {
            btnNumber[i] = new JButton("" + i);
            panel.add(btnNumber[i]);
            btnNumber[i].addActionListener(btnListener);
        }

        btnDel = new JButton("DEL");
        panel.add(btnDel);
        btnDel.addActionListener(btnListener);

        btnNumber[0] = new JButton("" + 0);
        panel.add(btnNumber[0]);
        btnNumber[0].addActionListener(btnListener);

        btnRes = new JButton("C");
        panel.add(btnRes);
        btnRes.addActionListener(btnListener);
        
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btn  = e.getActionCommand();
            if(btn.charAt(0) >= '0' && btn.charAt(0) <= '9') {
                display.setText(display.getText() + btn);
            }
            else if(btn.equals("DEL")){
                String str = display.getText().substring(0, display.getText().length()- 1);
                display.setText(str);
            }
            else {
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
    
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends JFrame {
    private JTextField tfInput, tfSecondInput, tfSumOutput;
    private JButton[] digits;
    private JLabel label;
    private JButton[] actions;
    private List<String> numbers;
    private boolean countingUp = true;
    private boolean checkSum = false;


    public Calculator() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }  catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


        // Input of Digits;
        JPanel input = new JPanel();
        input.setBackground(Color.orange);
        input.setLayout(new FlowLayout());
        label = new JLabel("Memory");
        input.add(label);
        tfInput = new JTextField(10);
        tfSecondInput = new JTextField(10);
        tfSumOutput = new JTextField(10);

        JRadioButton rbUp = new JRadioButton("Up", true);
        rbUp.setBackground(Color.ORANGE);
        rbUp.setMnemonic(KeyEvent.VK_U);
        rbUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countingUp = true;
            }
        });

        JRadioButton rbDown = new JRadioButton("Down", true);
        rbDown.setBackground(Color.orange);
        rbDown.setMnemonic(KeyEvent.VK_D);
        rbDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countingUp = false;
            }
        });
        JRadioButton sum = new JRadioButton("Sum", true);
        sum.setBackground(Color.ORANGE);
        rbDown.setMnemonic(KeyEvent.VK_S);
        rbDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSum = true;
            }
        });
        tfInput.setEditable(false);
        tfSecondInput.setEditable(false);
        tfSumOutput.setEditable(false);
        input.add(rbUp);
        input.add(tfInput);
        input.add(rbDown);
        input.add(tfSecondInput);
        input.add(sum);
        input.add(tfSumOutput);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbUp);
        buttonGroup.add(rbDown);
        buttonGroup.add(sum);


        // digits and panels for that digit

        JPanel panelOfDigits = new JPanel();
        panelOfDigits.setLayout(new GridLayout(4, 5));
        digits = new JButton[12];
        actions = new JButton[8];

        digits[1] = new JButton("7");
        digits[1].setBackground(Color.BLACK);
        digits[1].setForeground(Color.blue);
        panelOfDigits.add(digits[1]);
        digits[2] = new JButton("8");
        digits[2].setForeground(Color.blue);
        digits[2].setBackground(Color.BLACK);
        panelOfDigits.add(digits[2]);
        digits[3] = new JButton("9");
        digits[3].setForeground(Color.blue);
        digits[3].setBackground(Color.BLACK);
        panelOfDigits.add(digits[3]);
        actions[0] = new JButton("*");
        actions[0].setForeground(Color.RED);
        actions[0].setBackground(Color.BLACK);
        panelOfDigits.add(actions[0]);
        actions[1] = new JButton("C");
        actions[1].setForeground(Color.RED);
        actions[1].setBackground(Color.BLACK);
        panelOfDigits.add(actions[1]);
        digits[4] = new JButton("4");
        digits[4].setForeground(Color.blue);
        digits[4].setBackground(Color.BLACK);
        panelOfDigits.add(digits[4]);
        digits[5] = new JButton("5");
        digits[5].setForeground(Color.blue);
        digits[5].setBackground(Color.BLACK);
        panelOfDigits.add(digits[5]);
        digits[6] = new JButton("6");
        digits[6].setForeground(Color.blue);
        digits[6].setBackground(Color.BLACK);
        panelOfDigits.add(digits[6]);
        actions[2] = new JButton("-");
        actions[2].setForeground(Color.RED);
        actions[2].setBackground(Color.BLACK);
        panelOfDigits.add(actions[2]);
        actions[3] = new JButton("%");
        actions[3].setBackground(Color.BLACK);
        actions[3].setForeground(Color.RED);
        panelOfDigits.add(actions[3]);
        digits[7] = new JButton("1");
        digits[7].setForeground(Color.blue);
        digits[7].setBackground(Color.BLACK);
        panelOfDigits.add(digits[7]);
        digits[8] = new JButton("2");
        digits[8].setForeground(Color.blue);
        digits[8].setBackground(Color.BLACK);
        panelOfDigits.add(digits[8]);
        digits[9] = new JButton("3");
        digits[9].setForeground(Color.blue);
        digits[9].setBackground(Color.BLACK);
        panelOfDigits.add(digits[9]);
        actions[4] = new JButton("+");
        actions[4].setForeground(Color.RED);
        actions[4].setBackground(Color.BLACK);
        panelOfDigits.add(actions[4]);
        actions[5] = new JButton("Del");
        actions[5].setForeground(Color.RED);
        actions[5].setBackground(Color.BLACK);
        panelOfDigits.add(actions[5]);
        digits[10] = new JButton("-");
        digits[10].setForeground(Color.blue);
        digits[10].setBackground(Color.BLACK);
        panelOfDigits.add(digits[10]);
        digits[11] = new JButton("0");
        digits[11].setForeground(Color.blue);
        digits[11].setBackground(Color.BLACK);
        panelOfDigits.add(digits[11]);
        digits[0] = new JButton(".");
        digits[0].setForeground(Color.blue);
        digits[0].setBackground(Color.BLACK);
        panelOfDigits.add(digits[0]);
        actions[6] = new JButton("=");
        actions[6].setForeground(Color.RED);
        actions[6].setBackground(Color.BLACK);
        panelOfDigits.add(actions[6]);
        actions[7] = new JButton("/");
        actions[7].setForeground(Color.RED);
        actions[7].setBackground(Color.BLACK);
        panelOfDigits.add(actions[7]);


        container.add(input, BorderLayout.NORTH);
        container.add(panelOfDigits, BorderLayout.CENTER);

        Digits digitsCalculation = new Digits();
        for (int i = 0; i < digits.length; i++) {
            digits[i].addActionListener(digitsCalculation);
        }


        Actions act = new Actions();
        for (int i = 0; i < actions.length; i++) {
            actions[i].addActionListener(act);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Calculator");
        setSize(650, 200);
        setResizable(false);
        setVisible(true);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Calculator();
                    }
                });
            }
        });
    }


    private class Digits implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pressed = e.getActionCommand();
            StringBuilder num = new StringBuilder();
            StringBuilder secondNum = new StringBuilder();
            if (countingUp) {
                if (pressed == "7") {
                    num.append(tfInput.getText()).append(7);
                } else if (pressed == "8") {
                    num.append(tfInput.getText()).append(8);
                } else if (pressed == "9") {
                    num.append(tfInput.getText()).append(9);
                } else if (pressed == "4") {
                    num.append(tfInput.getText()).append(4);
                } else if (pressed == "5") {
                    num.append(tfInput.getText()).append(5);
                } else if (pressed == "6") {
                    num.append(tfInput.getText()).append(6);
                } else if (pressed == "1") {
                    num.append(tfInput.getText()).append(1);
                } else if (pressed == "2") {
                    num.append(tfInput.getText()).append(2);
                } else if (pressed == "3") {
                    num.append(tfInput.getText()).append(3);
                } else if (pressed == "-") {
                    num.insert(0, "-");
                } else if (pressed == "0") {
                    num.append(tfInput.getText()).append(0);
                } else {
                    num.append(tfInput.getText()).append(".");
                }
                tfInput.setText(num + "");
            } else {
                if (pressed == "7") {
                    secondNum.append(tfSecondInput.getText()).append(7);
                } else if (pressed == "8") {
                    secondNum.append(tfSecondInput.getText()).append(8);
                } else if (pressed == "9") {
                    secondNum.append(tfSecondInput.getText()).append(9);
                } else if (pressed == "4") {
                    secondNum.append(tfSecondInput.getText()).append(4);
                } else if (pressed == "5") {
                    secondNum.append(tfSecondInput.getText()).append(5);
                } else if (pressed == "6") {
                    secondNum.append(tfSecondInput.getText()).append(6);
                } else if (pressed == "1") {
                    secondNum.append(tfSecondInput.getText()).append(1);
                } else if (pressed == "2") {
                    secondNum.append(tfSecondInput.getText()).append(2);
                } else if (pressed == "3") {
                    secondNum.append(tfSecondInput.getText()).append(3);
                } else if (pressed == "-") {
                    secondNum.insert(0, "-");
                } else if (pressed == "0") {
                    secondNum.append(tfSecondInput.getText()).append(0);
                } else {
                    secondNum.append(tfSecondInput.getText()).append(".");
                }
                tfSecondInput.setText(secondNum + "");
            }
        }
    }


    private class Actions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String press = e.getActionCommand();
            StringBuilder sb = new StringBuilder(tfInput.getText());
            StringBuilder bs = new StringBuilder(tfSecondInput.getText());
            StringBuilder bb = new StringBuilder(tfSumOutput.getText());
            if(press == "C"){
                if(countingUp || checkSum) {
                    sb = new StringBuilder("");
                    bs = new StringBuilder("");
                    bb = new StringBuilder("");
                }
            } else if(press == "Del"){
                if(countingUp){
                    sb.deleteCharAt(sb.length()-1);
                } else{
                    bs.deleteCharAt(bs.length()-1);
                }
            } else if(press == "+"){
                if(checkSum){
                    if(tfInput.getText().contains(".")){
                        double first = parseDouble(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first + second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else {
                            int second = parseInt(tfSecondInput.getText());
                            double sum = first + second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    } else{
                        int first = parseInt(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first + second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else{
                            int second = parseInt(tfSecondInput.getText());
                            int sum = first + second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    }
                }
            } else if(press == "-"){
                if(checkSum){
                    if(tfInput.getText().contains(".")){
                        double first = parseDouble(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first - second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else {
                            int second = parseInt(tfSecondInput.getText());
                            double sum = first - second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    } else{
                        int first = parseInt(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first - second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else{
                            int second = parseInt(tfSecondInput.getText());
                            int sum = first - second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    }

                }
            } else if(press == "*"){
                if(checkSum){
                    if(tfInput.getText().contains(".")){
                        double first = parseDouble(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first * second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else {
                            int second = parseInt(tfSecondInput.getText());
                            double sum = first * second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    } else{
                        int first = parseInt(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first * second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else{
                            int second = parseInt(tfSecondInput.getText());
                            int sum = first * second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    }
                }
            } else if(press == "/"){
                if(checkSum){
                    if(tfInput.getText().contains(".")){
                        double first = parseDouble(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first / second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else {
                            int second = parseInt(tfSecondInput.getText());
                            double sum = first / second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    } else{
                        int first = parseInt(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first / second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else{
                            int second = parseInt(tfSecondInput.getText());
                            int sum = first / second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    }
                }
            } else if(press == "%"){
                if(checkSum){
                    if(tfInput.getText().contains(".")){
                        double first = parseDouble(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first % second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else {
                            int second = parseInt(tfSecondInput.getText());
                            double sum = first % second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    } else{
                        int first = parseInt(tfInput.getText());
                        if(tfSecondInput.getText().contains(".")){
                            double second = parseDouble(tfSecondInput.getText());
                            double sum = first % second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        } else{
                            int second = parseInt(tfSecondInput.getText());
                            int sum = first % second;
                            sb = new StringBuilder(sum + "");
                            bs = new StringBuilder("");
                        }
                    }
                }
            } else{
                if(checkSum){
                    bb = new StringBuilder(tfInput.getText());
                    sb = new StringBuilder("");
                    bs = new StringBuilder("");
                }
            }
                tfInput.setText(sb + "");
                tfSecondInput.setText(bs + "");
                tfSumOutput.setText(bb + "");
            }

            private Integer parseInt (String str){
                return Integer.parseInt(str);
            }
            private Double parseDouble (String str){
                return Double.parseDouble(str);
            }
        }
    }



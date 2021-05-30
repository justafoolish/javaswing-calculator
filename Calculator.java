package chuong5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame implements ActionListener {
    private JTextField display;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, clrBtn, mulBtn, sumBtn, decBtn, subBtn, resBtn, pBtn,cvBtn, ptBtn;
    private JPanel displayPanel, btnP1, btnP2, btnP3, btnP4, btnP5, Panel0;
    private Container con;
    private double num1 = 0, num2 = 0;
    private boolean newCycle = false;
    private String operator = "";

    public Calc (String s) {
        super(s);

        Panel0 = new JPanel();
        Panel0.setLayout(new GridLayout(6,1));

        con = getContentPane();
        con.add(Panel0);

        displayPanel = new JPanel();
        display = new JTextField(15);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("SansSerif", Font.BOLD, 20));
        display.setEditable(false);
        displayPanel.add(display);


        btnP1 = new JPanel();
        btnP1.setLayout(new GridLayout(1,4));

        btn7 = new JButton("7");
        btn7.setForeground(Color.MAGENTA);
        btn7.addActionListener(this);
        btn8 = new JButton("8");
        btn8.setForeground(Color.MAGENTA);
        btn8.addActionListener(this);
        btn9 = new JButton("9");
        btn9.setForeground(Color.MAGENTA);
        btn9.addActionListener(this);
        mulBtn = new JButton("x");
        mulBtn.setForeground(Color.red);
        mulBtn.addActionListener(this);

        btnP1.add(btn7);
        btnP1.add(btn8);
        btnP1.add(btn9);
        btnP1.add(mulBtn);


        btnP2 = new JPanel();
        btnP2.setLayout(btnP1.getLayout());

        btn4 = new JButton("4");
        btn4.setForeground(Color.MAGENTA);
        btn4.addActionListener(this);
        btn5 = new JButton("5");
        btn5.setForeground(Color.MAGENTA);
        btn5.addActionListener(this);
        btn6 = new JButton("6");
        btn6.setForeground(Color.MAGENTA);
        btn6.addActionListener(this);
        subBtn = new JButton("-");
        subBtn.setForeground(Color.red);
        subBtn.addActionListener(this);

        btnP2.add(btn4);
        btnP2.add(btn5);
        btnP2.add(btn6);
        btnP2.add(subBtn);

        btnP3 = new JPanel();
        btnP3.setLayout(btnP1.getLayout());

        btn1 = new JButton("1");
        btn1.setForeground(Color.MAGENTA);
        btn1.addActionListener(this);
        btn2 = new JButton("2");
        btn2.setForeground(Color.MAGENTA);
        btn2.addActionListener(this);
        btn3 = new JButton("3");
        btn3.setForeground(Color.MAGENTA);
        btn3.addActionListener(this);
        sumBtn = new JButton("+");
        sumBtn.setForeground(Color.red);
        sumBtn.addActionListener(this);

        btnP3.add(btn1);
        btnP3.add(btn2);
        btnP3.add(btn3);
        btnP3.add(sumBtn);

        btnP4 = new JPanel();
        btnP4.setLayout(btnP1.getLayout());

        clrBtn = new JButton("AC");
        clrBtn.setForeground(Color.red);
        clrBtn.addActionListener(this);
        cvBtn = new JButton("+/-");
        cvBtn.setForeground(Color.red);
        cvBtn.addActionListener(this);
        ptBtn = new JButton("%");
        ptBtn.setForeground(Color.red);
        ptBtn.addActionListener(this);
        decBtn = new JButton(":");
        decBtn.setForeground(Color.red);
        decBtn.addActionListener(this);

        btnP4.add(clrBtn);
        btnP4.add(cvBtn);
        btnP4.add(ptBtn);
        btnP4.add(decBtn);


        btnP5 = new JPanel();
        btnP5.setLayout(new GridLayout(1,3));

        GridBagConstraints c = new GridBagConstraints();

        btn0 = new JButton("0");
        btn0.setForeground(Color.MAGENTA);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridy = 0;
        c.gridwidth = 2;

        btn0.addActionListener(this);
        pBtn = new JButton(".");
        pBtn.setForeground(Color.red);
        pBtn.addActionListener(this);
        resBtn = new JButton("=");
        resBtn.setForeground(Color.green.brighter());
        resBtn.addActionListener(this);

        btnP5.add(btn0,c);
        btnP5.add(pBtn);
        btnP5.add(resBtn);


        Panel0.add(displayPanel);
        Panel0.add(btnP4);
        Panel0.add(btnP1);
        Panel0.add(btnP2);
        Panel0.add(btnP3);
        Panel0.add(btnP5);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public Double doMath(double firstNum, double secondNum, String Op) {
        double resultMath = 0;
        if(Op == "+")
            resultMath =  firstNum + secondNum;
        else if(Op == "-")
            resultMath = firstNum - secondNum;
        else if(Op == "x")
            resultMath = firstNum * secondNum;
        else if(Op == ":")
            resultMath = firstNum / secondNum;
        else if(Op == "")
            resultMath = secondNum;

        return resultMath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AC":
                setNum1(0);
                setNum2(0);
                operator = "";
                display.setText("");
                break;
            case "+/-":
                if(Double.parseDouble(display.getText()) > 0)
                    display.setText("-" + display.getText());
                else
                    display.setText(display.getText().substring(1));
                break;
            case "%":
                double m = Double.parseDouble(display.getText());
                if(m - (int)m == 0)
                    display.setText("0.0" + display.getText());
                //9.2 =>> 0.92
                else {
                    String tmp[] = display.getText().split("\\.");
                    display.setText( "0.0" + tmp[0] + tmp[1]);
                }
                break;
            case ".":
                double n = Double.parseDouble(display.getText());
                if(n - (int)n == 0)
                    display.setText(display.getText()+ ".");
                break;

            case "1":
                if(!newCycle) {
                    display.setText(display.getText() + "1");
                }
                else {
                    display.setText("1");
                    newCycle = false;
                }

                break;

            case "2":
                if(!newCycle) {
                    display.setText(display.getText() + "2");
                }
                else {
                    display.setText("2");
                    newCycle = false;
                }

                break;
            case "3":
                if(!newCycle) {
                    display.setText(display.getText() + "3");
                }
                else {
                    display.setText("3");
                    newCycle = false;
                }

                break;

            case "4":
                if(!newCycle) {
                    display.setText(display.getText() + "4");
                }
                else {
                    display.setText("4");
                    newCycle = false;
                }

                break;

            case "5":
                if(!newCycle) {
                    display.setText(display.getText() + "5");
                }
                else {
                    display.setText("5");
                    newCycle = false;
                }

                break;
            case "6":
                if(!newCycle) {
                    display.setText(display.getText() + "6");
                }
                else {
                    display.setText("6");
                    newCycle = false;
                }

                break;
            case "7":
                if(!newCycle) {
                    display.setText(display.getText() + "7");
                }
                else {
                    display.setText("7");
                    newCycle = false;
                }

                break;
            case "8":
                if(!newCycle) {
                    display.setText(display.getText() + "8");
                }
                else {
                    display.setText("8");
                    newCycle = false;
                }

                break;
            case "9":
                if(!newCycle) {
                    display.setText(display.getText() + "9");
                }
                else {
                    display.setText("9");
                    newCycle = false;
                }

                break;
            case "0":
                if(!newCycle && !display.getText().equals("")) {
                    display.setText(display.getText() + "0");
                }
                else
                    display.setText("0");
                break;
            case "+":
                operator = "+";
                setNum1(Double.parseDouble(display.getText()));
                newCycle = true;
                break;
            case "-":
                operator = "-";
                setNum1(Double.parseDouble(display.getText()));
                newCycle = true;
                break;
            case "x":
                operator = "x";
                setNum1(Double.parseDouble(display.getText()));
                newCycle = true;
                break;
            case ":":
                operator = ":";
                setNum1(Double.parseDouble(display.getText()));
                newCycle = true;
                break;
            case "=":
                setNum2(Double.parseDouble(display.getText()));
                if(num2 == 0 && operator.equals(":")) {
                    JOptionPane.showMessageDialog(null,"Số chia phải khác 0. Vui lòng nhập số khác.");
                }
                else {
                    double result = doMath(num1,num2,operator);
                    if(result - (int)result == 0)
                        display.setText(String.valueOf((int)result));
                    else
                        display.setText(String.valueOf(result));
                    newCycle = true;
                    setNum1(Double.parseDouble(display.getText()));
                    setNum2(0);
                    break;
                }

        }
    }

    public static void main(String[] args) {
        new Calc("Máy tính bỏ túi").setLocationRelativeTo(null);

    }
}

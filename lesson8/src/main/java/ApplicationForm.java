import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {
    private static final char imgSquareSymbol=8730;
    private static final char imgPiSymbol=960;
    private static final char imgBackSpaceSymbol=9003;
    private static final String imgSquare=String.valueOf(imgSquareSymbol);
    private static final String imgPi=String.valueOf(imgPiSymbol);
    private static final String imgBackSpace=String.valueOf(imgBackSpaceSymbol);
    private JTextField inputField;

    public ApplicationForm() throws HeadlessException {
        super.setTitle("Calculator v 2021.12.22.0");
        setBounds(900, 100, 350, 470);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());


        add(createTop(), BorderLayout.NORTH);
        add(createBottom(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        menu.add(new JMenuItem("Clear"));
        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitButtonListener());

        return menuBar;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        return top;
    }

    private JPanel createBottom() {
        JPanel bottom = new JPanel();

        bottom.setLayout(new BorderLayout());

        //DIGITS
        JPanel digitsPanel = new JPanel();


        digitsPanel.setLayout(new GridLayout(5, 3));
        ActionListener buttonListener = new ButtonListener(inputField);

        for (int i = 1; i < 10; i++) {
            // String buttonTitle = (i == 10) ? "0" : String.valueOf(i);
            String buttonTitle =String.valueOf(i);
            JButton btn = new JButton(buttonTitle);

            btn.addActionListener(buttonListener);

            digitsPanel.add(btn);
        }

        bottom.add(digitsPanel, BorderLayout.CENTER);


        String buttonScopeL = "(";
        JButton btnL = new JButton(buttonScopeL);
        btnL.addActionListener(buttonListener);
        digitsPanel.add(btnL);

        String buttonZero = "0";
        JButton btnZero = new JButton(buttonZero);
        btnZero.addActionListener(buttonListener);
        digitsPanel.add(btnZero);



        String buttonScopeR = ")";
        JButton btnR = new JButton(buttonScopeR);
        btnR.addActionListener(buttonListener);
        digitsPanel.add(btnR);

        JButton buttonExp = new JButton("e");
        buttonExp.addActionListener(buttonListener);
        digitsPanel.add(buttonExp);

        JButton buttonPoint = new JButton(".");
        buttonPoint.addActionListener(buttonListener);
        digitsPanel.add(buttonPoint);

        JButton buttonPi = new JButton(imgPi);
        buttonPi.addActionListener(buttonListener);
        digitsPanel.add(buttonPi);

        //OPERATORS
        JPanel advPanel = new JPanel();
        advPanel.setLayout(new GridLayout(5, 2));

        JButton plus = new JButton("+");
        plus.addActionListener(buttonListener);
        advPanel.add(plus);

        JButton minus = new JButton("-");
        minus.addActionListener(buttonListener);
        advPanel.add(minus);

        JButton multiplication = new JButton("*");
        multiplication.addActionListener(buttonListener);
        advPanel.add(multiplication);


        JButton division = new JButton("/");
        division.addActionListener(buttonListener);
        advPanel.add(division);

        JButton square = new JButton(imgSquare);
        square.addActionListener(buttonListener);
        advPanel.add(square);
        JButton raisingToPower = new JButton("^");
        raisingToPower.addActionListener(buttonListener);
        advPanel.add(raisingToPower);

        JButton intDivision = new JButton("%");
        intDivision.addActionListener(buttonListener);
        advPanel.add(intDivision);

        JButton calc = new JButton("=");

        calc.addActionListener(buttonListener);
        advPanel.add(calc);

        JButton clear = new JButton("C");


        clear.addActionListener(e -> inputField.setText(""));
        advPanel.add(clear);

        JButton clearLast = new JButton(imgBackSpace);
        clearLast.addActionListener(buttonListener);
        advPanel.add(clearLast);


        bottom.add(advPanel, BorderLayout.WEST);

        return bottom;
    }
}

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.Reader;

public class ButtonListener implements ActionListener {
    private JTextField inputField;
    private static final char imgBackSpaceSymbol=9003;
    private static final String imgBackSpace=String.valueOf(imgBackSpaceSymbol);

    public ButtonListener(JTextField inputField) {

        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String s = e.getActionCommand();
        //System.out.println("\""+inputField.getText()+"\"");
        if (s.equals("=")) {

            calculate();
            //System.out.println("\""+inputField.getText()+"\"");
        } else {
            if (!s.equals(imgBackSpace)) {
                inputField.setText(inputField.getText() + btn.getText());
            } else {
                s = (inputField.getText());
                s = (s == null || s.length() == 0) ? null : (s.substring(0, s.length() - 1));
                inputField.setText(s);
            }

        }
    }

    private void calculate() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn") ;

        String str;
        try {

            str = (scriptEngine.eval(inputField.getText())).toString();
            inputField.setText(str);

        } catch (ScriptException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Введите правильное значения для выражения");
            // inputField.setText ("E R R O R");
        }


    }
}




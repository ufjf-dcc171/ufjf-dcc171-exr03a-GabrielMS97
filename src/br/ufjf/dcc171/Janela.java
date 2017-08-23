package br.ufjf.dcc171;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Janela extends JFrame {

    private final JLabel etiqueta1 = new JLabel("Digite o coeficiente 'a'");
    private final JLabel etiqueta2 = new JLabel("Digite o coeficiente 'b'");
    private final JLabel etiqueta3 = new JLabel("Digite o coeficiente 'c'");
    private final JTextField text1 = new JTextField(10);
    private final JTextField text2 = new JTextField(10);
    private final JTextField text3 = new JTextField(10);
    private final JButton botao = new JButton("Calcular");
    private double a;
    private double b;
    private double c;
    private double res;

    public Janela() throws HeadlessException {
        super("Calcula raízes");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(etiqueta1);
        add(text1);
        add(etiqueta2);
        add(text2);
        add(etiqueta3);
        add(text3);
        add(botao);

        text1.addActionListener(new registra1());
        text2.addActionListener(new registra2());
        text3.addActionListener(new registra3());
        text3.addActionListener(new registra3());
        botao.addActionListener(new Calcula());
    }

    private class Calcula implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double delta;
            double x1, x2;
            
            delta = Math.sqrt(Math.pow(b,2) - (4 * a * c));
            if(delta < 0)
            {
                JOptionPane.showMessageDialog(null, "Esta equação não possui raiz real!", "Raíz Negativa!!!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                
            }
            //JOptionPane.showMessageDialog(null, "As raízes são: " + res , "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private class registra3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            c = Double.parseDouble(text3.getText());
            botao.requestFocus();
        }

    }

    private class registra2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            b = Double.parseDouble(text2.getText());
            text3.requestFocus();
        }

    }

    private class registra1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            a = Double.parseDouble(text1.getText());
            text2.requestFocus();
        }

    }
}

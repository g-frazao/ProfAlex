import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class formulario_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelRazaoSocial = new JLabel("Razão Social:");
        JLabel labelDocumento = new JLabel("Documento:");

        JTextField textFieldNome = new JTextField();
        JTextField textFieldRazaoSocial = new JTextField();
        JTextField textFieldDocumento = new JTextField();

        JComboBox<String> comboBoxTipoPessoa = new JComboBox<>(new String[]{"Física", "Jurídica"});

        JButton buttonSalvar = new JButton("Salvar");

        frame.add(labelNome);
        frame.add(textFieldNome);
        frame.add(labelRazaoSocial);
        frame.add(textFieldRazaoSocial);
        frame.add(labelDocumento);
        frame.add(textFieldDocumento);
        frame.add(new JLabel("Tipo de Pessoa:"));
        frame.add(comboBoxTipoPessoa);

        comboBoxTipoPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBoxTipoPessoa.getSelectedItem();
                if ("Física".equals(selectedItem)) {
                    labelDocumento.setText("CPF:");
                } else if ("Jurídica".equals(selectedItem)) {
                    labelDocumento.setText("CNPJ:");
                }
            }
        });

        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String razaoSocial = textFieldRazaoSocial.getText();
                String documento = textFieldDocumento.getText();
                String tipoPessoa = (String) comboBoxTipoPessoa.getSelectedItem();

                String mensagem = "Nome: " + nome + "\nRazão Social: " + razaoSocial + "\nDocumento: " + documento + "\nTipo de Pessoa: " + tipoPessoa;

                JOptionPane.showMessageDialog(frame, mensagem);
            }
        });

        frame.add(buttonSalvar);

        frame.setVisible(true);
    }
}

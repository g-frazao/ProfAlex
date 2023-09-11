import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class interfacegrafica {
    private JTextField nomeField, telefoneField, emailField, salarioField;

    public interfacegrafica() {
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField();
        JLabel emailLabel = new JLabel("E-mail:");
        emailField = new JTextField();
        JLabel salarioLabel = new JLabel("Salário:");
        salarioField = new JTextField();

        JButton gravarButton = new JButton("Gravar");
        JButton lerButton = new JButton("Ler");

        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravarDados();
            }
        });

        lerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerDados();
            }
        });

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(telefoneLabel);
        panel.add(telefoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(salarioLabel);
        panel.add(salarioField);
        panel.add(gravarButton);
        panel.add(lerButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void gravarDados() {
        String nome = nomeField.getText();
        String telefone = telefoneField.getText();
        String email = emailField.getText();
        String salario = salarioField.getText();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("client.txt"));
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("Telefone: " + telefone);
            writer.newLine();
            writer.write("E-mail: " + email);
            writer.newLine();
            writer.write("Salário: " + salario);
            writer.close();
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados.");
        }
    }

    private void lerDados() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("client.txt"));
            nomeField.setText(reader.readLine().replace("Nome: ", ""));
            telefoneField.setText(reader.readLine().replace("Telefone: ", ""));
            emailField.setText(reader.readLine().replace("E-mail: ", ""));
            salarioField.setText(reader.readLine().replace("Salário: ", ""));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao ler os dados.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new interfacegrafica();
            }
        });
    }
}

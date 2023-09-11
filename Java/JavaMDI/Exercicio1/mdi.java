import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mdi {
    private JFrame frame;
    private JDesktopPane desktopPane;

    public mdi() {
        frame = new JFrame("MDI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        createMenu();

        frame.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu cadastrosMenu = new JMenu("Cadastros");

        JMenuItem produtoMenuItem = new JMenuItem("Cadastro de Produto");
        produtoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCadastroProdutoForm();
            }
        });
        cadastrosMenu.add(produtoMenuItem);

        JMenuItem clienteMenuItem = new JMenuItem("Cadastro de Cliente");
        clienteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCadastroClienteForm();
            }
        });
        cadastrosMenu.add(clienteMenuItem);

        JMenuItem fornecedorMenuItem = new JMenuItem("Cadastro de Fornecedor");
        fornecedorMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCadastroFornecedorForm();
            }
        });
        cadastrosMenu.add(fornecedorMenuItem);

        menuBar.add(cadastrosMenu);

        frame.setJMenuBar(menuBar);
    }

    /**
     * 
     */
    private void openCadastroProdutoForm() {
        final Component produtoForm = new CadastroProdutoForm();
        desktopPane.add(produtoForm);
        produtoForm.setVisible(true);
    }

    private void openCadastroClienteForm() {
        CadastroClienteForm clienteForm = new CadastroClienteForm();
        desktopPane.add(clienteForm);
        clienteForm.setVisible(true);
    }

    /**
     * 
     */
    private void openCadastroFornecedorForm() {
        CadastroFornecedorForm fornecedorForm = new CadastroFornecedorForm();
        desktopPane.add(fornecedorForm);
        try {
            ((Window) fornecedorForm)
        } catch (Exception e) {
            // TODO: handle exception
        }.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mdi();
            }
        });
    }
}

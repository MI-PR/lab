import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExistingPersonWindow extends JFrame {
    private Graph graph;

    public ExistingPersonWindow(Graph graph) {
        this.graph = graph;

        setTitle("Existing Person");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JTextField nameField = new JTextField();
        JButton proceedButton = new JButton("Proceed");

        panel.add(new JLabel("Enter your name:"));
        panel.add(nameField);

        add(panel, BorderLayout.CENTER);
        add(proceedButton, BorderLayout.SOUTH);

        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (graph.personExists(name)) {
                    new ExistingPersonOptionsWindow(graph, name).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Name not found. Redirecting to add new person.");
                    new NewPersonWindow(graph).setVisible(true);
                    dispose();
                }
            }
        });
    }
}

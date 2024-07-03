import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPersonWindow extends JFrame {
    private Graph graph;

    public NewPersonWindow(Graph graph) {
        this.graph = graph;

        setTitle("Social Network Graph - New Person");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JTextField nameField = new JTextField();
        JButton addButton = new JButton("Add Person");

        panel.add(new JLabel("Enter your name:"));
        panel.add(nameField);

        add(panel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (!name.isEmpty()) {
                    graph.addPerson(name);
                    JOptionPane.showMessageDialog(null, name + " added.");
                    new InitialWindow(graph).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

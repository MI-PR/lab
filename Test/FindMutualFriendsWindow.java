import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;


public class FindMutualFriendsWindow extends JFrame {
    private Graph graph;
    private String personName;

    public FindMutualFriendsWindow(Graph graph, String personName) {
        this.graph = graph;
        this.personName = personName;

        setTitle("Find Mutual Friends");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JTextField otherPersonField = new JTextField();
        JButton findButton = new JButton("Find Mutual Friends");

        panel.add(new JLabel("Enter other person's name:"));
        panel.add(otherPersonField);

        add(panel, BorderLayout.CENTER);
        add(findButton, BorderLayout.SOUTH);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String otherPerson = otherPersonField.getText().trim();
                if (!otherPerson.isEmpty()) {
                    if (graph.personExists(otherPerson)) {
                        Set<String> mutualFriends = graph.findMutualFriends(personName, otherPerson);
                        JOptionPane.showMessageDialog(null, "Mutual friends between " + personName + " and " + otherPerson + ": " + mutualFriends);
                        new InitialWindow(graph).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Other person's name not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Other person's name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

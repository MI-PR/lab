import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFriendWindow extends JFrame {
    private Graph graph;
    private String personName;

    public AddFriendWindow(Graph graph, String personName) {
        this.graph = graph;
        this.personName = personName;

        setTitle("Add Friend");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JTextField friendNameField = new JTextField();
        JButton addButton = new JButton("Add Friend");

        panel.add(new JLabel("Enter friend's name:"));
        panel.add(friendNameField);

        add(panel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String friendName = friendNameField.getText().trim();
                if (!friendName.isEmpty()) {
                    if (graph.personExists(friendName)) {
                        graph.makeFriends(personName, friendName);
                        JOptionPane.showMessageDialog(null, personName + " and " + friendName + " are now friends.");
                        new InitialWindow(graph).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Friend's name not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Friend's name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

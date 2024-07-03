import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExistingPersonOptionsWindow extends JFrame {
    private Graph graph;
    private String personName;

    public ExistingPersonOptionsWindow(Graph graph, String personName) {
        this.graph = graph;
        this.personName = personName;

        setTitle("Options");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton addFriendButton = new JButton("Add Friend");
        JButton findMutualButton = new JButton("Find Mutual Friends");

        panel.add(addFriendButton);
        panel.add(findMutualButton);

        add(panel, BorderLayout.CENTER);

        addFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFriendWindow(graph, personName).setVisible(true);
                dispose();
            }
        });

        findMutualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindMutualFriendsWindow(graph, personName).setVisible(true);
                dispose();
            }
        });
    }
}

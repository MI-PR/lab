import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Graph {
    private Map<String, Set<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addPerson(String name) {
        if (!adjacencyList.containsKey(name)) {
            adjacencyList.put(name, new HashSet<>());
        }
    }

    public boolean personExists(String name) {
        return adjacencyList.containsKey(name);
    }

    public void makeFriends(String person1, String person2) {
        if (adjacencyList.containsKey(person1) && adjacencyList.containsKey(person2)) {
            adjacencyList.get(person1).add(person2);
            adjacencyList.get(person2).add(person1);
        }
    }

    public Set<String> findMutualFriends(String person1, String person2) {
        if (adjacencyList.containsKey(person1) && adjacencyList.containsKey(person2)) {
            Set<String> friendsOfPerson1 = adjacencyList.get(person1);
            Set<String> friendsOfPerson2 = adjacencyList.get(person2);
            Set<String> mutualFriends = new HashSet<>(friendsOfPerson1);
            mutualFriends.retainAll(friendsOfPerson2);
            return mutualFriends;
        }
        return Collections.emptySet();
    }
}

public class InitialWindow extends JFrame {
    private Graph graph;

    public InitialWindow(Graph graph) {
        this.graph = graph;

        setTitle("Initial");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton newPersonButton = new JButton("New Person");
        JButton existingPersonButton = new JButton("Existing Person");

        panel.add(newPersonButton);
        panel.add(existingPersonButton);

        add(panel, BorderLayout.CENTER);

        newPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPersonWindow(graph).setVisible(true);
                dispose();
            }
        });

        existingPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExistingPersonWindow(graph).setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graph graph = new Graph();
                new InitialWindow(graph).setVisible(true);
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdventureGame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());

        JTextField inputField = new JTextField();
        inputField.setColumns(20); // Set the number of columns to make the input field wider
        panel.add(inputField, BorderLayout.WEST);

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton, BorderLayout.EAST);

        contentPane.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);

        startGame(textArea, inputField, submitButton);
    }

    private static void startGame(JTextArea textArea, JTextField inputField, JButton submitButton) {
        textArea.append("Welcome to the adventure game!\n");
        textArea.append("You are stranded on a deserted island.\n");
        textArea.append("Do you want to enter the dark cave (enter \"cave\") or explore the beach (enter \"beach\")?");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String decision = inputField.getText().toLowerCase();
                inputField.setText("");

                if (decision.contains("cave")) {
                    enterCave(textArea, inputField, submitButton);
                } else if (decision.contains("beach")) {
                    exploreBeach(textArea, inputField, submitButton);
                } else {
                    textArea.append("\nInvalid input. Please try again.");
                }
            }
        });
    }

    private static void enterCave(JTextArea textArea, JTextField inputField, JButton submitButton) {
        textArea.append("\nYou enter the dark cave and discover a hidden treasure chest!");
        textArea.append("Congratulations! You have completed your adventure.");

        inputField.setEnabled(false);
        submitButton.setEnabled(false);
    }

    private static void exploreBeach(JTextArea textArea, JTextField inputField, JButton submitButton) {
        textArea.append("\nYou spend a relaxing time building a beautiful sandcastle on the beach.");

        String decision = getUserDecision(textArea, inputField, submitButton, "Explore more or relax on the beach?");
        if (decision.contains("explore")) {
            explore(textArea, inputField, submitButton);
        } else if (decision.contains("relax")) {
            textArea.append("\nYou decide to relax on the beach. The sun is setting, and it's time to go back to the camp.");

            inputField.setEnabled(false);
            submitButton.setEnabled(false);
        }
    }

    private static void explore(JTextArea textArea, JTextField inputField, JButton submitButton) {
        textArea.append("\nYou explore further and discover a group of friendly island inhabitants.");
        textArea.append("They offer you a delicious feast. The adventure continues...");

        inputField.setEnabled(false);
        submitButton.setEnabled(false);
    }

    private static String getUserDecision(JTextArea textArea, JTextField inputField, JButton submitButton, String prompt) {
        textArea.append("\n" + prompt);

        String decision = "";
        while (decision.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return decision;
    }
}

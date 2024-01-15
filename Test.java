import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel entfernen Beispiel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        ImageIcon dameIcon = new ImageIcon("bilder/dame.png");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(dameIcon);
         JLabel label2 = new JLabel(dameIcon);
        panel.add(label);
         panel.add(label2);

        JButton removeButton = new JButton("Entfernen");
        frame.add(panel, BorderLayout.CENTER);
        frame.add(removeButton, BorderLayout.SOUTH);
        frame.setVisible(true);

        removeButton.addActionListener(e -> {
            panel.remove(label);
            panel.revalidate();
            panel.repaint();
        });

    }
}

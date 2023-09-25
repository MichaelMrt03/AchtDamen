import java.awt.*;
import javax.swing.*;

public class Schachbrett {
    public Schachbrett() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Acht Damen Problem");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // zentriert

        JPanel schachbrett = new JPanel(new GridLayout(1, 2));

        JPanel quadrat1 = new JPanel();
        JPanel quadrat2 = new JPanel();

        quadrat1.setBackground(Color.BLACK);
        quadrat2.setBackground(Color.WHITE);

        schachbrett.add(quadrat1);
        schachbrett.add(quadrat2);

        frame.add(schachbrett);

    }

}
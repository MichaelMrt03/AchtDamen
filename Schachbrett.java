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

        JPanel schachbrett = new JPanel(new GridLayout(8, 8));

        for (int spalte = 0; spalte < 8; spalte++) {
            for (int zeile = 0; zeile < 8; zeile++) {
                JPanel quadrat = new JPanel();
                if ((spalte + zeile) % 2 == 0) { // Gerade Zahl
                    quadrat.setBackground(Color.WHITE);
                } else {
                    quadrat.setBackground(Color.BLACK);
                }
                schachbrett.add(quadrat);
            }
        }

        frame.add(schachbrett);

    }
}
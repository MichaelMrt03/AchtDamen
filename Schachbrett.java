import java.awt.*;
import javax.swing.*;

public class Schachbrett {
    JFrame frame;
    JPanel schachbrett;
    JLabel dame;

    int index = 0;

    public Schachbrett() {
        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Acht Damen Problem");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // zentriert
        erzeugeSchachbrett();

        // String s = Engine.stellungen[0];
        // System.out.println(s);
        stellungEinlesen(Engine.stellungen[index]);

        JButton removeButton = new JButton("Entfernen");
        // frame.add(removeButton, BorderLayout.SOUTH);

        removeButton.addActionListener(e -> {
            damenEntfernen();
        });

        //Nächste Stellung
        JButton rechtsButton = new JButton("=>");
        frame.add(rechtsButton, BorderLayout.EAST);
        rechtsButton.addActionListener(e -> {
            if(index<92){
                damenEntfernen();
                stellungEinlesen(Engine.stellungen[++index]);
                 System.out.println("Stellung Nummer: "+index);
            }
        });

        //Letze Stellung
        JButton linksButton = new JButton("<=");
        frame.add(linksButton, BorderLayout.WEST);
        linksButton.addActionListener(e -> {
            if(index>0){
                damenEntfernen();
                stellungEinlesen(Engine.stellungen[--index]);
                  System.out.println("Stellung Nummer: "+index);
            }
        });

        frame.setVisible(true);

    }

    // Erzeugt ein 8x8 Schachbrett
    public void erzeugeSchachbrett() {
        Color braun = new Color(139, 69, 19);
        schachbrett = new JPanel(new GridLayout(8, 8));
        for (int spalte = 0; spalte < 8; spalte++) {
            for (int zeile = 0; zeile < 8; zeile++) {
                JPanel quadrat = new JPanel();
                if ((spalte + zeile) % 2 == 0) { // Gerade Zahl
                    quadrat.setBackground(Color.WHITE);
                } else {
                    quadrat.setBackground(braun);
                }
                schachbrett.add(quadrat);
            }
        }
        frame.add(schachbrett);
        frame.setVisible(true);
    }

    // Platziert eine Dame auf die Koordinaten
    public void platziereDame(int zeile, int spalte) {
        ImageIcon dameIcon = new ImageIcon("bilder/dame.png");
        dame = new JLabel(dameIcon);
        JPanel zielQuadrat = (JPanel) schachbrett.getComponent(zeile * 8 + spalte);
        zielQuadrat.add(dame);
        frame.getContentPane().add(schachbrett);
        frame.setVisible(true);
    }

    // Liest die Stellung ein -> platziert 8 Damen
    public void stellungEinlesen(String stellung) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < stellung.length(); i++) {

            if (stellung.charAt(i) == '1') {
                // Dame platzieren
                platziereDame(x, y);

            }
            // Ermittelt die Koordinaten
            if (x % 7 == 0) {
                y++;
            } else {
                x++;
            }
        }
    }

    //Entfernt alle Damen
    public void damenEntfernen() {
        frame.remove(schachbrett);
        frame.revalidate();
        frame.repaint();
        erzeugeSchachbrett();
    }

}
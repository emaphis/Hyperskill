package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private final JLabel generationLabel;
    private final JLabel aliveLabel;
    private int generation;
    private JPanel lifePanel;
    private final Universe universe;


    public GameOfLife(Universe universe) {
        super("Game of Life");
        this.universe = universe;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel labelPanel;
        LifePanel lifePanel;

        this.generation = 0;

        this.generationLabel = new JLabel("Generation #" );
        this.generationLabel.setName("GenerationLabel");  // to pass checker

        this.aliveLabel = new JLabel("Alive: ");
        this.aliveLabel.setName("AliveLabel");  // to pass checker

        labelPanel = new JPanel();
        labelPanel.add(generationLabel);
        labelPanel.add(aliveLabel);
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        System.out.println("got here bbbbbb");
        lifePanel = new LifePanel(universe);

        add(labelPanel);
        add(lifePanel);

        setVisible(true);
    }

    public int getGeneration() {
        return generation;
    }

    public int nextGeneration() {
        generation++;
        return generation;
    }

    public void run(int generations) {
        for (int generation = 1; generation <= generations; generation++) {
            generationLabel.setText("Generation #" + generation);
            aliveLabel.setText("Alive: " + universe.numAlive());

            if (lifePanel == null) {
                System.out.println("Null error ddd");
            } else {
                System.out.println("lifePanel exists fffff");
            }

            //lifePanel.repaint();
            this.universe.advanceBoard();

            try {
                Thread.sleep(100L);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }

}

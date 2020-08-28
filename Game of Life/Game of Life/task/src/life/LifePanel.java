package life;

import javax.swing.*;
import java.awt.*;

public class LifePanel extends JPanel {
    private Universe universe;

    LifePanel(Universe universe) {
        this.universe = universe;
    }

    @Override
    protected void paintComponent(Graphics gr) {
        int size = universe.getSize();

        gr.setColor(Color.GRAY);
        gr.fillRect(0, 0, getWidth(), getHeight());

        // draw board.
        for (int row = 0; row < universe.getSize(); row++) {
            for (int col = 0; col < universe.getSize(); col++) {
                if (universe.getCell(row, col).isAlive()) {
                    gr.setColor(Color.BLACK);
                } else {
                    gr.setColor(Color.WHITE);
                }
                gr.fillRect(row * size, col * size, size, size);
                gr.setColor(Color.BLACK);
                gr.drawRect(col * size, row * size, size, size);
            }
        }

    }
}

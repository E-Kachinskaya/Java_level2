package one.circle;

import java.awt.*;

public class Background extends Sprite{

    private float time;
    private Color color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );


    void update(GameCanvas canvas, float deltaTime) {
        x = canvas.getLeft();
        y = canvas.getTop();
        time += deltaTime;
        if (time > 0.9){
            color = new Color(
                    (int)(Math.random() * 255 + 1),
                    (int)(Math.random() * 255 + 1),
                    (int)(Math.random() * 255 + 1)
            );
            time = 0;
        }
    }
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect((int)canvas.getLeft(), (int)canvas.getTop(), (int)canvas.getWidth(), (int)canvas.getHeight());
    }
}

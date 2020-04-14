import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Deque;
import java.util.LinkedList;

public class WineUtils {

    public static Deque<AffineTransform> init(Graphics2D g) {
        g.setStroke(new BasicStroke(1f, 0, 0, 4));
        Deque<AffineTransform> queue = new LinkedList<>();
        queue.push(g.getTransform());
        return queue;
    }

}

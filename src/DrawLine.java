import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawLine extends JComponent {
    @Override
    public void paint(Graphics g) {
        // Draw a simple line using the Graphics2D draw() method.
        Graphics2D g2 = (Graphics2D) g;

        paintEiffelTower(g2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawLine());
        frame.pack();
        frame.setSize(new Dimension(2000, 2000));
        frame.setVisible(true);
    }
    public static void paintTeddy(Graphics2D g) {
        g.transform(new AffineTransform(3, 0, 0, 3, 0, 0));
        drawEllipse(g,71, 155, 33, 17);
        drawEllipse(g,113, 155, 33, 17);
        drawEllipse(g,77, 106, 65, 59);
        drawEllipse(g,83, 67, 52, 47);
        drawEllipse(g,80, 40, 17, 45);
        drawEllipse(g,120, 40, 17, 45);
        drawEllipse(g,98, 79, 5, 5);
        drawEllipse(g,113, 79, 5, 5);
        drawEllipse(g,100, 88, 16, 14);
        drawEllipse(g,106, 91, 4, 4);
        drawEllipse(g,65, 110, 28, 25);
        drawEllipse(g,125, 110, 28, 25);
    }

    private static void drawEllipse(Graphics2D g, int i, int i1, int i2, int i3) {
        g.draw(new Ellipse2D.Double(i,i1,i2,i3));
    }


    private static void paintEiffelTower(Graphics2D g) {
        g.setStroke(new BasicStroke(19, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 4));
        Shape shape;
        AffineTransform defaultTransform = g.getTransform();

        g.draw(getStraightLineShape(new Point2D.Double(490.5, 80), new Point2D.Double(490.5, 33)));

        g.draw(getStraightLineShape(
                new Point2D.Double(470, 134.5),
                new Point2D.Double(459, 102),
                new Point2D.Double(491, 80),
                new Point2D.Double(522, 102.5),
                new Point2D.Double(511, 134.5)));

        g.draw(getStraightLineShape(new Point2D.Double(456, 141), new Point2D.Double(525, 141)));

        shape = getCurveLineShape(
                new Point2D.Double(375, 716),
                new CurvePoints(375, 716, 421, 630, 435, 544),
                new CurvePoints(450, 458, 479, 184, 471, 145));
        g.draw(shape);
        g.translate(980.5, 980.5);
        g.scale(-1, -1);
        g.draw(shape);
        g.setTransform(defaultTransform);

        g.draw(getStraightLineShape(new Point2D.Double(491, 496), new Point2D.Double(491, 393)));

        g.draw(getStraightLineShape(new Point2D.Double(415, 543), new Point2D.Double(566, 543)));

        g.draw(getCurveLineShape(
                new Point2D.Double(438, 715),
                new CurvePoints(438, 715, 461, 659, 470, 604),
                new CurvePoints(511, 604, 511, 604, 511, 604),
                new CurvePoints(514, 604, 533, 693, 543, 715)));

        shape = getCurveLineShape(new Point2D.Double(226, 952),
                new CurvePoints(226, 952, 310, 845, 344, 790));
        g.draw(shape);
        g.translate(980.5, 0);
        g.scale(-1, 1);
        g.draw(shape);
        g.setTransform(defaultTransform);

        shape = new RoundRectangle2D.Double(329, 717, 323, 64, 30, 30);
        g.draw(shape);

        Shape line = getStraightLineShape(new Point2D.Double(372.5, 744), new Point2D.Double(372.5, 756));
        for(int i = 0; i < 6; i++) {
            g.draw(line);
            g.translate(47, 0);
        }
        g.setTransform(defaultTransform);

        g.draw(getCurveLineShape(new Point2D.Double(319, 955),
                new CurvePoints(319, 955, 350, 820, 488, 821),
                new CurvePoints(625, 822, 665, 957, 662, 955)));

        shape = new RoundRectangle2D.Double(203, 959, 131, 47, 30, 30);
        g.draw(shape);
        g.translate(444.5, 0);
        g.draw(shape);
        g.setTransform(defaultTransform);
    }

    private static Shape getCurveLineShape(Point2D.Double aDouble, CurvePoints curvePoints, CurvePoints curvePoints1, CurvePoints curvePoints2) {
        return new Line2D.Double(0,0,0,0);
    }


    private static Shape getCurveLineShape(Point2D.Double aDouble, CurvePoints curvePoints, CurvePoints curvePoints1) {
        return new Line2D.Double(0,0,0,0);
    }

    private static Shape getCurveLineShape(Point2D.Double aDouble, CurvePoints curvePoints) {
        return new Line2D.Double(0,0,0,0);
    }

    private static Shape getStraightLineShape(Point2D.Double aDouble, Point2D.Double aDouble1, Point2D.Double aDouble2, Point2D.Double aDouble3, Point2D.Double aDouble4) {
        Path2D p = new Path2D.Double();
        p.moveTo(aDouble.x,aDouble.y);
        p.lineTo(aDouble1.x, aDouble1.y);
        p.lineTo(aDouble2.x, aDouble2.y);
        p.lineTo(aDouble3.x, aDouble3.y);
        p.lineTo(aDouble4.x, aDouble4.y);
        return p;
    }

    private static Shape getStraightLineShape(Point2D.Double aDouble, Point2D.Double aDouble1) {
        return new Line2D.Double(aDouble.x, aDouble.y, aDouble1.x, aDouble1.y);
    }

}
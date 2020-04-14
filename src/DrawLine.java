import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DrawLine extends JComponent {
    @Override
    public void paint(Graphics g) {
        // Draw a simple line using the Graphics2D draw() method.
        Graphics2D g2 = (Graphics2D) g;
       // drawImage(g2);
        //paintEiffelTower(g2);
        //paintTeddy(g2);
        //paintCheese(g2);
        paintFlower(g2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawLine());
        frame.pack();
        frame.setSize(new Dimension(1000, 1000));
        frame.setVisible(true);
    }
    public static void paintTeddy(Graphics2D g) {
        g.transform(new AffineTransform(3, 0, 0, 3, 0, 0));
        drawEllipse(g,71, 155, 33, 17);
        drawEllipse(g,113, 155, 33, 17);
        drawEllipse(g,77, 106, 65, 59);
        drawEllipse(g,83, 67, 52, 47);
        drawEllipse(g,80, 60, 17, 15);
        drawEllipse(g,120, 60, 17, 15);
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
        Path2D p = new Path2D.Double();
        p.moveTo(aDouble.x,aDouble.y);
        p.curveTo(curvePoints.x1,curvePoints.y1,curvePoints.x2,curvePoints.y2,curvePoints.x3,curvePoints.y3);
        p.curveTo(curvePoints1.x1,curvePoints1.y1,curvePoints1.x2,curvePoints1.y2,curvePoints1.x3,curvePoints1.y3);
        p.curveTo(curvePoints2.x1,curvePoints2.y1,curvePoints2.x2,curvePoints2.y2,curvePoints2.x3,curvePoints2.y3);
        return p;
    }


    private static Shape getCurveLineShape(Point2D.Double aDouble, CurvePoints curvePoints, CurvePoints curvePoints1) {
        Path2D p = new Path2D.Double();
        p.moveTo(aDouble.x,aDouble.y);
        p.curveTo(curvePoints.x1,curvePoints.y1,curvePoints.x2,curvePoints.y2,curvePoints.x3,curvePoints.y3);
        p.curveTo(curvePoints1.x1,curvePoints1.y1,curvePoints1.x2,curvePoints1.y2,curvePoints1.x3,curvePoints1.y3);
        return p;
    }

    private static Shape getCurveLineShape(Point2D.Double aDouble, CurvePoints curvePoints) {
        Path2D p = new Path2D.Double();
        p.moveTo(aDouble.x,aDouble.y);
        p.curveTo(curvePoints.x1,curvePoints.y1,curvePoints.x2,curvePoints.y2,curvePoints.x3,curvePoints.y3);
        return p;
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

    private static void drawImage(Graphics2D g) {
        g.setStroke(new BasicStroke(1));
        g.setPaint(Color.BLACK);
        drawStar(g, 200, 250, 250);
    }

    private static void drawStar(Graphics2D g, double radius, double x0, double y0) {
        if (radius < 5) {
            return;
        }
        double curveRadius = radius / 1.9;
        double insideRadius = radius / 2;
        double degree1 = 0;
        double degree2 = 2 * Math.PI / 5;
        double degree3 = 4 * Math.PI / 5;
        double degree4 = 6 * Math.PI / 5;
        double degree5 = 8 * Math.PI / 5;
        double betweenDegree1 = Math.PI / 5;
        double betweenDegree2 = 3 * Math.PI / 5;
        double betweenDegree3 = 5 * Math.PI / 5;
        double betweenDegree4 = 7 * Math.PI / 5;
        double betweenDegree5 = 9 * Math.PI / 5;

        drawFigure(g, new Point2D.Double(x0, y0 - radius),
                new Point2D.Double(x0 + getX(insideRadius, degree3), y0 + getY(insideRadius, degree3)),
                new Point2D.Double(x0 - getX(radius, degree5), y0 - getY(radius, degree5)),
                new Point2D.Double(x0 + getX(insideRadius, degree2), y0 + getY(insideRadius, degree2)),
                new Point2D.Double(x0 - getX(radius, degree4), y0 - getY(radius, degree4)),
                new Point2D.Double(x0, y0 + insideRadius),
                new Point2D.Double(x0 - getX(radius, degree3), y0 - getY(radius, degree3)),
                new Point2D.Double(x0 + getX(insideRadius, degree5), y0 + getY(insideRadius, degree5)),
                new Point2D.Double(x0 - getX(radius, degree2), y0 - getY(radius, degree2)),
                new Point2D.Double(x0 + getX(insideRadius, degree4), y0 + getY(insideRadius, degree4))
        );

        drawInsideRib(g, x0, y0, insideRadius, degree3, degree2,
                curveRadius, betweenDegree5, betweenDegree4);
        drawInsideRib(g, x0, y0, insideRadius, degree2, degree1,
                curveRadius, betweenDegree4, betweenDegree3);
        drawInsideRib(g, x0, y0, insideRadius, degree1, degree5,
                curveRadius, betweenDegree3, betweenDegree2);
        drawInsideRib(g, x0, y0, insideRadius, degree5, degree4,
                curveRadius, betweenDegree2, betweenDegree1);
        drawInsideRib(g, x0, y0, insideRadius, degree4, degree3,
                curveRadius, betweenDegree1, betweenDegree5);

        drawStar(g, radius / 5, x0 - getX(radius, betweenDegree1), y0 - getY(radius, betweenDegree1));
        drawStar(g, radius / 5, x0 - getX(radius, betweenDegree2), y0 - getY(radius, betweenDegree2));
        drawStar(g, radius / 5, x0 - getX(radius, betweenDegree3), y0 - getY(radius, betweenDegree3));
        drawStar(g, radius / 5, x0 - getX(radius, betweenDegree4), y0 - getY(radius, betweenDegree4));
        drawStar(g, radius / 5, x0 - getX(radius, betweenDegree5), y0 - getY(radius, betweenDegree5));
        drawStar(g, radius / 5, x0, y0);

        double insideStarCenterRadius = radius / 1.5;
        drawStar(g, radius / 10, x0 - getX(insideStarCenterRadius, degree1), y0 - getY(insideStarCenterRadius, degree1));
        drawStar(g, radius / 10, x0 - getX(insideStarCenterRadius, degree2), y0 - getY(insideStarCenterRadius, degree2));
        drawStar(g, radius / 10, x0 - getX(insideStarCenterRadius, degree3), y0 - getY(insideStarCenterRadius, degree4));
        drawStar(g, radius / 10, x0 - getX(insideStarCenterRadius, degree4), y0 - getY(insideStarCenterRadius, degree4));
        drawStar(g, radius / 10, x0 - getX(insideStarCenterRadius, degree5), y0 - getY(insideStarCenterRadius, degree5));
    }

    private static void drawFigure(Graphics2D g, Point2D.Double aDouble, Point2D.Double aDouble1, Point2D.Double aDouble2, Point2D.Double aDouble3, Point2D.Double aDouble4, Point2D.Double aDouble5, Point2D.Double aDouble6, Point2D.Double aDouble7, Point2D.Double aDouble8, Point2D.Double aDouble9) {
        Path2D p = new Path2D.Double();
        p.moveTo(aDouble.x,aDouble.y);
        p.lineTo(aDouble1.x, aDouble1.y);
//        p.lineTo(aDouble2.x, aDouble2.y);
//        p.lineTo(aDouble3.x, aDouble3.y);
//        p.lineTo(aDouble4.x, aDouble4.y);
//        p.moveTo(aDouble5.x, aDouble5.y);
//        p.lineTo(aDouble6.x, aDouble6.y);
//        p.lineTo(aDouble7.x, aDouble7.y);
//        p.lineTo(aDouble8.x, aDouble8.y);
//        p.lineTo(aDouble9.x, aDouble9.y);
        g.draw(p);

    }

    private static double getY(double radius, double degree) {
        return radius*Math.sin(degree);
    }

    private static double getX(double insideRadius, double degree) {
        return insideRadius*Math.cos(degree);
    }

    private static void drawInsideRib(Graphics2D g, double x0, double y0, double insideRadius, double degree3, double degree2, double curveRadius, double betweenDegree5, double betweenDegree4) {
        return;
    }


    public static void paintCheese(Graphics2D g) {
        Deque<AffineTransform> transformations = new LinkedList<>();

        drawLine(g, new Point2D.Double(43, 128), new ArrayList<Point2D.Double>(){{
            add(new Point2D.Double(43, 173));
            add(new Point2D.Double(170, 156));
            add(new Point2D.Double(170, 128));
        }});

        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.508f, 0, 0, 0.52f, 427.4f, 335.8f));

        GeneralPath shape = new GeneralPath();
        shape.moveTo(-756, -401);
        shape.curveTo(-736, -416, -716, -431, -700, -438);
        shape.curveTo(-686, -446, -676, -446, -644, -438);
        shape.curveTo(-612, -431, -558, -416, -505, -401);
        g.setPaint(Color.WHITE);
        g.fill(shape);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        g.draw(shape);
        g.setTransform(transformations.pop());

        drawEllipse(g, 62, 120, 15, 4);
        drawEllipse(g, 110, 119, 15, 5);
        drawEllipse(g, 85, 114, 15, 3);
        drawEllipse(g, 51, 153, 13, 13);
        drawEllipse(g, 65, 137, 16, 13);
        drawEllipse(g, 132, 143, 12, 12);
        drawEllipse(g, 98, 144, 14, 13);
        drawEllipse(g, 117, 136, 9, 9);
        drawEllipse(g, 92, 137, 5, 5);
    }

    private static void drawLine(Graphics2D g, Point2D.Double aDouble, ArrayList<Point2D.Double> doubles) {
        Path2D p = new Path2D.Double();
        p.moveTo(aDouble.x,aDouble.y);
        for (Point2D.Double point:doubles) {
            p.lineTo(point.x, point.y);
        }
        g.draw(p);
    }
    
    

    public static void paintFlower(Graphics2D graphics2D) {
        Deque<AffineTransform> transformations = new LinkedList<>();

        graphics2D.setStroke(new BasicStroke(1f, 0, 0, 4));
        transformations.push(graphics2D.getTransform());
        graphics2D.transform(new AffineTransform(3.78f, 0, 0, 3.78f, 0, 5.77E-5f));
        transformations.push(graphics2D.getTransform());
        graphics2D.transform(new AffineTransform(1, 0, 0, 1, 7.56f, -130f));

        transformations.push(graphics2D.getTransform());
        graphics2D.transform(new AffineTransform(1, 0, 0, 1, 3f, -58.2f));

        drawLeaf(graphics2D, transformations, 0.38f, -0.12f, 0.12f, 0.4f, 12.62f, 180.88f);
        drawLeaf(graphics2D, transformations, 0.48f, 0.05f, -0.07f, 0.41f, 57.56f, 165.03f);
        drawLeaf(graphics2D, transformations, -0.18f, -0.14f, -0.11f, 0.27f, 146.43f, 201.5f);

        drawLeaf(graphics2D, transformations, -0.39f, -0.08f, -0.08f, 0.41f, 146f, 178f);
        drawLeaf(graphics2D, transformations, 0.39f, -0.08f, 0.08f, 0.41f, 30f, 181f);

        drawLeaf(graphics2D, transformations, 0.37f, -0.4f, 0.15f, 0.39f, 10.89f, 341.48f);
        drawLeaf(graphics2D, transformations, -0.37f, -0.4f, -0.14f, 0.39f, 177.02f, 300.22f);

        graphics2D.setTransform(transformations.pop());

        GeneralPath shape = new GeneralPath();
        shape.moveTo(62, 211);

        shape.lineTo(124, 212);
        shape.curveTo(124, 212, 107, 223, 102, 232);
        shape.curveTo(99, 238, 97, 246, 97, 253);
        shape.curveTo(97, 267, 103, 279, 105, 292);
        shape.curveTo(106, 304, 107, 316, 105, 327);
        shape.curveTo(104, 339, 95, 348, 95, 360);
        shape.curveTo(94, 371, 102, 393, 102, 393);

        shape.lineTo(96, 394);
        shape.curveTo(96, 394, 88, 373, 88, 361);
        shape.curveTo(89, 349, 98, 339, 99, 327);
        shape.curveTo(101, 316, 101, 304, 99, 293);
        shape.curveTo(98, 277, 95, 260, 90, 244);
        shape.curveTo(88, 239, 86, 233, 82, 228);
        shape.curveTo(77, 221, 62, 211, 62, 211);

        shape.closePath();

        graphics2D.setPaint(Color.WHITE);
        graphics2D.fill(shape);
        graphics2D.setPaint(Color.BLACK);
        graphics2D.draw(shape);

        graphics2D.setTransform(transformations.pop());
        graphics2D.setTransform(transformations.pop());
    }

    private static void drawLeaf(Graphics2D graphics2D, Deque<AffineTransform> transformations, float v, float v1, float v2, float v3, float v4, float v5) {
        Path2D.Double p = new Path2D.Double();


        p.moveTo(v, v1);
        graphics2D.draw(p);
        Ellipse2D.Double el = new Ellipse2D.Double(v2,v3,v4,v5);



        for (AffineTransform transform:transformations) {
            graphics2D.setTransform(transform);
        }
        graphics2D.draw(el);




    }

    public static void paintWine(Graphics2D g) {
        Deque<AffineTransform> transformations = WineUtils.init(g);

        transformations.push(g.getTransform());
        g.transform(new AffineTransform(0.27f, 0, 0, 0.27f, 0, 0));

        GeneralPath shape = new GeneralPath();
        shape.moveTo(271, 243);
        shape.lineTo(271, 400);
        shape.lineTo(209, 400);
        shape.curveTo(182, 400, 160, 421, 160, 448);
        shape.lineTo(160, 968);
        shape.curveTo(160, 995, 182, 1017, 209, 1017);
        shape.lineTo(426, 1019);
        shape.curveTo(453, 1017, 474, 995, 474, 968);
        shape.lineTo(474, 448);
        shape.curveTo(474, 421, 453, 400, 428, 400);
        shape.lineTo(367, 400);
        shape.lineTo(367, 243);
        shape.closePath();
        g.setPaint(Color.WHITE);
        g.fill(shape);
        g.setPaint(Color.BLACK);
        g.draw(shape);
        g.setTransform(transformations.pop());

        WineUtils.drawRectangle(g, Color.BLACK, 43.1, 173, 85.2, 15);
        WineUtils.drawRectangle(g, Color.BLACK, 43.1, 226, 85.2, 15);
        WineUtils.drawRoundRectangle(g, BLACK, 74, 51, 25, 15, 11, 11);
        WineUtils.postPaint(g, transformations);
    }
}
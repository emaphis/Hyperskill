abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double sp = getPerimeter() / 2.0;
        return Math.sqrt(sp * (sp - a) * (sp - b) * (sp - c));
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getPerimeter() {
        return 2.0 * (width + height);
    }

    @Override
    double getArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        System.out.println(circle.getPerimeter() + ", " + circle.getArea());

        Shape triangle = new Triangle(3, 4, 5);
        System.out.println(triangle.getPerimeter() + ", " + triangle.getArea());

        Shape rectangle = new Rectangle(5, 10);
        System.out.println(rectangle.getPerimeter() + ", " + rectangle.getArea());
    }
}
 */

abstract class Base { }

abstract class Abs extends Base {
    private static final int LEN = 10;
    private int i;
    private double d;

    public static int getLen() {
        return LEN;
    }

    public Abs(int i, double d) {
        this.i = i;
        this.d = d;
    }

    private double add() {
        return d + i;
    }
}
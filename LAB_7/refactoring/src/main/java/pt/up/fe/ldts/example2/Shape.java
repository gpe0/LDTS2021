package pt.up.fe.ldts.example2;


public abstract class Shape {

    protected double x;
    protected double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getArea() throws Exception {
        throw new Exception("Shape with no type");
    }

    public double getPerimeter() throws Exception {
        throw new Exception("Shape with no type");
    }

}

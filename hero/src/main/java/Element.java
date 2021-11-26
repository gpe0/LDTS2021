public abstract class Element {
    protected Position position;

    public Element() {
        this(0, 0);
    }

    public Element(int x, int y) {
        position = new Position(x, y);
    }

    public void draw() {

    }
}

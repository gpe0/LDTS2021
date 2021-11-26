import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroTest {
    @Test
    public void testConstructor() {
        Hero hero = new Hero(2, 2);
        Position expected = new Position(2, 2);
        Assertions.assertEquals(expected, hero.getPosition());
    }

    @Test
    public void testSetPosition() {
        Hero hero = new Hero(1, 1);
        hero.setPosition(new Position(2, 2));
        Position expected = new Position(2, 2);
        Assertions.assertEquals(expected, hero.getPosition());
    }

    @Test
    public void testMoveUp() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveUp();
        Position expected = new Position(2, 1);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void testMoveDown() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveDown();
        Position expected = new Position(2, 3);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void testMoveRight() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveRight();
        Position expected = new Position(3, 2);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void testMoveLeft() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveLeft();
        Position expected = new Position(1, 2);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void testDraw() {
        Hero hero = new Hero(2, 2);

    }
}

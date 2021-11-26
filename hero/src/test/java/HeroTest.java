import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroTest {
    @Test
    public void test1() {
        Hero hero = new Hero(2, 2);
        Position expected = new Position(2, 2);
        Assertions.assertEquals(expected, hero.getPosition());
    }

    @Test
    public void test2() {
        Hero hero = new Hero(1, 1);
        hero.setPosition(new Position(2, 2));
        Position expected = new Position(2, 2);
        Assertions.assertEquals(expected, hero.getPosition());
    }

    @Test
    public void test3() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveUp();
        Position expected = new Position(2, 1);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void test4() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveDown();
        Position expected = new Position(2, 3);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void test5() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveRight();
        Position expected = new Position(3, 2);
        Assertions.assertEquals(expected, pos);
    }

    @Test
    public void test6() {
        Hero hero = new Hero(2, 2);
        Position pos = hero.moveLeft();
        Position expected = new Position(1, 2);
        Assertions.assertEquals(expected, pos);
    }
}

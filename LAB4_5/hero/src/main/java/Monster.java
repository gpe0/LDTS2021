import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    public Monster() {
        this(0, 0);
    }

    public  Monster(int x, int y) {
        super(x, y);
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move() {
        Random random = new Random();

        int x = random.nextInt(3) - 1;
        int y = random.nextInt(3) - 1;

        return new Position(position.getX() + x, position.getY() + y);
    }

}

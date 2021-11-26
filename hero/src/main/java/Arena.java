import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena() {
        this(40, 20);
    }

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        hero = new Hero(10, 10);

        this.walls = createWalls();

        this.coins = createCoins();

        this.monsters = createMonsters();
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        } else if (key.getKeyType() == KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        } else if (key.getKeyType() == KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        } else if (key.getKeyType() == KeyType.ArrowRight) {
            moveHero(hero.moveRight());
        }

        moveMonsters();
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
            retrieveCoins(position);
        }
    }

    public void draw(TextGraphics graphics) throws IOException {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Wall wall : walls) {
            wall.draw(graphics);
        }

        for (Coin coin : coins) {
            coin.draw(graphics);
        }

        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height && !hasWall(position)) {
            return true;
        }
        return false;

    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }


    private boolean hasWall(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    private void retrieveCoins(Position position) {
        for (Coin coin : coins) {
            if (position.equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            Position pos = monster.move();
            if (verifyMonsterCollisions(pos)) {
                monster.setPosition(pos);
            }
        }
    }

    private boolean verifyMonsterCollisions(Position position) {
        if (position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height && !hasWall(position)) {
            return true;
        }
        return false;
    }

    public boolean isPlayerDead() {
        for (Monster monster : monsters) {

            if (hero.getPosition().equals(monster.getPosition())) {
                System.out.println("LOST");
                return true;
            }
        }
        return false;
    }
}


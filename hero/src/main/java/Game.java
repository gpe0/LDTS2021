import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private Terminal terminal;
    private Screen screen;
    private Arena arena;
    public Game() throws IOException{
            //Terminal terminal = new DefaultTerminalFactory().createTerminal();
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            this.terminal = terminalFactory.createTerminal();


            this.screen = new TerminalScreen(terminal);



            screen.setCursorPosition(null);

            screen.startScreen();

            screen.doResizeIfNecessary();


            arena = new Arena();

    }
    private void draw() throws IOException{

        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();

    }

    private void processKey(KeyStroke key) {

        arena.processKey(key);

    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
            }
            else if (key.getKeyType() == KeyType.EOF || arena.isPlayerDead()) {
                screen.close();
                break;

            }
            processKey(key);
        }
    }


}

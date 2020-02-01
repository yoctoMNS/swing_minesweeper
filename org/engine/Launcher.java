package org.engine;

import org.display.Display;

public class Launcher {
    public static final String TITLE = "マインスイーパ";
    public static final int SCREEN_WIDTH = Display.DRAW_TEXTURE_WIDTH * 10;
    public static final int SCREEN_HEIGHT = Display.DRAW_TEXTURE_HEIGHT * 10;

    public static void main( String... args ) {
        GameManager game = new GameManager( TITLE, SCREEN_WIDTH, SCREEN_HEIGHT );
        game.start();
    }
}

package org.engine;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.entity.Cursor;
import org.display.Display;
import org.stage.Stage;
import org.states.State;
import org.states.GameOverState;
import org.states.GameState;
import org.states.MenuState;

public class GameManager implements Runnable {
    private boolean running;
    private boolean gameOver;
    private Thread gameThread;
    private Display display;
    private Stage stage;
    private Cursor cursor;
    private BufferStrategy bs;
    private Graphics g;
    private State state;
    private GameState gameState;
    private MenuState menuState;
    private GameOverState gameOverState;

    private void init() {
        org.graphics.Assets.init();
        cursor = new Cursor( this, 0, 0, Display.DRAW_TEXTURE_WIDTH, Display.DRAW_TEXTURE_HEIGHT );
        stage = new Stage( this );
        gameState = new GameState( this );
        gameOverState = new GameOverState( this );
        menuState = new MenuState( this );
        state = gameState;
        display = new Display( this, "マインスイーパ", Display.DRAW_TEXTURE_WIDTH * 10, Display.DRAW_TEXTURE_HEIGHT * 10 );
    }

    public synchronized void start() {
        if ( running ) {
            return;
        }

        running = true;
        gameThread = new Thread( this );
        gameThread.setName( "Game Thread" );
        gameThread.start();
    }

    public synchronized void stop() {
        if ( !running ) {
            return;
        }

        running = false;
        try {
            gameThread.join();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if ( bs == null ) {
            display.getCanvas().createBufferStrategy( 3 );
            return;
        }

        g = bs.getDrawGraphics();

        state.render( g );

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        while ( running ) {
            render();
        }

        stop();
    }

    public boolean isRunning() {
        return running;
    }

    public void setGameOver( boolean b ) {
        gameOver = b;
        if ( b ) {
            state = gameOverState;
        }
    }

    public void reset() {
        stage.reset();
        state = gameState;
    }
 
    public boolean isGameOver() {
        return gameOver;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public Stage getStage() {
        return stage;
    }

    public State getState() {
        return state;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState() {
        state = gameState;
    }

    public GameOverState getGameOverState() {
        return gameOverState;
    }

    public void setGameOverState() {
        state = gameOverState;
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public void setMenuState() {
        state = menuState;
    }

    public Display getDisplay() {
        return display;
    }
}

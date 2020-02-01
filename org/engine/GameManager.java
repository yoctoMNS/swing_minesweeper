package org.engine;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.entity.Cursor;
import org.event.KeyboardManager;
import org.event.MouseManager;
import org.display.Display;
import org.stage.Stage;
import org.states.State;
import org.states.GameOverState;
import org.states.GameState;
import org.states.MenuState;

public class GameManager implements Runnable {
    private String title;
    private int width;
    private int height;
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
    private KeyboardManager keyboardManager;
    private MouseManager mouseManager;

    public GameManager( String title, int width, int height ) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        org.graphics.Assets.init();
        gameState = new GameState( this );
        gameOverState = new GameOverState( this );
        menuState = new MenuState( this );
        cursor = new Cursor( this, 0, 0, Display.DRAW_TEXTURE_WIDTH, Display.DRAW_TEXTURE_HEIGHT );
        state = gameState;
        stage = new Stage( this );
        keyboardManager = new KeyboardManager( this );
        mouseManager = new MouseManager( this, cursor, stage );
        display = new Display( this, title, width, height );
        display.getFrame().addKeyListener( keyboardManager );
        display.getFrame().addMouseMotionListener( mouseManager );
        display.getFrame().addMouseListener( mouseManager );
        display.getCanvas().addKeyListener( keyboardManager );
        display.getCanvas().addMouseMotionListener( mouseManager );
        display.getCanvas().addMouseListener( mouseManager );
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
        display.getFrame().dispose();
        System.exit( 0 );
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

        int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

        while ( running ) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
 
            if ( delta >= 1 ) {
                render();
                ++ticks;
                --delta;
            }

            if ( timer >= 1000000000 ) {
                display.getFrame().setTitle( title + "  " + ticks + "FPS" );
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public boolean isRunning() {
        return running;
    }

    public void exit() {
        stop();
    }

    public void setGameOver( boolean b ) {
        gameOver = b;
        if ( b ) {
            state = gameOverState;
        }
    }

    public void reset() {
        stage.reset();
        setGameOver( false );
        state = gameState;
    }
 
    public boolean isGameOver() {
        return gameOver;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

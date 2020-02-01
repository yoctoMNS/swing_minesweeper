package org.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import org.engine.GameManager;
import org.entity.Cursor;
import org.display.Display;
import org.stage.Stage;
import org.ui.button.Button;

public class MouseManager extends MouseAdapter {
    private GameManager game;
    private Cursor cursor;
    private Stage stage;

    public MouseManager( GameManager game, Cursor cursor, Stage stage ) {
        this.game = game;
        this.cursor = cursor;
        this.stage = stage;
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        int x = e.getX() / Display.DRAW_TEXTURE_WIDTH;
        int y = e.getY() / Display.DRAW_TEXTURE_HEIGHT;
        if ( game.getState().equals( game.getGameState() ) ) {
            stage.open( x, y );
        }

        for ( Button button : game.getState().getButtons() ) {
            if ( button.isFocus( e.getX(), e.getY() ) ) {
                button.click();
            }
        }
    }

    @Override
    public void mouseMoved( MouseEvent e ) {
        cursor.update( e );
    }
}

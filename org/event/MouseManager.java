package org.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import org.engine.GameManager;
import org.entity.Cursor;
import org.display.Display;
import org.stage.Stage;
import org.states.State;
import org.ui.button.Button;

public class MouseManager extends MouseAdapter {
    private GameManager game;
    private Cursor cursor;
    private Stage stage;
    private State currentState;

    public MouseManager( GameManager game ) {
        this.game = game;
        cursor = game.getCursor();
        stage = game.getStage();
        currentState = game.getState();
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        int x = e.getX() / Display.DRAW_TEXTURE_WIDTH;
        int y = e.getY() / Display.DRAW_TEXTURE_HEIGHT;
        if ( game.getState().equals( game.getGameState() ) ) {
            stage.open( x, y );
        }

        // FIXME
        System.out.println( currentState );
        // for ( Button button : currentState.getButtons() ) {
        //     if ( button.isFocus( x, y ) ) {
        //         button.click();
        //     }
        // }
    }

    @Override
    public void mouseMoved( MouseEvent e ) {
        cursor.update( e );
    }
}

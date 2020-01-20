package org.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import org.engine.GameManager;
import org.entity.Cursor;
import org.display.Display;
import org.stage.Stage;

public class MouseManager extends MouseAdapter {
    private GameManager game;
    private Cursor cursor;
    private Stage stage;

    public MouseManager( GameManager game ) {
        this.game = game;
        cursor = game.getCursor();
        stage = game.getStage();
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        int x = e.getX() / Display.DRAW_TEXTURE_WIDTH;
        int y = e.getY() / Display.DRAW_TEXTURE_HEIGHT;
        stage.open( x, y );
    }

    @Override
    public void mouseMoved( MouseEvent e ) {
        cursor.update( e );
    }
}

package org.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.engine.GameManager;
import org.display.Display;

public class Cursor extends Entity {
    private Color currentColor;

    public Cursor( GameManager game, int x, int y, int width, int height ) {
        super( game, x, y, width, height );
        currentColor = new Color( 255, 255, 0, 60 );
    }

    @Override
    public void render( Graphics g ) {
        g.setColor( currentColor );
        g.fillRect( x, y, width, height );
    }

    @Override
    public void update( MouseEvent e ) {
        x = ( e.getX() / Display.DRAW_TEXTURE_WIDTH ) * Display.DRAW_TEXTURE_WIDTH;
        y = ( e.getY() / Display.DRAW_TEXTURE_HEIGHT ) * Display.DRAW_TEXTURE_WIDTH;
    }
}

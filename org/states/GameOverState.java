package org.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.engine.GameManager;

public class GameOverState extends State {
    public GameOverState( GameManager game ) {
        super( game );
    }

    @Override
    public void render( Graphics g ) {
        int screenWidth = game.getDisplay().getCanvas().getWidth();
        int screenHeight = game.getDisplay().getCanvas().getHeight();

        game.getStage().render( g );
        g.setColor( new Color( 1.0f, 1.0f, 1.0f, 0.5f ) );
        g.fillRect( 0, 0, screenWidth,  screenHeight);
        g.setColor( Color.black );

        String str = "Game Over";

        // FIXME
        g.drawString( str,
                      ( screenWidth / 2 ) - 20,
                      ( screenHeight / 2 ) - 10 );
    }

    @Override
    public void update( MouseEvent e ) {
    }
}

package org.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.engine.GameManager;
import org.graphics.Assets;
import org.ui.button.Button;
import org.ui.button.ResetButton;
import org.ui.button.ExitButton;

public class GameOverState extends State {

    public GameOverState( GameManager game ) {
        super( game );
        buttons.add( new ResetButton( game,
                         ( game.getWidth() / 2 ) - ( Assets.BUTTON_WIDTH * 10 / 2 ), ( game.getHeight() / 2 ) - ( game.getHeight() / 3 ),
                         Assets.BUTTON_WIDTH * 10, Assets.BUTTON_HEIGHT * 10,
                         Assets.resetButton ) );
        buttons.add( new ExitButton( game,
                                     ( game.getWidth() / 2 ) - ( Assets.BUTTON_WIDTH * 10 / 2 ), ( game.getHeight() / 2 ) + ( game.getHeight() / 5 ),
                                     Assets.BUTTON_WIDTH * 10, Assets.BUTTON_HEIGHT * 10,
                                     Assets.exitButton ) );
    }

    @Override
    public void render( Graphics g ) {
        int screenWidth = game.getWidth();
        int screenHeight = game.getHeight();

        game.getStage().render( g );
        g.setColor( new Color( 1.0f, 1.0f, 1.0f, 0.5f ) );
        g.fillRect( 0, 0, screenWidth,  screenHeight);

        for ( Button b : buttons ) {
            b.render( g );
        }
    }

    @Override
    public void update( MouseEvent e ) {
    }
}

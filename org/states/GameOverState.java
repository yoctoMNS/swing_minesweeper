package org.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.engine.GameManager;

public class GameOverState extends State {
    public GameOverState( GameManager game ) {
        super( game );
    }

    @Override
    public void render( Graphics g ) {
        game.getStage().render( g );
    }

    @Override
    public void update( MouseEvent e ) {
    }
}

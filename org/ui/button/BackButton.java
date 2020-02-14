package org.ui.button;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.engine.GameManager;

public class BackButton extends Button {
    public BackButton( GameManager game, int x, int y, int width, int height, BufferedImage image ) {
        super( game, x, y, width, height, image );
    }

    @Override
    public void click() {
        if ( game.getState().equals( game.getMenuState() ) ) {
            game.setGameState();
        }
    }
}

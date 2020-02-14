package org.ui.button;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.engine.GameManager;

public class ResetButton extends Button {
    public ResetButton( GameManager game, int x, int y, int width, int height, BufferedImage image ) {
        super( game, x, y, width, height, image );
    }

    @Override
    public void click() {
        game.reset();
    }
}

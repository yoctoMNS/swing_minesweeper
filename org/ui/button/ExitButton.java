package org.ui.button;

import java.awt.image.BufferedImage;

import org.engine.GameManager;

public class ExitButton extends Button {
    public ExitButton( GameManager game, int x, int y, int width, int height, BufferedImage image ) {
        super( game, x, y, width, height, image );
    }

    @Override
    public void click() {
        game.exit();
    }
}

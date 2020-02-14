package org.ui.button;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.engine.GameManager;
import org.ui.UI;

public abstract class Button extends UI {
    public Button( GameManager game, int x, int y, int width, int height, BufferedImage image ) {
        super( game, x, y, width, height, image );
    }

    public boolean isFocus( int x, int y ) {
        return bounds.contains( x, y );
    }

    public abstract void click();

    @Override
    public void render( Graphics g ) {
        g.drawImage( image, x, y, width, height, null );
    }
}

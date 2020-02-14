package org.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.engine.GameManager;

public abstract class UI {
    protected GameManager game;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Rectangle bounds;
    protected BufferedImage image;

    public UI( GameManager game, int x, int y, int width, int height, BufferedImage image ) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;

        bounds = new Rectangle( x, y, width, height );
    }

    public abstract void render( Graphics g );

    public void setX( int x ) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY( int y ) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setWidth( int width ) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setheight( int height ) {
        this.height = height;
    }

    public int getheight() {
        return height;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}

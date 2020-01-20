package org.entity;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.engine.GameManager;

public abstract class Entity {
    protected GameManager game;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Entity( GameManager game, int x, int y, int width, int height ) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void render( Graphics g );

    public abstract void update( MouseEvent e );

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
        return this.y = y;
    }

    public void setWidth( int width ) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight( int height ) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}

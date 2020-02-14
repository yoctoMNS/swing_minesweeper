package org.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.engine.GameManager;

public class KeyboardManager implements KeyListener {
    private GameManager game;

    public KeyboardManager( GameManager game ) {
        this.game = game;
    }

    @Override
    public void keyPressed( KeyEvent e ) {
        switch ( e.getKeyCode() ) {
        case KeyEvent.VK_P:
            game.setMenuState();
            break;
        }
    }

    @Override
    public void keyReleased( KeyEvent e ) {
    }

    @Override
    public void keyTyped( KeyEvent e ) {
    }
}

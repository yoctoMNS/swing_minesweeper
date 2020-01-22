package org.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.engine.GameManager;

public abstract class State {
    public static State currentState;
    protected GameManager game;

    public State( GameManager game ) {
        this.game = game;
    }

    public abstract void render( Graphics g );

    public abstract void update( MouseEvent e );

    public void setCurrentState( State state ) {
        currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }

    public GameManager getGameManager() {
        return game;
    }
}

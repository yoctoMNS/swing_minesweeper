package org.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

import org.engine.GameManager;
import org.ui.button.Button;

public abstract class State {
    public static State currentState;
    protected GameManager game;
    List< Button > buttons;

    public State( GameManager game ) {
        this.game = game;
        buttons = new ArrayList<>();
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

    public List< Button > getButtons() {
        return buttons;
    }
}

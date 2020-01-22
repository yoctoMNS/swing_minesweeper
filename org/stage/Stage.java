package org.stage;

import java.awt.Graphics;
import java.util.Random;

import org.engine.GameManager;
import org.graphics.Assets;
import org.display.Display;

public class Stage {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    public static final int NONE = 0;
    public static final int BOMB = 1;
    public static final int OPEN = 2;

    private GameManager game;
    private Random random;
    private int[][] data;

    public Stage( GameManager game ) {
        this.game = game;
        random = new Random();
        buildStage();
    }

    private void buildStage() {
        data = new int[ HEIGHT ][ WIDTH ];
        putBombs();
    }

    private void putBombs() {
        for ( int i = 0; i < HEIGHT; ++i ) {
            for ( int j = 0; j < WIDTH; ++j ) {
                if ( random.nextInt( 100 ) < 20 ) {
                    data[ i ][ j ] = BOMB;
                } else {
                    data[ i ][ j ] = NONE;
                }
            }
        }
    }

    public void open( int x, int y ) {
        if ( canOpenCell( x, y ) ) {
            if ( isBombCell( x, y ) ) {
                game.setGameOver( true );
            } else {
                setStageCell( x, y, OPEN );
            }
        }
    }

    private int countBombs( int x, int y ) {
        int cnt = 0;

        for ( int i = -1; i <= 1; ++i ) {
            for ( int j = -1; j <= 1; ++j ) {
                if ( isOutOfStage( x + j, y + i ) ) {
                    continue;
                }

                if ( isBombCell( x + j, y + i ) ) {
                    ++cnt;
                }
            }
        }

        return cnt;
    }

    public boolean isBombCell( int x, int y ) {
        return data[ y ][ x ] == BOMB;
    }

    public boolean isOutOfStage( int x, int y ) {
        return ( x < 0 || x >= WIDTH ) ||
               ( y < 0 || y >= HEIGHT );
    }

    public boolean isNoneCell( int x, int y ) {
        return data[ y ][ x ] == NONE;
    }

    public boolean canOpenCell( int x, int y ) {
        return isNoneCell( x, y ) || isBombCell( x, y );
    }

    public void render( Graphics g ) {
        for ( int i = 0; i < HEIGHT; ++i ) {
            for ( int j = 0; j < WIDTH; ++j ) {
                switch ( data[ i ][ j ] ) {
                case NONE:
                    g.drawImage( Assets.noneCell,
                                 Display.DRAW_TEXTURE_WIDTH * j, Display.DRAW_TEXTURE_HEIGHT * i,
                                 Display.DRAW_TEXTURE_WIDTH, Display.DRAW_TEXTURE_HEIGHT,
                                 null );
                    break;

                case BOMB:
                    g.drawImage( game.isGameOver() ? Assets.bombCell : Assets.noneCell,
                                 Display.DRAW_TEXTURE_WIDTH * j, Display.DRAW_TEXTURE_HEIGHT * i,
                                 Display.DRAW_TEXTURE_WIDTH, Display.DRAW_TEXTURE_HEIGHT,
                                 null );
                    break;

                case OPEN:
                    g.drawImage( Assets.openCell[ countBombs( j, i ) ],
                                 Display.DRAW_TEXTURE_WIDTH * j, Display.DRAW_TEXTURE_HEIGHT * i,
                                 Display.DRAW_TEXTURE_WIDTH, Display.DRAW_TEXTURE_HEIGHT,
                                 null );
                    break;
                }
            }
        }
    }

    public void setStageCell( int x, int y, int value ) {
        data[ y ][ x ] = value;
    }

    public int getStageCell( int x, int y ) {
        return data[ y ][ x ];
    }
}

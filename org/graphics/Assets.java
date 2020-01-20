package org.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static final int TEXTURE_WIDTH = 10;
    public static final int TEXTURE_HEIGHT = 10;

    public static BufferedImage noneCell;
    public static BufferedImage bombCell;
    public static BufferedImage[] openCell;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet( ImageLoader.loadImage( "/res/texture/textures.png" ) );
        openCell = new BufferedImage[ 9 ];

        noneCell = sheet.crop( TEXTURE_WIDTH * 10, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT );
        bombCell = sheet.crop( TEXTURE_WIDTH * 9, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT );

        for ( int i = 0; i < openCell.length; ++i ) {
            openCell[ i ] = sheet.crop( TEXTURE_WIDTH * i, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT );
        }
    }
}

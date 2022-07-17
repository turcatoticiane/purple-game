package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Coin extends GameObject {
    private Picture picture;

    public Coin(int var1, int var2) {
        this.picture = new Picture((double)var1, (double)var2, "resources/Coin.png");
        this.posX = var1;
        this.posY = var2;
    }

    public Picture getPicture() {
        return this.picture;
    }
}

package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sword extends GameObject {
    private Picture picture;

    public Sword(int var1, int var2) {
        this.picture = new Picture((double)var1, (double)var2, "resources/Sword.png");
        this.posX = var1;
        this.posY = var2;
    }

    public Picture getPicture() {
        return this.picture;
    }
}

package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pistol extends GameObject {
    private Picture picture;

    public Pistol(int var1, int var2) {
        this.picture = new Picture((double)var1, (double)var2, "resources/Pistol.png");
        this.posX = var1;
        this.posY = var2;
    }

    public Picture getPicture() {
        return this.picture;
    }
}

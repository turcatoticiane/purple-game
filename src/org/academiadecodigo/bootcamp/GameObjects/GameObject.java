package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {
    Picture picture;
    Grid grid;
    GameObject gameObjects;
    boolean active = true;
    int posX;
    int posY;

    public GameObject() {
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean var1) {
        this.active = var1;
    }

    public void setPicture(Picture var1) {
        this.picture = var1;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public void deleteObject() {
        this.gameObjects = null;
    }
}

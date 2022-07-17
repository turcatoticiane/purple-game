package org.academiadecodigo.bootcamp.GameObjects.Players;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player extends GameObject implements KeyboardHandler, Runnable {
    private Picture picture;
    private int posX;
    private int posY;
    private boolean walk;
    private Grid grid;
    private Keyboard keyboard;

    public Player() {
    }

    public void init() {
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int changeXtoCol(int var1) {
        return (var1 - this.grid.getPADDING()) / this.grid.getCellSize();
    }

    public int changeYtoRow(int var1) {
        return (var1 - this.grid.getPADDING()) / this.grid.getCellSize();
    }

    public int changeColToX(int var1) {
        return var1 * this.grid.getCellSize() + this.grid.getPADDING();
    }

    public int changeRowToY(int var1) {
        return var1 * this.grid.getCellSize() + this.grid.getPADDING() + this.grid.getTitleSpace();
    }
}

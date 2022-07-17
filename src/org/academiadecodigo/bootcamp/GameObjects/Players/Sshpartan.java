package org.academiadecodigo.bootcamp.GameObjects.Players;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Menu;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sshpartan extends Player {
    private Sound sound;
    private Picture picture;
    private int posX;
    private int posY;
    private boolean walk = true;
    private Grid grid;
    private GameObject[][] gridObjects;
    private Keyboard keyboard;
    private CollisionDetector collisionDetector;
    private Menu menu;

    public Sshpartan(Grid var1, Menu var2) {
        this.grid = var1;
        this.menu = var2;
        this.picture = new Picture((double)(var1.getScreenWidth() + var1.getPADDING() - 2 * var1.getCellSize()), (double)(var1.getScreenHeight() + var1.getPADDING() + var1.getTitleSpace() - 2 * var1.getCellSize()), "resources/SpartanDown.png");
        this.posX = this.picture.getX();
        this.posY = this.picture.getY();
        this.keyboard = new Keyboard(this);
        this.init();
        this.collisionDetector = new CollisionDetector(this, var1, var2);
    }

    public synchronized void run() {
        this.picture.draw();
    }

    public void init() {
        KeyboardEvent var1 = new KeyboardEvent();
        var1.setKey(39);
        var1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var1);
        KeyboardEvent var2 = new KeyboardEvent();
        var2.setKey(37);
        var2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var2);
        KeyboardEvent var3 = new KeyboardEvent();
        var3.setKey(38);
        var3.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var3);
        KeyboardEvent var4 = new KeyboardEvent();
        var4.setKey(40);
        var4.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var4);
    }

    public void keyPressed(KeyboardEvent var1) {
    }

    public void keyReleased(KeyboardEvent var1) {
        Sound var2 = new Sound("/resources/sounds/Single-footstep-in-grass.wav");
        int var3 = (this.picture.getY() - this.grid.getPADDING()) / this.grid.getCellSize();
        int var4 = (this.picture.getX() - this.grid.getPADDING()) / this.grid.getCellSize();
        if (var1.getKey() == 37) {
            this.picture.load("resources/SpartanLeft.png");
            if (!this.collisionDetector.checkWallLeft(var3, var4)) {
                var2.play(true);
                this.picture.translate((double)(-this.grid.getCellSize()), 0.0);
                this.collisionDetector.checkSpartanCollision(var3, var4);
            }
        } else {
            this.picture.translate(0.0, 0.0);
        }

        if (var1.getKey() == 39) {
            this.picture.load("resources/SpartanRight.png");
            if (!this.collisionDetector.checkWallRight(var3, var4)) {
                var2.play(true);
                this.picture.translate((double)this.grid.getCellSize(), 0.0);
                this.collisionDetector.checkSpartanCollision(var3, var4);
            }
        } else {
            this.picture.translate(0.0, 0.0);
        }

        if (var1.getKey() == 38) {
            this.picture.load("resources/SpartanUp.png");
            if (!this.collisionDetector.checkWallUp(var3, var4)) {
                var2.play(true);
                this.picture.translate(0.0, (double)(-this.grid.getCellSize()));
                this.collisionDetector.checkSpartanCollision(var3, var4);
            }
        } else {
            this.picture.translate(0.0, 0.0);
        }

        if (var1.getKey() == 40) {
            this.picture.load("resources/SpartanDown.png");
            if (!this.collisionDetector.checkWallDown(var3, var4)) {
                var2.play(true);
                this.picture.translate(0.0, (double)this.grid.getCellSize());
                this.collisionDetector.checkSpartanCollision(var3, var4);
            }
        } else {
            this.picture.translate(0.0, 0.0);
        }

    }
}
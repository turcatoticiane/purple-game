package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Players.Player;
import org.academiadecodigo.bootcamp.GameObjects.Players.Shellby;
import org.academiadecodigo.bootcamp.GameObjects.Players.Sshpartan;
import org.academiadecodigo.bootcamp.Grid.Grid;

public class Game {
    private Grid grid;
    private Player spartan;
    private Player shellby;
    private Sound sound = new Sound("/resources/sounds/GameOfThronesSound.wav");
    private CollisionDetector collisionDetector;
    private Menu menu;

    public Game(int var1, int var2) {
        this.grid = new Grid(var1, var2);
        this.menu = new Menu(this.grid, this);
        this.spartan = new Sshpartan(this.grid, this.menu);
        this.shellby = new Shellby(this.grid, this.menu);
    }

    public void init() {
        this.sound.play(true);
        this.menu.run();
    }

    public void loadGame() {
        this.grid.run();
        this.spartan.run();
        this.shellby.run();
        this.collisionDetector.shellbyInit();
        this.collisionDetector.sshpartanInit();
    }

}

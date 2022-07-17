package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.GameObjects.Pistol;
import org.academiadecodigo.bootcamp.GameObjects.Sword;
import org.academiadecodigo.bootcamp.GameObjects.Wall;
import org.academiadecodigo.bootcamp.GameObjects.Players.Player;
import org.academiadecodigo.bootcamp.GameObjects.Players.Shellby;
import org.academiadecodigo.bootcamp.GameObjects.Players.Sshpartan;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.Grid.CellFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class CollisionDetector {
    private Text shellbyTxt;
    private Text sshpartanTxt;
    private Player player;
    private Text sshpartanTxtTitle;
    private Integer shpartanCoin = 0;
    private Text shellbyTxtTitle;
    private Integer shellbyCoin = 0;
    private Grid grid;
    private Sound sound;
    private Menu menu;

    public Integer getShpartanCoin() {
        return this.shpartanCoin;
    }

    public Integer getShellbyCoin() {
        return this.shellbyCoin;
    }

    public CollisionDetector(Player player, Grid grid, Menu menu) {
        this.player = player;
        this.grid = grid;
        this.menu = menu;
        if (player instanceof Sshpartan) {
            this.sshpartanTxtTitle = new Text(1042.0, 30.0, "SSHPARTAN: ");
            this.sshpartanTxt = new Text(1200.0, 30.0, this.shpartanCoin.toString());
            this.sshpartanInit();
        }

        if (player instanceof Shellby) {
            this.shellbyTxtTitle = new Text(52.0, 30.0, "SHELLBY: ");
            this.shellbyTxt = new Text(182.0, 30.0, this.shellbyCoin.toString());
            this.shellbyInit();
        }

    }

    public void shellbyInit() {
        this.shellbyTxtTitle.setColor(Color.BLUE);
        this.shellbyTxtTitle.grow(30.0, 15.0);
        this.shellbyTxt.grow(30.0, 15.0);
        this.shellbyTxtTitle.draw();
        this.shellbyTxt.setColor(Color.BLUE);
    }

    public void sshpartanInit() {
        this.sshpartanTxtTitle.setColor(Color.BLUE);
        this.sshpartanTxtTitle.grow(40.0, 15.0);
        this.sshpartanTxt.grow(35.0, 15.0);
        this.sshpartanTxtTitle.draw();
        this.sshpartanTxt.setColor(Color.BLUE);
    }

    public void checkSpartanCollision(int var1, int var2) {
        GameObject gameObject = this.grid.getGameObjects(var1, var2);
        if (gameObject != null && gameObject.isActive()) {
            if (gameObject instanceof Pistol) {
                this.sound = new Sound("/resources/sounds/shotGunSound.wav");
                this.sound.play(true);
                this.shpartanCoin = this.shpartanCoin - 20;
                --CellFactory.pistolCounter;
                this.sshpartanTxt.delete();
                this.sshpartanTxt.setText(this.shpartanCoin.toString());
                this.sshpartanTxt.draw();
                gameObject.getPicture().delete();
                gameObject.setActive(false);
                if (CellFactory.pistolCounter == 0 || CellFactory.swordCounter == 0) {
                    if (this.shpartanCoin > this.shellbyCoin) {
                        this.menu.setSpartanVictoryDrawStatus(true);
                        this.menu.drawSpartanVictory();
                    }

                    if (this.shpartanCoin < this.shellbyCoin) {
                        this.menu.setShellbyVictoryDrawStatus(true);
                        this.menu.drawShellbyVictory();
                    }
                }
            }

            if (gameObject instanceof Sword) {
                this.sound = new Sound("/resources/sounds/swordSound.wav");
                this.sound.play(true);
                this.shpartanCoin = this.shpartanCoin + 20;
                --CellFactory.swordCounter;
                this.sshpartanTxt.delete();
                this.sshpartanTxt.setText(this.shpartanCoin.toString());
                this.sshpartanTxt.draw();
                gameObject.getPicture().delete();
                gameObject.setActive(false);
                if (CellFactory.pistolCounter == 0 || CellFactory.swordCounter == 0) {
                    if (this.shpartanCoin < this.shellbyCoin) {
                        this.menu.setShellbyVictoryDrawStatus(true);
                        this.menu.drawShellbyVictory();
                    }

                    if (this.shpartanCoin > this.shellbyCoin) {
                        this.menu.setSpartanVictoryDrawStatus(true);
                        this.menu.drawSpartanVictory();
                    }
                }
            }
        }

    }

    public void checkShellbyCollision(int var1, int var2) {
        GameObject var3 = this.grid.getGameObjects(var1, var2);
        if (var3 != null && var3.isActive()) {
            if (var3 instanceof Pistol) {
                this.sound = new Sound("/resources/sounds/shotGunSound.wav");
                this.sound.play(true);
                this.shellbyCoin = this.shellbyCoin + 20;
                --CellFactory.pistolCounter;
                this.shellbyTxt.delete();
                this.shellbyTxt.setText(this.shellbyCoin.toString());
                this.shellbyTxt.draw();
                var3.getPicture().delete();
                var3.setActive(false);
                if (CellFactory.pistolCounter == 0 || CellFactory.swordCounter == 0) {
                    if (this.shpartanCoin > this.shellbyCoin) {
                        this.sound.play(false);
                        this.menu.setSpartanVictoryDrawStatus(true);
                        this.menu.drawSpartanVictory();
                    }

                    if (this.shpartanCoin < this.shellbyCoin) {
                        this.menu.setShellbyVictoryDrawStatus(true);
                        this.menu.drawShellbyVictory();
                    }
                }
            }

            if (var3 instanceof Sword) {
                this.sound = new Sound("/resources/sounds/swordSound.wav");
                this.sound.play(true);
                this.shellbyCoin = this.shellbyCoin - 20;
                --CellFactory.swordCounter;
                this.shellbyTxt.delete();
                this.shellbyTxt.setText(this.shellbyCoin.toString());
                this.shellbyTxt.draw();
                var3.getPicture().delete();
                var3.setActive(false);
                if (CellFactory.pistolCounter == 0 || CellFactory.swordCounter == 0) {
                    if (this.shpartanCoin > this.shellbyCoin) {
                        this.sound.play(false);
                        this.menu.setSpartanVictoryDrawStatus(true);
                        this.menu.drawSpartanVictory();
                    }

                    if (this.shpartanCoin < this.shellbyCoin) {
                        this.menu.setShellbyVictoryDrawStatus(true);
                        this.menu.drawShellbyVictory();
                    }
                }
            }
        }

    }

    public boolean checkWallUp(int var1, int var2) {
        return this.grid.getGameObjects(var1 - 1, var2) instanceof Wall;
    }

    public boolean checkWallDown(int var1, int var2) {
        return this.grid.getGameObjects(var1 + 1, var2) instanceof Wall;
    }

    public boolean checkWallLeft(int var1, int var2) {
        return this.grid.getGameObjects(var1, var2 - 1) instanceof Wall;
    }

    public boolean checkWallRight(int var1, int var2) {
        return this.grid.getGameObjects(var1, var2 + 1) instanceof Wall;
    }
}

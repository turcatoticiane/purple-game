package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {
    private Picture mainMenu;
    private Picture guideMenu;
    private Picture spartanVictory;
    private Picture shellbyVictory;
    private Keyboard keyboard;
    private Game game;
    private boolean mainMenuDrawStatus = false;
    private boolean guideMenuDrawStatus = false;
    private boolean spartanVictoryDrawStatus = false;
    private boolean shellbyVictoryDrawStatus = false;
    private boolean gameStart;

    public Menu(Grid var1, Game var2) {
        this.mainMenu = new Picture((double)var1.getPADDING(), (double)var1.getPADDING(), "resources/mainMenu.png");
        this.guideMenu = new Picture((double)var1.getPADDING(), (double)var1.getPADDING(), "resources/guideMenu.png");
        this.spartanVictory = new Picture((double)var1.getPADDING(), (double)var1.getPADDING(), "resources/sshpartanVictory.png");
        this.shellbyVictory = new Picture((double)var1.getPADDING(), (double)var1.getPADDING(), "resources/shellby_Victory.png");
        this.keyboard = new Keyboard(this);
        this.game = var2;
        this.init();
    }

    public void drawSpartanVictory() {
        this.spartanVictory.draw();
    }

    public void drawShellbyVictory() {
        this.shellbyVictory.draw();
    }

    public void run() {
        this.mainMenu.draw();
        this.setMainMenuDrawStatus(true);
    }

    public void init() {
        KeyboardEvent var1 = new KeyboardEvent();
        var1.setKey(77);
        var1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var1);
        KeyboardEvent var2 = new KeyboardEvent();
        var2.setKey(71);
        var2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var2);
        KeyboardEvent var3 = new KeyboardEvent();
        var3.setKey(82);
        var3.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var3);
        KeyboardEvent var4 = new KeyboardEvent();
        var4.setKey(32);
        var4.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(var4);
    }

    public void keyPressed(KeyboardEvent var1) {
    }

    public void keyReleased(KeyboardEvent var1) {
        try {
            if (var1.getKey() == 77) {
                System.exit(0);
                if (this.getSpartanVictoryDrawStatus()) {
                    this.setSpartanVictoryDrawStatus(false);
                    this.spartanVictory.delete();
                    this.mainMenu.draw();
                    this.setGuideMenuDrawStatus(true);
                }

                if (this.getShellbyVictoryDrawStatus()) {
                    this.setShellbyVictoryDrawStatus(false);
                    this.shellbyVictory.delete();
                    this.mainMenu.draw();
                    this.setMainMenuDrawStatus(true);
                }
            }

            if (var1.getKey() == 71 && this.getMainMenuDrawStatus()) {
                this.guideMenu.draw();
                this.setGuideMenuDrawStatus(true);
            }

            if (var1.getKey() == 82 && this.getGuideMenuDrawStatus()) {
                this.guideMenu.delete();
                this.setGuideMenuDrawStatus(false);
            }

            if (var1.getKey() == 32 && this.getMainMenuDrawStatus() && !this.getGuideMenuDrawStatus()) {
                this.mainMenu.delete();
                this.mainMenuDrawStatus = false;
                this.game.loadGame();
            }
        } catch (Exception var3) {
            System.out.println("No picture to access.");
        }

    }

    public void setMainMenuDrawStatus(boolean var1) {
        this.mainMenuDrawStatus = var1;
    }

    public boolean getMainMenuDrawStatus() {
        return this.mainMenuDrawStatus;
    }

    public boolean getGuideMenuDrawStatus() {
        return this.guideMenuDrawStatus;
    }

    public boolean getSpartanVictoryDrawStatus() {
        return this.spartanVictoryDrawStatus;
    }

    public boolean getShellbyVictoryDrawStatus() {
        return this.shellbyVictoryDrawStatus;
    }

    public void setGuideMenuDrawStatus(boolean var1) {
        this.guideMenuDrawStatus = var1;
    }

    public void setSpartanVictoryDrawStatus(boolean var1) {
        this.spartanVictoryDrawStatus = var1;
    }

    public void setShellbyVictoryDrawStatus(boolean var1) {
        this.shellbyVictoryDrawStatus = var1;
    }

    public boolean isGameStart() {
        return this.gameStart;
    }
}

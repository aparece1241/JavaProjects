/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation;

/**
 *
 * @author 1styrGroupB
 */
public class MouseEventListener {
    
    private static MouseEventListener instance;
    private double scrollX,scrollY;
    private double xPos,yPos,lastX,lastY;
    private boolean isDraging;
    
    private MouseEventListener(){
        this.scrollX = 0.0;
        this.scrollY = 0.0;
        this.xPos = 0.0;
        this.yPos = 0.0;
        this.lastX = 0.0;
        this.lastY = 0.0;
    }
    private static MouseEventListener get(){
        if(instance == null){
            MouseEventListener instance = new MouseEventListener();
        }
        return instance;
    }
}

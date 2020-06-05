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
public abstract class Scene {
    
    public Scene(){
        
    }
     public abstract void init();
     public abstract void update(float delta_time);
}


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
public class LevelScene extends Scene {
    
    public LevelScene(){
        System.out.println("Inside the Level Scene");
        Window.get().r = 1.0f;
        Window.get().g = 1.0f;
        Window.get().b = 1.0f;
    }

    @Override
    public void update(float delta_time) {
    
    
    }

    @Override
    public void init() {

    }
}

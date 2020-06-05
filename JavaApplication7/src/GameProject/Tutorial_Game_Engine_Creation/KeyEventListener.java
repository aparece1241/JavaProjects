/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation;

import org.lwjgl.glfw.GLFW;

/**
 *
 * @author 1styrGroupB
 */
public class KeyEventListener {
    private static KeyEventListener instance;
    private static boolean KeyPressed [] = new boolean[350];
    
    private KeyEventListener(){
        
    }
    
    public static KeyEventListener get(){
        if(KeyEventListener.instance == null){
            KeyEventListener.instance = new KeyEventListener();
        }
        return KeyEventListener.instance;
    }
    
    public static void key_callback(long window, int key, int scancode, int action, int mods){
        if(action == GLFW.GLFW_PRESS){
            get().KeyPressed[key] = true;
        }else if(action == GLFW.GLFW_RELEASE){
            get().KeyPressed[key] = false;
        }
    }
    
    public static boolean getKeypress(int keyCode){
        if(keyCode < get().KeyPressed.length){
            return get().KeyPressed[keyCode];
            
        }
        return false;
        
    }
}

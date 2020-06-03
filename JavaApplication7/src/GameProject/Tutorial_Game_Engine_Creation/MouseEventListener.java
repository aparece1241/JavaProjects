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
public class MouseEventListener {
    
    private static MouseEventListener instance;
    private double scrollX,scrollY;
    private double xPos,yPos,lastX,lastY;
    private boolean mouseButtonPressed [] = new boolean[3];
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
            MouseEventListener.instance = new MouseEventListener();
        }
        return instance;
    }
    
    public static void cursor_position_callback(long window, double xPos, double yPos){
        get().lastX = get().xPos;
        get().lastY = get().yPos;
        get().xPos = xPos;
        get().yPos = yPos;
        get().isDraging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];
    }
    
    public static void mouse_button_callback(long window, int button, int action, int mods){
        System.out.println(button);
        if(action == GLFW.GLFW_PRESS){
            if(button < get().mouseButtonPressed.length){
                get().mouseButtonPressed[button] = true;
            }
            
        }else if(action == GLFW.GLFW_RELEASE){
            if(button < get().mouseButtonPressed.length){
                get().mouseButtonPressed[button] = false;
                get().isDraging = false;
            }
        }   
    }
    
    public static void scroll_back(long window, double xoffset, double yoffset){
        get().scrollX = xoffset;
        get().scrollY = yoffset;
    }
    
    public static void endFrame(){
        get().scrollX = 0;
        get().scrollY = 0;
        get().lastX = get().xPos;
        get().lastY = get().yPos;
    }
    
    public static float getX(){
        return (float)get().xPos;
    }
    
    public static float getY(){
        return (float)get().yPos;
    }
    public static float getDx(){
        return (float)(get().lastX - get().xPos);
    }
    
    public static float getDy(){
        return (float)(get().lastY - get().yPos);
    }
    
    
    public static float getScrollX(){
        return (float)get().scrollX;
    }
    
    
    public static float getScrollY(){
        return (float)get().scrollY;
    }
    
    public static boolean getisDraging(){
        return get().isDraging;
    }
    
    public static boolean mouse_button_down(int button){
        if(button < get().mouseButtonPressed.length){
            return get().mouseButtonPressed[button];
        }else{
            return false;
        }
    }
}

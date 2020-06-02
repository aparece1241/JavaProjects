/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation.newpackage;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.glfwInit;
import org.lwjgl.glfw.GLFWErrorCallback;

/**
 *
 * @author 1styrGroupB
 */
public class Window {
    private int width,height;
    private String title;
    
    private static Window window = null;
    private Window(){
        this.width = 1280;
        this.height = 800;
        this.title = "Game Window";
    }
    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }
    
    public void run(){
        init();
        loop();
    }
    
    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();
        
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialized GLFW|");
        }
        
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE,GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE,GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_MAXIMIZED,GLFW.GLFW_TRUE);
        
        long window = GLFW.glfwCreateWindow(width, height, title, width, width);
        
    }
    public void loop(){
        
    }

}//GamesWithGabe tutorial

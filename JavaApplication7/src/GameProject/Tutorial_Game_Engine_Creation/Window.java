/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.glfwInit;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.opengl.GL45;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 *
 * @author 1styrGroupB
 */
public class Window {
    private int width,height;
    private String title;
    private long glfwindow;
    
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
        
        glfwindow = GLFW.glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        
        if(glfwindow == NULL){
            throw new IllegalStateException("Failed to create  GLFW window.");
        }
        //create current context
        GLFW.glfwMakeContextCurrent(glfwindow);
        
        GLFW.glfwShowWindow(glfwindow);
        
        GLFW.glfwSwapInterval(1);
        // very import for us to use data bindings and etc.
        GL.createCapabilities();
    }
    public void loop(){
        while(!GLFW.glfwWindowShouldClose(glfwindow)){
            //poll events
            GLFW.glfwPollEvents();
            
            glClearColor(1,0,0,0);
            glClear(GL11.GL_COLOR_BUFFER_BIT);
            GLFW.glfwSwapBuffers(glfwindow);
            
        }
    }

}//GamesWithGabe tutorial

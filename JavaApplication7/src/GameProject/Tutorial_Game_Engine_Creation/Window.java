/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation;

import Util.Time;
import org.lwjgl.glfw.Callbacks;
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
    private boolean fadeToBlack = false;
    private float r,g,b,a;
    
    private static Window window = null;
    private Window(){
        this.width = 1280;
        this.height = 700;
        this.title = "Game Window";
        this.r = 1.0f;
        this.g = 1.0f;
        this.b = 0.0f;
        this.a = 1.0f;
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
        
        Callbacks.glfwFreeCallbacks(glfwindow);
        GLFW.glfwDestroyWindow(glfwindow);
        
        
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }
    
    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();
        
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialized GLFW|");
        }
        
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE,GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE,GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_MAXIMIZED,GLFW.GLFW_FALSE);
        
        glfwindow = GLFW.glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        
        if(glfwindow == NULL){
            throw new IllegalStateException("Failed to create  GLFW window.");
        }
        
        GLFW.glfwSetMouseButtonCallback(glfwindow,MouseEventListener::mouse_button_callback);
        GLFW.glfwSetScrollCallback(glfwindow, MouseEventListener::scroll_back);
        GLFW.glfwSetCursorPosCallback(glfwindow, MouseEventListener::cursor_position_callback);
        GLFW.glfwSetKeyCallback(glfwindow, KeyEventListener::key_callback);
        //create current context
        GLFW.glfwMakeContextCurrent(glfwindow);
        
        GLFW.glfwShowWindow(glfwindow);
        
        GLFW.glfwSwapInterval(1);
        // very import for us to use data bindings and etc.
        GL.createCapabilities();
    }
    public void loop(){
        float beginTime = Time.getTime();
        float endTime = Time.getTime();
        
        while(!GLFW.glfwWindowShouldClose(glfwindow)){
            //poll events
            GLFW.glfwPollEvents();
            
//            if(fadeToBlack){
//                this.r = Math.max(r - 0.1f,0.0f);
//                this.g = Math.max(g - 0.1f,0.0f);
//                this.b = Math.max(b - 0.1f,0.0f);
//            }
            
//            if(KeyEventListener.getKeypress(GLFW.GLFW_KEY_SPACE)){
//                this.fadeToBlack = true;
//            }
//            
            glClearColor(r,g,b,a);
            glClear(GL11.GL_COLOR_BUFFER_BIT);
            GLFW.glfwSwapBuffers(glfwindow);
            
            endTime = Time.getTime();
            float delta_time = endTime - beginTime;
            beginTime = endTime;
        }
    }

}//GamesWithGabe https://www.youtube.com/watch?v=gYhEknnKFJY&list=PLtrSb4XxIVbp8AKuEAlwNXDxr99e3woGE&index=4

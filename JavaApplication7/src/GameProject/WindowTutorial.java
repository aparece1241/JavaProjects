/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;
/**
 *
 * @author 1styrGroupB
 */
public class WindowTutorial {
    
    public WindowTutorial(){
        if(glfwInit() != true){
            System.err.println("GLFW failed to Initialized");
            System.exit(1);
        }
        long window = glfwCreateWindow(600,600, "Hello World", 0, 0);
        glfwShowWindow(window);
        
        glfwMakeContextCurrent(window);
        
        
        GL.createCapabilities();    
        glEnable(GL_TEXTURE_2D);
        
        
        glClearColor(Color.Cyan().r, Color.Cyan().g, Color.Cyan().b,0);
        while(glfwWindowShouldClose(window) != true){
            glfwGetKey(window, GL_S);
            if(glfwGetKey(window, GLFW_KEY_A) == 1){
                glfwSetWindowShouldClose(window, true);
            }
            
            
            
            glfwPollEvents();
                    
            glClear(GL_COLOR_BUFFER_BIT);
            glBegin(GL_QUAD_STRIP);
                
            glEnd();
            glfwSwapBuffers(window);
            
            
        }
        glfwTerminate();
    }
    
    
}

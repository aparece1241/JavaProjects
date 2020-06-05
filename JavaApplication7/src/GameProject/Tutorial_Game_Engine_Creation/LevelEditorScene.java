/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation;

import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_INFO_LOG_LENGTH;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glShaderSource;


/**
 *
 * @author 1styrGroupB
 */
public class LevelEditorScene extends Scene {
    
    private String vertexShaderSrc = "#type vertex\n" +
            "#version 333 core\n" +
            "\n" +
            "layout(location = 0) in vec3 aPos;\n" +
            "layout(location = 1) in vec4 aColor;\n" +
            "\n" +
            "out vec4 fColor;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    fColor = aColor;\n" +
            "    gl_position = vec4(aPos,1.0);\n" +
            "}";
    
    private String fragmentShaderSrc = "#type fragment\n" +
            "#version 333 core\n" +
            "\n" +
            "in vec4 fColor\n" +
            "\n" +
            "out vec4 color;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    color = fColor;\n" +
            "}\n" +
            "";
    
    private int vertexId,fragmentId,shaderProgarm;
    
    public LevelEditorScene(){
        System.out.println("Inside the Level Editor Scene");
    }

    @Override
    public void init(){
        // compile and link shaders
        
        //load ang compile vertex shader
        vertexId = glCreateShader(GL_VERTEX_SHADER);
        //pass the shader source to GPU
        glShaderSource(vertexId,vertexShaderSrc);
        glCompileShader(vertexId);
        
        //check error for compilation process
        
        int success = glGetShaderi(vertexId,GL_COMPILE_STATUS);
        if(success == GL_FALSE){
            int len = glGetShaderi(vertexId,GL_INFO_LOG_LENGTH);
            System.out.println("ERROR:'defaultShader.glsl'\n\t vertex shader compilation failed");
            System.out.println(glGetShaderInfoLog(vertexId,len));
            assert false: "";
        }
    }
    
    @Override
    public void update(float delta_time) {
       
    }
}

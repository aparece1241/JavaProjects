/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject.Tutorial_Game_Engine_Creation;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import org.lwjgl.opengl.GL15;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import org.lwjgl.opengl.GL20;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_INFO_LOG_LENGTH;
import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import org.lwjgl.opengl.GL30;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengles.GLES20.glDrawElements;


/**
 *
 * @author 1styrGroupB
 */
public class LevelEditorScene extends Scene {
    
    private String vertexShaderSrc = "#type vertex\n" +
"#version 430 core\n" +
"\n" +
"layout(location = 0) in vec3 aPos;\n" +
"layout(location = 1) in vec4 aColor;\n" +
"\n" +
"out vec4 fColor;\n" +
"\n" +
"void main()\n" +
"{\n" +
"    fColor = aColor;\n" +
"    gl_Position = vec4(aPos,1.0);\n" +
"}\n" ;
    
    private String fragmentShaderSrc ="#type fragment\n" +
"#version 430 core\n" +
"\n" +
"in vec4 fColor\n" +
"\n" +
"out vec4 color;\n" +
"\n" +
"void main()\n" +
"{\n" +
"    color = fColor;\n" +
"}\n";
    
    private int vertexId,fragmentId,shaderProgarm;
    
    private float [] vertexArray = {
    // Position            //color
     0.5f, -0.5f, 0.0f,     1.0f, 0.0f, 0.0f, 1.0f,
     -0.5f, 0.5f, 0.0f,     1.0f, 0.0f, 1.0f, 1.0f,
     0.5f, 0.5f, 0.0f,     0.0f, 1.0f, 0.0f, 1.0f,
     -0.5f, -0.5f, 0.0f,     1.0f, 1.0f, 0.0f, 1.0f,
    };
    // IMPORTANT: this must be in counter clock wise order
    private int[] elementArray = {
        2,1,0,
        0,1,3
    };
    
    private int vaoId, vboId,eboId;
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
        
        // load and compile fragment shader
        fragmentId = glCreateShader(GL_FRAGMENT_SHADER);
        //pass the shader source to GPU
        glShaderSource(fragmentId,fragmentShaderSrc);
        glCompileShader(fragmentId);
        
        //check error for compilation process
        
        success = glGetShaderi(fragmentId,GL_COMPILE_STATUS);
        if(success == GL_FALSE){
            int len = glGetShaderi(fragmentId,GL_INFO_LOG_LENGTH);
            System.out.println("ERROR:'defaultShader.glsl'\n\t fragment shader compilation failed");
            System.out.println(glGetShaderInfoLog(fragmentId,len));
            assert false: "";

        }
        
        //link shaders and check for errors
        
        shaderProgarm = glCreateProgram();
        glAttachShader(shaderProgarm, vertexId);
        glAttachShader(shaderProgarm, fragmentId);
        glLinkProgram(shaderProgarm);
        
        //check for errors
        
        success = glGetProgrami(shaderProgarm, GL_LINK_STATUS);
        if(success == GL_FALSE){
            int len = glGetProgrami(shaderProgarm, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR:'defaultShader.glsl'\n\t the progarm linking failed");
            System.out.println(glGetProgramInfoLog(shaderProgarm,len));
            assert false: "";
        }        
        
        
        //generate vao, vbo, ebo
        
        vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);
        
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();
        
        // create vbo upload
        
        vboId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vaoId);
       
        glBufferData(GL_ARRAY_BUFFER,vertexBuffer,GL_STATIC_DRAW);
        
        //create the indecies and uploads
        
        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementArray.length);
        elementBuffer.put(elementArray).flip();
        
        eboId = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vaoId);
       
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,elementBuffer,GL_STATIC_DRAW);
        
        //add the vertex attribute pointers
        
        int positionSize = 3;
        int colorSize = 4;
        int floatSizeBytes = 4;
        int vertexSizeBytes = (positionSize + colorSize)* floatSizeBytes;
        glVertexAttribPointer(0,positionSize,GL_FLOAT,false,vertexSizeBytes,0);
        glEnableVertexAttribArray(0);
        
        glVertexAttribPointer(1,colorSize,GL_FLOAT,false,vertexSizeBytes,positionSize * floatSizeBytes);
        glEnableVertexAttribArray(1);
        
    }
    
    @Override
    public void update(float delta_time) {
       // bind shader program
       glUseProgram(shaderProgarm);
       // bind the vao that were using
       glBindVertexArray(vaoId);
       glEnableVertexAttribArray(0);
       glEnableVertexAttribArray(1);
       glDrawElements(GL_TRIANGLES,elementArray.length,GL_UNSIGNED_INT,0);
       
       
       //unbined everything
       
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        
        glBindVertexArray(0);
        
        glUseProgram(0);
    }
}

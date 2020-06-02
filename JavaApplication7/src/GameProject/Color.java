/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameProject;

/**
 *
 * @author 1styrGroupB
 */
public class Color {
    public float r = 1;
    public float g = 1;
    public float b = 1;
    public float a = 1;
    
    public Color(float r, float g, float b, float a){
        this.r = Mathf.clamp(r, 0, 1);
        this.g = Mathf.clamp(g, 0, 1);
        this.b = Mathf.clamp(b, 0, 1);
        this.a = Mathf.clamp(a, 0, 1);
    }
    // for having no alpha value
    
    public Color(float r, float g, float b){
        this.r = Mathf.clamp(r, 0, 1);
        this.g = Mathf.clamp(g, 0, 1);
        this.b = Mathf.clamp(b, 0, 1);
        
    }
    
    public static Color Black() {return new Color(0,0,0);}
    public static Color White() {return new Color(1,1,1);}
    public static Color Red() {return new Color(1,0,0);}
    public static Color Green() {return new Color(0,1,0);}
    public static Color Blue() {return new Color(0,0,1);}
    public static Color Gray() {return new Color(0.5f,0.5f,0.5f);}
    public static Color Wine() {return new Color(0.5f,0,0);}
    public static Color Forest() {return new Color(0,0.5f,0);}
    public static Color Marine() {return new Color(0,0,0.5f);}
    public static Color Yellow() {return new Color(1,1,0);}
    public static Color Cyan() {return new Color(0,1,1);}
    
    
    public String ToString(){
        return "("+String.valueOf(r + "," + String.valueOf(b)+","+ String.valueOf(g)+"," +String.valueOf(a)+")");
    }
}

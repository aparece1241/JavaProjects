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
public class Mathf {
    public static float clamp(float value,float min,float max){
        if(value < min)
        {
            return min;
        }
        if(value > max)
        {
            return max;
        }
        return value;
    }
}

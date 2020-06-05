/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author 1styrGroupB
 */
public class Time {
    public static float timeStarted = System.nanoTime();
    
    public static float getTime(){
        return (float)((System.nanoTime() - timeStarted)*1E-9);
    }
}

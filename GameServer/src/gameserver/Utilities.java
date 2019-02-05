/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

/**
 *
 * @author karim
 */
public class Utilities {
    public static boolean contains(String[] arr, String element)
    {
        for(int i=0; i<arr.length;i++)
        {
            if(element.equals(arr[i]))
            {
             return true ;   
            }
        }
        return false ; 
    } 
    
    public static boolean contains(int[] arr, int element)
    {
        for(int i=0; i<arr.length;i++)
        {
            if(element == arr[i])
            {
             return true ;   
            }
        }
        return false ; 
    } 
    
}

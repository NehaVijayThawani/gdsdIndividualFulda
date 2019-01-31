/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Neha V Thawani
 */
public class Helper {

    public static int compareStrings(String s1, String s2) {
        int comparison = 0;
        int c1, c2;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            c1 = (int) s1.toLowerCase().charAt(i);   // See note 1
            c2 = (int) s2.toLowerCase().charAt(i);   // See note 1
            comparison = c1 - c2;   // See note 2

            if (comparison != 0) // See note 3
            {
                return comparison;
            }
        }
        if (s1.length() > s2.length()) // See note 4
        {
            return 1;
        } else if (s1.length() < s2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
    public static void sortArrayByAge(int x[]) {//go through the array and sort from smallest to highest
      for(int i=1; i<x.length; i++) {
         int temp=0;
         if(x[i-1] > x[i]) {
            temp = x[i-1];
            x[i-1] = x[i];
            x[i] = temp;
         }
      }
   }
     public static void sortArrayByAgeDesc(int x[]) {//go through the array and sort from smallest to highest
      for(int i=1; i<x.length; i++) {
         int temp=0;
         if(x[i-1] < x[i]) {
            temp = x[i-1];
            x[i-1] = x[i];
            x[i] = temp;
         }
      }
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbauernregeln;


/**
 *
 * @author Arjuna
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        try {
            
        mySQLconnection blubb = new mySQLconnection();
        blubb.readDataBase();
        } catch (Exception e) {
      System.out.println(e);
        }
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;

/**
 *
 * @author oscar
 */
public class View {
    private final Controller contr;
    
    public View(Controller contr) {
        this.contr = contr;
    }
    
    public void sampleExecution() {
        contr.beginInspection();
        // Customer enters
        contr.closeGarageDoor();
    }
}

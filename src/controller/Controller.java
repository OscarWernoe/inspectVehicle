/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Garage;

/**
 *
 * @author oscar
 */
public class Controller {
    private final Garage garage;
    
    public Controller(Garage garage) {
        this.garage = garage;
    }
    
    public void beginInspection() {
        garage.nextCustomer();
    }
    
    public void closeGarageDoor() {
        garage.closeDoor();
    }
}

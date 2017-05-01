/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

import model.Garage;
import controller.Controller;
import view.View;

/**
 *
 * @author oscar
 */
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Controller contr = new Controller(garage);
        View view = new View(contr);
        view.sampleExecution();
    }
}

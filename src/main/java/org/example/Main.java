package org.example;

import Models.*;
import com.mysql.cj.xdevapi.SqlResultBuilder;

import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        HouseDAO houseDAO = new HouseDAO();
        House gryffindor = new House("Gryffindor", "Godric Gryffindor");
        House slytherin = new House("Slytherin", "Salazar Slytherin");
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff");
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw");
       /* houseDAO.create(gryffindor);
        houseDAO.create(slytherin);
        houseDAO.create(hufflepuff);
        houseDAO.create(ravenclaw);*/

        List<House> houses = houseDAO.getAll();
       //forma Olga: houses.forEach(System.out :: println);
       for(House h : houses){
           System.out.println(h.toString());
       }





        Wand wand1 = new Wand("Acebo", "Pluma de fénix", 28.0);
        Wand wand2 = new Wand("Espino", "Pelo de unicornio", 23.0);
        Wand wand3 = new Wand("Vid", "Corazon de dragon", 25.4);
        Wand wand4 = new Wand("Sauce", "Pelo de unicornio", 25.4);

        WandDAO wandDAO = new WandDAO();

       /*wandDAO.create(wand1);
        wandDAO.create(wand2);
        wandDAO.create(wand3);
        wandDAO.create(wand4);*/


        List<Wand> wands = wandDAO.getAll();
        //forma Olga: houses.forEach(System.out :: println);
        for(Wand w : wands){
            System.out.println(w.toString());
        }


        Wizard harry = new Wizard("Harry Potter", 17, 1, 1);
        Wizard ron = new Wizard("Ron Weasley", 17, 1,2);
        Wizard hermione = new Wizard("Hermione Granger", 17, 1, 3);
        Wizard draco= new Wizard("Draco Malfoy", 17, 2,4);

        WizardDAO wizardDAO = new WizardDAO();

       /* wizardDAO.create(harry);
        wizardDAO.create(ron);
        wizardDAO.create(hermione);
        wizardDAO.create(draco);*/


        List<Wizard> wizards = wizardDAO.getAll();

        for(Wizard w : wizards){
            System.out.println(w.toString());
        }

       /* System.out.println(gryffindor.toString());
        System.out.println(slytherin.toString());
        System.out.println(hufflepuff.toString());
        System.out.println(ravenclaw.toString());

        System.out.println(wand1.toString());
        System.out.println(wand2.toString());
        System.out.println(wand3.toString());
        System.out.println(wand4.toString());


        System.out.println(harry.toString());
        System.out.println(ron.toString());
        System.out.println(hermione.toString());
        System.out.println(draco.toString());*/

    }
}
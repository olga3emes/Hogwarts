package org.example;

import Views.WizardView;

import java.sql.SQLException;

public class MainControllerTest {
    public static void main(String[] args) throws SQLException {
        WizardView view = new WizardView();
        view.showMenu();
    }

}

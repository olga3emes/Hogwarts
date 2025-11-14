package Controllers;

import Models.Wizard;
import Models.WizardDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WizardController {

    private WizardDAO wizardDAO;


    public WizardController() {
        wizardDAO = new WizardDAO();
    }

    public void addWizard(String name, int age, int house_id, int wand_id) {
        //comprobar permisos
        //comprobar parámetros (verificación en servidor)
        //transacciones
        try {
            Wizard wizard = new Wizard(name, age, house_id, wand_id);
            wizardDAO.create(wizard);
            System.out.println("✅ Mago agregado con éxito");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar mago:" + e.getMessage());
        }
    }

    public void listWizard() {
        try {
            List<Wizard> wizards = wizardDAO.getAll();
            if (wizards.isEmpty()) {
                System.out.println("⚠️ No hay magos");
            } else {

                for (Wizard w : wizards) {
                    System.out.println(w);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌❌ Error al listar los magos" + e.getMessage());
        }
    }

    public void updateWizard(int id, String name, int age, int houseId, int wandId){
        try{
            Wizard wizard = new Wizard(name, age, houseId, wandId);
            wizard.setId(id);
            wizardDAO.update(wizard);
            System.out.println("✅ Mago actualizado con éxito 🪄");
        }catch (SQLException e){
            System.out.println("❌ Error al actualizar mago:" + e.getMessage());
        }
    }

    public void deleteWizard (int id) {
        try{
            wizardDAO.delete(id);
            System.out.println("Mago eliminado 🧻🗑️");
        }catch(SQLException e){
            System.out.println("❌ Error al eliminar mago:" + e.getMessage());
        }
    }

    public List<Wizard> getAllWizards() {
        try {
            return wizardDAO.getAll();
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener magos: " + e.getMessage());
            return null;
        }
    }


    public void addWizard(String name, int age)  {
        try {
            wizardDAO.create2(new Wizard(name, age));
            System.out.println("➕ Mago agregado");
        }catch(SQLException e){
            System.out.println("❌ Error al añadir el mago: " + e.getMessage());
        }
    }
}

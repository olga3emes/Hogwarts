package Views;

import Controllers.WizardController;
import Models.Wizard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WizardViewSwing extends JFrame {

    private WizardController controller;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtName, txtAge, txtId;

    public WizardViewSwing() throws SQLException {
        controller = new WizardController();
        setTitle("🏰 Hogwarts - Gestión de Magos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        //Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Tabla
        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Edad"}, 0);
        table = new JTable(model);
        panel.add(table);

        JButton btnAdd = new JButton("Agregar ➕");
        JButton btnDelete = new JButton("Eliminar ❌");
        JButton btnRefresh = new JButton("Actualizar Lista 🌀");

        JPanel inputPanel = new JPanel();


        panel.add(inputPanel, BorderLayout.SOUTH);

        inputPanel.add(new JLabel("ID:"));
        txtId = new JTextField(5);
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Nombre:"));
        txtName = new JTextField(10);
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Edad:"));
        txtAge = new JTextField(5);
        inputPanel.add(txtAge);

        inputPanel.add(btnAdd);
        inputPanel.add(btnDelete);
        inputPanel.add(btnRefresh);

        loadData();


    }


    private void loadData() throws SQLException {
        model.setRowCount(0);
        List<Wizard> wizards = controller.getAllWizards();
        if (wizards != null) {
            for (Wizard w : wizards) {
                model.addRow(new Object[]{w.getId(), w.getName(), w.getAge()});
            }
        }
    }

}

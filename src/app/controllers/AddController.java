package app.controllers;

import app.models.UsersModel;
import app.views.Add;
import app.views.Users;
import database.Queries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddController {

    Add view;
    UsersModel users = new UsersModel();
    Queries queries = new Queries();

    public AddController(Add view) {
        this.view = view;
        events( );
    }

    private void events() {

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Users usersView = new Users();
                UsersController usersController = new UsersController(usersView);

                users.setFirstName(view.txtFirstNameAdd.getText());
                users.setLastName(view.txtLastNameAdd.getText());
                users.setAdress(view.txtAdressAdd.getText());
                users.setCity(view.txtCityAdd.getText());
                users.setEmail(view.txtEmailAdd.getText());
                users.setPhone(view.txtPhoneAdd.getText());
                users.setDepartment(view.txtDepartmentAdd.getText());
                System.out.println("buenas");
                if (queries.insertUser(users)) {
                    JOptionPane.showMessageDialog(view, "Se creo el usuario");
                    System.out.println("hello");
                    usersController.loadTable();
                } else {
                    JOptionPane.showMessageDialog(view, "No se ha podido crear el usuario");
                }

            }
        });

        view.btnAddCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Users usersView = new Users();
                UsersController usersController = new UsersController(usersView);
                usersView.setBounds(0, 0, 800, 700);
                view.removeAll();
                view.add(usersView);
                view.repaint();
                view.revalidate();

            }
        });
    }

}
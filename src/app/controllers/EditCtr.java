package app.controllers;

import app.models.UsersModel;
import app.views.Edit;
import app.views.Users;
import database.Queries;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class EditCtr {

    Edit view;
    UsersModel users = new UsersModel();
    Queries queries = new Queries();

    public EditCtr(Edit view) {
        this.view = view;
        events();
        loadData();

    }

    private void events() {
        view.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Users usersView = new Users();
                UsersController usersController = new UsersController(usersView);

                users.setFirstName(view.txtFirstNameEdit.getText());
                users.setLastName(view.txtLastNameEdit.getText());
                users.setAdress(view.txtAdressEdit.getText());
                users.setCity(view.txtCityEdit.getText());
                users.setEmail(view.txtEmailEdit.getText());
                users.setPhone(view.txtPhoneEdit.getText());
                users.setDepartment(view.txtDepartmentEdit.getText());

                if (queries.updateUser(users)) {
                    JOptionPane.showMessageDialog(view, "Se actualizó el usuario");
                    usersController.loadTable();
                } else {
                    JOptionPane.showMessageDialog(view, "No se ha actualizado el usuario");
                }

            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Users usersView = new Users();
                UsersController usersController = new UsersController(usersView);
                Object obj = usersView.tblUsers.getValueAt(usersView.tblUsers.getSelectedRow(), 0);

                int id = (int) obj;
                users.setIdUsers(id);
                users.setState(0);

                if (queries.updateUser(users)) {
                    JOptionPane.showMessageDialog(view, "Se eliminó el usuario");
                    usersController.loadTable();
                } else {
                    JOptionPane.showMessageDialog(view, "No se ha eliminado el usuario");
                }
            }
        });

        view.btnEditCancel.addActionListener(new ActionListener() {
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

    public void loadData() {
        Users usersView = new Users();
        UsersController usersController = new UsersController(usersView);

        Object obj = usersView.tblUsers.getValueAt(usersView.tblUsers.getSelectedRow(), 0);
        int id = (int) obj;
        users = queries.search(id);
        view.txtFirstNameEdit.setText(users.getFirstName());
        view.txtLastNameEdit.setText(users.getLastName());
        view.txtDepartmentEdit.setText(users.getDepartment());
        view.txtCityEdit.setText(users.getCity());
        view.txtPhoneEdit.setText(users.getPhone());
        view.txtAdressEdit.setText(users.getAdress());
        view.txtEmailEdit.setText(users.getEmail());

    }

}

esrgddffggf
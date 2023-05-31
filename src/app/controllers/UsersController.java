package app.controllers;

import app.models.UsersModel;
import app.views.Add;
import app.views.Dashboard;
import app.views.Edit;
import app.views.Users;
import database.Queries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class UsersController {

    Users view;
    Queries queries = new Queries();

    public UsersController(Users view) {
        this.view = view;
        events();
        //table();
        loadTable();
        editUserTable();

    }

    public void editUserTable() {
        view.tblUsers.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

                Edit usersEdit = new Edit();
                EditCtr ctrEdit = new EditCtr(usersEdit);

                usersEdit.setBounds(0, 0, 800, 728);
                view.pnlMain.removeAll();
                view.pnlMain.add(usersEdit);
                view.pnlMain.repaint();
                view.pnlMain.revalidate();

            }
        });

    }

    public void loadTable() {

        DefaultTableModel model = (DefaultTableModel) view.tblUsers.getModel();
        model.getDataVector().removeAllElements();
        ArrayList<UsersModel> usersList = new ArrayList<UsersModel>();
        usersList = queries.consultUsers();
        System.out.println("bandera 20");

        for (UsersModel user : usersList) {
            Object[] row = new Object[8];

            row[0] = user.getIdUsers();
            row[1] = user.getFirstName();
            row[2] = user.getLastName();
            row[3] = user.getDepartment();
            row[4] = user.getCity();
            row[5] = user.getAdress();
            row[6] = user.getEmail();
            row[7] = user.getPhone();
            System.out.println("bandera 21");
            //Falta una linea de codigo mas
            //view.tblUsers.setModel(model);
            model.addRow(row);
        }
    }

    private void events() {
        view.btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Hola");
                Add addUser = new Add();
                AddController usersController = new AddController(addUser);

                addUser.setBounds(0, 0, 800, 728);

                view.pnlMain.removeAll();
                view.pnlMain.add(addUser);
                view.pnlMain.repaint();
                view.pnlMain.revalidate();
            }
        });
    }

}

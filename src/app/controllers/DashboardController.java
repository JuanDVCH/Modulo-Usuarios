package app.controllers;

import app.models.UsersModel;
import app.views.Dashboard;
import app.views.Home;
import app.views.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {
    UsersModel model;
    Dashboard view;

    public DashboardController(UsersModel model, Dashboard view) {
        this.model = model;
        this.view = view;
        
        start();
        events();
    }
    
    private void start() {
        view.setVisible(true);
    }
    
    private void events() {
        view.btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Home home = new Home();
                
                home.setBounds(0,0,800, 700);
                
                view.pnlMain.removeAll();
                view.pnlMain.add(home);
                view.pnlMain.repaint();
                view.pnlMain.revalidate();
            }
        });
        
        view.btnUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Users users = new Users();
                UsersController usersController = new UsersController(users);
                
                users.setBounds(0,0,800, 700);
                
                view.pnlMain.removeAll();
                view.pnlMain.add(users);
                view.pnlMain.repaint();
                view.pnlMain.revalidate();
            }
        });
    }
    
}

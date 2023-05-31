package main;

import app.controllers.DashboardController;
import app.models.UsersModel;
import app.views.Dashboard;

public class Main {

    public static void main(String[] args) {
        UsersModel model = new UsersModel();
        Dashboard view = new Dashboard();
        DashboardController controller = new DashboardController(model, view);
    }
}

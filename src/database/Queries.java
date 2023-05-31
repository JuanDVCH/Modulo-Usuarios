package database;

import app.models.UsersModel;
import configuration.Configuration;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class Queries implements Configuration {

    public boolean success;

    public UsersModel search(int id) {
        DatabaseConnection connection = new DatabaseConnection();
        UsersModel users = null;

        String sql = "SELECT * FROM users WHERE id = " + id;
        ResultSet result = connection.consult(sql);

        try {
            if (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("ID"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAdress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));

            }
        } catch (SQLException e) {
            System.err.println("Failed to get users by id: " + e);
        }

        return users;
    }

    public boolean insertUser(UsersModel user) {

        DatabaseConnection connection = new DatabaseConnection();
        System.out.println("bandera 1");

        String sql = "INSERT INTO users (first_name, last_name, address, city, department, phone, email, state) "
                + "VALUES ('" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getAdress() + "', '"
                + user.getCity() + "', '" + user.getDepartment() + "', '" + user.getPhone() + "', '" + user.getEmail()
                + "', '" + 1 + "')";

        boolean insert = false;

        try {

            if (connection.execute(sql)) {
                insert = true;
                System.out.println("bandera 2");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar el registro (UsersController): " + e);
        } finally {
            connection.disconnect();
        }

        return insert;
    }

    public boolean updateUser(UsersModel user) {

        DatabaseConnection connection = new DatabaseConnection();

        String sql = "UPDATE USERS SET first_name = '" + user.getFirstName() + "', last_name = '" + user.getLastName()
                + "', address = '" + user.getAdress() + "', city = '" + user.getCity() + "', department = '"
                + user.getDepartment() + "', phone = '" + user.getPhone() + "', email = '" + user.getEmail()
                + "' WHERE ID = '" + user.getIdUsers() + "'";

        boolean modify = false;

        try {

            if (connection.execute(sql)) {
                modify = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el registro (UsersController): " + e);
        }

        connection.disconnect();
        return modify;
    }

    public boolean deleteUser(int idUser) {

        DatabaseConnection connection = new DatabaseConnection();

        String sql = "DELETE FROM users WHERE ID = " + idUser;

        boolean remove = false;

        try {
            if (connection.execute(sql)) {
                remove = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el registro (UsersController): " + e);
        }
        connection.disconnect();
        return remove;
    }

    public ArrayList<UsersModel> consultUsers() {
        ArrayList<UsersModel> usersList = new ArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT * FROM users";
        ResultSet result;
        result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("ID"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAdress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

}

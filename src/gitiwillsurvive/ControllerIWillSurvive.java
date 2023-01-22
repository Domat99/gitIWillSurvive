/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitiwillsurvive;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import DBConnection.DBConnectionProvider;
import java.util.Arrays;

/**
 *
 * @author elias
 */
public class ControllerIWillSurvive {

    DBConnectionProvider connectionProvider = new DBConnectionProvider();

    static User user;

    private void changeScenes(String sceneName, int h, int w) throws IOException {

        GitIWillSurvive m = new GitIWillSurvive();

        m.changeScene(sceneName);
        m.stg.setHeight(h);
        m.stg.setWidth(w);
        m.stg.centerOnScreen();
    }

    //Sign in page
    @FXML
    private TextField txtFldUsername;
    @FXML
    private PasswordField txtFldPassword;
    @FXML
    private Label lblNotFound;
    @FXML
    private Button btnLogIn;

    @FXML
    private void logInClicked(ActionEvent event) throws IOException, SQLException {
        checkLogin();
    }

    public void signUpClicked() throws IOException {
        changeScenes("CreateAccount.fxml", 775, 820);

    }

    public void forgotPasswordClicked() throws IOException {
        lblNotFound.setText("Please contact us at example@sehtak.ca");
        lblNotFound.setStyle("-fx-text-fill: #c54b7c");//Darkish Purple
    }

    private void checkLogin() throws IOException, SQLException {
        String test1 = txtFldUsername.getText().trim().toLowerCase();
        String test2 = txtFldPassword.getText().trim();

        if ((txtFldPassword.getText().trim().isEmpty()) || (txtFldUsername.getText().trim().isEmpty())) {
            lblNotFound.setText("Please type in both the username and password");
            lblNotFound.setStyle("-fx-text-fill: #D05F12");//Orange
        } else {
            boolean data = importData(test1, test2, lblNotFound);
            if (data == true) {
                user = getUserObject(test1);
                changeScenes("MainPage.fxml", 950, 1500);

            }
        }
    }

    private User getUserObject(String userName) throws SQLException {
        Connection connection = connectionProvider.getConnection();

        User u1 = null;
        String query = "SELECT Password, Income, Family FROM Users WHERE UserName = \"" + userName + "\"";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();

            String password = resultSet.getString("Password");
            int income = resultSet.getInt("Income");
            int family = resultSet.getInt("Family");

            u1 = new User(userName, password, income, family);

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With getUserObject Selecting: " + ex.getMessage());
        }
        connection.close();
        return u1;

    }

    //For the main page (dashboard) after sign in
    @FXML
    private Button btnDeleteAccountMain;

    @FXML
    private Button btnLoadGraphs;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnUpdate1;

    @FXML
    private Button btnUpdate10;

    @FXML
    private Button btnUpdate11;

    @FXML
    private Button btnUpdate12;

    @FXML
    private Button btnUpdate2;

    @FXML
    private Button btnUpdate3;

    @FXML
    private Button btnUpdate4;

    @FXML
    private Button btnUpdate5;

    @FXML
    private Button btnUpdate6;

    @FXML
    private Button btnUpdate7;

    @FXML
    private Button btnUpdate8;

    @FXML
    private Button btnUpdate9;

    @FXML
    private Button btnUpdateIncome;

    @FXML
    private Button btnUpdateSavings;

    @FXML
    private Label lblEducation;

    @FXML
    private Label lblElectricity;

    @FXML
    private Label lblErrors;

    @FXML
    private Label lblGroceries;

    @FXML
    private Label lblHealth;

    @FXML
    private Label lblIncomeMonth;

    @FXML
    private Label lblInsurance;

    @FXML
    private Label lblInternet;

    @FXML
    private Label lblLeisure;

    @FXML
    private Label lblOther;

    @FXML
    private Label lblPhoneBills;

    @FXML
    private Label lblRent;

    @FXML
    private Label lblSavingPercent;

    @FXML
    private Label lblShopping;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblTest;

    @FXML
    private Label lblTotalExpences;

    @FXML
    private Label lblTransportation;

    @FXML
    private TextField txtFieldEducation;

    @FXML
    private TextField txtFieldElectricity;

    @FXML
    private TextField txtFieldGroceries;

    @FXML
    private TextField txtFieldHealth;

    @FXML
    private TextField txtFieldInsurance;

    @FXML
    private TextField txtFieldInternet;

    @FXML
    private TextField txtFieldLeisure;

    @FXML
    private TextField txtFieldOther;

    @FXML
    private TextField txtFieldPhone;

    @FXML
    private TextField txtFieldRent;

    @FXML
    private TextField txtFieldShopping;

    @FXML
    private TextField txtFieldTransportation;

    @FXML
    private TextField txtFieldUpdateIncome;

    @FXML
    private TextField txtFieldUpdateSavings;

    @FXML
    void updateBtnClicked1(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Phone", txtFieldPhone, lblPhoneBills);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked10(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Shopping", txtFieldShopping, lblShopping);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked11(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Leisure", txtFieldLeisure, lblLeisure);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked12(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Other", txtFieldOther, lblOther);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked2(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Rent", txtFieldRent, lblRent);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked3(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Internet", txtFieldInternet, lblInternet);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked4(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Electricity", txtFieldElectricity, lblElectricity);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked5(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Education", txtFieldEducation, lblEducation);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked6(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Groceries", txtFieldGroceries, lblGroceries);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked7(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Insurance", txtFieldInsurance, lblInsurance);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked8(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Transport", txtFieldTransportation, lblTransportation);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateBtnClicked9(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Health", txtFieldHealth, lblHealth);
        int saving = loadData("Saving", lblSavingPercent);
        int totExp = getData(saving);
        lblTotalExpences.setText(Integer.toString(totExp));
    }

    @FXML
    void updateIncomeBtnClicked(ActionEvent event) throws SQLException {
        updateData(user.getUserName(), "Income", txtFieldUpdateIncome, lblIncomeMonth);
    }

    @FXML
    void updateSavingBtnClicked(ActionEvent event) throws SQLException {
        if (Integer.parseInt(txtFieldUpdateSavings.getText()) <= 100 && Integer.parseInt(txtFieldUpdateSavings.getText()) >= 0) {
            updateData(user.getUserName(), "Saving", txtFieldUpdateSavings, lblSavingPercent);
        } else {
            lblErrors.setText("Please set the saving value to be between 0 and 100!");
            lblErrors.setStyle("-fx-text-fill: #FF0000");
        }
    }

    //For sign up page (create account) 
    @FXML
    private Label messageLabel;
    @FXML
    private TextField txtFldCreateUsername;
    @FXML
    private TextField txtFldIncome;
    @FXML
    private TextField txtFldFamilyMembers;
    @FXML
    private PasswordField txtFldCreatePassword;
    @FXML
    private PasswordField txtFldConfirmPassword;

    @FXML
    private void createClicked(ActionEvent event) throws IOException, SQLException {
        checkValues();
    }

    //Checks the entered values by the user when he/she tries to sign up
    private void checkValues() throws IOException, SQLException {

        boolean isNum = true;
        Double doubleX = 0.0;
        try {
            doubleX = Double.parseDouble(txtFldCreateUsername.getText().trim());
        } catch (NumberFormatException ex) {
            isNum = false;
        }

        if ((txtFldCreateUsername.getText().trim().isEmpty())
                || (txtFldCreatePassword.getText().trim().isEmpty())
                || (txtFldConfirmPassword.getText().trim().isEmpty())
                || (txtFldIncome.getText().trim().isEmpty())
                || (txtFldFamilyMembers.getText().trim().isEmpty())) {
            messageLabel.setText("Please fill all the fields");
            messageLabel.setStyle("-fx-text-fill: #D05F12");//Orange
        } else if ((txtFldCreatePassword.getText().trim()).equals(txtFldConfirmPassword.getText().trim())) {

            if (isNum == false) {
                if ((txtFldCreatePassword.getText().trim().chars().count()) >= (8.00)) {

                    messageLabel.setText("Success");
                    messageLabel.setStyle("-fx-text-fill: #00B050");//Green

                    checkUsername(txtFldCreateUsername, txtFldCreatePassword, txtFldIncome, txtFldFamilyMembers, messageLabel);

                } else {
                    messageLabel.setText("Please use at least 8 Characters for the password");
                    messageLabel.setStyle("-fx-text-fill: #FF0000");//Red
                }
            } else {
                messageLabel.setText("Please include letters in the username");
                messageLabel.setTextFill(Color.RED);
            }

        } else if (!(txtFldCreatePassword.getText().trim()).equals(txtFldConfirmPassword.getText().trim())) {
            messageLabel.setText("Please make sure the password matches in both boxes");
            messageLabel.setStyle("-fx-text-fill: #D05F12");//Orange
        } else {
            messageLabel.setText("An Error has accured");
            messageLabel.setStyle("-fx-text-fill: #FF0000");//Red
        }
    }

    //Gets the users info to use for the sign in.
    private Boolean importData(String s1, String s2, Label lbl) throws IOException, SQLException {
        Connection connection = connectionProvider.getConnection();
        String query = "SELECT Password FROM Users WHERE UserName = ?";
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            stmt = connection.prepareStatement(query);

            stmt.setString(1, s1);

            resultSet = stmt.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                lbl.setText("User not found.");
                lbl.setStyle("-fx-text-fill: #FF0000");//Red
            } else {
                while (resultSet.next()) {
                    String retrievePassword = resultSet.getString("Password");
                    lbl.setText("Wrong Password");
                    lbl.setStyle("-fx-text-fill: #FF0000");//Red
                    if (retrievePassword.equals(s2)) {
                        lbl.setText("Success!!");
                        lbl.setStyle("-fx-text-fill: #00B050");//Green
                        connection.close();
                        return true;
                    }
                }

            }

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With importData Selecting: " + ex.getMessage());
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }

        connection.close();

        return false;

    }

    //Takes the user's info and creates an account.
    private void save(TextField username, PasswordField password,
            TextField income, TextField familyNum) throws SQLException {

        Connection connection = connectionProvider.getConnection();
        String query = "INSERT INTO Users (UserName, Password, Income, Family) VALUES(?,?,?,?) ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, username.getText().toLowerCase().trim());
            pstmt.setString(2, password.getText().trim());
            pstmt.setString(3, income.getText().trim());
            pstmt.setString(4, familyNum.getText().trim());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With Users Update: " + ex.getMessage());
        }
        connection.close();
    }

    private void createUserTable(TextField username) throws SQLException {
        Connection connection = connectionProvider.getConnection();

        String user = username.getText().toLowerCase().trim();

        String sql = "CREATE TABLE IF NOT EXISTS " + user + " (\n"
                + "	Saving integer,\n"
                + "	Phone integer,\n"
                + "	Rent integer,\n"
                + "     Internet integer,\n"
                + "     Electricity integer,\n"
                + "     Education integer,\n"
                + "     Groceries integer,\n"
                + "     Insurance integer,\n"
                + "     Transport integer,\n"
                + "     Health integer,\n"
                + "     Leisure integer,\n"
                + "     Shopping integer,\n"
                + "     Other integer);";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured while creating a user table: " + ex.getMessage());
        }
        insertDataNewTable(user);
        connection.close();
    }

    private void insertDataNewTable(String userName) throws SQLException {

        Connection connection = connectionProvider.getConnection();
        String query = "INSERT INTO " + userName + " (Saving, Phone, Rent, Internet, Electricity, Education, Groceries, Insurance, Transport, Health, Leisure, Shopping, Other) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, 0);
            pstmt.setInt(2, 0);
            pstmt.setInt(3, 0);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.setInt(6, 0);
            pstmt.setInt(7, 0);
            pstmt.setInt(8, 0);
            pstmt.setInt(9, 0);
            pstmt.setInt(10, 0);
            pstmt.setInt(11, 0);
            pstmt.setInt(12, 0);
            pstmt.setInt(13, 0);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With adding empty data to user while creating: " + ex.getMessage());
        }
        connection.close();

    }

    //Checks if the username is already taken. If not, it saves the new user's
    //info using the save() function, creates a tabel in the database for the user
    //for the last 8 days and adds its name to the users table.
    private void checkUsername(TextField username2, PasswordField password2, TextField income,
            TextField familyNum, Label lbl2) throws IOException, SQLException {

        Connection connection = connectionProvider.getConnection();

        String query = "SELECT * FROM Users WHERE UserName = ?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, username2.getText().toLowerCase().trim());

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.isBeforeFirst()) {
                lbl2.setText("The username is already taken, please choose another one");
                lbl2.setStyle("-fx-text-fill: #FF0000");//Red
            } else if (username2.getText().toLowerCase().trim().equals("users")) {
                lbl2.setText("This username is not available, please choose another one");
                lbl2.setStyle("-fx-text-fill: #FF0000");//Red
            } else {
                lbl2.setText("Success! Welcome to Sehtak Fitness!");
                lbl2.setStyle("-fx-text-fill: #00B050");//Green

                save(username2, password2, income, familyNum);
                createUserTable(username2);
                changeScenes("MainPage.fxml", 500, 800);
            }

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With checkUsername Selecting: " + ex.getMessage());
        }
        connection.close();
    }

    //*
    //*
    //*
    //Dashboard
    //*
    //*
    //*
    @FXML
    void loadBtnClicked(ActionEvent event) throws IOException, SQLException {

        lblStatus.setText("");
        lblErrors.setText("");

        lblIncomeMonth.setText(Integer.toString(user.getMonthly_income()));

        int saving = loadData("Saving", lblSavingPercent);
        getData(saving);

    }

    private int getData(int saving) throws SQLException {

        int ex2 = loadData("Phone", lblPhoneBills);
        int ex3 = loadData("Rent", lblRent);
        int ex4 = loadData("Internet", lblInternet);
        int ex5 = loadData("Electricity", lblElectricity);
        int ex6 = loadData("Education", lblEducation);
        int ex7 = loadData("Groceries", lblGroceries);
        int ex8 = loadData("Insurance", lblInsurance);
        int ex9 = loadData("Transport", lblTransportation);
        int ex10 = loadData("Health", lblHealth);
        int ex11 = loadData("Shopping", lblShopping);
        int ex12 = loadData("leisure", lblLeisure);
        int ex13 = loadData("Other", lblOther);
        
        int totExp = ex2 + ex3 + ex4 + ex5 + ex6 + ex7 + ex8 + ex9 + ex10 + ex11 + ex12 + ex13;
        lblTotalExpences.setText(Integer.toString(totExp));
        getStatus(totExp, saving);
        return totExp;
    }

    private void getStatus(int exp, int saving) {
        int result = user.getMonthly_income() - ((100 - saving) / 100) - exp;
        if (exp > user.getMonthly_income()) {
            lblStatus.setText("Your monthly income will not cover your expences. Please reduce the unnecessary expences.");
            lblStatus.setStyle("-fx-text-fill: #FF0000");
            
        } else {
            
            if ((user.getMonthly_income() * saving / 100) < (user.getMonthly_income() - exp)) {
                lblStatus.setText("We suggest looking into your expences to keep up with your saving goal");
                lblStatus.setStyle("-fx-text-fill: #D05F12");
            }
            
            else if(result > 0){
                lblStatus.setText("You are doing great!");
                lblStatus.setStyle("-fx-text-fill: #00B050");
            }

        }
    }

    private int loadData(String expence, Label lbl) throws SQLException {

        Connection connection = connectionProvider.getConnection();
        String query;
        if (expence.equals("Income")) {
            query = "SELECT Income FROM Users WHERE UserName = \"" + user.getUserName() + "\"";
        } else {
            query = "SELECT " + expence + " FROM " + user.getUserName();
        }

        int data = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();

            data = resultSet.getInt(expence);

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With loading data: " + ex.getMessage());
        }

        lbl.setText(Integer.toString(data));
        connection.close();
        return data;
    }

    void updateData(String name, String expense, TextField field, Label lbl) throws SQLException {
        lblStatus.setText("");
        lblErrors.setText("");
        boolean isInteger = true;
        int expenseTest = 0;
        try {
            expenseTest = Integer.parseInt(field.getText());

        } catch (NumberFormatException ex) {
            System.out.println("An Error Has Occured: " + ex.getMessage());
            lblErrors.setText("Please enter the values as integers");
            lblErrors.setTextFill(Color.RED);
            lblErrors.setTextFill(Color.RED);
            isInteger = false;
        }
        if (isInteger == true) {
            Connection connection = connectionProvider.getConnection();
            String query2;

            if (expense.equals("Income")) {
                query2 = "UPDATE Users SET Income = " + expenseTest + " WHERE UserName = \"" + user.getUserName() + "\"";
                user.setMonthly_income(expenseTest);
            } else {
                query2 = "UPDATE " + name + " SET " + expense + " = \"" + expenseTest + "\"";
            }
            try {
                PreparedStatement stmt = connection.prepareStatement(query2);

                stmt.executeUpdate();

                lbl.setText(Integer.toString(expenseTest));
                field.setText("");

            } catch (SQLException ex) {
                System.out.println("An Error Has Occured With User Data Updating: " + ex.getMessage());
            }
            connection.close();
        }

    }

    @FXML
    private void logOutClicked() throws IOException {
        user = null;
        changeScenes("SignIn.fxml", 525, 800);
    }

    @FXML
    private void deleteAccount2Clicked() throws IOException, SQLException {
        changeScenes("DeleteAccount.fxml", 525, 800);
    }

    @FXML
    private void backClicked(ActionEvent event) {
        try {
            changeScenes("SignIn.fxml", 500, 800);
        } catch (IOException ex) {
            Logger.getLogger(ControllerIWillSurvive.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Delete account page
    @FXML
    private Button btnDeleteAccount;
    @FXML
    private Button btnConfrimDelete;
    @FXML
    private Button btnCancelDelete;
    @FXML
    private TextField txtFldUsernameDelete;
    @FXML
    private PasswordField txtFldPasswordDelete;
    @FXML
    private Label lblDeleteInfo;

    @FXML
    private void deleteClicked(ActionEvent event) throws IOException, SQLException {

        String name = txtFldUsernameDelete.getText().trim().toLowerCase();
        String password = txtFldPasswordDelete.getText().trim();

        if ((password.isEmpty()) || (name.isEmpty())) {
            lblDeleteInfo.setText("Please type in both the username and password");
            lblDeleteInfo.setStyle("-fx-text-fill: #D05F12");//Orange
        } else {
            boolean data = importData(name, password, lblDeleteInfo);
            if (data == true) {
                if (!name.equals(user.getUserName())) {
                    lblDeleteInfo.setText("Please enter your own user name");
                    lblDeleteInfo.setStyle("-fx-text-fill: #FF0000");//Red
                } else {

                    lblDeleteInfo.setText("Please confirm delete");
                    lblDeleteInfo.setStyle("-fx-text-fill: #FF0000");//Red
                    btnConfrimDelete.setVisible(true);
                    btnDeleteAccount.setVisible(false);
                    txtFldUsernameDelete.setEditable(false);
                    txtFldPasswordDelete.setEditable(false);
                }
            }
        }

    }

    @FXML
    private void confirmDeleteClicked(ActionEvent event) throws IOException {
        Connection connection = connectionProvider.getConnection();
        String name = txtFldUsernameDelete.getText().trim().toLowerCase();

        String sql = "DELETE FROM Users WHERE UserName = ?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, name);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured while deleting the account from the users data: " + ex.getMessage());
        }
        String sql2 = "DROP TABLE " + name;

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql2);
            pstmt.executeUpdate();

            lblDeleteInfo.setText("User has been deleted succesfully!");
            lblDeleteInfo.setStyle("-fx-text-fill: #D05F12");//Orange
            user = null;

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured while deleting the account table: " + ex.getMessage());
        }
        changeScenes("SignIn.fxml", 500, 800);
    }

    @FXML
    private void cancelDeleteClicked(ActionEvent event) throws IOException {
        changeScenes("MainPage.fxml", 950, 1500);
    }

}

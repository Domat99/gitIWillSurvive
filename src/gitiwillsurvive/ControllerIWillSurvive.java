/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitiwillsurvive;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import DBConnection.DBConnectionProvider;

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
    private Button btnInfoPage;

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
    private Label lblBmiInfo;

    @FXML
    private Label lblEducation;

    @FXML
    private Label lblElectricity;

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
    void infoBtnClicked(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked1(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked10(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked11(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked12(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked2(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked3(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked4(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked5(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked6(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked7(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked8(ActionEvent event) {

    }

    @FXML
    void updateBtnClicked9(ActionEvent event) {

    }

    @FXML
    void updateIncomeBtnClicked(ActionEvent event) {

    }

    @FXML
    void updateSavingBtnClicked(ActionEvent event) {

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
            TextField income, TextField familyNum, Label lbl1) throws SQLException {

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
                + "     Transport integer\n"
                + "     Health integer\n"
                + "     Leisure integer\n"
                + "     Shopping integer\n"
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

                save(username2, password2, income, familyNum, lbl2);
                createUserTable(username2);
                changeScenes("FXMLHealth.fxml", 500, 800);
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
    void loadGraphsBtnClicked(ActionEvent event) throws IOException, SQLException {

        lblIncomeMonth.setText(Integer.toString(user.getMonthly_income()));
        lblSavingPercent.setText(Integer.toString(user.getNumFamily()));
    }

//    @FXML
//    void updateHeightBtnClicked(ActionEvent event) throws SQLException {
//        boolean isInteger = true;
//        int height = 0;
//        try {
//            height = Integer.parseInt(txtFieldUpdateHeight.getText());
//
//        } catch (NumberFormatException ex) {
//            System.out.println("An Error Has Occured With updateHeightBtnClicked: " + ex.getMessage());
//            lblBmiInfo.setText("Please enter the values as integers");
//            lblBmiInfo.setTextFill(Color.RED);
//            lblBmi.setTextFill(Color.RED);
//            isInteger = false;
//        }
//        if (isInteger == true) {
//            Connection connection = connectionProvider.getConnection();
//            String query2 = "UPDATE Users SET Height = " + height + " WHERE UserName = \"" + user.getUserName() + "\"";
//
//            try {
//                PreparedStatement stmt = connection.prepareStatement(query2);
//
//                stmt.executeUpdate();
//
//                user.setMonthly_income(height);
//
//                lblHeight.setText(Integer.toString(height));
//                lblBmi.setText(Integer.toString(calBMI(user.getMonthly_income(), user.getNumFamily())));
//                txtFieldUpdateHeight.setText("");
//
//            } catch (SQLException ex) {
//                System.out.println("An Error Has Occured With User Height Updating: " + ex.getMessage());
//            }
//            connection.close();
//        }
//
//    }

    
    //Import user data from the user's table in database
    private int[] getGraphsData(String name, String column, LocalDate today) throws SQLException {

        String dateToday = today.toString();
        int[] results = new int[4];
        Connection connection = connectionProvider.getConnection();
        String query = "SELECT " + column + " FROM " + name + " WHERE Date = \"" + dateToday + "\"";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();
            int i = 0;
            int retrieveColumn;
            while (resultSet.next()) {
                retrieveColumn = resultSet.getInt(column);
                results[i] = retrieveColumn;
                i += 1;
            }
        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With setGraphsData Selecting: " + ex.getMessage());
        }
        connection.close();
        return results;

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

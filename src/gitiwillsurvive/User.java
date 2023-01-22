/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitiwillsurvive;

/**
 *
 * @author domat
 */
public class User {
    private String userName;
    private String password;
    private int monthly_income;
    private int numFamily;

    public User(String userName, String password, int monthly_income, int numFamily) {
        this.userName = userName;
        this.password = password;
        this.monthly_income = monthly_income;
        this.numFamily = numFamily;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getMonthly_income() {
        return this.monthly_income;
    }

    public void setMonthly_income(int monthly_income) {
        this.monthly_income = monthly_income;
    }

    public int getNumFamily() {
        return this.numFamily;
    }

    public void setNumFamily(int numFamily) {
        this.numFamily = numFamily;
    }

    
}

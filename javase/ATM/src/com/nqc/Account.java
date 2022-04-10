package com.nqc;

public class Account {
    /**
     成员变量私有
     */

    private String cardId;
    private String userName;//用户名
    private String passWord;//密码
    private double money;//账户余额
    private double quotamoney;//每次取现额度

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotamoney() {
        return quotamoney;
    }

    public void setQuotamoney(double quotamoney) {
        this.quotamoney = quotamoney;
    }
}

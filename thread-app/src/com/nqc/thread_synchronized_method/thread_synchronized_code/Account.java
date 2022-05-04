package com.nqc.thread_synchronized_method.thread_synchronized_code;

public class Account {
    private String name;
    private Double money;

    public Account() {
    }

    public Account(Double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public synchronized void DrawMoney(double money) {
        String name = Thread.currentThread().getName();

            if (money <= this.money){
                //可以进行取钱操作
                System.out.println(name + "取钱成功" );
                this.money -= money;
                System.out.println(name + "取钱成功，余额为：" + this.money);
            }else {
                System.out.println(name + "取钱，余额不足！");
            }
    }
}

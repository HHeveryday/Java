package com.nqc.polymorphic_test;

public class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println(name + "已经启动！！！");
    }

    public void run(USB usb){
        usb.Istall();
        if (usb instanceof KeyBoard){
            KeyBoard k = (KeyBoard) usb;
            k.onclick();
        }else if (usb instanceof Mouse){
            ((Mouse) usb).dbclick();
        }
        usb.Unistall();
    }
}

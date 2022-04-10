package com.nqc;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 ATM系统的入口类
 */
public class ATMSystem {
    public static void main(String[] args) {
        //定义一个集合容器，负责以后存储全部的账户对象，进行相关的业务操作。
        //定义一个集合容器，负责以后存储全部的账户对象，进行相关的业务操作。
        ArrayList<Account> accounts = new ArrayList<>();
        //展示系统的首页
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==================ATM系统===================");
            System.out.println("1、账户登录");
            System.out.println("2、账户开户");
            System.out.println("请您选择操作：");
            int command = sc.nextInt();


            switch (command){
                case 1:
                    //进行账户登录操作
                    login(accounts, sc);
                    break;
                case 2:
                    //进行账户开户操作
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("对不起，您输入的操作不存在，请重新输入！");
            }
        }
    }

    /**
     * 登录系统
     * @param accounts 用户集合
     * @param sc 扫描器
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=============登录系统操作===================");
        //1、判断当前是否存在用户
        if (accounts.size() == 0){
            System.out.println("当前无任何用户，请先进行开户操作后再进行登录！");
            return;
        }
        //2、输入卡号进行登录
        while (true) {
            System.out.println("请输入要登录的账户卡号：");
            String CradId = sc.next();
            Account account = getacountById(accounts,CradId);
            if (account != null){
                //账户存在，验证密码
                while (true) {
                    System.out.println("请您输入登录密码：");
                    String passWord = sc.next();
                    if (passWord.equals(account.getPassWord())){
                        //密码正确
                        System.out.println("密码正确，登录成功！！！");
                        ShowUsercommond(account, sc, accounts);
                        return;
                    }else {
                        //密码错误
                        System.out.println("密码错误，请重新输入！！！");
                    }
                }
            }else {
                System.out.println("您输入的账户卡号不存在，请重新输入！");
            }
        }

    }

    /**
     * 登录成功后的用户操作界面
     * @param account 当前登录的用户
     * @param sc
     */
    private static void ShowUsercommond(Account account, Scanner sc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("====================用户操作界面=======================");
            System.out.println("1、查询账户信息");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销用户");
            System.out.println("请选择要进行的操作：");
            int usercommond = sc.nextInt();
            switch (usercommond) {
                case 1:
                    //查询账户信息
                    showaccount(account);
                    break;
                case 2:
                    //存款
                    depositMoney(account,sc);
                    break;
                case 3:
                    //取款
                    drawMoney(account,sc);
                    break;
                case 4:
                    //转账
                    transferMoney(account , accounts , sc);
                    break;
                case 5:
                    //修改密码
                    updatePassword(account, sc);
                    return;
                case 6:
                    //退出
                    System.out.println("退出成功！！！");
                    return;
                case 7:
                    //注销用户
                    //从当前账户集合中，删除当前账户对象

                    if (deleteAccount(account , accounts , sc)){
                        return;
                        //销户成功，回到首页
                    }else{
                        //没有销户，停在操作页
                        break;
                    }

                default:
                    System.out.println("输入错误，请重新输入！");
            }
        }
    }

    /**
     * 对当前登录的账户进行销户操作
     * @param account
     * @param accounts
     * @param sc
     */
    private static boolean deleteAccount(Account account, ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=================用户销户操作界面=======================");
        System.out.println("确认进行销户操作？y/n");
        String next = sc.next();
        switch (next){
            case "y":
                //确认销户
                if (account.getMoney() > 0){
                    System.out.println("您的余额不为0，不允许销户");
                }
                else {
                    accounts.remove(account);
                    System.out.println("您的账户销户完成！！！");
                    return true;
                }
                break;
            default:
                System.out.println("取消销户操作");
        }
        return false;
    }




    /**
     * 修改密码
     * @param account 当前登录的用户
     * @param sc
     */
    private static void updatePassword(Account account, Scanner sc) {
        while (true) {
            System.out.println("=================修改密码操作界面=======================");
            System.out.println("请您输入当前密码：");
            String psd = sc.next();
            //判断这个密码是否正确
            if (account.getPassWord().equals(psd)){
                //密码正确
                while (true) {
                    System.out.println("请您输入新密码：");
                    String newpsd = sc.next();
                    System.out.println("请您再次输入新密码：");
                    String okpad = sc.next();
                    if (newpsd.equals(okpad)){
                        account.setPassWord(okpad);
                        System.out.println("修改密码成功！");
                        return;
                    }else {
                        System.out.println("您两次输入的密码不一致，请重新输入！");
                    }
                }
            }else {
                System.out.println("密码输入错误，请重新输入！");
            }
        }
    }

    /**
     * 转账功能
     * @param account 当前账户
     * @param accounts 全部账户集合
     * @param sc
     */
    private static void transferMoney(Account account, ArrayList<Account> accounts, Scanner sc) {
        System.out.println("===============用户转账界面=================");
        //判断是否足够两个账户
        if (accounts.size() < 2){
            System.out.println("当前系统中不足两个账户，不能进行转账操作，请进行开户操作");
            return;//结束当前方法
        }
        //判断当前账户是否有钱
        if (account.getMoney() == 0){
            System.out.println("当前账户余额为0，不能进行转账操作！");
            return;
        }

        while (true) {
            //开始转账
            System.out.println("请输入对方账户的卡号：");
            String CardId = sc.next();
            //这个卡号不能是自己的卡号
            if (CardId.equals(account.getCardId())){
                System.out.println("不可以给自己进行转账！");
                continue;
            }

            Account account1 = getacountById(accounts, CardId);

            if (account1 == null){
                System.out.println("对不起，您输入的账号不存在！");
            }else {
                //对方账号存在，继续认证对方的姓氏
                String name = account1.getUserName();
                String tip = "*" + name.substring(1);
                System.out.println("请您输入[" + tip + "]的姓氏：");
                String prename = sc.next();
                //认证姓氏是否输入正确

                if (name.startsWith(prename)){
                    //认证成功，进行转账
                    while (true) {
                        System.out.println("请您输入金额：");
                        double money = sc.nextDouble();
                        if (money > account.getMoney()){
                            System.out.println("对不起，您的余额不足，您最多可以转账" + account.getMoney() + "元");
                        }else {
                            //余额充足，可以进行转账
                            account.setMoney(account.getMoney() - money);
                            account1.setMoney(account1.getMoney() + money);
                            System.out.println("转账成功，您的账户还剩" + account.getMoney());
                            return;
                        }
                    }
                }else {
                    System.out.println("您输入的信息有误！");
                }

            }
        }


    }


    /**
     * 取款功能
     * @param account 当前登录用户
     * @param sc
     */
    private static void drawMoney(Account account, Scanner sc) {
        System.out.println("===================用户取款操作界面=====================");
        //1、判断当前账户余额是否大于100
        if (account.getMoney() < 100){
            System.out.println("对不起，当前账户余额不足100元，不能进行取款操作！！！");
            return;
        }
        //2、用户输入取款金额
        while (true) {
            System.out.println("请输入取款金额：");
            double money = sc.nextDouble();

            //3、判断这个金额是否满足要求
            if (money > account.getQuotamoney()){
                System.out.println("对不起，当前取款金额超过每次限额，每次最多可取：" + account.getQuotamoney());
            }else {
                //4、判断是否超过余额
                if (money > account.getMoney()){
                    System.out.println("当前余额不足，您当前账户余额为：" + account.getMoney());
                }else {
                    //可以进行取款操作了
                    System.out.println("取款"+ money +"元成功！！！");
                    //更新余额
                    account.setMoney(account.getMoney() - money);
                    //取款结束
                    showaccount(account);
                    return;
                }
            }
        }
    }

    /**
     * 存款
     * @param account 当前登录的用户
     * @param sc
     */
    private static void depositMoney(Account account, Scanner sc) {
        System.out.println("=================存款操作系统====================");
        System.out.println("请输入要存取金额：");
        double money = sc.nextDouble();
        account.setMoney(account.getMoney() + money);
        System.out.println("存款成功，账户的当前信息如下所示：");
        showaccount(account);
    }

    /**
     * 查询显示当前登录用户的信息
     * @param account
     */
    private static void showaccount(Account account) {
        System.out.println("==================当前用户信息如下===============");
        System.out.println("卡号：" + account.getCardId());
        System.out.println("户主：" + account.getUserName());
        System.out.println("余额：" + account.getMoney());
        System.out.println("限额：" + account.getQuotamoney());
    }

    /**
     * 实现用户开户功能
     * @param accounts 接收的用户集合
     * @param sc 用于录入信息的扫描器
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=====================系统开户操作=======================");
        //1、创建一个用户对象，用于封装信息
        Account account = new Account();
        //2、录入相关信息
        System.out.println("请输入用户账户名称：");
        String name = sc.next();
        account.setUserName(name);
        while (true) {
            System.out.println("请输入用户密码：");
            String password = sc.next();
            System.out.println("请确认用户密码：");
            String okPassWord = sc.next();
            if (password.equals(okPassWord)){
                account.setPassWord(okPassWord);
                break;
            }else {
                System.out.println("两次输入的密码不一致，请重新输入！！！");
            }
        }
        System.out.println("请输入账户当次限额：");
        double quotaMoney = sc.nextDouble();
        account.setQuotamoney(quotaMoney);

        //为用户随机一个8位不与其他账户卡号不重复的号码
        String CardId = getRandomCardId(accounts);
        account.setCardId(CardId);

        //3、将录入好信息的用户对象存入用户集合中
        accounts.add(account);
        System.out.println("恭喜您" + name + "先生/女生，您开户成功，您的卡号为：" + CardId + "，请妥善保管");
    }

    /**
     * 随机生成8位唯一的号码
     * @param accounts 用户集合
     * @return CardId
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        //生成8位随机号码
        Random r = new Random();
        while (true) {
            String CardId = "";
            for (int i = 0; i < 8; i++) {
                CardId += r.nextInt(10);
            }
            //判断生成的卡号是否唯一
            Account account = getacountById(accounts, CardId);
            if (account == null){
                //说明该卡号没有没使用
                return CardId;
            }
        }
    }

    /**
     * 根据卡号查找用户
     * @param accounts 用户集合
     * @param CardId 要查询的卡号
     * @return 找到的相关用户/null
     */
    private static Account getacountById(ArrayList<Account> accounts, String CardId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getCardId().equals(CardId)){
                //找到了
                return account;
            }
        }
        //没有找到
        return null;
    }
}



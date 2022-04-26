package com.nqc.run;

import com.nqc.bean.Business;
import com.nqc.bean.Customer;
import com.nqc.bean.Movie;
import com.nqc.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieSystem {

    /**
     * 1、定义集合来存储用户的信息
     */

    public static final List<User> ALL_USERS = new ArrayList<>();

    /**
     * 2、定义map来存储商家和其排片信息
     */
    public static Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();

    public static final Scanner SYS_SC = new Scanner(System.in);

    public static User loginUser;//用于记录当前系统登录成功的用户

    public static final Logger LOGGER = LoggerFactory.getLogger("MovieSystem.class");

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");



    /**
     3、准备一些测试数据
     */
    static {
        Customer c = new Customer();
        c.setLoginName("zyf888");
        c.setPassWord("123456");
        c.setUserName("黑马刘德华");
        c.setSex('男');
        c.setMoney(10000);
        c.setPhone("110110");
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassWord("123456");
        c1.setUserName("黑马关之琳");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone("111111");
        ALL_USERS.add(c1);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b , movies); // b = []

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassWord("123456");
        b2.setUserName("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b2 , movies3); // b2 = []
    }
    public static void main(String[] args) {
        showMain();
    }

    /**
     * 首页展示
     */
    private static void showMain() {
        while (true) {
            System.out.println("-----------------电影系统首页-------------------");
            System.out.println("1、登录");
            System.out.println("2、用户注册");
            System.out.println("3、商家注册");
            System.out.println("请输入要进行的操作：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    loginMain();
                    break;
                case "2":
                    //
                    break;
                case "3":
                    break;
                default:
                    System.out.println("您的选择有误，请重新选择！！！");
            }
        }
    }

    /**
     * 登录界面
     */
    private static void loginMain() {
        System.out.println("-----------用户登录界面----------------");
        while (true) {
            System.out.println("请输入用户名：");
            String name =  SYS_SC.nextLine();
            System.out.println("请输入登录密码：");
            String passWord =  SYS_SC.nextLine();
            //遍历所有用户集合，查询是否有此用户名
            for (User user : ALL_USERS) {
                if (user.getLoginName().equals(name)){
                    //接着验证密码
                    if (user.getPassWord().equals(passWord)){
                        //密码也正确，将该用户放入静态变量USER中，方便后续程序调用
                        loginUser = user;
                        //然后判断是用户登录还是商家登录
                        if (user instanceof Customer){
                            //说明为用户登录，进入用户操作界面
                            showCustomerMain();
                        }else {
                            //说明为商家登录，进入商家操作界面
                            showBusinessMain();
                        }
                        return;
                    }else {
                        //密码不正确
                        System.out.println("密码不正确！！！");
                    }
                }
            }
            //没有找到此用户
            System.out.println("没有此用户，请重新输入！！！");
        }
    }

    private static void showBusinessMain() {
        while (true) {
            System.out.println("==============电影商家界面===================");
            System.out.println(loginUser.getUserName() + (loginUser.getSex()=='男'? "先生":"女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");

            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    showBusinessInfo();
                    break;
                case "2":
                    // 上架电影信息
                    addMovie();
                    break;
                case "3":
                    // 下架电影信息
                    removeMovie();
                    break;
                case "4":
                    // 修改电影信息
                    updateMovie();
                    break;
                case "5":
                    System.out.println(loginUser.getUserName() +"请您下次再来啊~~~");
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }


    /**
     * 商家修改电影
     */
    private static void updateMovie() {
        System.out.println("================修改电影====================");
        // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);

        if (movies.size() == 0) {
            System.out.println("您的店铺当前没有上架任何电影！");
            return;
        }
        System.out.println("请输入要修改的电影名称：");
        String movieName = SYS_SC.nextLine();
        Movie movie = findMovieByName(movieName);
        if (movie != null) {
            //进行修改操作
            System.out.println("请您输入新片名：");
            String name = SYS_SC.nextLine();
            movie.setName(name);
            System.out.println("请您输入主演：");
            String actor = SYS_SC.nextLine();
            movie.setActor(actor);
            System.out.println("请您输入时长：");
            String time = SYS_SC.nextLine();
            movie.setTime(Double.valueOf(time));
            System.out.println("请您输入票价：");
            String price = SYS_SC.nextLine();
            movie.setPrice(Double.valueOf(price));
            System.out.println("请您输入票数：");
            String totalNumber = SYS_SC.nextLine(); // 200\n
            movie.setNumber(Double.valueOf(totalNumber));
            while (true) {
                try {
                    System.out.println("请您输入影片放映时间：");
                    String stime = SYS_SC.nextLine();
                    movie.setStartTime(sdf.parse(stime));
                    System.out.println("您以成功修改该电影！！！");
                    return;
                } catch (ParseException e) {
                    e.printStackTrace();
                    LOGGER.error("时间解析出了毛病");
                }

            }
        } else {
            System.out.println("没有找到该电影！！！");
        }
    }

        /**
         * 商家下架电影
         */
        private static void removeMovie () {
            System.out.println("================下架电影====================");
            // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
            Business business = (Business) loginUser;
            List<Movie> movies = ALL_MOVIES.get(business);

            if (movies.size() == 0) {
                System.out.println("您的店铺当前没有上架任何电影！");
                return;
            }
            System.out.println("请输入要下架的电影名称：");
            String movieName = SYS_SC.nextLine();
            Movie movie = findMovieByName(movieName);
            if (movie != null) {
                System.out.println("您以成功电影：" + movie.getName());
                movies.remove(movie);
            } else {
                System.out.println("没有找到该电影！！！");
            }
        }

        public static Movie findMovieByName (String movieName){
            Business business = (Business) loginUser;
            List<Movie> movies = ALL_MOVIES.get(business);
            for (Movie movie : movies) {
                if (movie.getName().contains(movieName)) {
                    return movie;
                }
            }
            return null;
        }

        private static void addMovie () {
            System.out.println("================上架电影====================");
            // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
            Business business = (Business) loginUser;
            List<Movie> movies = ALL_MOVIES.get(business);

            System.out.println("请您输入新片名：");
            String name = SYS_SC.nextLine();
            System.out.println("请您输入主演：");
            String actor = SYS_SC.nextLine();
            System.out.println("请您输入时长：");
            String time = SYS_SC.nextLine();
            System.out.println("请您输入票价：");
            String price = SYS_SC.nextLine();
            System.out.println("请您输入票数：");
            String totalNumber = SYS_SC.nextLine(); // 200\n
            while (true) {
                try {
                    System.out.println("请您输入影片放映时间：");
                    String stime = SYS_SC.nextLine();
                    //   public Movie(String name, String actor, Date startTime, double price, double number, double time)        // 封装成电影对象 ，加入集合movices中去
                    Movie movie = new Movie(name, actor, sdf.parse(stime), Double.valueOf(price)
                            , Integer.valueOf(totalNumber), Double.valueOf(time));
                    movies.add(movie);
                    System.out.println("您已经成功上架了：《" + movie.getName() + "》");
                    return; // 直接退出去
                } catch (ParseException e) {
                    e.printStackTrace();
                    LOGGER.error("时间解析出了毛病");
                }
            }
        }

        private static void showBusinessInfo () {
            System.out.println("================商家详情界面==================");
            LOGGER.info(loginUser.getUserName() + "商家，正在看自己的详情~~~");
            // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
            Business business = (Business) loginUser;
            System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone()
                    + "\t\t地址:" + business.getAddress() + "\t\t余额：" + business.getMoney());
            List<Movie> movies = ALL_MOVIES.get(business);
            if (movies.size() > 0) {
                System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
                for (Movie movie : movies) {

                    System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                            + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice() + "\t\t" + movie.getNumber() + "\t\t"
                            + sdf.format(movie.getStartTime()));
                }
            } else {
                System.out.println("您的店铺当前无片在放映~~~~");
            }
        }


        private static void showCustomerMain () {
            while (true) {
                System.out.println("==============电影客户界面===================");
                System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男' ? "先生" : "女士" + "欢迎您进入系统" +
                        "\t余额：" + loginUser.getMoney()));
                System.out.println("请您选择要操作的功能：");
                System.out.println("1、展示全部影片信息功能:");
                System.out.println("2、根据电影名称查询电影信息:");
                System.out.println("3、评分功能:");
                System.out.println("4、购票功能:");
                System.out.println("5、退出系统:");
                System.out.println("请输入您要操作的命令：");
                String command = SYS_SC.nextLine();
                switch (command) {
                    case "1":
                        // 展示全部排片信息
                        showAllMovie();
                        break;
                    case "2":
                        break;
                    case "3":
                        // 评分功能
                        break;
                    case "4":
                        // 购票功能
                        break;
                    case "5":
                        return; // 干掉方法
                    default:
                        System.out.println("不存在该命令！！");
                        break;
                }
            }
        }


    /**
     * 展示所有的电影信息
     */
    private static void showAllMovie() {
        ALL_MOVIES.forEach(((business, movies) -> {
            System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone()
                    + "\t\t地址:" + business.getAddress());
            System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {

                System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t" + movie.getTime()
                        + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice() + "\t\t" + movie.getNumber() + "\t\t"
                        + sdf.format(movie.getStartTime()));
            }
        }));
    }
}

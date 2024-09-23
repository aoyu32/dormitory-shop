package Store;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


/**
 * 宿舍商店入口类
 */
public class dormitoryStore {
    public static void main(String[] args) {

        //创建一个存储所有用户信息的集合
        ArrayList<accounts> Accounts = new ArrayList<>();
        //定义一个存储订单信息的集合
        ArrayList<myOrders> ordersInformation = new ArrayList<>();

        //获取扫描器对象
        Scanner scanner = new Scanner(System.in);

        //商店首页
        while (true) {
            //登录界面
            System.out.println("\33[m" + "￥￥=========================$[" + "\033[34;1m" + "傲宇宿舍商店" + "\033[m" + "]$=========================￥￥");
            System.out.println(" |                      W E L C O M E , C O M E                     |");
            System.out.println("\33[m" + "￥￥================================================================￥￥");
            System.out.println(" |       " + "1:" + "\033[34m" + " 登录");
            System.out.println("\33[m" + " |       " + "2:" + "\033[34m" + " 注册");
            System.out.println("\033[33m" + "[all@login.or.register ~]$ ");
            //获取用户输入的操作命令 userCommand(用户命令)
            String userCommand = scanner.next();

            //命令操作的功能
            switch (userCommand) {
                case "1":
                    System.out.println(".");
                    login(ordersInformation, Accounts, scanner);
                    break; //登录功能
                case "2":
                    System.out.println(".");
                    register(Accounts, scanner);
                    break;//注册功能
                default:
                    System.out.println(".");
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");


            }
        }

    }

    //注册账号的方法

    /**
     * 用户注册功能的实现
     *
     * @param Accounts 接收用户信息的集合
     * @return 返回一串账号
     */
    public static accounts register(ArrayList<accounts> Accounts, Scanner sc) {
        /*注册账号界面*/
        System.out.println("\33[m" + "￥￥=========================$[" + "\033[34;1m" + "傲宇宿舍商店" + "\033[m" + "]$=========================￥￥");
        System.out.println(" |                   W E L C O M E , R E G I S T E R                |");
        System.out.println("￥￥================================================================￥￥");
        System.out.println(" |                                                                  |");
        System.out.println(" |                                                                  |");
        System.out.println("￥￥+++++++++++++++++++++++++$【 注册账户 】$+++++++++++++++++++++++++￥￥");

        /* 创建一个用户对象*/
        accounts userAccounts = new accounts();
        System.out.println("￥￥------------------------$< 设置用户名称 >$------------------------￥￥");
        /*设置账户名称信息*/
        System.out.println("\033[33m" + "[all@enter.输入账户名称 ~]$ ");
        String username = sc.next();
        System.out.println(".");
        userAccounts.setUserName(username);
        System.out.println("\033[32m" + "[账户名称设置成功。");
        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");

        //判断账户名称是否有重复

        System.out.println("￥￥------------------------$< 设置登录密码 >$------------------------￥￥");
        /*设置用户密码信息*/
        while (true) {
            System.out.println("\033[33m" + "[all@enter.输入账号登录密码 ~]$ ");
            String userPasswd = sc.next();
            userAccounts.setUserPasswd(userPasswd);
            System.out.println("\033[33m" + "[all@enter.再次输入账号密码 ~]$ ");
            String userPasswd2 = sc.next();
            //判断两次密码输入的是否相同
            if (userPasswd.equals(userPasswd2)) {
                System.out.println(".");
                System.out.println("\033[32m" + "[密码设置成功。 ~]");
                break; //跳出死循环
            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[ERROR:你两次输入的密码不一致，请重新输入！！]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
            }
        }
        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");


        /*设置账户支付密码*/
        managePayPasswd(userAccounts, userAccounts, sc, "set", "Yes", "No");


        /*设置用户宿舍门牌号信息（楼层范围在1~6）*/
        System.out.println("￥￥------------------------$< 设置门牌号码 >$------------------------￥￥");
        String choseNumber = settingDoorNumber(userAccounts, Accounts, sc);
        userAccounts.setDormitoryNumber(choseNumber);
        System.out.println("\033[32m" + "[宿舍门牌号设置成功。 ~]");
        System.out.println("\33[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");


        /*设置用户电话号码*/
        System.out.println("￥￥------------------------$< 绑定手机号码 >$------------------------￥￥");
        //询问是否绑定手机号
        System.out.println(".");
        System.out.println("\033[32m" + "[绑定手机号才能购买商品,是否现在绑定手机号 ~]$");
        while (true) {
            System.out.println("\33[m" + "[1: " + "\033[34m" + "现在绑定 " + "\033[m" + "~]");
            System.out.println("[2: " + "\033[34m" + "稍后绑定 " + "\033[m" + "~]");
            System.out.println("\033[33m" + "[all@enter.command ~]$");
            String bindNowOrLater = sc.next();
            if (bindNowOrLater.equals("1")) {
                setPhoneNumber(userAccounts, sc, "绑定");
                break;
            } else if (bindNowOrLater.equals("2")) {
                userAccounts.setPhoneNumber("未绑定");
                System.out.println(".");
                System.out.println("\033[31m" + "[已跳过绑定手机号操作 ~]");
                break;
            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                System.out.println(".");
            }

        }
        System.out.println("\33[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");



        /*随机生成一个十位数的账号*/
        System.out.println("￥￥------------------------$< 账号注册成功 >$------------------------￥￥");
        System.out.println(" |                 R E G I S T E R , S U C C E E D                  |");
        System.out.println("￥￥----------------------------------------------------------------￥￥");
        String userIDNumber = getRamdomUserID(Accounts);
        userAccounts.setUserID(userIDNumber);
        System.out.println("\033[32m" + "[恭喜你,账户注册成功 ~]");
        System.out.println("\33[m" + " |                                                                  |");
        System.out.println("\033[32m" + "[ 你的账号是 ~] : " + "\033[34m" + userIDNumber + "\033[32m" + "   [ 请使用该账号登录到你的账户！]");
        System.out.println("\033[m" + "[-------------------------------------------------------------------]" + "\n\n");

        /*把账户信息添加到账户信息集合中*/
        Accounts.add(userAccounts);
        return userAccounts;
    }

    /**
     * 随机生成账号的方法
     *
     * @param Accounts 账户集合
     * @return 返回生成的账号
     */
    public static String getRamdomUserID(ArrayList<accounts> Accounts) {
        Random random = new Random();
        while (true) {
            //随机生成10位数
            String userIDNumber = "";
            for (int i = 0; i < 10; i++) {
                userIDNumber += random.nextInt(10);
            }
            //判断是否有生成重复的账号
            accounts acc = duplicateAccount(Accounts, userIDNumber);
            if (acc == null) {
                return userIDNumber;
            }
        }

    }

    /**
     * 判断生成的账号是否有重复的方法
     *
     * @param Accounts      账户集合
     * @param userIDNumbers 生成的用户账号
     * @return 返回没重复的用户账号
     */
    public static accounts duplicateAccount(ArrayList<accounts> Accounts, String userIDNumbers) {
        for (int i = 0; i < Accounts.size(); i++) {
            accounts acc = Accounts.get(i);
            if (acc.getUserID().equals(userIDNumbers)) {
                return acc;
            }

        }
        return null;
    }


    /**
     * 登录账户的方法
     *
     * @param Accounts 账户信息集合
     * @param sc       扫描器对象
     */
    public static void login(ArrayList<myOrders> ordersInformation, ArrayList<accounts> Accounts, Scanner sc) {


        //判断系统中是否有用户存在
        if (Accounts.size() == 0) {
            System.out.println(".");
            System.out.println("\33[31m" + "[ERROR:系统中无用户，请注册 ~~]");
            System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");
            return;
        }
        System.out.println("\33[m" + "￥￥=========================$[" + "\033[34;1m" + "傲宇宿舍商店" + "\033[m" + "]$=========================￥￥");
        System.out.println(" [                    W E L C O M E , L O G I N                     ]");
        System.out.println("￥￥================================================================￥￥");
        System.out.println(" [                                                                  ]");
        System.out.println(" [                                                                  ]");
        System.out.println("￥￥+++++++++++++++++++++++++$【 登录账号 】$+++++++++++++++++++++++++￥￥");
        //输入账号
        while (true) {
            System.out.println(" [                                                                  ]");
            System.out.println(" [                                                                  ]");
            System.out.println(" |" + "\033[33m" + "[all@enter.输入账号 ~]$ ");
            String enterUserID = sc.next();
            //判断输入的账号是否正确
            accounts loginUser = duplicateAccount(Accounts, enterUserID);
            if (loginUser != null) {

                while (true) {
                    //输入账号密码
                    System.out.println("\033[m" + " |" + "\033[33m" + "[all@enter.输入密码 ~]$ ");
                    String enterPasswd = sc.next();
                    System.out.println(".");
                    //判断密码是否正确
                    if (enterPasswd.equals(loginUser.getUserPasswd())) {

                        //选择是否登录操作
                        while (true) {
                            System.out.println("\33[m" + " [     1: " + "\033[34m" + "确认登录" + "\033[m");
                            System.out.println(" [ 任意键: " + "\033[34m" + "取消登录");
                            System.out.println("\033[33m" + " |[all@enter.command ~]$ ");
                            String enter = sc.next();
                            System.out.println(".");
                            switch (enter) {
                                case "1":

                                    System.out.println("\033[32m" + " [登录成功，欢迎" + "”" + "\033[34m" + loginUser.getUserName() + "\033[32m" + "“" + "光临傲宇商店 ~~]");
                                    System.out.println("\33[m" + "￥￥------------------------$< 账号登录成功 >$------------------------￥￥");
                                    System.out.println(" [                    L O G I N , S U C C E E D                     ]");
                                    System.out.println("￥￥----------------------------------------------------------------￥￥");

                                    System.out.println("\n");

                                    //登录成功后商店的操作界面
                                    storeCommand(ordersInformation, Accounts, loginUser, sc);
                                    break;
                                default:
                                    System.out.println(".");
                                    System.out.println("\033[31m" + " [登录操作已取消！！ ~]");
                                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                                    break;
                            }
                            return;
                        }


                    } else {
                        System.out.println("\033[31m" + " [ERROR:你输入的密码不正确，请重新输入！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    }
                }
            } else {
                System.out.println(" .");
                System.out.println("\033[31m" + " [ERROR:你输入的账号不存在，请重新输入！！]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                System.out.println("\033[m" + "￥￥+++++++++++++++++++++++++$【 登录账号 】$+++++++++++++++++++++++++￥￥");
            }
        }


    }

    /**
     * 商店操作界面
     */
    public static void storeCommand(ArrayList<myOrders> ordersInformation, ArrayList<accounts> Accounts, accounts loginUser, Scanner sc) {
        while (true) {
            System.out.println("\033[m" + "￥￥*************************#[" + "\033[34;1m" + "傲宇商店首页" + "\033[m" + "]#*************************￥￥");
            System.out.println(" |                   S E L E C T , A C T I O N S                    |");
            System.out.println("￥￥****************************************************************￥￥");
            System.out.println(" |  [1: " + "\033[34m" + "选购商品   " + "\33[m" + "~]                                                | ");
            System.out.println(" |  [2: " + "\033[34m" + "我的订单   " + "\33[m" + "~]                                                | ");
            System.out.println(" |  [3: " + "\033[34m" + "我的信息   " + "\33[m" + "~]                                                | ");
            System.out.println(" |  [4: " + "\033[34m" + "用户设置   " + "\33[m" + "~]                                                | ");
            System.out.println(" |  [请输入选项命令进行操作  ~]");
            System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.options.command   ~]#");
            String enterStoreCommand = sc.next();
            System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");

            switch (enterStoreCommand) {
                case "1":
                    //查看商品
                    //返回的商品信息集合
                    ArrayList<storeCommodity> products = allProducts();
                    //调用展示商品信息的方法
                    printProductInformation(ordersInformation, products, loginUser, sc);
                    break;

                case "2":
                    allMyOrders(ordersInformation, sc, loginUser);
                    //订单信息
                    break;
                case "3":
                    //我的信息
                    accountInformation(loginUser, sc);
                    break;
                case "4":
                    //用户设置
                    int returnBack = userSettings(Accounts, loginUser, sc);
                    if (returnBack == 1) {
                        return;
                    } else {
                        break;
                    }
                default:
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请输入1~9的数值！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                    break;
            }
        }
    }


    /**
     * 显示用户信息的方法
     *
     * @param loginUser 登录的用户对象
     */
    public static void accountInformation(accounts loginUser, Scanner sc) {
        while (true) {
            System.out.println("￥￥------------------------#< 我的账户信息 >#------------------------￥￥");
            System.out.println("用户名称:" + "\033[34m" + loginUser.getUserName() + "\33[m");
            System.out.println("账户ID:" + "\033[34m" + loginUser.getUserID() + "\33[m");
            System.out.println("宿舍门牌号:" + "\033[34m" + loginUser.getDormitoryNumber() + "\33[m");
            System.out.println("余额:" + "\033[34m" + loginUser.getUserBalance() + "元" + "\33[m");
            System.out.println("手机号码:" + "\033[34m" + loginUser.getPhoneNumber() + "\33[m");
            System.out.println(".");
            System.out.println("\033[32m" + "[输入命令" + "\033[34m" + "“ 1 ”" + "\033[32m" + "返回商店首页 ~]");
            System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.back.home ~]#");
            String backStoreHome = sc.next();
            if (backStoreHome.equals("1")) {
                System.out.println(".");
                System.out.println("\033[31m" + "[已返回商店首页 ~]");
                System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");
                return;
            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[输入的返回命令错误,若要返回请输入" + "\033[34m" + "” 1 “" + "\033[31m" + " ~]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
            }
            System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");
        }

    }

    /**
     * 余额管理的方法
     *
     * @param loginUser 登录的用户对象
     * @return 返回充值的余额
     */
    public static double balanceTopUo(accounts loginUser, double addMoney, Scanner sc) {

        System.out.println(".");
        //定义一个变量接收当前余额
        double nowBalance = loginUser.getUserBalance();
        while (true) {
            System.out.println("\033[m" + "[1: " + "\033[34m" + "确认充值" + "\033[m" + " ~]");
            System.out.println("\033[m" + "[2: " + "\033[34m" + "取消充值" + "\033[m" + " ~]");
            System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.是否确定充值 ~]#");
            String surePay = sc.next();
            switch (surePay) {
                case "1":
                    String passwdTure = verifyPayPasswd(loginUser, sc);
                    if (passwdTure.equals("1")) {
                        nowBalance += addMoney;
                        System.out.println(".");
                        System.out.println("\033[32m" + "[充值成功 ~]");
                        loginUser.setUserBalance(nowBalance);
                        System.out.println(".");
                        System.out.println("\033[32m" + "[当前余额 : " + "\033[34m" + loginUser.getUserBalance() + "元" + "\033[32m" + "   ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return nowBalance;
                    } else {
                        System.out.println(".");
                        System.out.println("\033[32m" + "[充值失败,用户未支付 ~]");
                        System.out.println("\033[32m" + "[当前余额 : " + "\033[34m" + loginUser.getUserBalance() + "元" + "\033[32m" + "   ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        break;
                    }
                case "2":
                    System.out.println(".");
                    System.out.println("\033[32m" + "[用户充值操作已取消,充值失败,返回账户设置页 ~]");
                    System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                    return nowBalance;
                default:
                    System.out.println(".");
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    break;
            }
        }

    }

    /**
     * 验证支付密码是否正确的方法
     *
     * @param loginUser 当前登录的用户
     * @param sc        扫描器对象
     */
    public static String verifyPayPasswd(accounts loginUser, Scanner sc) {
        while (true) {
            System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.输入支付密码 ~]#");
            String enterPayPassed = sc.next();
            if (enterPayPassed.length() == 6) {
                if (enterPayPassed.equals(loginUser.getPayPasswd())) {
                    System.out.println("\033[32" + "[密码正确 ~]");
                    return "1";
                } else {
                    System.out.println(".");
                    System.out.println("\033[31m" + "[ERROR:密码错误 ~]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                    System.out.println("\033[m" + "[1: " + "\033[34m" + "重新输入" + "\033[m" + " ~]");
                    System.out.println("\033[m" + "[2: " + "\033[34m" + "取消支付" + "\033[m" + " ~]");
                    System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.是否重新输入 ~]#");
                    String againEnter = sc.next();
                    switch (againEnter) {
                        case "1":
                            System.out.println(".");
                            break;
                        case "2":
                            System.out.println(".");
                            System.out.println("\033[32m" + "[已取消支付 ~]");
                            return "3";
                        default:
                            System.out.println(".");
                            System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                            System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                            break;
                    }

                }
            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[ERROR:密码位数有误，请输入6位数密码 ~]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
            }
        }
    }

    /**
     * 修改用户密码的方法
     *
     * @param loginUser 登录的用户对象
     * @param sc        扫描器对象
     */
    public static int changePasswd(accounts loginUser, Scanner sc) {
        System.out.println("\033[m" + "￥￥------------------------#< 修改账户密码 >#------------------------￥￥");
        //定义一个变量接收验证密码是否正确的结果
        int verifyResult = verifyPassword(loginUser, sc);
        if (verifyResult == 1) {
            return 1;
        } else {
            while (true) {
                System.out.println("\033[m" + "[1: " + "\033[34m" + "忘记密码,使用手机号码验证" + "\033[m" + " ~]");
                System.out.println("\033[m" + "[2: " + "\033[34m" + "记得密码,重新输入密码验证" + "\033[m" + " ~]");
                System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.是否记得密码   ~]#");
                String enter = sc.next();
                switch (enter) {
                    case "1":
                        //忘记密码，使用手机号码验证
                        int backResult1 = verifyPhone(loginUser, sc);
                        if (backResult1 == 1) {
                            return 1;
                        } else if (backResult1 == 3) {
                            return 3;
                        } else {
                            break;
                        }
                    case "2":
                        int backResult = verifyPassword(loginUser, sc);
                        if (backResult == 1) {
                            return 1;
                        } else break;
                        //记得密码，重新输入密码验证
                    default:
                        System.out.println(".");
                        System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                        break;
                }
            }
        }


    }

    /**
     * 直接输入原密码来修改密码的方法
     *
     * @param loginUser 当前登录的账户对象
     * @param sc        扫描器对象
     * @return 返回用于判断是否修改密码成功的整数
     */
    public static int verifyPassword(accounts loginUser, Scanner sc) {


        //输入旧密码
        System.out.println(".");
        while (true) {
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入原来的账户密码 ~]#");
            String oldPasswd = sc.next();
            if (oldPasswd.equals(loginUser.getUserPasswd())) {
                while (true) {
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入新的账户密码 ~]#");
                    String newPasswd = sc.next();
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.再次输入新的账户密码 ~]#");
                    String againNewPasswd = sc.next();
                    if (againNewPasswd.equals(newPasswd)) {
                        loginUser.setUserPasswd(newPasswd);
                        System.out.println(".");
                        System.out.println("\033[32m" + "[修改密码成功！ ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        break;
                    } else {
                        System.out.println(".");
                        System.out.println("\033[31m" + "[ERROR:你两次输入的密码不一致，请重新输入！！ ~]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R--------￥￥" + "\033[m");
                    }
                }
                return 1;
            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[ERROR:你输入的密码和原密码不一致！！ ~]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                return 0;
            }
        }

    }

    /**
     * 通过手机号修改密码的方法
     *
     * @param loginUser 当前登录的账户对象
     * @param sc        扫描器对象
     * @return 返回用于判断是否修改密码成功的整数
     */
    public static int verifyPhone(accounts loginUser, Scanner sc) {

        if (loginUser.getPhoneNumber().equals("未绑定")) {
            System.out.println(".");
            System.out.println("\033[31m" + "[ERROR:你的账户未绑定手机号,无法通过手机号进行找回,请先绑定手机号！！ ~]");
            System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n" + "\033[m");
            return 3;
        } else {
            //输入旧密码
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入该用户使用的手机号 ~]#");
            String oldPhone = sc.next();
            if (oldPhone.equals(loginUser.getPhoneNumber())) {
                while (true) {
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入输入新密码 ~]#");
                    String newPasswd = sc.next();
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.再次输入新密码 ~]#");
                    String againNewPasswd = sc.next();
                    if (againNewPasswd.equals(newPasswd)) {
                        loginUser.setUserPasswd(newPasswd);
                        System.out.println(".");
                        System.out.println("\033[32m" + "[修改密码成功！ ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        break;
                    } else {
                        System.out.println(".");
                        System.out.println("\033[31m" + "[ERROR:你两次输入的密码不一致，请重新输入！！ ~]");
                        System.out.println("\033[31m" + "[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    }
                }
                return 1;
            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[ERROR:你输入的手机号与该账户使用的手机号不一致！！ ~]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n" + "\033[m");
                return 0;
            }
        }
    }

    /**
     * 注销账户的方法
     *
     * @param loginUser 当前登录的账户对象
     * @param sc        扫描器对象
     */
    public static int logoutAccount(ArrayList<accounts> Accounts, accounts loginUser, Scanner sc) {

        System.out.println("\033[m" + "￥￥------------------------#< 注销当前用户 >#------------------------￥￥");
        System.out.println(".");
        //判断账户中是否还有余额
        if (loginUser.getUserBalance() == 0) {

            System.out.println("\033[32m" + "[你当前账户的余额为: " + "<" + "\033[34m" + loginUser.getUserBalance() + "元" + "\033[32m" + ">   ~]");
            //询问是否确定销户
            System.out.println(".");
            while (true) {
                System.out.println("\033[m" + "[1: " + "\033[34m" + "确定注销" + "\033[m" + " ~]");
                System.out.println("\033[m" + "[2: " + "\033[34m" + "取消注销" + "\033[m" + " ~]");
                System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否确定注销 ~]#");
                String logoutSureOrNot = sc.next();
                switch (logoutSureOrNot) {
                    case "1":
                        Accounts.remove(loginUser);
                        System.out.println(".");
                        System.out.println("\033[32m" + "[当前账户已注销,已退出到登录界面 ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return 1;
                    case "2":
                        System.out.println(".");
                        System.out.println("\033[32m" + "[注销操作已取消,已返回我的账户设置页 ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return 0;
                    default:
                        System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！ ~]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                        break;
                }
            }
        } else {
            System.out.println("\033[32m" + "[你当前账户的余额为: " + "<" + "\033[34m" + loginUser.getUserBalance() + "元" + "\033[32m" + ">   ~]");
            System.out.println(".");
            //询问是否确定销户
            System.out.println("\033[32m" + "[你确定要注销当前账户？注销账户余额将不会返还，请谨慎操作！！ ~]");
            while (true) {
                System.out.println("\033[m" + "[1: " + "\033[34m" + "确定注销" + "\033[m" + " ~]");
                System.out.println("\033[m" + "[2: " + "\033[34m" + "取消注销" + "\033[m" + " ~]");
                System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否确定注销 ~]#");
                String logoutSureOrNot = sc.next();
                switch (logoutSureOrNot) {
                    case "1":
                        Accounts.remove(loginUser);
                        System.out.println(".");
                        System.out.println("\033[32m" + "[当前账户已注销,已退出到登录界面 ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return 1;
                    case "2":

                        System.out.println(".");
                        System.out.println("\033[32m" + "[注销操作已取消,已返回我的账户设置页 ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return 0;
                    default:
                        System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                        break;
                }
            }
        }
    }

    /**
     * 用户设置的方法
     *
     * @param Accounts  用户信息集合
     * @param loginUser 当前登录的用户对象
     * @param sc        扫描器对象
     * @return 返回整数用来跳出方法或循环
     */
    public static int userSettings(ArrayList<accounts> Accounts, accounts loginUser, Scanner sc) {


        //用户设置操作选项
        while (true) {
            System.out.println("\033[m" + "￥￥------------------------#< 我的账户设置 >#------------------------￥￥");
            System.out.println("[1: " + "\033[34m" + "修改此用户名   " + "\33[m" + "~]");
            System.out.println("[2: " + "\033[34m" + "管理此手机号   " + "\33[m" + "~]");
            System.out.println("[3: " + "\033[34m" + "修改账户密码   " + "\33[m" + "~]");
            System.out.println("[4: " + "\033[34m" + "修改支付密码   " + "\33[m" + "~]");
            System.out.println("[5: " + "\033[34m" + "修改宿舍牌号   " + "\33[m" + "~]");
            System.out.println("[6: " + "\033[34m" + "账户余额充值   " + "\33[m" + "~]");
            System.out.println("[7: " + "\033[34m" + "退出当前用户   " + "\33[m" + "~]");
            System.out.println("[8: " + "\033[34m" + "注销当前用户   " + "\33[m" + "~]");
            System.out.println("[9: " + "\033[34m" + "回到商店首页   " + "\33[m" + "~]");
            System.out.println("[请输入选项命令进行操作  ~]");
            System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.options.command   ~]#");
            String enterUserCommand = sc.next();
            System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");


            switch (enterUserCommand) {
                case "1":
                    changeUserInformation("用户名", loginUser.getUserName(), "changeUserName", loginUser, Accounts, sc);
                    //修改用户名
                    break;
                case "2":
                    changeUserInformation("手机号码", loginUser.getPhoneNumber(), "changePhoneNumber", loginUser, Accounts, sc);
                    //修改手机号
                    break;
                case "3":
                    //修改密码
                    int returnValue = changePasswd(loginUser, sc);
                    if (returnValue == 3) {
                        break;
                    } else {
                        System.out.println("\033[m" + "￥￥------------------------#< 密码变更警告 >#------------------------￥￥");
                        System.out.println("\033[31m" + "[ERROR: 密码变更,需重新登录,请确认是账户本人操作！！！ ~~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");
                        return 1;
                    }
                case "4":
                    System.out.println("￥￥------------------------#< 修改支付密码 >#------------------------￥￥");
                    managePayPasswd(loginUser, loginUser, sc, "changeOrVerify", "No", "No");
                    //修改支付密码
                    break;
                case "5":
                    changeUserInformation("门牌号", loginUser.getDormitoryNumber(), "changeDoorNumber", loginUser, Accounts, sc);
                    //修改宿舍门牌号
                    break;
                case "6":
                    //余额充值
                    System.out.println("￥￥------------------------#< 账户余额充值 >#------------------------￥￥");
                    System.out.println(".");
                    System.out.println("\033[32m" + "[当前余额 : " + "\033[34m" + loginUser.getUserBalance() + "元" + "\033[32m" + "   ~]");
                    System.out.println("\033[33m" + "[" + "rootuser." + loginUser.getUserName() + "@enter.输入充值余额   ~]#");
                    double addMoney = sc.nextDouble();
                    balanceTopUo(loginUser, addMoney, sc);
                    break;
                case "7":
                    //退出登录
                    int logoutYesOrNot = logout(loginUser, sc);
                    if (logoutYesOrNot == 1) {
                        return 1;
                    } else {
                        break;
                    }
                case "8":
                    //注销账户
                    int returnResult = logoutAccount(Accounts, loginUser, sc);
                    if (returnResult == 1) {
                        return 1;
                    } else {
                        break;
                    }
                case "9":
                    //回到主页
                    System.out.println(".");
                    System.out.println("\033[31m" + "[已返回商店主页 ~]");
                    return 0;
                default:
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    break;
            }
        }

    }

    public static int logout(accounts loginUser, Scanner sc) {

        System.out.println("￥￥------------------------#< 退出当前用户 >#------------------------￥￥");
        System.out.println(".");
        while (true) {
            System.out.println("\33[m" + "[1:" + "\033[34m" + "确认退出" + "\033[m" + "]");
            System.out.println("[2:" + "\033[34m" + "取消退出" + "\033[m" + "]");
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否确认退出 ~]:");
            String enterBackSure = sc.next();

            switch (enterBackSure) {
                case "1":
                    System.out.println(".");
                    System.out.println("\033[32m" + "[已退出当前用户   ~]");
                    System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n\n");
                    return 1;
                case "2":
                    System.out.println(".");
                    System.out.println("\033[32m" + "[已取消退出当前用户   ~]");
                    System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                    return 0;
                default:
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    break;
            }

        }
    }

    /**
     * 修改用户信息的方法
     *
     * @param changeType    需要修改哪一项用户信息的中文名称
     * @param changeGetWhat 获取需要修改的用户信息的原信息
     * @param changSetWhat  输入字符串“changeUserName”、“changePhoneName”、”changePayNumber"
     * @param loginUser     当前登录的用户对象
     * @param sc            扫描器对象
     */
    public static void changeUserInformation(String changeType, String changeGetWhat, String changSetWhat, accounts loginUser, ArrayList<accounts> Accounts, Scanner sc) {

        //修改用户名
        if (changSetWhat.equals("changeUserName")) {
            System.out.println("\033[m" + "￥￥------------------------#< 修改此用户名 >#------------------------￥￥");
            System.out.println(".");
            System.out.println("\033[32m" + "[当前账户使用的用户名" + changeType + " ~]:" + "\033[34m" + changeGetWhat);
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入新的用户名 ~]:");
            String newUserName = sc.next();
            while (true) {
                System.out.println("\33[m" + "[1:" + "\033[34m" + "确认修改" + "\033[m" + "]");
                System.out.println("[2:" + "\033[34m" + "取消修改" + "\033[m" + "]");
                String enterChosen = sc.next();
                switch (enterChosen) {
                    case "1":
                        loginUser.setUserName(newUserName);
                        System.out.println(".");
                        System.out.println("\033[32m" + "修改用户名成功。");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return;
                    case "2":
                        System.out.println(".");
                        System.out.println("\033[31m" + "[修改用户名操作已取消,返回商店首页！ ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return;
                    default:
                        System.out.println(".");
                        System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                        break;
                }
            }

            //修改手机号
        } else if (changSetWhat.equals("changePhoneNumber")) {
            System.out.println("\033[m" + "￥￥------------------------#< 管理手机号码 >#------------------------￥￥");
            System.out.println(".");
            while (true) {
                System.out.println("\033[m" + "[1:" + "\033[34m" + "绑定手机号 " + "\033[m" + "~]");
                System.out.println("[2:" + "\033[34m" + "修改手机号 " + "\033[m" + "~]");
                System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.请选择你需要对手机号码进行的操作 ~]:");
                String enterChosen = sc.next();
                System.out.println(".");
                switch (enterChosen) {
                    case "1":
                        //绑定手机号
                        setPhoneNumber(loginUser, sc, "绑定");
                        return;
                    case "2":
                        //修改手机号
                        if (loginUser.getPhoneNumber().equals("未绑定")) {
                            System.out.println("\033[32m" + "[当前" + changeType + " ~]: " + "\033[34m" + changeGetWhat);
                            System.out.println(".");
                            System.out.println("\033[32m" + "[当前用户未绑定手机号,请绑定手机号！ ~]");
                            System.out.println(".");
                            break;
                        } else {
                            setPhoneNumber(loginUser, sc, "修改");
                            return;
                        }

                    default:
                        System.out.println(".");
                        System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                        break;
                }
            }

            //修改门牌号
        } else if (changSetWhat.equals("changeDoorNumber")) {
            System.out.println("\033[m" + "￥￥------------------------#< 修改门牌号码 >#------------------------￥￥");
            //输出当前门牌号
            System.out.println("\033[32m" + "[当前" + changeType + ": " + "\033[34m" + "<" + changeGetWhat + ">    " + "\033[32m" + "~]");
            String backDoorNumber = settingDoorNumber(loginUser, Accounts, sc);
            while (true) {
                System.out.println("\033[m" + "[1:" + "\033[34m" + "确认修改" + "\033[m" + " ~]");
                System.out.println("\033[m" + "[2:" + "\033[34m" + "取消修改" + "\033[m" + " ~]");
                System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否确认修改 ~]:");
                String enterChosen3 = sc.next();
                switch (enterChosen3) {
                    case "1":
                        loginUser.setDormitoryNumber(backDoorNumber);
                        System.out.println(".");
                        System.out.println("\033[32m" + "修改门牌号成功。 ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return;
                    case "2":
                        System.out.println(".");
                        System.out.println("\033[32m" + "[修改门牌号操作已取消,返回用户设置页！！ ~]");
                        System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                        return;
                    default:
                        System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                        break;
                }
            }
        }


    }


    /**
     * 设置门牌号的方法
     *
     * @param userAccounts 账户信息对象
     * @param sc           扫描器对象
     */
    public static String settingDoorNumber(accounts userAccounts, ArrayList<accounts> Accounts, Scanner sc) {
        while (true) {
            if (Accounts.size() != 0) {
                System.out.println("\033[33m" + "[rootuser." + userAccounts.getUserName() + "@enter.输入所在楼层 ~]#:");

            } else {
                System.out.println("\033[33m" + "[all@enter.输入所在楼层 ~]$ ");
            }
            int floor = sc.nextInt();
            System.out.println(".");
            //判断输入的楼层是否存在
            if (floor > 0 && floor <= 6) {
                String doorNumber = accounts.doorNumber(floor);
                System.out.println("\033[34m" + doorNumber);

                //判断门牌号是否存在
                //将所有门牌号的字符串分割成三位数的门牌号
                while (true) {
                    if (Accounts.size() != 0) {
                        System.out.println("\033[33m" + "[rootuser." + userAccounts.getUserName() + "@enter.选择你的门牌号 ~]#:");
                    } else {
                        System.out.println("\033[33m" + "[all@enter.输入所在楼层 ~]$ ");

                    }
                    String choseNumber = sc.next();
                    System.out.println(".");
                    int doorBack = accounts.doorTureOrFalse(floor, doorNumber, choseNumber);
                    if (doorBack == 1) {

                        System.out.println("\033[32m" + "[你选择的门牌号是 ~] :" + "\033[34m" + "[" + choseNumber + "]" + "\n");
                        return choseNumber;

                    } else {
                        System.out.println("\033[31m" + "[ERROR:该楼层没有你所选择的宿舍，请重新选择！！]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    }
                }

            } else {
                System.out.println("\033[31m" + "[ERROR:你输入的楼层不存在，请重新输入！！]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
            }

        }
    }

    /**
     * 设置手机号码的方法
     *
     * @param accountByUser 用户对象
     * @param sc            扫描器对象
     * @param bindOrChange  绑定或者修改
     */
    public static void setPhoneNumber(accounts accountByUser, Scanner sc, String bindOrChange) {
        while (true) {

            System.out.println("\033[33m" + "[rootuser." + accountByUser.getUserName() + "@enter.输入要" + bindOrChange + "的手机号码 ~]#");
            String newPhoneNumber = sc.next();

            //判断手机号的位数是否正确
            if (newPhoneNumber.length() == 11) {
                while (true) {
                    System.out.println("\033[32m" + "[需要验证手机号是否可用 ~]");
                    System.out.println("\033[32m" + "[是否确定验证 ~]");
                    System.out.println("\033[m" + "[1:" + "\033[34m" + "确定验证 " + "\33[m" + "~]");
                    System.out.println("[2:" + "\033[34m" + "取消验证 " + "\33[m" + "~]");
                    System.out.println("\033[033m" + "[rootuser." + accountByUser.getUserName() + "@enter.是否确定验证 ~]# ");
                    String verifySureOrNot = sc.next();
                    switch (verifySureOrNot) {
                        case "1":
                            String verificationCode = captchaTool.createCaptcha(5);
                            System.out.println("\033[32m" + "[验证码 ~]: " + "\033[34m" + verificationCode);
                            while (true) {
                                System.out.println("\033[033m" + "[rootuser." + accountByUser.getUserName() + "@enter.输入验证码 ~]# ");
                                String enterCode = sc.next();
                                if (enterCode.equals(verificationCode)) {
                                    while (true) {
                                        System.out.println("\033[32m" + "[手机号已验证成功 ~~]");
                                        System.out.println("\033[m" + "[1:" + "\033[34m" + "确认" + bindOrChange + " ~]" + "\033[m");
                                        System.out.println("[2:" + "\033[34m" + "取消" + bindOrChange + " ~]" + "\033[m");
                                        System.out.println("\033[33m" + "[rootuser." + accountByUser.getUserName() + "@enter.是否确定" + bindOrChange + "该手机号 ~]# ");
                                        String bindSure = sc.next();
                                        switch (bindSure) {
                                            case "1":
                                                accountByUser.setPhoneNumber(newPhoneNumber);
                                                System.out.println("\033[32m" + "[" + bindOrChange + "手机号成功。 ~]");
                                                return;
                                            case "2":
                                                System.out.println("\033[31m" + "[" + bindOrChange + "操作已取消,返回我的账户设置页~]");
                                                System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                                                return;
                                            default:
                                                System.out.println(".");
                                                System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                                                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                                                break;
                                        }
                                    }

                                } else {
                                    System.out.println(".");
                                    System.out.println("\033[31m" + "[ERROR:你输入的验证码有误，请重新输入！！]");
                                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                                }
                            }
                        case "2":
                            System.out.println(".");
                            System.out.println("\033[31m" + "[你已取消验证，无法绑定手机号,返回我的账户设置页 ~]");
                            System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                            return;
                        default:
                            System.out.println(".");
                            System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                            System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                            break;
                    }
                }

            } else {
                System.out.println(".");
                System.out.println("\033[31m" + "[ERROR:你输入的手机号位数有误，请重新输入！！]");
                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
            }
        }
    }

    /**
     * 管理支付密码的方法
     *
     * @param userOrLoginAccounts 用户对象
     * @param loginUser           当前登录的用户对象
     * @param sc                  扫描器对象
     * @param changeOrSetOrVerify 修改密码或者设置密码或者验证密码
     * @param changeYes           是否输出设置密码的横幅
     * @param returnYes           是否只验证密码
     */
    public static int managePayPasswd(accounts userOrLoginAccounts, accounts loginUser, Scanner sc, String changeOrSetOrVerify, String changeYes, String returnYes) {
        if (changeOrSetOrVerify.equals("set")) {
            System.out.println("\033[m" + "￥￥------------------------$< 设置支付密码 >$------------------------￥￥");
            System.out.println(".");
            while (true) {
                System.out.println("\033[33m" + "[all@enter.输入账户支付密码]$");
                String sixPayPasswd = sc.next();
                if (sixPayPasswd.length() == 6) {
                    while (true) {
                        System.out.println("\033[33m" + "[all@enter.再次输入账户支付密码]$:");
                        String againPayPasswd = sc.next();
                        if (againPayPasswd.equals(sixPayPasswd)) {
                            userOrLoginAccounts.setPayPasswd(sixPayPasswd);
                            System.out.println(".");
                            System.out.println("\033[32m" + "[账户支付密码设置成功。]");
                            System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                            return 5;
                        } else {
                            System.out.println(".");
                            System.out.println("\033[31m" + "[ERROR:你两次输入的密码不一致,请重新输入！ ~]");
                            System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                        }
                    }

                } else {
                    System.out.println(".");
                    System.out.println("\033[31m" + "[ERROR:请输入6位数支付密码!! ~]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                }
            }
        } else if (changeOrSetOrVerify.equals("changeOrVerify")) {
            if (changeYes.equals("Yes")) {
                System.out.println("\033[m" + "￥￥------------------------$< 设置支付密码 >$------------------------￥￥");
                System.out.println(".");
            } else {
                while (true) {
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入支付密码 ~]#");
                    String oldPayPasswd = sc.next();
                    if (oldPayPasswd.length() == 6) {
                        if (oldPayPasswd.equals(loginUser.getPayPasswd())) {
                            System.out.println(".");
                            System.out.println("\033[32m" + "[支付密码验证成功！ ~]");
                            System.out.println(".");
                            if (returnYes.equals("Yes")) {
                                return 1;
                            } else {
                                while (true) {
                                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.输入新的的支付密码 ~]#");
                                    String newPayPasswd = sc.next();
                                    if (newPayPasswd.length() == 6) {
                                        while (true) {
                                            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.再次输入新的的支付密码 ~]#");
                                            String newPayPasswd1 = sc.next();
                                            if (newPayPasswd1.equals(newPayPasswd)) {
                                                loginUser.setPayPasswd(newPayPasswd);
                                                System.out.println(".");
                                                System.out.println("\033[32m" + "[账户支付密码修改成功。 ~]");
                                                System.out.println("\033[m" + "￥￥----------------------------------------------------------------￥￥" + "\n");
                                                return 5;
                                            } else {
                                                System.out.println(".");
                                                System.out.println("\033[31m" + "[ERROR:两次输入的新密码不一致，请重新输入 ~]");
                                                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                                            }
                                        }

                                    } else {
                                        System.out.println(".");
                                        System.out.println("\033[31m" + "[ERROR:请输入6位数支付密码!! ~]");
                                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                                    }
                                }
                            }
                        } else {
                            if (returnYes.equals("Yes")) {
                                System.out.println(".");
                                System.out.println("\033[31m" + "[ERROR:支付密码错误！ ~]");
                                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                                return 6;
                            } else {
                                System.out.println(".");
                                System.out.println("\033[31m" + "[ERROR:你输入的密码与原来的支付密码不一致,修改操作已取消，返回用户设置页！ ~]");
                                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                                return 5;
                            }
                        }
                    } else {
                        System.out.println(".");
                        System.out.println("\033[31m" + "[ERROR:请输入6位数支付密码!! ~]");
                        System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                    }
                }
            }

        }
        return 6;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    //商品信息

    /**
     * 创建所有商品对象并将创建的对象放到商品信息集合里的方法
     */
    public static ArrayList<storeCommodity> allProducts() {
        //干脆面
        storeCommodity crispNoodles1 = new storeCommodity("a01", "小当家面", "干脆", 00.5, 100, 0);
        storeCommodity crispNoodles2 = new storeCommodity("a02", "小浣熊面", "干脆", 01.5, 100, 0);
        storeCommodity crispNoodles3 = new storeCommodity("a03", "给力餐面", "干脆", 01.0, 100, 0);
        storeCommodity crispNoodles4 = new storeCommodity("a04", "魔术师面", "干脆", 01.0, 100, 0);
        //泡面
        storeCommodity instantNoodles1 = new storeCommodity("b05", "香菇炖鸡", "泡面", 05.0, 100, 0);
        storeCommodity instantNoodles2 = new storeCommodity("b06", "藤椒牛肉", "泡面", 05.0, 100, 0);
        storeCommodity instantNoodles3 = new storeCommodity("b07", "红烧牛肉", "泡面", 05.0, 100, 0);
        storeCommodity instantNoodles4 = new storeCommodity("b08", "茄皇鸡蛋", "泡面", 05.0, 100, 0);
        //拌面
        storeCommodity mixNoodles1 = new storeCommodity("c09", "火鸡拌面", "拌面", 06.0, 100, 0);
        storeCommodity mixNoodles2 = new storeCommodity("c10", "鸡蛋拌面", "拌面", 05.0, 100, 0);
        storeCommodity mixNoodles3 = new storeCommodity("c11", "炸酱拌面", "拌面", 06.0, 100, 0);
        storeCommodity mixNoodles4 = new storeCommodity("c12", "牛肉拌面", "拌面", 05.0, 100, 0);
        //小零食
        storeCommodity smallSnacks1 = new storeCommodity("d13", "大士力架", "零食", 02.5, 100, 0);
        storeCommodity smallSnacks2 = new storeCommodity("d14", "大肉松饼", "零食", 02.0, 100, 0);
        storeCommodity smallSnacks3 = new storeCommodity("d15", "小小鱼干", "零食", 01.5, 100, 0);
        storeCommodity smallSnacks4 = new storeCommodity("d16", "乐事薯片", "零食", 03.5, 100, 0);
        storeCommodity smallSnacks5 = new storeCommodity("d17", "小米锅巴", "零食", 01.0, 100, 0);
        storeCommodity smallSnacks6 = new storeCommodity("d18", "干鱿鱼丝", "零食", 01.5, 100, 0);
        storeCommodity smallSnacks7 = new storeCommodity("d19", "卤香凤爪", "零食", 01.5, 100, 0);
        storeCommodity smallSnacks8 = new storeCommodity("d20", "五香脆骨", "零食", 01.5, 100, 0);
        storeCommodity smallSnacks9 = new storeCommodity("d21", "恰恰瓜子", "零食", 05.0, 100, 0);
        storeCommodity smallSnacks10 = new storeCommodity("d22", "卤小鸡腿", "零食", 02.5, 100, 0);
        //饮品
        storeCommodity drinks1 = new storeCommodity("e23", "大瓶怡宝", "饮品", 03.0, 100, 0);
        storeCommodity drinks2 = new storeCommodity("e24", "可口可乐", "饮品", 04.0, 100, 0);
        storeCommodity drinks3 = new storeCommodity("e25", "大瓶雪碧", "饮品", 04.0, 100, 0);
        storeCommodity drinks4 = new storeCommodity("e26", "小菠萝啤", "饮品", 02.5, 100, 0);
        storeCommodity drinks5 = new storeCommodity("e27", "农夫山泉", "饮品", 03.0, 100, 0);
        storeCommodity drinks6 = new storeCommodity("e28", "大冰红茶", "饮品", 04.0, 100, 0);
        //辣条
        storeCommodity spicyStrips1 = new storeCommodity("f29", "大小飞旺", "辣条", 03.0, 100, 0);
        storeCommodity spicyStrips2 = new storeCommodity("f30", "大小面筋", "辣条", 03.0, 100, 0);
        storeCommodity spicyStrips3 = new storeCommodity("f31", "大刀肉块", "辣条", 03.0, 100, 0);
        storeCommodity spicyStrips4 = new storeCommodity("f32", "手撕牛肉", "辣条", 03.0, 100, 0);


        ArrayList<storeCommodity> productsInformation = new ArrayList<>();

        productsInformation.add(crispNoodles1);
        productsInformation.add(crispNoodles2);
        productsInformation.add(crispNoodles3);
        productsInformation.add(crispNoodles4);

        productsInformation.add(instantNoodles1);
        productsInformation.add(instantNoodles2);
        productsInformation.add(instantNoodles3);
        productsInformation.add(instantNoodles4);

        productsInformation.add(mixNoodles1);
        productsInformation.add(mixNoodles2);
        productsInformation.add(mixNoodles3);
        productsInformation.add(mixNoodles4);

        productsInformation.add(smallSnacks1);
        productsInformation.add(smallSnacks2);
        productsInformation.add(smallSnacks3);
        productsInformation.add(smallSnacks4);
        productsInformation.add(smallSnacks5);
        productsInformation.add(smallSnacks6);
        productsInformation.add(smallSnacks7);
        productsInformation.add(smallSnacks8);
        productsInformation.add(smallSnacks9);
        productsInformation.add(smallSnacks10);

        productsInformation.add(drinks1);
        productsInformation.add(drinks2);
        productsInformation.add(drinks3);
        productsInformation.add(drinks4);
        productsInformation.add(drinks5);
        productsInformation.add(drinks6);

        productsInformation.add(spicyStrips1);
        productsInformation.add(spicyStrips2);
        productsInformation.add(spicyStrips3);
        productsInformation.add(spicyStrips4);


        return productsInformation;

    }

    /**
     * 展示商品信息的方法
     *
     * @param products  商品信息集合
     * @param loginUser 用户对象
     * @param sc        扫描器对象
     */
    public static void printProductInformation(ArrayList<myOrders> ordersInformation, ArrayList<storeCommodity> products, accounts loginUser, Scanner sc) {
        System.out.println("\033[m" + "￥￥-------------------------------------------选购商品----------------------------------------------￥￥");
        for (int i = 0; i < products.size(); i++) {
            storeCommodity information1 = products.get(i);
            storeCommodity information2 = products.get(i + 1);
            storeCommodity information3 = products.get(i + 2);
            storeCommodity information4 = products.get(i + 3);
            System.out.println("\033[m" + "￥￥----------------￥￥ " + "￥￥----------------￥￥ " + "￥￥-----------------￥￥ " + "￥￥-----------------￥￥");
            System.out.println(" | [编号 ~]: " + "\033[34m" + information1.getProductNumber() + "\033[m" + "\t\t|\t" + "| [编号 ~]: " + "\033[34m" + information2.getProductNumber() + "\033[m" + "\t\t|\t" + "| [编号 ~]: " + "\033[34m" + information3.getProductNumber() + "\033[m" + "\t\t|\t" + "| [编号 ~]: " + "\033[34m" + information4.getProductNumber() + "\033[m" + "\t\t|");
            System.out.println(" | [名称 ~]: " + "\033[34m" + information1.getProductName() + "\033[m" + "\t|\t" + "| [名称 ~]: " + "\033[34m" + information2.getProductName() + "\033[m" + "\t|\t" + "| [名称 ~]: " + "\033[34m" + information3.getProductName() + "\033[m" + "\t|\t" + "| [名称 ~]: " + "\033[34m" + information4.getProductName() + "\033[m" + "\t|");
            System.out.println(" | [类别 ~]: " + "\033[34m" + information1.getProductType() + "\033[m" + "\t\t|\t" + "| [类别 ~]: " + "\033[34m" + information2.getProductType() + "\033[m" + "\t\t|\t" + "| [类别 ~]: " + "\033[34m" + information3.getProductType() + "\033[m" + "\t\t|\t" + "| [类别 ~]: " + "\033[34m" + information4.getProductType() + "\033[m" + "\t\t|");
            System.out.println(" | [单价 ~]: " + "\033[34m" + information1.getProductPrice() + "元" + "\033[m" + "\t|\t" + "| [单价 ~]: " + "\033[34m" + information2.getProductPrice() + "元" + "\033[m" + "\t|\t" + "| [单价 ~]: " + "\033[34m" + information3.getProductPrice() + "元" + "\033[m" + "\t|\t" + "| [单价 ~]: " + "\033[34m" + information4.getProductPrice() + "元" + "\033[m" + "\t|");
            System.out.println(" | [库存 ~]: " + "\033[34m" + information1.getProductInventory() + "件" + "\033[m" + "\t|\t" + "| [库存 ~]: " + "\033[34m" + information2.getProductInventory() + "件" + "\033[m" + "\t|\t| [库存 ~]: " + "\033[34m" + information3.getProductInventory() + "件" + "\033[m" + "\t|\t" + "| [库存 ~]: " + "\033[34m" + information4.getProductInventory() + "件" + "\033[m" + "\t|");
            System.out.println(" | [销量 ~]: " + "\033[34m" + information1.getProductSales() + "件" + "\033[m" + "\t\t|\t" + "| [销量 ~]: " + "\033[34m" + information2.getProductSales() + "件" + "\033[m" + "\t\t|\t" + "| [销量 ~]: " + "\033[34m" + information3.getProductSales() + "件" + "\033[m" + "\t\t|\t" + "| [销量 ~]: " + "\033[34m" + information4.getProductSales() + "件" + "\033[m" + "\t\t|");
            System.out.println("\033[m" + "￥￥----------------￥￥ " + "￥￥----------------￥￥ " + "￥￥-----------------￥￥ " + "￥￥-----------------￥￥" + "\n");
            i += 3;
        }
        System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥");
        while (true) {
            System.out.println("\033[m" + "[1: " + "\033[34m" + "选购商品" + "\033[m" + " ~]");
            System.out.println("\033[m" + "[2: " + "\033[34m" + "返回首页" + "\033[m" + " ~]");
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否选购商品 ~]#");
            String shopYesOrNo = sc.next();
            switch (shopYesOrNo) {
                case "1":
                    int back = buyProduct(ordersInformation, products, loginUser, sc);
                    break;
                case "2":
                    System.out.println(".");
                    System.out.println("\033[31m" + "[已返回商店首页！ ~]");
                    System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                    return;
                default:
                    System.out.println(".");
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                    System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                    break;
            }
        }
    }

    /**
     * 选购商品的方法
     *
     * @param products  商品信息集合
     * @param loginUser 登录用户对象
     * @param sc        扫描器对象
     */
    public static int buyProduct(ArrayList<myOrders> ordersInformation, ArrayList<storeCommodity> products, accounts loginUser, Scanner sc) {

        while (true) {
            //输入商品编号
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.需要选购的商品编号 ~]#");
            String productNumber = sc.next();
            for (int i = 0; i < products.size(); i++) {
                storeCommodity buyProductInformation = products.get(i);
                if (buyProductInformation.getProductNumber().equals(productNumber)) {
                    System.out.println("\033[32m" + "[你选购的商品信息     ~~]:");
                    System.out.println("\033[m" + "￥￥--------------------￥￥ ");
                    System.out.println("\033[m" + "| [商品名称 ~]: " + "\033[34m" + buyProductInformation.getProductName() + "\033[m" + "\t|");
                    System.out.println("\033[m" + "| [商品类别 ~]: " + "\033[34m" + buyProductInformation.getProductType() + "\033[m" + "\t\t|");
                    System.out.println("\033[m" + "| [商品单价 ~]: " + "\033[34m" + buyProductInformation.getProductPrice() + "元" + "\033[m" + "\t\t|");
                    System.out.println("\033[m" + "| [商品库存 ~]: " + "\033[34m" + buyProductInformation.getProductInventory() + "件" + "\033[m" + "\t\t|");
                    System.out.println("\033[m" + "| [商品销量 ~]: " + "\033[34m" + buyProductInformation.getProductSales() + "件" + "\033[m" + "\t\t|");
                    System.out.println("\033[m" + "￥￥--------------------￥￥" + "\n");
                    while (true) {
                        System.out.println("\033[m" + "[1: " + "\033[34m" + "立即购买" + "\033[m" + " ~]" + "\033[m" + "    [2: " + "\033[34m" + "取消购买" + "\033[m" + " ~]");
                        System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否立即购买 ~]#");
                        String buyNowYesOrNo = sc.next();
                        switch (buyNowYesOrNo) {
                            case "1":
                                //立即购买商品

                                storeCommodity buyNow = products.get(i);
                                //购买数量
                                while (true) {
                                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.购买数量 ~]#");
                                    int buyCount = sc.nextInt();
                                    if (buyCount <= buyNow.getProductInventory()) {
                                        //调用打印订单信息的方法
                                        myOrders orders1 = printOrderInfo(products, loginUser, buyNow, buyCount, sc);
                                        //将订单对象放入到订单信息集合中
                                        ordersInformation.add(orders1);
                                        //是否支付订单
                                        while (true) {
                                            System.out.println("\033[m" + "[1: " + "\033[34m" + "立即支付" + "\033[m" + " ~]");
                                            System.out.println("\033[m" + "[2: " + "\033[34m" + "稍后支付" + "\033[m" + " ~]");
                                            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.是否支付 ~]#");
                                            String payYesOrNo = sc.next();
                                            switch (payYesOrNo) {
                                                case "1":
                                                    int verifySuccess = managePayPasswd(loginUser, loginUser, sc, "changeOrVerify", "No", "Yes");
                                                    if (verifySuccess == 1) {
                                                        double allPay = buyAllPrice(buyNow, buyCount);
                                                        if (allPay <= loginUser.getUserBalance()) {
                                                            System.out.println(".");
                                                            orders1.setBuyPayYesOrNo("已支付,你的商品预计十分钟后送达。");
                                                            loginUser.userBalance-=allPay;
                                                            System.out.println("\033[32m" + "[支付成功,订单已支付！！ ~]");
                                                            System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                                            return 1;
                                                        } else {
                                                            orders1.setBuyPayYesOrNo("未支付,需先支付订单商家才会派送");
                                                            System.out.println("\033[31m" + "[账户余额不足,请充值后支付！！ ~]");
                                                            System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                                            break;
                                                        }

                                                    } else {
                                                        break;
                                                    }
                                                case "2":
                                                    orders1.setBuyPayYesOrNo("未支付,需先支付订单商家才会派送");
                                                    System.out.println(".");
                                                    System.out.println("\033[31m" + "[未完成支付,订单未支付！！ ~]");
                                                    System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                                    return 0;
                                                default:
                                                    System.out.println(".");
                                                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                                                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]");
                                                    System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                                    break;
                                            }
                                        }
                                    } else {
                                        System.out.println("\033[31m" + "[ERROR:库存不足，请减少购买数量！！]");
                                    }
                                }
                            case "2":
                                //将商品加入购物车
                                System.out.println(".");
                                System.out.println("\033[31m" + "[已取消购买！ ~]");
                                System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                return 3;
                            default:
                                System.out.println(".");
                                System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                                System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                                break;
                        }
                    }

                }
            }
            System.out.println(".");
            System.out.println("\033[31m" + "[ERROR:不存在你输入的商品编号所对应的商品，请重新输入商品编号！！ ~]");
            System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
        }


    }


    /**
     * 立即购买商品的方法
     *
     * @param products  商品信息集合
     * @param loginUser 登录用户对象
     * @param buyCount  购买数量
     * @param sc        扫描器对象
     */
    public static myOrders printOrderInfo(ArrayList<storeCommodity> products, accounts loginUser, storeCommodity buyProduct, int buyCount, Scanner sc) {
        //计算商品总价
        double needPayMoney = buyAllPrice(buyProduct, buyCount);
        //生成下单时间
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日-hh时mm分ss秒");

        String ordersTime = sdf.format(nowTime);

        //获取随机订单编号
        String ordersNumber = createOrderNumber(buyProduct);
        //创建一个订单对象
        myOrders orders1 = new myOrders(loginUser.getUserName(), loginUser.getDormitoryNumber(), loginUser.getPhoneNumber(), buyProduct.getProductName(), buyCount, needPayMoney, ordersTime, ordersNumber);
        myOrders.createOrder(loginUser.getUserName(), loginUser.getDormitoryNumber(), loginUser.getPhoneNumber(), buyProduct.getProductName(), buyCount, needPayMoney, ordersTime, ordersNumber);
        return orders1;
    }

    /**
     * 计算总价的方法
     *
     * @param buyProduct 购买的商品对象
     * @param buyCount   购买的数量
     * @return 总价
     */
    public static double buyAllPrice(storeCommodity buyProduct, int buyCount) {
        double buyAllPrice = buyProduct.getProductPrice() * buyCount;
        return buyAllPrice;
    }


    /**
     * 生成订单编号的方法
     *
     * @param productNumber 产品编号
     * @return 返回订单编号
     */
    public static String createOrderNumber(storeCommodity productNumber) {
        Date nowTime = new Date();
        SimpleDateFormat sde = new SimpleDateFormat("yyyyMMddhhmmss");
        String ordersTime2 = sde.format(nowTime);
        String product = productNumber.getProductNumber();
        product += ordersTime2;
        String allChars = "0123456789";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(allChars.length());

            product += allChars.charAt(index);

        }

        return product;
    }

    /**
     * 查看订单信息的方法
     *
     * @param myOrdersArrayList 所有订单信息的集合
     * @param sc                扫描器
     */
    public static void allMyOrders(ArrayList<myOrders> myOrdersArrayList, Scanner sc, accounts loginUser) {
        System.out.println("\033[m" + "￥￥------------------------------------------我的订单---------------------------------------------￥￥");
        if (myOrdersArrayList.size() == 0) {
            System.out.println(".");
            System.out.println("\033[31m" + "[你当前没有如何订单！！ ~]");
            System.out.println("\033[m" + "￥￥---------------------------------------------------------------------------------------------￥￥" + "\n");
            return;
        }
        //打印所有订单
        for (int i = 0; i < myOrdersArrayList.size(); i++) {
            myOrders allOrders = myOrdersArrayList.get(i);
            allOrders.setOrdersNumber(i);
            System.out.println("\033[m" + "[--------------------订单信息--------------------]");
            System.out.println("\033[32m" + "[ " + (allOrders.getOrdersNumber() + 1) + "号订单 ]");
            System.out.println("\033[m" + "[订单编号  ~]:" + "\033[34m" + allOrders.getBuyNumber());
            System.out.println("\033[m" + "[下单时间  ~]:" + "\033[34m" + allOrders.getBuyTime());
            System.out.println("\033[m" + "[购买用户  ~]:" + "\033[34m" + allOrders.getBuyUser());
            System.out.println("\033[m" + "[宿舍牌号  ~]:" + "\033[34m" + allOrders.getBuyUserDoorNumber());
            System.out.println("\033[m" + "[手机号码  ~]:" + "\033[34m" + allOrders.getBuyUserPhoneNumber());
            System.out.println("\033[m" + "[商品名称  ~]:" + "\033[34m" + allOrders.getBuyProductName());
            System.out.println("\033[m" + "[购买数量  ~]:" + "\033[34m" + "x" + allOrders.getBuyProductCount() + "件");
            System.out.println("\033[m" + "[合计      ~~]:" + "\033[34m" + allOrders.getBuyProductPrice() + "元");
            System.out.println("\033[m" + "[订单状态  ~]:" + "\033[34m" + allOrders.getBuyPayYesOrNo());
            System.out.println("\033[m" + "[----------------------------------------------]" + "\n");

        }
        while (true) {
            System.out.println("\033[m" + "[1: " + "\033[34m" + "支付未支付订单" + "\033[m" + " ~]    " + "\033[m" + "[2: " + "\033[34m" + "取消订单" + "\033[m" + " ~]    " + "\033[m" + "[3: " + "\033[34m" + "返回商店首页" + "\033[m" + " ~]");
            System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.选择操作 ~]#");
            String payYesOrNo = sc.next();
            switch (payYesOrNo) {
                case "1":
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.选择未支付订单 ~]#");
                    String enterNumber = sc.next();
                    int enterNumberInt = Integer.parseInt(enterNumber);
                    if (enterNumberInt <= myOrdersArrayList.size()) {
                        myOrders allOrders1 = myOrdersArrayList.get(enterNumberInt-1);
                            //判断当前选择的订单是否已经支付
                            if (allOrders1.getBuyPayYesOrNo().equals("未支付,需先支付订单商家才会派送")) {
                                //判断用户余额是否够支付当前订单
                                if (allOrders1.getBuyProductPrice() <= loginUser.userBalance) {
                                    while (true) {
                                        int passwdTure = managePayPasswd(loginUser, loginUser, sc, "changeOrVerify", "No", "Yes");
                                        //判断当前输入的密码是否正确
                                        if (passwdTure == 1) {
                                            System.out.println(".");
                                            allOrders1.setBuyPayYesOrNo("已支付,你的商品预计十分钟后送达。");
                                            loginUser.userBalance-=allOrders1.getBuyProductPrice();
                                            System.out.println("\033[32m" + "[支付成功,订单已支付！！ ~]");
                                            System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                            break;
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println(".");
                                    System.out.println("\033[31m" + "[余额不足,请先充值！！ ~]");
                                    System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                    return;
                                }
                            } else {
                                System.out.println(".");
                                System.out.println("\033[31m" + "[该订单已支付！！ ~]");
                                System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                                break;
                            }

                    } else {
                        System.out.println("\033[31m" + "[你没有该序号的订单！！ ~]");
                        break;
                    }
                case "2":
                    System.out.println("\033[33m" + "[rootuser." + loginUser.getUserName() + "@enter.选择要取消的订单 ~]#");
                    String enterNumber1 = sc.next();
                    int enterNumberInt1 = Integer.parseInt(enterNumber1);
                    if(enterNumberInt1 <= myOrdersArrayList.size()) {

                        myOrdersArrayList.remove(enterNumberInt1-1);
                        System.out.println(".");
                        System.out.println("\033[31m" + "[已取消该订单！！ ~]");
                        System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                        break;
                    }else {
                        System.out.println("\033[31m" + "[你没有该序号的订单！！ ~]");
                        System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥");
                        break;
                    }
                case "3":
                    System.out.println(".");
                    System.out.println("\033[31m" + "[已返回首页！！ ~]");
                    System.out.println("\033[m" + "￥￥-----------------------------------------------------------------------------------------￥￥" + "\n");
                   return;

                default:
                    System.out.println(".");
                    System.out.println("\033[31m" + "[ERROR:你输入的命令不存在，请重新输入！！]");
                    System.out.println("[---------E-R-R-O-R-,-P-R-O-M-P-T-,-R-E-S-U-M-E-,-E-N-T-E-R----------]" + "\n");
                    break;
            }




        }
    }


}
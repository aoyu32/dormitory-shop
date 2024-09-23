package Store;


/**
 * 账户信息类
 */
public class accounts {

    //私有成员变量
    private String userName;   //账号名称
    private String userID;  //账户账号
    private String userPasswd;         //账户密码
    private String payPasswd;           //支付密码
    private String dormitoryNumber;   //用户宿舍门牌号
    private String phoneNumber;         //用户电话号码
    double userBalance = 0.000;

    public double getUserBalance() {
        return userBalance;
    }

    public String getPayPasswd() {
        return payPasswd;
    }

    public void setPayPasswd(String payPasswd) {
        this.payPasswd = payPasswd;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    //选择门牌号的方法
    public static String doorNumber(int floorNumber){
        //列出该楼层所有的门牌号并返回
        //定义一个生成门牌号的数组
        int[] doorNumbers = new int[11];
        //循环生成门牌号并格式化返回
        String backDoorNumber = "[";
        for (int i = 1; i < doorNumbers.length; i++) {
            doorNumbers[i] = floorNumber*100+i;
            backDoorNumber += doorNumbers[i];
            backDoorNumber += "]"+" ";
            if (i==10){
                break;
            }else {
                backDoorNumber += "[";
            }
        }
        return backDoorNumber;
    }


    /**
     * 判断输入的门牌号是否存在的方法
     */
    public static int doorTureOrFalse(int floor,String backDoorNumber,String choseNumber) {
        String[] doorNumberArray = backDoorNumber.split(" ");
        //遍历存放三位数门牌号的数组
        for (int i = 0; i < doorNumberArray.length; i++) {
            String haveDoorNumber = doorNumberArray[i];
            //将遍历的门牌号与输入的门牌号比较是否相同
            if (haveDoorNumber.equals("["+choseNumber+"]")){
                return 1;
            }
        }return 0;
    }


}

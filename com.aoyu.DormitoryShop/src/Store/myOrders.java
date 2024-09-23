package Store;

public class myOrders{

    private String buyUser; //购买用户
    private String buyUserDoorNumber; //用户的宿舍门牌号
    private String buyUserPhoneNumber; //用户的手机号
    private String buyProductName; //购买的商品名称
    private int buyProductCount; //购买的商品数量
    private double buyProductPrice; //购买的商品总价格
    private String buyTime; //下单时间
    private String buyNumber; //订单编号
    private String buyPayYesOrNo; //是否付款
    private int ordersNumber; //订单序号
    

    //构造器



    public myOrders(String buyUser, String buyUserDoorNumber, String buyUserPhoneNumber, String buyProductName, int buyProductCount, double buyProductPrice, String buyTime, String buyNumber) {
        this.buyUser = buyUser;
        this.buyUserDoorNumber = buyUserDoorNumber;
        this.buyUserPhoneNumber = buyUserPhoneNumber;
        this.buyProductName = buyProductName;
        this.buyProductCount = buyProductCount;
        this.buyProductPrice = buyProductPrice;
        this.buyTime = buyTime;
        this.buyNumber = buyNumber;
    }

    public int getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(int ordersNumber) {
        this.ordersNumber = ordersNumber;
    }


    public String getBuyUser() {
        return buyUser;
    }

    public void setBuyUser(String buyUser) {
        this.buyUser = buyUser;
    }

    public String getBuyUserDoorNumber() {
        return buyUserDoorNumber;
    }

    public void setBuyUserDoorNumber(String buyUserDoorNumber) {
        this.buyUserDoorNumber = buyUserDoorNumber;
    }

    public String getBuyUserPhoneNumber() {
        return buyUserPhoneNumber;
    }

    public void setBuyUserPhoneNumber(String buyUserPhoneNumber) {
        this.buyUserPhoneNumber = buyUserPhoneNumber;
    }

    public String getBuyProductName() {
        return buyProductName;
    }

    public void setBuyProductName(String buyProductName) {
        this.buyProductName = buyProductName;
    }

    public int getBuyProductCount() {
        return buyProductCount;
    }

    public void setBuyProductCount(int buyProductCount) {
        this.buyProductCount = buyProductCount;
    }

    public double getBuyProductPrice() {
        return buyProductPrice;
    }

    public void setBuyProductPrice(double buyProductPrice) {
        this.buyProductPrice = buyProductPrice;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        this.buyNumber = buyNumber;
    }

    public String getBuyPayYesOrNo() {
        return buyPayYesOrNo;
    }

    public void setBuyPayYesOrNo(String buyPayYesOrNo) {
        this.buyPayYesOrNo = buyPayYesOrNo;
    }

    public static void createOrder(String buyUser, String buyUserDoorNumber, String buyUserPhoneNumber, String buyProductName, int buyProductCount, double buyProductPrice, String buyTime, String buyNumber){
        //打印订单信息
        System.out.println("\033[m"+"[--------------------订单信息--------------------]");
        System.out.println("\033[32m"+"[你的订单信息     ~~]:");
        System.out.println("\033[m"+"[商品名称  ~]:"+"\033[34m"+buyProductName);
        System.out.println("\033[m"+"[商品数量  ~]:"+"\033[34m"+"x"+buyProductCount+"件");
        System.out.println("\033[m"+"[购买用户  ~]:"+"\033[34m"+buyUser);
        System.out.println("\033[m"+"[宿舍牌号  ~]:"+"\033[34m"+buyUserDoorNumber);
        System.out.println("\033[m"+"[手机号码  ~]:"+"\033[34m"+buyUserPhoneNumber);
        System.out.println("\033[m"+"[下单时间  ~]:"+"\033[34m"+buyTime);
        System.out.println("\033[m"+"[订单编号  ~]:"+"\033[34m"+buyNumber);
        System.out.println("\033[m"+"[合计      ~~]:"+"\033[34m"+buyProductPrice+"元");
        System.out.println("\033[m"+"[----------------------------------------------]");

    }
}

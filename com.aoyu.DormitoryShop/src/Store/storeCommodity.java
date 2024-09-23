package Store;

/**
 * 商品类
 */
public class storeCommodity{
    private  String productNumber;
    private  String productName ;
    private  String productType ;
    private  double productPrice ;
    private  int productInventory ;
    private  int productSales ;

    public storeCommodity(String ProductNumber,String productName,String productType,double productPrice,int productInventory,int productSales){
        this.productNumber = ProductNumber;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productInventory = productInventory;
        this.productSales = productSales;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    public int getProductSales() {
        return productSales;
    }

    public void setProductSales(int productSales) {
        this.productSales = productSales;
    }
}

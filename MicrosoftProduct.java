//Parent class MicrosoftProduct
public class MicrosoftProduct{

    //declaring instance variables
    private int productNumber;
    private String productName;
    private String productActivationKey;
    private int productPrice;

    //constructor for the class
    public MicrosoftProduct(int productNumber, String productName){
        this.productNumber = productNumber;
        this. productName = productName;
        productActivationKey = "";
        productPrice = 0;
    }

    //accessor method for productNumber
    public int getProductNumber(){
        return this.productNumber;
    }

    //accessor method for productName
    public String getProductName(){
        return this.productName;
    }

    //accessor method for activation key
    public String getActivtionKey(){
        return this.productActivationKey;
    }

    //accessor method for product price
    public int getprice(){
        return this.productPrice;
    }

    //setter method for activation key
    public void setProductActivationKey(String productActivationKey){
        this.productActivationKey = productActivationKey;
    }

    //setter method for product price
    public void setProductPrice(int productPrice){
        this.productPrice = productPrice;
    }

    //display method
    public void display(){
        System.out.println("Product Number: "+this.productNumber);
        System.out.println("Product Name: "+this.productName);

        //displaying activation key and price if they arent empty
        if(!(productActivationKey.equals("")) && productPrice != 0){
            System.out.println("Product Activation Key: "+this.productActivationKey);
            System.out.println("Product Price: "+this.productPrice);
        }
    }

}
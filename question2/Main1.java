import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Phone[] phones = new Phone[4];
		for(int i=0;i<phones.length;i++)
		{
		    phones[i] = new Phone(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
		}
		String parbrand = sc.next();
		String paros = sc.next();
		Phone[] result = getPhoneIdBasedOnOs(paros, phones);
		int sum = findPriceForGivenBrand(phones, parbrand);
		if(sum!=0)
		{
		    System.out.println(sum);
		}
		else
		{
		    System.out.println("The given Brand is not available");
		}
		if(result!=null)
		{
		    for(int i=0;i<result.length;i++)
		    {
		       System.out.println(result[i].getPhoneId()); 
		    }
		}
		else
		{
		    System.out.println("No phones are available with specified os and price range");
		}
	}
	
	public static int findPriceForGivenBrand(Phone[] phones, String parbrand){
	    int sum = 0;
	    for(int i=0;i<phones.length;i++)
	    {
	        if(phones[i].getBrand().equals(parbrand))
	        {
	            sum = sum + phones[i].getPrice();
	        }
	    }
	    return sum;
	}
	public static Phone[] getPhoneIdBasedOnOs(String paros, Phone[] phones){
	    Phone[] ref = new Phone[0];
	    for(int i=0;i<phones.length;i++)
	    {
	        if(phones[i].getOs().equals(paros) && phones[i].getPrice()>=50000)
	        {
	            ref = Arrays.copyOf(ref, ref.length+1);
	            ref[ref.length-1] = phones[i]; 
	        }
	    }
	    return ref;
	}
}

class Phone
{
    private int phoneId;
    private String os;
    private String brand;
    private int price;
    
    Phone(int phoneId, String os, String brand, int price){
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }
    
    /*getters*/
    public int getPhoneId(){
        return phoneId;
    }
    public String getOs(){
        return os;
    }
    public String getBrand(){
        return brand;
    }
    public int getPrice(){
        return price;
    }
    
    /*setters*/
    public void setPhoneId(int phoneId){
        this.phoneId = phoneId;
    }
    public void setOs(String os){
        this.os = os;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
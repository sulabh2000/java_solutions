import java.util.*;
public class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		TravelAgencies[] travelagencies = new TravelAgencies[4];
		for(int i=0;i<travelagencies.length;i++)
		{
		    int regNo = sc.nextInt();
		    sc.nextLine();
		    String agencyName = sc.nextLine();
		    String pakageType = sc.nextLine();
		    int price = sc.nextInt();
		    boolean flightFacility = sc.nextBoolean();
			travelagencies[i] = new TravelAgencies(regNo, agencyName, pakageType, price, flightFacility);
		}
		int paregNo = sc.nextInt();
		sc.nextLine();
		String parpakageType = sc.nextLine();
		TravelAgencies result = agencyDetailsforGivenIdAndType(travelagencies, paregNo, parpakageType);
		int res = findAgencyWithHighestPackagePrice(travelagencies);
		System.out.println(res);
		System.out.println(result.getagencyName()+":"+result.getprice());
	}

	public static int findAgencyWithHighestPackagePrice(TravelAgencies[] travelagencies){
		int max=0;
		for(int i=0;i<travelagencies.length;i++)
		{
			if(travelagencies[i].getprice()>max)
			{
				max=travelagencies[i].getprice();
			}
		}
		return max;
	}
	public static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies[] travelagencies, int paregNo, String parpakageType){
		for(int i=0;i<travelagencies.length;i++)
		{
			if(travelagencies[i].getflightFacility()==true && travelagencies[i].getregNo()==paregNo && travelagencies[i].getpakageType().equals(parpakageType))
			{
				return travelagencies[i];
			}
		}
		return null;
	}

}


class TravelAgencies
{
	private int regNo;
	private String agencyName;
	private String pakageType;
	private int price;
	private boolean flightFacility;

	TravelAgencies(int regNo, String agencyName, String pakageType, int price, boolean flightFacility){
		this.regNo = regNo;
		this.agencyName = agencyName;
		this.pakageType = pakageType;
		this.price = price;
		this.flightFacility = flightFacility;
	}

	/*getters*/
	public int getregNo()
	{
		return regNo;
	}
	public String getagencyName()
	{
		return agencyName;
	}
	public String getpakageType()
	{
		return pakageType;
	}
	public int getprice()
	{
		return price;
	}
	public boolean getflightFacility()
	{
		return flightFacility;
	}

	/*setters*/
	public void setregNo(int regNo)
	{
		this.regNo = regNo;
	}
	public void setagencyName(String agencyName)
	{
		this.agencyName = agencyName;
	}
	public void setpakageType(String pakageType)
	{
		this.pakageType = pakageType;
	}
	public void setprice(int price)
	{
		this.price = price;
	}
	public void setflightFacility(boolean flightFacility)
	{
		this.flightFacility = flightFacility;
	}

}
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AutonomousCar[] autonomouscar = new AutonomousCar[4];
		for(int i=0;i<autonomouscar.length;i++)
		{
		    autonomouscar[i] = new AutonomousCar(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next());
		}
		String parenvir = sc.next();
		String parbrand = sc.next();
		AutonomousCar[] result = updateCarGrade(parbrand, autonomouscar);
		int res = findTestPassedByEnv(autonomouscar, parenvir);
		if(res!=0)
		{
		System.out.println(res);
		}
		else
		{
		System.out.println("There are no tests passed in this particular environment");
		}
		if(result!=null)
		{
		for(int j=0;j<result.length;j++)
		{
		    System.out.println(result[j].getBrand()+"::"+result[j].getGrade());
		}
		}
		else
		{
		    System.out.println("No Car is available with the specified brand");
		}
	}
	
	public static int findTestPassedByEnv(AutonomousCar[] autonomouscar, String parenvir){
	    int sum = 0;
	    for(int i=0;i<autonomouscar.length;i++)
	    {
	        if(autonomouscar[i].getEnvironment().equals(parenvir))
	        {
	            sum = sum + autonomouscar[i].getnoOfTestsPassed();
	        }
	    }
	   return sum;
	}
	public static AutonomousCar[] updateCarGrade(String parbrand, AutonomousCar[] autonomouscar){
	    AutonomousCar[] ref = new AutonomousCar[0];
	    for(int i=0;i<autonomouscar.length;i++)
	    {
	        if(autonomouscar[i].getBrand().equals(parbrand))
	        {
	            
	            if(((autonomouscar[i].getnoOfTestsPassed()*100)/autonomouscar[i].getnoOfTestsConducted())>=80)
	            {
	                autonomouscar[i].setGrade("A1");
	            }
	            else
	            {
	                autonomouscar[i].setGrade("B2");
	            }
	            ref = Arrays.copyOf(ref, ref.length+1);
	            ref[ref.length-1] = autonomouscar[i];
	        }
	    }
	    return ref;
	}
}

class AutonomousCar
{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;
    
    AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment){
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }
    /* getters */
    public int getcarId()
    {
       return carId; 
    }
    public String getBrand()
    {
       return brand; 
    }
    public int getnoOfTestsConducted()
    {
       return noOfTestsConducted; 
    }
    public int getnoOfTestsPassed()
    {
       return noOfTestsPassed; 
    }
    public String getEnvironment()
    {
       return environment; 
    }
    public String getGrade()
    {
       return grade; 
    }
    /* setters */
    public void setcarId(int carId)
    {
       this.carId = carId; 
    }
    public void setBrand(String brand)
    {
       this.brand = brand; 
    }
    public void setnoOfTestsConducted(int noOfTestsConducted)
    {
       this.noOfTestsConducted = noOfTestsConducted; 
    }
    public void setnoOfTestsPassed(int noOfTestsPassed)
    {
       this.noOfTestsPassed = noOfTestsPassed; 
    }
    public void setEnvironment(String environment)
    {
       this.environment = environment; 
    }
    public void setGrade(String grade)
    {
       this.grade = grade; 
    }
}
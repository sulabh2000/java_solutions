import java.util.*;
public class Main
{
	public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Institution[] institutions = new Institution[4];
            for(int i=0;i<institutions.length;i++)
            {
                institutions[i] = new Institution(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next());
            }
            String parloc = sc.next();
            String parinsname = sc.next();
            int sum = findNumClearancedByLoc(institutions, parloc);
            Institution result = updateInstitutionGrade(parinsname, institutions);
            if(sum!=0)
            {
                System.out.println(sum);
            }
            else{
                System.out.println("There are no cleared students in this particular location");
            }
            if(result!=null)
            {
                System.out.println(result.getinstitutionName()+"::"+result.getgrade());
            }
            else{
                System.out.println("No Institute is available with the specified name");
            }
            
	}
	
	public static int findNumClearancedByLoc(Institution[] institutions, String parloc){
	    int sum=0;
	    for(int i=0;i<institutions.length;i++)
	    {
	        if(institutions[i].getlocation().equals(parloc))
	        {
	            sum = sum + institutions[i].getnoOfStudentsCleared();
	        }
	    }
	    return sum;
	}
	public static Institution updateInstitutionGrade(String parinsname, Institution[] institutions){
	    for(int i=0;i<institutions.length;i++)
	    {
	        if(institutions[i].getinstitutionName().equals(parinsname))
	        {
	            if(((institutions[i].getnoOfStudentsPlaced() * 100)/institutions[i].getnoOfStudentsCleared())>=80)
	            {
	                institutions[i].setgrade("A");
	            }
	            else
	            {
	                institutions[i].setgrade("B");
	            }
	            return institutions[i];
	        }
	    }
	    return null;
	}
}

class Institution
{
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;
    
    Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location){
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }
    
    /*getters*/
    public int getinstitutionId()
    {
        return institutionId;
    }
    public String getinstitutionName()
    {
        return institutionName;
    }
    public int getnoOfStudentsPlaced()
    {
        return noOfStudentsPlaced;
    }
    public int getnoOfStudentsCleared()
    {
        return noOfStudentsCleared;
    }
    public String getlocation()
    {
        return location;
    }
    public String getgrade()
    {
        return grade;
    }
    
    /*setters*/
    public void setinstitutionId(int institutionId)
    {
        this.institutionId = institutionId;
    }
    public void setinstitutionName(String institutionName)
    {
        this.institutionName = institutionName;
    }
    public void setnoOfStudentsPlaced(int noOfStudentsPlaced)
    {
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }
    public void setnoOfStudentsCleared(int noOfStudentsCleared)
    {
        this.noOfStudentsCleared = noOfStudentsCleared;
    }
    public void setlocation(String location)
    {
        this.location = location;
    }
    public void setgrade(String grade)
    {
        this.grade = grade;
    }
}
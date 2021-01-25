import java.util.*;
public class Main
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for(int i=0;i<players.length;i++)
        {
            players[i] = new Player(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        int target = sc.nextInt();
        double[] arr = findAverageOfRuns(players, target);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=80 && arr[i]<=100)
            {
                System.out.println("Grade A");
            }
            else if(arr[i]>=50 && arr[i]<=79)
            {
                System.out.println("Grade B");
            }
            else
            {
                System.out.println("Grade C");
            }
        }
    }
    
    public static double[] findAverageOfRuns(Player[] players, int target){
        double[] arr = new double[0];
        for(int i=0;i<players.length;i++)
        {
            if(target<=players[i].getmatchesPlayed())
            {
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = (double)(players[i].getrunsScored()/players[i].getmatchesPlayed()); 
            }
        }
        return arr;
    }
}


class Player
{
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;
    
    Player(int id, String name, int iccRank, int matchesPlayed, int runsScored){
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }
    
    /*getters*/
    public int getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
    public int geticcRank()
    {
        return iccRank;
    }
    public int getmatchesPlayed()
    {
        return matchesPlayed;
    }
    public int getrunsScored()
    {
        return runsScored;
    }
    
    /*setters*/
    public void setid(int id)
    {
        this.id = id;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public void seticcRank(int iccRank)
    {
        this.iccRank = iccRank;
    }
    public void setmatchesPlayed(int matchesPlayed)
    {
        this.matchesPlayed = matchesPlayed;
    }
    public void setrunsScored(int runsScored)
    {
        this.runsScored = runsScored;
    }
    
}
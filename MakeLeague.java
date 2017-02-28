package andrew.zach.lmsprototype1;

/**
 * Created by Zach on 16/02/2017.
 */
public class MakeLeague {

    private String leagueName; //to store user defined string name
    private String Admin;//the owner of the league
    private int numPlayers; //to define the number of players allowed in the league

    //default constructor takes in name of league, admin and number of players
    public MakeLeague (String leagueName,String Admin, int x){
        this.leagueName=leagueName;
        this.Admin=Admin;
        this.numPlayers=x;

    }




}

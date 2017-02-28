package andrew.zach.lmsprototype1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static andrew.zach.lmsprototype1.R.id.*;

import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //*Add firebase references if needed*
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); //get an instence of the database
    DatabaseReference mRootChild = mRootRef.child("Player Entries");
    DatabaseReference mRootChild1 = mRootRef.child("League 1");

    final int maxSizeLeague1 = 20; //size of league
    int leaguesize = 0;

    private static Button viewPlayersButton;//to switch view to DisplayPlayers class
    private static Button viewTotalPlayers;//to switch view to total players


    // HashMap <Integer,String> map= new HashMap<Integer, String>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //
        viewTotalPlayers= (Button) findViewById(R.id.viewAllPlayers);
        viewPlayersButton = (Button) findViewById(R.id.pressViewPlayers);

        //**to bring to show players page*

        //  viewPlayersScreen();
        //  viewTotalPlayers();


        //********************************
        //***to bring up all players page****

        //************************************


        //Declare variables that will be used
        //Buttons
        final Button uploadTeam = (Button) findViewById(sendT);//to upload teams
        final Button placeListIntoLeague = (Button) findViewById(enterIntoLeague); //to enter players into league
        final Button resetDatabaseData = (Button) findViewById(changeDatabaseInfo);//to change data on database
        // final Button viewPlayersButton = (Button) findViewById(pressViewPlayers);//to switch view to DisplayPlayers class

        //TextView
        final TextView text1 = (TextView) findViewById(textView); //a view to see what team has been uploaded
        final TextView notif = (TextView) findViewById(notifications);//just to display and notifies us of whats happening

        //EditText
        final EditText textInputTeam = (EditText) findViewById(playerInputText); // an EditText field to enter team names

        /*/Try array of names
        final String playerList[]=new String[5]; //try to store a list of names to put onto database
        playerList[1]="Tom Smith";
        playerList[2]="Jack Thomas";
        /*/

        //try list of names
        final List<String> list = new ArrayList<>();


        //*Add firebase references if needed*


        //

        //*Upload teams function*
        uploadTeam.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                EditText teamNameEntry = (EditText) findViewById(playerInputText); //find whats in teamInputText, convert to string, store as teamName
                String teamName = teamNameEntry.getText().toString();
                // TextView temp = (TextView) findViewById(R.id.textView);
                notif.setText("");
                textInputTeam.setText("");

                //A list for player names
                List<String> list1 = list;


                //*Firebase function*
                //*IGNORE* mRootChild.setValue(new Teams(teamName));
                if (leaguesize < maxSizeLeague1) {
                    list1.add(teamName);
                    mRootChild.setValue(list);


                    //*IGNORE*  map.put(x,teamName);
                    //*IGNORE*  mRootChild.setValue(map); //push map
                    //***mRootChild.push().setValue(new Teams(map.get("League"))); //push to Teams
                    //***mRootChild1.push().setValue(new EnteredLeague(teamName));//push to League
                    // playerList [leaguesize]=teamName;
                    //DATABASE ATTEMPT 1
                   /* if(leaguesize<maxSizeLeague1) {  //GET NAMES ONTO DATABASE
                        for(int x1=0;x1<maxSizeLeague1;x1++){
                        mRootChild.push().setValue(playerList[leaguesize]);}
                    }*/

                    //DATABASE ATTEMPT 2
                    // mRootChild.setValue(new PlayerList(teamName));

                    //Database ATTEMPT 3
                    // int inOrder=leaguesize;
                    // Teams t=new Teams(inOrder,teamName);
                    // mRootChild.setValue(t);


                    text1.setText("*Player entered into League!*"); //set info on text field to typed in name
                    notif.setText("Player*" + teamName + "* entered into the *LEAGUE*");

                    leaguesize++; //Increment league capacity member count, as one team is added at a time


                } else {
                    text1.setText("*CANNONT enter team! LEAGUE IS FULL*");


                }

                   /* if(mRootChild.getRoot().toString()!=teamName)  //a checked to stop adding duplicate teams
                    {
                        mRootChild.setValue(new Teams(teamName));
                    }*/


            }

        });


        //*Reset Data function*
        resetDatabaseData.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                //reset child node data
                mRootRef.setValue("*RESETTED ALL DATABASE DATA*");

                notif.setText("DATA on the DATABASE is *RESETTED*!");

                text1.setText("***LEAGUE HAS BEEN EMPTIED***");
                notif.setText("");
                //reset league size (so teams can be added again)
                leaguesize = 0;
                list.clear();

            }
        });

        //*Upload players into the League*
        placeListIntoLeague.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                mRootChild1.setValue(list);
            }
        });

/*
            */
    }


    //*Outside of onCreate*

    public void viewPlayersButton(View view) {
        Intent intent = new Intent(this, PlayerList.class);
        startActivity(intent);
    }

    public void viewTotalPlayers(View view) {
        Intent intent = new Intent(this, DisplayPlayers.class);
        startActivity(intent);

    }



//***********TO SWITCH TO 'DisplayPlayers' class!***********
    /*
    public void viewPlayersScreen() {

        viewPlayersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("andrew.zach.lmsprototype1.DisplayPlayers");
                startActivity(intent);
            }
        });
        */

    }
//***********TO SWITCH TO 'DisplayPlayers' class!***********
/*
    public void viewTotalPlayers() {


        viewTotalPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent("andrew.zach.lmsprototype1.PlayerList");
                startActivity(intent2);
            }
        });        //***********TO SWITCH TO 'DisplayPlayers' class!***********

*/
//***********TO SWITCH TO 'DisplayPlayers' class!***********

        //   Intent intent = new Intent(this, DisplayPlayers.class);
        //   startActivity(intent);



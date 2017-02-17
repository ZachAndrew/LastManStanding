package andrew.zach.lmsprototype1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

import static andrew.zach.lmsprototype1.R.id.*;

import com.google.firebase.database.*;


public class MainActivity extends AppCompatActivity {

        //*Add firebase references if needed*
        DatabaseReference mRootRef=FirebaseDatabase.getInstance().getReference(); //get an instence of the database
        DatabaseReference mRootChild=mRootRef.child("Teams");
        DatabaseReference mRootChild1=mRootRef.child("League");

        final int maxSizeLeague1=5; //size of league
        int leaguesize=0;



        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);

            //Declare variables that will be used
            //Buttons
            final Button uploadTeam =(Button) findViewById(sendT);//to upload teams
            final Button resetDatabaseData=(Button)findViewById(changeDatabaseInfo);//to change data on database

            //TextView
            final TextView text1= (TextView) findViewById(textView); //a view to see what team has been uploaded
            final TextView notif=(TextView) findViewById(notifications);//just to display and notifies us of whats happening

            //EditText
            final EditText textInputTeam=(EditText) findViewById(teamInputText); // an EditText field to enter team names

            //*Add firebase references if needed*


            String teamName="No input yet.";



            //

            //*Upload teams function*
            uploadTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EditText teamNameEntry = (EditText) findViewById(teamInputText); //find whats in teamInputText, convert to string, store as teamName
                    String teamName=teamNameEntry.getText().toString();
                    // TextView temp = (TextView) findViewById(R.id.textView);
                    text1.setText("***Team has entered a League!***"); //set info on text field to typed in name

                    //*Firebase function*
                    //mRootChild.setValue(new Teams(teamName));
                    if(leaguesize<maxSizeLeague1) {
                        mRootChild.push().setValue(new Teams(teamName)); //push to Teams
                        mRootChild1.push().setValue(new EnteredLeague(teamName));//push to League
                        notif.setText("The team *" + teamName + "* has been added to the DATABASE, in *TEAMS* and *LEAGUE*");

                        leaguesize++; //Increment league capacity member count, as one team is added at a time

                    }else{
                        text1.setText("***CANNONT enter team! LEAGUE IS FULL***");
                    }

                   /* if(mRootChild.getRoot().toString()!=teamName)  //a checked to stop adding duplicate teams
                    {
                        mRootChild.setValue(new Teams(teamName));
                    }*/




                }

            });




            //*Reset Data function*
            resetDatabaseData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //reset child node data
                    mRootRef.setValue("*RESETTED ALL DATABASE DATA*");

                    notif.setText("DATA on the DATABASE is *RESETTED*!");

                    text1.setText("***LEAGUE HAS BEEN EMPTIED***");
                    notif.setText("");

                }
            });





        }



        //*Outside of onCreate*









}


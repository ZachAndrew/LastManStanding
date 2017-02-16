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




        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);

            //Declare variables that will be used
            final Button uploadTeam =(Button) findViewById(sendT);
            final TextView text1= (TextView) findViewById(textView); //a view to see what team has been uploaded
            final EditText textInputTeam=(EditText) findViewById(teamInputText); // an EditText field to enter team names

            //*Add firebase references if needed*


            String teamName="No input yet.";



            //


            uploadTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EditText teamNameEntry = (EditText) findViewById(teamInputText); //find whats in teamInputText, convert to string, store as teamName
                    String teamName=teamNameEntry.getText().toString();
                    // TextView temp = (TextView) findViewById(R.id.textView);
                    text1.setText(teamName); //set info on text field to typed in name

                    //*Firebase function*
                    //mRootChild.setValue(new Teams(teamName));
                    mRootChild.setValue(new Teams(teamName));
                   /* if(mRootChild.getRoot().toString()!=teamName)  //a checked to stop adding duplicate teams
                    {
                        mRootChild.setValue(new Teams(teamName));
                    }*/


                }

            });

        }



        //*Outside of onCreate*









}


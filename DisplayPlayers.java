package andrew.zach.lmsprototype1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayPlayers extends Activity {


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); //get an instence of the database
    DatabaseReference mRootChild = mRootRef.child("Teams");
    //DatabaseReference mRootChild1 = mRootRef.child("League");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_players);

        TextView playersDisplay=(TextView) findViewById(R.id.textViewDisplayPlayers);

       // mRootChild.push().setValue(new Teams("Second Page working"));//a check to see if class can acess database

       // playersDisplay.setText(mRootChild.child("Teams").getKey());//*Display child node data*
        playersDisplay.setText(mRootChild.getRoot().toString());//*Display child node data*

       /***TRYING TO GET childlistener to work***
       mRootRef.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                System.out.println(dataSnapshot.getKey());
            }

            // ...
        });*/


        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_players);

    }
}

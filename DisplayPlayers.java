package andrew.zach.lmsprototype1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.*;

import java.util.List;


public class DisplayPlayers extends Activity {


    private ListView mListView;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); //get an instence of the database
    DatabaseReference mRootChild = mRootRef.child("Player Entries");
    DatabaseReference mRootChild1 = mRootRef.child("League 1");
 //   DatabaseReference mRootChild2 = mRootRef.child("Player List2");
   // DatabaseReference getmRootChildChild=mRootChild.child("CHECK");
    //DatabaseReference mRootChild1 = mRootRef.child("League");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_players);
      //  TextView playersDisplay=(TextView) findViewById(R.id.textViewDisplayPlayers);


        mListView=(ListView) findViewById(R.id.listView); //a list view referenced by id

        //this adapter works with our list and displays whats on firebase
        FirebaseListAdapter <String> firebaseListAdapter= new FirebaseListAdapter<String>(
                this,
                String.class,
                android.R.layout.simple_list_item_1,
                mRootChild1
        ) {
            @Override
            protected void populateView(View v, String model, int position) {
                TextView textView=(TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };

        mListView.setAdapter(firebaseListAdapter);























        /*********************************************************************
        mRootChild.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                List mylist = dataSnapshot.getValue(List.class);
                System.out.println("The blog post titled " + mylist + " has been deleted");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        //********************************************************************

        //************TRYING TO PULL DOWN DATA FROM FIREBASE*************
        final DatabaseReference dinosaursRef = mRootChild.getRef();
        dinosaursRef.orderByChild("height").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                List mylist = dataSnapshot.getValue(List.class);
                System.out.println(dataSnapshot.getKey() + " was " + mylist+ " meters tall.");
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                List mylist = dataSnapshot.getValue(List.class);
                System.out.println("The blog post titled " + mylist + " has been deleted");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}

            // ...
        });
        //****************************************************************

        //***************TRYING TO PULL DATA DOWN FROM FIREBASE**************************
        DatabaseReference teamsRef = mRootRef.getRef();
        teamsRef.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                System.out.println("The " + dataSnapshot.getKey() + " score is " + dataSnapshot.getValue());
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                List mylist = dataSnapshot.getValue(List.class);
                System.out.println("The blog post titled " + mylist + " has been deleted");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
         //******************************************************************************


            // ...
        });  */


       // mRootChild.push().setValue(new Teams("Second Page working"));//a check to see if class can acess database

       // playersDisplay.setText(mRootChild.child("Teams").getKey());//*Display child node data*
       // playersDisplay.setText(mRootChild.getParent().toString());//*Display child node data*

       /***TRYING TO GET childlistener to work***
       mRootRef.orderByKey().addChildEventmListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                System.out.println(dataSnapshot.getKey());
            }

            // ...
        });*/


        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_players);

    }

}

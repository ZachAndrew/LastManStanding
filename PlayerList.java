package andrew.zach.lmsprototype1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Zach on 13/02/2017.
 */
public class PlayerList extends Activity {

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
        setContentView(R.layout.activity_display_total_players);
      //  TextView playersDisplay = (TextView) findViewById(R.id.textViewDisplayPlayers);

        mListView = (ListView) findViewById(R.id.listView2); //a list view referenced by id

        //this adapter works with our list and displays whats on firebase
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(
                this,
                String.class,
                android.R.layout.simple_list_item_1,
                mRootChild
        ) {
            @Override
            protected void populateView(View v, String model, int position) {
                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };


        mListView.setAdapter(firebaseListAdapter);

    }
}







/*********ATTEMPT 1**********
    //Default constructor
    public PlayerList(){
        String name="*NAME*";
    }

    public String PlayerList(String input){
        //store names
        if(x!=array.length) {
            array[x] = input;
            return array[x];
        }
        else{return "NULL";}
    }**********************/


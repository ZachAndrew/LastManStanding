package andrew.zach.lmsprototype1;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Zach on 13/02/2017.
 */
public class PlayerList {
    String name;
    String p1;
    String p2;
    String p3;
    String p4;
    String p5;
    String list[]=new String[5];
    int x=0;//counter to input names

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); //get an instence of the database
    DatabaseReference mRootChild = mRootRef.child("Teams");

    //Default constructor
    public PlayerList(int c,String x){ //take values before Teams is implemented

        list[c]=x;
        System.out.print("*******************************"+"VALUE OF c:"+c+"******************************");



       /* if(c==5) {
            list[0]=p1;
            list[1]=p2;
            list[2]=p3;
            list[3]=p4;
            list[4]=p5;
        }*
        /*if(c==5) {
            for (int cx=0;cx<list.length;cx++) {
               // mRootChild.push().setValue(list[cx]);

            }*/

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


package ***Put Your Package Name here***;

import android.app.Application;

import android.widget.Button;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Heather on 31/10/2016.
 */

public class MyApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Firebase.setAndroidContext(this);

    }

}

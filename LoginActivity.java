package ***Put Your Package Name Here***;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;

    private TextView msignup;

    private Button mLoginBtn;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);
        msignup = (TextView) findViewById(R.id.signupTxt);

        mLoginBtn = (Button) findViewById(R.id.loginBtn);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(this, AccountActivity.class));

                }
            }
        };

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });

        msignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(this, Signup.class));

            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        mAuth.addAuthStateListener((mAuthListener));
    }

    private void startSignIn(){

        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Fields are Empty", Toast.LENGTH_LONG).show();

        }
        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {

                        Toast.makeText(this, "Sign In Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}

package com.example.lastmanstandingv1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailVerificationActivity extends AppCompatActivity {

    private static final String TAG = "EmailVerification";

    private EditText mEmailField;
    private Button msendEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        final FirebaseAuth auth = FirebaseAuth.getInstance();
        mEmailField = (EditText) findViewById(R.id.editText7);
        msendEmailBtn = (Button) findViewById(R.id.button3);

        msendEmailBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String emailaddress = mEmailField.getText().toString().trim();

                if (TextUtils.isEmpty(emailaddress)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                user.sendEmailVerification()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent.");
                                    mEmailField.setText("");
                                    Toast.makeText(EmailVerificationActivity.this, "Email sent.",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Email failed to send." + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}

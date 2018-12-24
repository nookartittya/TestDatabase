package com.example.lenovo.testdatabase;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFriendActivity extends AppCompatActivity {
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mTel;
    private EditText mEmail;
    private EditText mDescription;
    private Button mButtonOK;

    private DBHelper mHelper;

    private int ID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_friend);

        mFirstName = (EditText) findViewById(R.id.add_first_name);
        mLastName = (EditText) findViewById(R.id.add_last_name);
        mTel = (EditText) findViewById(R.id.add_tel);
        mEmail = (EditText) findViewById(R.id.add_email);
        mDescription = (EditText) findViewById(R.id.add_description);
        mButtonOK = (Button) findViewById(R.id.button_submit);
        mHelper = new DBHelper(this);

        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(AddFriendActivity.this);
                builder.setTitle(getString(R.string.add_data_title));
                builder.setMessage(getString(R.string.add_data_message));

                builder.setPositiveButton(getString(android.R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Friend friend = new Friend();
                                friend.setFirstName(mFirstName.getText().toString());
                                friend.setLastName(mLastName.getText().toString());
                                friend.setTel(mTel.getText().toString());
                                friend.setEmail(mEmail.getText().toString());
                                friend.setDescription(mDescription.getText().toString());

                                if (ID == -1) {
                                    mHelper.addFriend(friend);
                                } else {
                                    friend.setId(ID);
                                    //mHelper.updateFriend(friend);
                                }
                                finish();
                            }
                        });

                builder.setNegativeButton(getString(android.R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });


                builder.show();
            }
        });

    }
}

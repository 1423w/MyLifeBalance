package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.database.DatabaseQuery;
import com.inducesmile.androidmultiquiz.entities.Client;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private TextView thing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>My Life Balance</font>"));

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        thing = (TextView) findViewById(R.id.textView2);

//        Button register = (Button) findViewById(R.id.register_button);
//        assert register != null;
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatabaseQuery dbQuery = new DatabaseQuery(RegisterActivity.this);
//                Client client = new Client(name.getText().toString(), email.getText().toString());
//                dbQuery.addClient(client);
//                Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
//                startActivity(quizCategoryIntent);
//            }
//        });

//        Button asGuest = (Button)findViewById(R.id.guest_button);
//        assert asGuest != null;
//        asGuest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
//                startActivity(quizCategoryIntent);
//            }
//        });
    }

    public void registerClient(View view){
        DBHandler DBhandler = new DBHandler(RegisterActivity.this, null, null, 1);
        Client client = new Client(name.getText().toString(), email.getText().toString());
        DBhandler.addClient(client);
        Intent quizCategoryIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
        startActivity(quizCategoryIntent);
    }

    public void findClients() {
        DBHandler dbHandler = new DBHandler(RegisterActivity.this, null, null, 1);
        Client client = dbHandler.findAllClients();
        if(client != null) {
            thing.setText(String.valueOf(client.getEmail()));
        }
    }
}

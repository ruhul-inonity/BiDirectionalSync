package com.inonitylab.bidirectionalsync.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.inonitylab.bidirectionalsync.R;
import com.inonitylab.bidirectionalsync.db.DBController;

import java.util.HashMap;

public class InputUserActivity extends AppCompatActivity {

    EditText editAddUser;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);

        editAddUser = (EditText) findViewById(R.id.editTextAddUser);
    }

    /**
     * Called when Save button is clicked
     * @param view
     */
    public void addUser(View view){
        String user = editAddUser.getText().toString();

        HashMap<String, String> queryValues = new HashMap<String, String>();
        queryValues.put("userName", user);
        if (user != null
                && user.trim().length() != 0) {
            controller.createUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter User name",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Navigate to Home Screen
     * @param view
     */
    public void callHomeActivity(View view) {
        Intent intent = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(intent);
    }
}

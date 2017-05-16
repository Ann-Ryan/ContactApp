package com.example.ryana7853.contactapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText editName;
    EditText editNumber;
    EditText editEmail;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.editText_name);
        editNumber = (EditText) findViewById(R.id.editText_number);
        editEmail = (EditText) findViewById(R.id.editText_email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addData (View v){
        boolean isInserted = myDb.insertData(editName.getText().toString(), editNumber.getText().toString(), editEmail.getText().toString());
        if(isInserted){
            //create toast method to user indicating data inserted correctly
            Log.d("MyContact", "Data insertion successful!");
            String message = "SUCCESS!";
            int duration  = Toast.LENGTH_SHORT;
            Context context = getApplicationContext();
           // Toast toast = new Toast(this, message, duration);
           Toast t = new Toast(context);
            t.setDuration(duration);
            t.setText(message);
            t.show();
        }
        else{
            //create toast method to user indicating data inserted incorrectly!
            Log.d("MyContact", "Data insertion unsuccessful!");
            String message = "FAILURE!";
            int duration  = Toast.LENGTH_SHORT;
            Context context = getApplicationContext();
            Toast t = new Toast(context);
            t.setText(message);
            t.setDuration(duration);
            t.show();
        }
    }

    public void viewData(View v){
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0){
            showMessage("Error", "No data found in database");
            //put a log.d message and toast
            Log.d("MyContact", "No data found in database!");
        }
        StringBuffer buffer = new StringBuffer();
        //set up while loop with curser moveToNext method
        //append each col to buffer
        //use getString method
        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title, String message){

    }
}

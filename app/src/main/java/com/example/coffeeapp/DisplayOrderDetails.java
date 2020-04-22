package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayOrderDetails extends AppCompatActivity {
    Intent intent;
    String message;
    String name;
    String cost;
    CoffeeDBHandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = new CoffeeDBHandler(this,null,null,1);
        setContentView(R.layout.activity_display_order_details);
        //catch the message that is being sent and display the details
        intent = getIntent();
        name = intent.getStringExtra("name");
        message = intent.getStringExtra("sendMessage");
        cost = intent.getStringExtra("cost");
        //display the message in this activity
        TextView displayText = (TextView) findViewById(R.id.displayText);
        displayText.setText(message);
    }

    //method to display Email
    public void emailOrder(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        //only Email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Coffee Order by " + name);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(emailIntent);
        }
    }
    //button to save data in SQLite database
    public void addButtonClicked(View view){
        int intcost = Integer.parseInt(cost);
        // start the new intent here
        Order order = new Order(name,intcost);
       dbHandler.addOrder(order);
        Toast.makeText(getApplicationContext(), "Data Saved!", Toast.LENGTH_SHORT).show();
    }

    //method to send the report details
    public void salesReport(View view){
        //read the details from hte database to produce the report
        String dbString = dbHandler.databaseToString();
        // start the new intent here
        Intent salesIntent = new Intent(this, DisplaySalesDetails.class);
        salesIntent.putExtra("db",dbString);
        startActivity(salesIntent);
    }

}

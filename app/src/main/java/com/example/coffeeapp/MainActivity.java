package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declare global variable
    int noOfCoffee = 0;
    int priceOfCoffee = 4;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //create a new method for ORDER button
    public void submitOrder(View v) {
        //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        //calculate total price
        //int totalCost = noOfCoffee * priceOfCoffee;
        //display to display price
        //display(noOfCoffee);
        //String message = "Total: $" + totalCost + "\n" + "Thank you!";
        //priceTextView.setText(message);
        //____________________________________________________________________________________
        //Store user name in a String
        EditText userName1 = (EditText) findViewById(R.id.userName);
        String name = userName1.getText().toString();

        //Figure out if the user wants toppings
        CheckBox whippedCreamCheckBox = (CheckBox)
                findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox)
                findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        //call the calculate totalPrice() method
        int cost = calculateTotalPrice(hasWhippedCream,hasChocolate);
        String strCost = Integer.toString(cost);
        //Create the message String
            String message ="Name: "+name+"\n"+
                            "Add Whipped Cream: " +hasWhippedCream+ "\n"+
                            "Add Chocolate: " +hasChocolate+ "\n"+
                            "Quantity: " +noOfCoffee+"\n"+
                            "Total: $" +cost+ "\n"+
                            "\n"+"Thank You!";
            //Create a new Explicit Intent to pass the message
        Intent intent = new Intent(this,DisplayOrderDetails.class);
        intent.putExtra("name", name);
        intent.putExtra("sendMessage",message);
        intent.putExtra("cost", strCost);
        startActivity(intent);
    }

    //method to calculate the total price of coffee
    public int calculateTotalPrice(boolean whippedCreamCB, boolean chocolateCB) {
    if (whippedCreamCB) {
        priceOfCoffee = priceOfCoffee + 1;
        }
    if (chocolateCB == true) {
        priceOfCoffee = priceOfCoffee +2;
        }
    int totalCost = priceOfCoffee * noOfCoffee;
    return totalCost;
    }

    //method to display
    public void display(int number) {
        //create objects of the TextView
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("" + number);
        //priceTextView.setText(number);
    }

    //declare a method to increase the noOfCoffee
    public void increment(View v) {
        noOfCoffee = noOfCoffee + 1;
        if (noOfCoffee >= 10){
            noOfCoffee = 10;
        }
        display(noOfCoffee);
    }

    public void decrement(View v) {
        noOfCoffee = noOfCoffee - 1;
        if (noOfCoffee <= 0){
            //reset the noOfCoffee to 0
            noOfCoffee = 0;
        }
        display(noOfCoffee);
    }
}

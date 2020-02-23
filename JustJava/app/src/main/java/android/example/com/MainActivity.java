package android.example.com;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view) {
        int price = 0;
        EditText nameEditText = (EditText) findViewById(R.id.name_view);
        String customerName = nameEditText.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        price = calculatePrice(hasWhippedCream, hasChocolate);
        String message = createOrderSummary(price, customerName, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order summary");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        //displayMessage(message);

    }

    public void increment(View view) {
        quantity += 1;
        if (quantity > 99) {
            Toast.makeText(this, "Your order cannot be more than 99", Toast.LENGTH_LONG).show();
            quantity = 99;
        }
        display(quantity);
    }

    public void decrement(View view) {
        quantity -= 1;
        if (quantity < 0) {
            Toast.makeText(this, "Your order cannot be negative", Toast.LENGTH_LONG).show();
            quantity = 0;
        }
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(number));
    }

//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;

        if (hasWhippedCream) basePrice += 1;
        if (hasChocolate) basePrice += 2;

        return quantity * basePrice;
    }

    private String createOrderSummary(int price, String customerName, boolean hasWhippedCream, boolean hasChocolate) {
        String msg = "Name: " + customerName + "\nAdd whipped cream? " + hasWhippedCream + "\nAdd chocolate? " + hasChocolate +
                "\nQuantity: " + quantity + "\nTotal: $" + quantity * price + "\nThank you!";
        return msg;
    }
}

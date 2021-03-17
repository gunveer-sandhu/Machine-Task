package gunveer.codes.machinetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailsScreen extends AppCompatActivity {
    private static final String TAG = "whatever";
    String contact;
    String membership_number;
    String full_name, email_id, address, data_type, designation, list_year;
    String profile_pic_url;

    ImageView details_imageView;
    Button updateButton;
    TextView details_id, details_full_name,
            details_contact ,details_email,
            details_mem_num, details_address,
            details_list_year, details_data_type,
            details_designation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);


        details_imageView = findViewById(R.id.details_imageView);
        details_id = findViewById(R.id.details_id);
        details_full_name = findViewById(R.id.details_full_name);
        details_contact = findViewById(R.id.details_contact);
        details_email = findViewById(R.id.details_email);
        details_mem_num = findViewById(R.id.details_mem_num);
        details_address = findViewById(R.id.details_address);
        details_list_year = findViewById(R.id.details_list_year);
        details_data_type = findViewById(R.id.details_data_type);
        details_designation = findViewById(R.id.details_designation);
        updateButton = findViewById(R.id.updateButton);


        Intent intent = getIntent();
        int id = intent.getIntExtra("details_id", -1);
        full_name = intent.getStringExtra("details_full_name");
        contact = intent.getStringExtra("details_contact");
        email_id = intent.getStringExtra("details_email");
        address = intent.getStringExtra("details_address");
        membership_number = intent.getStringExtra("details_mem_num");
        data_type = intent.getStringExtra("details_data_type");
        designation = intent.getStringExtra("details_designation");
        list_year = intent.getStringExtra("details_list_year");
        profile_pic_url = intent.getStringExtra("details_imageView");



        details_id.setText(Integer.toString(id));
        details_full_name.setText(full_name);
        details_contact.setText(contact);
        details_email.setText(email_id);
        details_mem_num.setText(membership_number);
        details_address.setText(address);
        details_list_year.setText(list_year);
        details_data_type.setText(data_type);
        details_designation.setText(designation);
        Glide.with(this).load(profile_pic_url).into(details_imageView);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailsScreen.this, UpdateScreen.class);

                intent1.putExtra("details_id", Integer.toString(id));
                intent1.putExtra("details_full_name", full_name);
                intent1.putExtra("details_contact", contact);
                intent1.putExtra("details_email", email_id);
                intent1.putExtra("details_mem_num", membership_number);
                intent1.putExtra("details_address", address);
                intent1.putExtra("details_list_year", list_year);
                intent1.putExtra("details_data_type", data_type);
                intent1.putExtra("details_designation", designation);
                intent1.putExtra("details_imageView", profile_pic_url);

                startActivity(intent1);
            }
        });


    }
}
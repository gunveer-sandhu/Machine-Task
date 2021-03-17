package gunveer.codes.machinetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UpdateScreen extends AppCompatActivity {

    Button ok_button, cancel_button, update_image_button;
    EditText update_image, update_name, update_contact,
    update_email, update_mem_num, update_address,
    update_list_year, update_data_type, update_designation;
    ImageView imageView2;
    int id;


    RecyclerView recyclerView;
    RecyclerView.Adapter recAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_screen);
        recyclerView = findViewById(R.id.recyclerView);

        ok_button = findViewById(R.id.ok_button);
        cancel_button = findViewById(R.id.cancel_button);
        update_image = findViewById(R.id.update_image);
        update_name = findViewById(R.id.update_name);
        update_contact = findViewById(R.id.update_contact);
        update_email = findViewById(R.id.update_email);
        update_mem_num = findViewById(R.id.update_mem_num);
        update_address = findViewById(R.id.update_address);
        update_list_year = findViewById(R.id.update_list_year);
        update_data_type = findViewById(R.id.update_data_type);
        update_designation = findViewById(R.id.update_designation);
        imageView2 = findViewById(R.id.imageView2);
        update_image_button = findViewById(R.id.update_image_button);

        Intent intent = getIntent();

        update_image.setText(intent.getStringExtra("details_imageView"));
        update_name.setText(intent.getStringExtra("details_full_name"));
        update_contact.setText(intent.getStringExtra("details_contact"));
        update_email.setText(intent.getStringExtra("details_email"));
        update_mem_num.setText(intent.getStringExtra("details_mem_num"));
        update_address.setText(intent.getStringExtra("details_address"));
        update_list_year.setText(intent.getStringExtra("details_list_year"));
        update_data_type.setText(intent.getStringExtra("details_data_type"));
        update_designation.setText(intent.getStringExtra("details_designation"));
        id = Integer.parseInt(intent.getStringExtra("details_id"));

        Glide.with(UpdateScreen.this).load(update_image).into(imageView2);

        update_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageDrawable(null);
                Glide.with(UpdateScreen.this).load(update_image.getText().toString()).into(imageView2);
            }
        });


        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Write code for updating the array

                ArrayList<DataFetched> dataFetched = null;

                dataFetched = RecViewAdapter.getdataFetcheds();

                for(DataFetched d: dataFetched){
                    if(id== d.getId()){
                        Toast.makeText(UpdateScreen.this, "Got the id"+ id, Toast.LENGTH_SHORT).show();


                        d.setFull_name(update_name.getText().toString());
                        d.setProfile_pic_url(update_image.getText().toString());
                        d.setContact(update_contact.getText().toString());
                        d.setEmail_id(update_email.getText().toString());
                        d.setAddress(update_address.getText().toString());
                        d.setList_year(update_list_year.getText().toString());
                        d.setMembership_number(update_mem_num.getText().toString());
                        d.setData_type(update_data_type.getText().toString());
                        d.setDesignation(update_designation.getText().toString());

                        dataFetched.set(dataFetched.indexOf(d), d);
                    }
                }

                Intent intent = new Intent(UpdateScreen.this, MainActivity.class);

                startActivity(intent);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
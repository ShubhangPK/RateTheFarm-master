package com.example.msrit.ratethefarm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowFarmerDetails extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView mListView;
    private EditText mName;
    private EditText mVillage;
    private EditText mHobli;
    private EditText mTaluq;
    private EditText mAge;
    private ArrayList<String> mUsername=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_farmer_details);

       /* Bundle bundle = getIntent().getExtras();

        String data_1 = bundle.getString("Name");
        String data_2 = bundle.getString("Village");
        String data_3 = bundle.getString("Hobli");
        String data_4 = bundle.getString("Taluq");
        String data_5 = bundle.getString("Crop");
        TextView textView_1= (TextView)findViewById(R.id.name);
        TextView textView_2= (TextView)findViewById(R.id.village);
        TextView textView_3= (TextView)findViewById(R.id.hobli);
        TextView textView_4= (TextView)findViewById(R.id.taluq);
        TextView textView_5= (TextView)findViewById(R.id.crop);

        textView_1.setText(data_1);
        textView_2.setText(data_2);
        textView_3.setText(data_3);
        textView_4.setText(data_4);
        textView_5.setText(data_5);

*/
        // initiate rating bar and a button
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        mName = (EditText)findViewById(R.id.name_show);
        mVillage = (EditText)findViewById(R.id.village_show);
        mTaluq = (EditText)findViewById(R.id.taluq_show);
        mHobli = (EditText)findViewById(R.id.hobli_show);
        mAge = (EditText)findViewById(R.id.age_show);


        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://ratethefarm.firebaseio.com/Users");
        mListView =(ListView) this.<View>findViewById(R.id.user_list);
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mUsername);
        mListView.setAdapter(arrayAdapter);


        mDatabase.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {




                                                String name = mName.getText().toString().trim();
                                                String village = mVillage.getText().toString().trim();
                                                String hobli = mHobli.getText().toString().trim();
                                                String taluq = mTaluq.getText().toString().trim();
                                                String age = mAge.getText().toString().trim();




                                                HashMap<String,String> dataMap=new HashMap<String,String>();
                                                dataMap.put("Name",name);
                                                dataMap.put("Village",village);
                                                dataMap.put("Hobli",hobli);
                                                dataMap.put("Taluq",taluq);
                                                dataMap.put("Age",age);



                                                mDatabase.child(String.valueOf(dataSnapshot.getChildrenCount())).setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {

                                                    }
                                                });

                                                arrayAdapter.notifyDataSetChanged();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });


                mDatabase.child("Users").child(MyAdapter.mClickID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        UserData value = dataSnapshot.getValue(UserData.class);


                        Toast.makeText(ShowFarmerDetails.this, value.getName(), Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }
}

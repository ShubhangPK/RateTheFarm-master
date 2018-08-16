package com.example.msrit.ratethefarm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class GetFarmerDetails extends AppCompatActivity {

    DatabaseReference mDatabase;
    UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_farmer_details);
        mDatabase = FirebaseDatabase.getInstance().getReference();


        mDatabase.child("Current Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int value = dataSnapshot.getValue(Integer.class);
                value++;
                userData.setUserID(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Personal Details

        final EditText mName = findViewById(R.id.name);
        final EditText mVillage = findViewById(R.id.village);
        final EditText mHobli = findViewById(R.id.hobli);
        final EditText mTaluq = findViewById(R.id.taluq);
        final EditText mAge = findViewById(R.id.age);

        //Total no. of Workers

        final EditText mMaleWorkers = findViewById(R.id.workers_men);
        final EditText mFemaleWorkers = findViewById(R.id.workers_women);

        //Land Details

        final EditText mLandArea = findViewById(R.id.land_area);
        final RadioGroup rgLandType = findViewById(R.id.land_type);

        //Animals Owned

        final EditText mCow = findViewById(R.id.cow);
        final EditText mBuffalo = findViewById(R.id.buffalo);
        final EditText mCock = findViewById(R.id.cock);
        final EditText mHen = findViewById(R.id.hen);
        final EditText mSheep = findViewById(R.id.sheep);
        final EditText mGoat = findViewById(R.id.goat);
        final EditText mOtherAnimals = findViewById(R.id.others);

        //Sericulture

        final EditText mMulberryYield = findViewById(R.id.mulberry_yield);
        final RadioGroup rgMulberry = findViewById(R.id.sell_mulberry);

        //Machines Owned

        final CheckBox cTractor = findViewById(R.id.tractor);
        final CheckBox cPowerTiller = findViewById(R.id.power_tiller);
        final CheckBox cPlougher = findViewById(R.id.plougher);
        final CheckBox cRotomator = findViewById(R.id.rotomator);
        final CheckBox cBullock = findViewById(R.id.bullock_cart);
        final CheckBox cSprayer = findViewById(R.id.sprayer);
        final CheckBox cSprinkler = findViewById(R.id.sprinkler);

        //Crop Details

        final EditText mCrop = findViewById(R.id.crop_name);
        final EditText mCropArea = findViewById(R.id.crop_area);
        final EditText mCropYield = findViewById(R.id.crop_yield);

        //Miscellaneous

        final RadioGroup rgOnlineSales = findViewById(R.id.sell_online);

        final RadioGroup rgScientificSuggestions = findViewById(R.id.scientific_suggestions);

        final RadioGroup rgNursery = findViewById(R.id.own_nursery);

        final CheckBox cLocal = findViewById(R.id.sale_local);
        final CheckBox cAPMC = findViewById(R.id.sale_apmc);

        Button mSubmitBtn = findViewById(R.id.submit);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userData.setName(mName.getText().toString());
                userData.setVillage(mVillage.getText().toString());
                userData.setHobli(mHobli.getText().toString());
                userData.setTaluq(mTaluq.getText().toString());

                if (mAge.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mAge.getText().toString()));
                }


                if (mMaleWorkers.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mMaleWorkers.getText().toString()));
                }

                if (mFemaleWorkers.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mFemaleWorkers.getText().toString()));
                }


                if (mLandArea.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setLand(Double.parseDouble(mLandArea.getText().toString()));
                }


                int SelectedID = rgLandType.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(SelectedID);
                if (radioButton == null) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    userData.setIrrigatedOrRainfed(radioButton.getText().toString());
                }



                if (mCow.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mCow.getText().toString()));
                }

                if (mBuffalo.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mBuffalo.getText().toString()));
                }

                if (mCock.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mCock.getText().toString()));
                }

                if (mHen.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mHen.getText().toString()));
                }

                if (mSheep.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mSheep.getText().toString()));
                }

                if (mGoat.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mGoat.getText().toString()));
                }

                if (mOtherAnimals.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setAge(Integer.parseInt(mOtherAnimals.getText().toString()));
                }


                userData.setMulberryYield(Double.parseDouble(mMulberryYield.getText().toString()));
                SelectedID = rgMulberry.getCheckedRadioButtonId();
                radioButton = findViewById(SelectedID);
                if (radioButton == null) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String Value = radioButton.getText().toString();
                    if (Value.equals("Yes")) {
                        userData.setSellMulberry(true);
                    } else {
                        userData.setSellMulberry(false);
                    }
                }

                if (cTractor.isChecked()) {
                    userData.setOwnsTractor(true);
                }
                if (cPowerTiller.isChecked()) {
                    userData.setOwnsPowerTiller(true);
                }
                if (cPlougher.isChecked()) {
                    userData.setOwnsPlougher(true);
                }
                if (cRotomator.isChecked()) {
                    userData.setOwnsRotomator(true);
                }
                if (cBullock.isChecked()) {
                    userData.setOwnsBullockCart(true);
                }
                if (cSprayer.isChecked()) {
                    userData.setOwnsSprayer(true);
                }
                if (cSprinkler.isChecked()) {
                    userData.setOwnsSprinkler(true);
                }


                userData.setCropName(mCrop.getText().toString());

                if (mCropArea.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setCropArea(Double.parseDouble(mCropArea.getText().toString()));
                }

                if (mCropYield.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    userData.setCropArea(Double.parseDouble(mCropYield.getText().toString()));
                }

                SelectedID = rgOnlineSales.getCheckedRadioButtonId();
                radioButton = findViewById(SelectedID);
                if (radioButton == null) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String Value = radioButton.getText().toString();
                    if (Value.equals("Yes")) {
                        userData.setOnlineSale(true);
                    } else {
                        userData.setOnlineSale(false);
                    }
                }

                SelectedID = rgScientificSuggestions.getCheckedRadioButtonId();
                radioButton = findViewById(SelectedID);
                if (radioButton == null) {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String Value = radioButton.getText().toString();
                    if (Value.equals("Yes")) {
                     userData.setScientificSuggestions(true);
                    } else {
                      userData.setScientificSuggestions(false);
                    }
                 }

                SelectedID = rgNursery.getCheckedRadioButtonId();
                radioButton = findViewById(SelectedID);
                if (radioButton == null)
                {
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                    String Value = radioButton.getText().toString();

                    if (Value.equals("Yes")) {
                        userData.setOwnsNursery(true);
                    } else {
                        userData.setOwnsNursery(false);
                    }
                }

                if(cLocal.isChecked()){
                    userData.setSalesLocal(true);
                }

                if(cAPMC.isChecked()){
                    userData.setSalesAPMC(true);
                }

                userData.setCalculatedValues();

                mDatabase.child("Users").child(Integer.toString(userData.getUserID())).setValue(userData);
                mDatabase.child("Current Users").setValue(userData.getUserID());

            }
        });


        }

    /*public void Submit(View v){
        String Name = userData.getName();
        String Village =userData.getVillage();
        String Hobli =userData.getHobli();
        String Taluq = userData.getTaluq();
        String Crop = userData.getCropName();
        Intent passdata_Intent=new Intent(this,ShowFarmerDetails.class);
        passdata_Intent.putExtra("Name",Name);
        passdata_Intent.putExtra("Village",Village);
        passdata_Intent.putExtra("Hobli",Hobli);
        passdata_Intent.putExtra("Taluq",Taluq);
        passdata_Intent.putExtra("Crop",Crop);
        startActivity(passdata_Intent);
    }*/



}

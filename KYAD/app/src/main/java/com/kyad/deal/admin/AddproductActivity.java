package com.kyad.deal.admin;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.kyad.deal.admin.spinner.SpinnerAdapters;
import com.kyad.deal.R;
import com.kyad.deal.db.DatabaseManager;

import java.util.Calendar;

public class AddproductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    String[] productType = {"Groceries", "Pharmacy", "Fashion", "Pets"};

    String[] dealType = {};
    public static int logo[] = {R.drawable.amazon, R.drawable.walmart, R.drawable.canadiantire, R.drawable.bestbuy, R.drawable.shoppers};
    public static String[] storeName = {"Amazon", "Walmart", "Canadian Tire", "Best Buy", "Shoppers"};

    int storeSP = 0, productSP = 0, dealTypeSP = 0;
    DatabaseManager db;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);
        dealType = new String[]{getString(R.string.eg_bestdeals), getString(R.string.eg_newedeals), getString(R.string.stores)};

        db = new DatabaseManager(getApplicationContext());
        db.open();


        Spinner store_spin = (Spinner) findViewById(R.id.storeName);
        Spinner pd_spin = (Spinner) findViewById(R.id.productTypeSP);
        Spinner dt_spin = (Spinner) findViewById(R.id.dealTypeSP);


        EditText productName = findViewById(R.id.productName);
        EditText discount = findViewById(R.id.discount);

        TextView startDate = findViewById(R.id.startDate);
        TextView endDate = findViewById(R.id.endDate);

        EditText image = findViewById(R.id.image);
        EditText desc = findViewById(R.id.desc);

        store_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                storeSP = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        pd_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                productSP = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dt_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dealTypeSP = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinnerAdapters spinnerAdapter = new SpinnerAdapters(this, storeName, logo);
        store_spin.setAdapter(spinnerAdapter);

        ArrayAdapter deTypespinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dealType);
        deTypespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dt_spin.setAdapter(deTypespinner);

        ArrayAdapter pdSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, productType);
        pdSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pd_spin.setAdapter(pdSpinner);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddproductActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                startDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddproductActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                endDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit(storeName[storeSP], logo[storeSP], productName.getText().toString(),
                        discount.getText().toString(), startDate.getText().toString(),
                        endDate.getText().toString(), image.getText().toString(), desc.getText().toString(),
                        dealType[dealTypeSP], productType[productSP]);
            }
        });

    }

    private void Submit(String store, int logo, String product, String discount,
                        String startDate, String endDate, String image, String des,
                        String bealType, String proType) {
        Log.i("store", store);
        Log.i("product", product);
        Log.i("discount", discount);

        Log.i("startDate", startDate);
        Log.i("endDate", endDate);
        Log.i("image", image);

        Log.i("des", des);
        Log.i("best", bealType);
        Log.i("proType", proType);

        long temp = db.insertData(store, logo, product, discount,
                startDate, endDate, image,
                des, bealType, proType, 0, 0);

        if (temp <= 0) {
            Toast.makeText(getApplicationContext(), "Faild to insert data", Toast.LENGTH_SHORT).show();
            Log.d("Submit: ", "" + temp);

        } else {
            Toast.makeText(getApplicationContext(), "Data stored successfully", Toast.LENGTH_SHORT).show();
//            firstName.setText("");
//            marks.setText("");
//            lastName.setText("");
//            radioGroup.clearCheck();

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}
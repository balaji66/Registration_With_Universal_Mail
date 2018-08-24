package com.durga.balaji66.registrationwithuniversalmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mSpinner;
    private EditText mEmail;
    private TextView mDisplayEmail;
    private Button mDisplay;

    /**
     * In this method we are initializing views, listeners and adding static arrayList in spinner using adapter
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.spinnerArray));
        mSpinner.setAdapter(arrayAdapter);

    }

    /**
     * In this method we are type casting the views
     */
    public void  initializeViews() {
        mSpinner =(Spinner)findViewById(R.id.spinner);
        mEmail =(EditText)findViewById(R.id.editTextEmailId);
        mDisplayEmail =(TextView)findViewById(R.id.textView);
        mDisplay =(Button)findViewById(R.id.buttonDisplay);
    }

    /**
     * In this one we are initializing listeners
     */
    public void initializeListeners()
    {
        mDisplay.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonDisplay:

                /**
                 * This is for hiding the softKey board after clicking button
                 */
                InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                /*
                 * Here we are checking the EditText and Spinner validation
                 * After that we are displaying the total mail in textView
                 */
                if(mEmail.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Email field must not be empty",Toast.LENGTH_LONG).show();
                }
                else if(mSpinner.getSelectedItem().toString().equals("Select type of mail")) {
                    Toast.makeText(getApplicationContext(),"Select type of mail",Toast.LENGTH_LONG).show();
                }
                else {
                    String mStoreEmail = mEmail.getText().toString() + "@" + mSpinner.getSelectedItem().toString();
                    mDisplayEmail.setText(mStoreEmail);
                }
                break;
        }
    }
}

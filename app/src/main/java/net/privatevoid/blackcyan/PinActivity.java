package net.privatevoid.blackcyan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class PinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        final TextView textview = findViewById(R.id.pindigit);

        textview.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(getIntent().getBooleanExtra("change", false)) {
                    SharedPreferences.Editor e = getSharedPreferences("auth", MODE_PRIVATE).edit();
                    e.putString("pin", v.getText().toString().trim() == "" ? null : v.getText().toString()).apply();
                }

                if(v.getText().toString().equals(getSharedPreferences("auth", MODE_PRIVATE).getString("pin", null))) {
                    startActivity(new Intent(PinActivity.this, MainActivity.class));
                }

                finish();
                return true;
            }
        });

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

}

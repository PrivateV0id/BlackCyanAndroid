package net.privatevoid.blackcyan;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        List<SettingsEntry> settings = new ArrayList<>();
        settings.add(new SettingsEntry("Change PIN", "Pin is " +
                (getSharedPreferences("auth", MODE_PRIVATE).getString("pin", null) == "" ? "in" : "")
                + "active"));

        SettingsAdapter sAdapter = new SettingsAdapter(this, settings);
        setListAdapter(sAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, PinActivity.class);
        i.putExtra("change", true);
        startActivity(i);
        finish();
    }
}


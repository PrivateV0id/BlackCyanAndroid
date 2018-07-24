package net.privatevoid.blackcyan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter extends ArrayAdapter<SettingsEntry> {

    private Activity context;
    private List<SettingsEntry> settings = new ArrayList<>();

    public SettingsAdapter(Activity activity, List<SettingsEntry>settings) {
        super(activity, R.layout.settingentry, settings);
        this.settings = settings;
        this.context = activity;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.settingentry, null);
        TextView title = row.findViewById(R.id.title);
        TextView desc = row.findViewById(R.id.description);
        ImageView image= row.findViewById(R.id.icon);
        SettingsEntry s = this.settings.get(position);
        title.setText(s.getTitle());
        desc.setText(s.getDescription());
        image.setImageResource(R.drawable.ic_menu_manage);
        return row;
    }

}

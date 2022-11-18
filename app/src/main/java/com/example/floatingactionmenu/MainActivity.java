package com.example.floatingactionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickEvent(R.id.fab_toggle, "toggle");

        FadingBackgroundView fadingBackgroundView = (FadingBackgroundView) findViewById(R.id.fading);
        final FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fam);
        floatingActionMenu.setFadingBackgroundView(fadingBackgroundView);


        floatingActionMenu.setLabelText(3, "Main Fab");

        floatingActionMenu.setIcon(2, R.drawable.ic_mode_edit_white_48dp);

        floatingActionMenu.setBackgroundColor(2, getResources().getColor(R.color.teal_200), false);

        floatingActionMenu.setOnFloatingActionMenuSelectedListener(new OnFloatingActionMenuSelectedListener() {
            @Override
            public void onFloatingActionMenuSelected(FloatingActionButton fab) {
                if (fab instanceof FloatingActionToggleButton) {
                    FloatingActionToggleButton fatb = (FloatingActionToggleButton) fab;
                    if (fatb.isToggleOn()) toast(fab.getLabelText());
                } else {
                    toast(fab.getLabelText());
                }
            }
        });
    }

    private void setOnClickEvent(int id, final String msg) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast(msg);
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}

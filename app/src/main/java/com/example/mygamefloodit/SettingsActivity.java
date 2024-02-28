package com.example.mygamefloodit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.widget.CompoundButton;

public class SettingsActivity extends AppCompatActivity {

    private static MediaPlayer mediaPlayer;
    private Switch switchMusic;
    private Spinner spinnerMusicTracks;
    private Switch switchTheme;
    private MyBase myBase;
    private static final int[] trackIds = {R.raw.track1, R.raw.track2, R.raw.track3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_settings);

        myBase = new MyBase(this);

        switchMusic = findViewById(R.id.switch_music);
        spinnerMusicTracks = findViewById(R.id.spinner_music_tracks);
        switchTheme = findViewById(R.id.switch_day_night);

        switchTheme.setChecked(myBase.getMode());

        String[] trackNames = {"The Perfect Girl (Instrumental)", "let go - ark patrol", "Porter Robinson - Goodbye To A World"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, trackNames);
        spinnerMusicTracks.setAdapter(adapter);

        boolean isMusicEnabled = myBase.getMusicEnabled();
        switchMusic.setChecked(isMusicEnabled);
        spinnerMusicTracks.setVisibility(isMusicEnabled ? View.VISIBLE : View.GONE);

        switchMusic.setOnCheckedChangeListener((buttonView, isChecked) -> {
            myBase.saveMusicEnabled(isChecked);

            spinnerMusicTracks.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            if (isChecked) {
                int position = spinnerMusicTracks.getSelectedItemPosition();
                if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                    mediaPlayer = MediaPlayer.create(SettingsActivity.this, trackIds[position]);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                }
            } else {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });


        spinnerMusicTracks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (switchMusic.isChecked()) {
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    mediaPlayer = MediaPlayer.create(SettingsActivity.this, trackIds[position]);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                myBase.saveMode(b);
                switchTheme.setChecked(b);
                if (myBase.getMode()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}


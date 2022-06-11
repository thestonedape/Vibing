package org.beta.vibing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;



public class main extends Activity {


    boolean plays1 = false, plays2 = false, plays3 = false, plays4 = false, plays5 = false, plays6 = false, plays7 = false, plays8 = false, plays9 = false, plays10 = false, plays11 = false ;
    private final static int MAX_VOLUME = 100;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        SeekBar seekBar3 = findViewById(R.id.seekBar3);
        SeekBar seekBar4 = findViewById(R.id.seekBar4);
        SeekBar seekBar5 = findViewById(R.id.seekBar5);
        SeekBar seekBar6 = findViewById(R.id.seekBar6);
        SeekBar seekBar7 = findViewById(R.id.seekBar7);
        SeekBar seekBar8 = findViewById(R.id.seekBar8);
        SeekBar seekBar9 = findViewById(R.id.seekBar9);
        SeekBar seekBar10 = findViewById(R.id.seekBar10);
        SeekBar seekBar11 = findViewById(R.id.seekBar11);
        TextView textView1 = findViewById(R.id.totalStudents_adapter1);
        TextView textView2 = findViewById(R.id.totalStudents_adapter);
        TextView textView3 = findViewById(R.id.totalStudents_adapter3);
        TextView textView4 = findViewById(R.id.totalStudents_adapter4);
        TextView textView5 = findViewById(R.id.totalStudents_adapter5);
        TextView textView6 = findViewById(R.id.totalStudents_adapter6);
        TextView textView7 = findViewById(R.id.totalStudents_adapter7);
        TextView textView8 = findViewById(R.id.totalStudents_adapter8);
        TextView textView9 = findViewById(R.id.totalStudents_adapter9);
        TextView textView10 = findViewById(R.id.totalStudents_adapter10);
        TextView textView11 = findViewById(R.id.totalStudents_adapter11);



        seekBar1.setVisibility(View.INVISIBLE);
        seekBar2.setVisibility(View.INVISIBLE);
        seekBar3.setVisibility(View.INVISIBLE);
        seekBar4.setVisibility(View.INVISIBLE);
        seekBar5.setVisibility(View.INVISIBLE);
        seekBar6.setVisibility(View.INVISIBLE);
        seekBar7.setVisibility(View.INVISIBLE);
        seekBar8.setVisibility(View.INVISIBLE);
        seekBar9.setVisibility(View.INVISIBLE);
        seekBar10.setVisibility(View.INVISIBLE);
        seekBar11.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        textView8.setVisibility(View.INVISIBLE);
        textView9.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);





        // Media Player Section

        ImageButton switch1 = findViewById(R.id.switch1);
        switch1.setOnClickListener(v -> {

            if (!plays1) {
                plays1 = true;
                switch1.setImageResource(R.drawable.pause);
                seekBar1.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);


                Intent intent = new Intent(main.this, PlayAudio1.class);
                startService(intent);
            } else {
                plays1 = false;
                switch1.setImageResource(R.drawable.play);
                seekBar1.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio1.class));
            }
        });




        ImageButton switch2 = findViewById(R.id.switch2);
        switch2.setOnClickListener(v -> {
            if (!plays2) {
                plays2 = true;
                switch2.setImageResource(R.drawable.pause);
                seekBar2.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio2.class);
                startService(intent);
            } else {
                plays2 = false;
                seekBar2.setVisibility(View.INVISIBLE);
                switch2.setImageResource(R.drawable.play);
                textView2.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio2.class));
            }
        });

        ImageButton switch3 = findViewById(R.id.switch3);
        switch3.setOnClickListener(v -> {
            if (!plays3) {
                plays3 = true;
                switch3.setImageResource(R.drawable.pause);
                seekBar3.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio3.class);
                startService(intent);
            } else {
                plays3 = false;
                seekBar3.setVisibility(View.INVISIBLE);
                switch3.setImageResource(R.drawable.play);
                textView3.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio3.class));
            }
        });

        ImageButton switch4 = findViewById(R.id.switch4);
        switch4.setOnClickListener(v -> {
            if (!plays4) {
                plays4 = true;
                switch4.setImageResource(R.drawable.pause);
                seekBar4.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio4.class);
                startService(intent);
            } else {
                plays4 = false;
                seekBar4.setVisibility(View.INVISIBLE);
                switch4.setImageResource(R.drawable.play);
                textView4.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio4.class));
            }
        });

        ImageButton switch5 = findViewById(R.id.switch5);
        switch5.setOnClickListener(v -> {
            if (!plays5) {
                plays5 = true;
                switch5.setImageResource(R.drawable.pause);
                seekBar5.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio5.class);
                startService(intent);
            } else {
                plays5 = false;
                seekBar5.setVisibility(View.INVISIBLE);
                switch5.setImageResource(R.drawable.play);
                textView5.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio5.class));
            }
        });

        ImageButton switch6 = findViewById(R.id.switch6);
        switch6.setOnClickListener(v -> {
            if (!plays6) {
                plays6 = true;
                switch6.setImageResource(R.drawable.pause);
                seekBar6.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio6.class);
                startService(intent);
            } else {
                plays6 = false;
                seekBar6.setVisibility(View.INVISIBLE);
                switch6.setImageResource(R.drawable.play);
                textView6.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio6.class));
            }
        });

        ImageButton switch7 = findViewById(R.id.switch7);
        switch7.setOnClickListener(v -> {
            if (!plays7) {
                plays7 = true;
                switch7.setImageResource(R.drawable.pause);
                seekBar7.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio7.class);
                startService(intent);
            } else {
                plays7 = false;
                seekBar7.setVisibility(View.INVISIBLE);
                switch7.setImageResource(R.drawable.play);
                textView7.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio7.class));
            }
        });

        ImageButton switch8 = findViewById(R.id.switch8);
        switch8.setOnClickListener(v -> {
            if (!plays8) {
                plays8 = true;
                switch8.setImageResource(R.drawable.pause);
                seekBar8.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio8.class);
                startService(intent);
            } else {
                plays8 = false;
                seekBar8.setVisibility(View.INVISIBLE);
                switch8.setImageResource(R.drawable.play);
                textView8.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio8.class));
            }
        });


        ImageButton switch9 = findViewById(R.id.switch9);
        switch9.setOnClickListener(v -> {
            if (!plays9) {
                plays9 = true;
                switch9.setImageResource(R.drawable.pause);
                seekBar9.setVisibility(View.VISIBLE);
                textView9.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio9.class);
                startService(intent);
            } else {
                plays9= false;
                seekBar9.setVisibility(View.INVISIBLE);
                switch9.setImageResource(R.drawable.play);
                textView9.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio9.class));
            }
        });

        ImageButton switch10 = findViewById(R.id.switch10);
        switch10.setOnClickListener(v -> {
            if (!plays10) {
                plays10 = true;
                switch10.setImageResource(R.drawable.pause);
                seekBar10.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio10.class);
                startService(intent);
            } else {
                plays10 = false;
                seekBar10.setVisibility(View.INVISIBLE);
                switch10.setImageResource(R.drawable.play);
                textView10.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio10.class));
            }
        });

        ImageButton switch11 = findViewById(R.id.switch11);
        switch11.setOnClickListener(v -> {
            if (!plays11) {
                plays11 = true;
                switch11.setImageResource(R.drawable.pause);
                seekBar11.setVisibility(View.VISIBLE);
                textView11.setVisibility(View.VISIBLE);

                Intent intent = new Intent(main.this, PlayAudio11.class);
                startService(intent);
            } else {
                plays11 = false;
                seekBar11.setVisibility(View.INVISIBLE);
                switch11.setImageResource(R.drawable.play);
                textView11.setVisibility(View.INVISIBLE);
                stopService(new Intent(main.this, PlayAudio11.class));
            }
        });










        //Seek bar Volume Control




        seekBar1.setMax(0);
        seekBar1.setMax(100);
        seekBar1.setProgress(100);

        seekBar2.setMax(0);
        seekBar2.setMax(100);
        seekBar2.setProgress(100);

        seekBar3.setMax(0);
        seekBar3.setMax(100);
        seekBar3.setProgress(100);

        seekBar4.setMax(0);
        seekBar4.setMax(100);
        seekBar4.setProgress(100);

        seekBar5.setMax(0);
        seekBar5.setMax(100);
        seekBar5.setProgress(100);

        seekBar6.setMax(0);
        seekBar6.setMax(100);
        seekBar6.setProgress(100);

        seekBar7.setMax(0);
        seekBar7.setMax(100);
        seekBar7.setProgress(100);

        seekBar8.setMax(0);
        seekBar8.setMax(100);
        seekBar8.setProgress(100);

        seekBar9.setMax(0);
        seekBar9.setMax(100);
        seekBar9.setProgress(100);

        seekBar10.setMax(0);
        seekBar10.setMax(100);
        seekBar10.setProgress(100);

        seekBar11.setMax(0);
        seekBar11.setMax(100);
        seekBar11.setProgress(100);



        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress1, boolean fromUser) {
                float volume1 = (float) (1 - (Math.log(MAX_VOLUME - progress1) / Math.log(MAX_VOLUME)));
                PlayAudio1.volume1 = volume1;
                if (plays1) {
                    PlayAudio1.mCurrentPlayer1.setVolume(volume1, volume1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress2, boolean fromUser) {
                float volume2 = (float) (1 - (Math.log(MAX_VOLUME - progress2) / Math.log(MAX_VOLUME)));
                PlayAudio2.volume2 = volume2;
                if (plays2) {
                    PlayAudio2.mCurrentPlayer2.setVolume(volume2, volume2);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar3, int progress3, boolean fromUser) {
                float volume3 = (float) (1 - (Math.log(MAX_VOLUME - progress3) / Math.log(MAX_VOLUME)));
                PlayAudio3.volume3 = volume3;
                if (plays3) {
                    PlayAudio3.mCurrentPlayer3.setVolume(volume3, volume3);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar3) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar3) {

            }
        });

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar4, int progress4, boolean fromUser) {
                float volume4 = (float) (1 - (Math.log(MAX_VOLUME - progress4) / Math.log(MAX_VOLUME)));
                PlayAudio4.volume4 = volume4;
                if (plays4) {
                    PlayAudio4.mCurrentPlayer4.setVolume(volume4, volume4);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar4) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar4) {

            }
        });

        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar5, int progress5, boolean fromUser) {
                float volume5 = (float) (1 - (Math.log(MAX_VOLUME - progress5) / Math.log(MAX_VOLUME)));
                PlayAudio5.volume5 = volume5;
                if (plays5) {
                    PlayAudio5.mCurrentPlayer5.setVolume(volume5, volume5);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar5) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar5) {

            }
        });

        seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar6, int progress6, boolean fromUser) {
                float volume6 = (float) (1 - (Math.log(MAX_VOLUME - progress6) / Math.log(MAX_VOLUME)));
                PlayAudio6.volume6 = volume6;
                if (plays6) {
                    PlayAudio6.mCurrentPlayer6.setVolume(volume6, volume6);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar6) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar6) {

            }
        });


        seekBar7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar7, int progress7, boolean fromUser) {
                float volume7 = (float) (1 - (Math.log(MAX_VOLUME - progress7) / Math.log(MAX_VOLUME)));
                PlayAudio7.volume7 = volume7;
                if (plays7) {
                    PlayAudio7.mCurrentPlayer7.setVolume(volume7, volume7);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar7) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar7) {

            }
        });

        seekBar8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar8, int progress8, boolean fromUser) {
                float volume8 = (float) (1 - (Math.log(MAX_VOLUME - progress8) / Math.log(MAX_VOLUME)));
                PlayAudio8.volume8 = volume8;
                if (plays8) {
                    PlayAudio8.mCurrentPlayer8.setVolume(volume8, volume8);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar8) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar8) {

            }
        });


        seekBar9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar9, int progress9, boolean fromUser) {
                float volume9 = (float) (1 - (Math.log(MAX_VOLUME - progress9) / Math.log(MAX_VOLUME)));
                PlayAudio9.volume9 = volume9;
                if (plays9) {
                    PlayAudio9.mCurrentPlayer9.setVolume(volume9, volume9);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar9) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar9) {

            }
        });


        seekBar10.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar10, int progress10, boolean fromUser) {
                float volume10 = (float) (1 - (Math.log(MAX_VOLUME - progress10) / Math.log(MAX_VOLUME)));
                PlayAudio10.volume10 = volume10;
                if (plays10) {
                    PlayAudio10.mCurrentPlayer10.setVolume(volume10, volume10);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar10) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar10) {

            }
        });

        seekBar11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar11, int progress11, boolean fromUser) {
                float volume11 = (float) (1 - (Math.log(MAX_VOLUME - progress11) / Math.log(MAX_VOLUME)));
                PlayAudio11.volume11 = volume11;
                if (plays11) {
                    PlayAudio11.mCurrentPlayer11.setVolume(volume11, volume11);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar11) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar11) {

            }
        });





    }

    //Handle PlayAudioX Service calls

    public void playAudio1(View view) {
        Intent objIntent = new Intent(this, PlayAudio1.class);
        startService(objIntent);
    }

    public void killAudio1() {
        stopService(new Intent(this, PlayAudio1.class));
    }

    public void playAudio2(View view) {
        Intent objIntent = new Intent(this, PlayAudio2.class);
        startService(objIntent);
    }

    public void killAudio2() {
        stopService(new Intent(this, PlayAudio2.class));
    }

    public void playAudio3(View view) {
        Intent objIntent = new Intent(this, PlayAudio3.class);
        startService(objIntent);
    }

    public void killAudio3() {
        stopService(new Intent(this, PlayAudio3.class));
    }

    public void playAudio4(View view) {
        Intent objIntent = new Intent(this, PlayAudio4.class);
        startService(objIntent);
    }

    public void killAudio4() {
        stopService(new Intent(this, PlayAudio4.class));
    }

    public void playAudio5(View view) {
        Intent objIntent = new Intent(this, PlayAudio5.class);
        startService(objIntent);
    }

    public void killAudio5() {
        stopService(new Intent(this, PlayAudio5.class));
    }

    public void playAudio6(View view) {
        Intent objIntent = new Intent(this, PlayAudio6.class);
        startService(objIntent);
    }

    public void killAudio6() {
        stopService(new Intent(this, PlayAudio6.class));
    }

    public void playAudio7(View view) {
        Intent objIntent = new Intent(this, PlayAudio7.class);
        startService(objIntent);
    }

    public void killAudio7() {
        stopService(new Intent(this, PlayAudio7.class));
    }

    public void playAudio8(View view) {
        Intent objIntent = new Intent(this, PlayAudio8.class);
        startService(objIntent);
    }

    public void killAudio8() {
        stopService(new Intent(this, PlayAudio8.class));
    }

    public void playAudio9(View view) {
        Intent objIntent = new Intent(this, PlayAudio9.class);
        startService(objIntent);
    }

    public void killAudio9() {
        stopService(new Intent(this, PlayAudio9.class));
    }

    public void playAudio10(View view) {
        Intent objIntent = new Intent(this, PlayAudio10.class);
        startService(objIntent);
    }

    public void killAudio10() {
        stopService(new Intent(this, PlayAudio10.class));
    }

    public void playAudio11(View view) {
        Intent objIntent = new Intent(this, PlayAudio11.class);
        startService(objIntent);
    }

    public void killAudio11() {
        stopService(new Intent(this, PlayAudio11.class));
    }




    //Exit on Back press prompt
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.exit);
        builder.setMessage(R.string.sure);

        builder.setPositiveButton(R.string.yes, (dialog, which) -> {
            dialog.dismiss();
            if (plays1) {
                killAudio1();
            }
            if (plays2) {
                killAudio2();
            }
            if (plays3) {
                killAudio3();
            }
            if (plays4) {
                killAudio4();
            }
            if (plays5) {
                killAudio5();
            }
            if (plays6) {
                killAudio6();
            }
            if (plays7) {
                killAudio7();
            }
            if (plays8) {
                killAudio8();
            }
            if (plays9) {
                killAudio9();
            }
            if (plays10) {
                killAudio10();
            }
            if (plays11) {
                killAudio11();
            }
            main.super.onBackPressed();
            finish();
        }).setNegativeButton(R.string.no, (dialog, which) -> dialog.dismiss());

        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        int id= android.os.Process.myPid();
        android.os.Process.killProcess(id);
    }
}
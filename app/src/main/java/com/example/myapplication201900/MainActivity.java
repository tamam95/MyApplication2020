package com.example.myapplication201900;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button>arrMusicButton=new ArrayList<>();
    final ArrayList<String>arrayRecord=new ArrayList<>();
    TextView txtPlayer;
    int counter=0;
    String playerTurn="Player1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewButtons();
    }
    public void setViewButtons() {
        final Button btnA, btnB, btnC, btnD, btnDone, btnNewGame;
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        txtPlayer = findViewById(R.id.txtPlayer);


        // txt tag 1 = player1 recording
        //     tag 2 = player2 testing

        arrMusicButton.add(btnA);
        arrMusicButton.add(btnB);
        arrMusicButton.add(btnC);
        arrMusicButton.add(btnD);
        btnNewGame = findViewById(R.id.newGame);
        btnDone = findViewById(R.id.done);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (txtPlayer.getTag().toString()) {

                    case "1":
                        changePlayer();
                        txtPlayer.setTag("2");
                        txtPlayer.setText(playerTurn + "Remember?");
                        break;

                    case "2":
                        if (counter == arrayRecord.size()) {
                            Log.d("Success", "Good Play!");
                            dialogBox("Great Job!", "Good Play!");
                        } else {
                            Log.d("Fail", "Missing clicks");
                            changePlayer();
                            dialogBox("Error", "Missing clicks");
                        }
                        displayNextPlayerToRecord();
                        break;
                }
            }
        });
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNewGame.setBackgroundResource(android.R.drawable.btn_default);
                arrayRecord.clear();
                counter = 0;
                playerTurn = "Player 1";
                displayNextPlayerToRecord();
            }
        });
    }
    void displayNextPlayerToRecord() {
        txtPlayer.setTag("1");
        txtPlayer.setText(playerTurn + "recording");
        counter = 0;
        arrayRecord.clear();
    }
    public void buttonClicked(final View view){
        MediaPlayer mediaPlayer=null;
        switch (view.getTag().toString()){
            case "1":
                enableButton(view.getTag().toString(),false);
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btn);
                view.setBackgroundColor(Color.RED);
                break;
            case "2":

                enableButton(view.getTag().toString(),false);
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btnn);
                view.setBackgroundColor(Color.GREEN);

                break;

            case "3":

                enableButton(view.getTag().toString(),false);
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btnnn);
                view.setBackgroundColor(Color.BLUE);

                break;

            case "4":

                enableButton(view.getTag().toString(),false);
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btnnnn);
                view.setBackgroundColor(Color.YELLOW);
                break;

            default:
                break;
        }
        if (txtPlayer.getTag().toString().equals("1"))//recording
        {
            arrayRecord.add(view.getTag().toString());
        }
        else if (txtPlayer.getTag().toString().equals("2")) //testing
        {
            if (counter == arrayRecord.size()){
                Log.d("Error","More clicks than previus player");
                dialogBox("Error","More clicks than previus player");
                changePlayer();
                displayNextPlayerToRecord();
            }
            else{
                if (!view.getTag().toString().equals(arrayRecord.get(counter).toString())){
                    Log.d("Error","Wrong click");
                    dialogBox("Error","Wrong Click!");
                    changePlayer();
                    displayNextPlayerToRecord();
                }
            }
            counter++;

        }
        if (mediaPlayer !=null){
            mediaPlayer.start();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                view.setBackgroundResource(android.R.drawable.btn_default);
                enableButton(view.getTag().toString(),true);
            }
        });
        }
        public void changePlayer(){
        if (playerTurn.equals("Player1")){
            playerTurn="Player2";
        }
        else {
            playerTurn="Player1";
        }
        }
    public void enableButton(String exceptTag,boolean enable){

        for (int i = 0 ; i < arrMusicButton.size();i++){
            if (!arrMusicButton.get(i).getTag().toString().equals(exceptTag)){
                arrMusicButton.get(i).setEnabled(enable);
            }
        }
    }
    public void dialogBox(String title,String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}









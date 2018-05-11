package julio.argueta.com.mole;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    //variables
    private TextView name;
    private TextView scoreBoard;
    private TextView missBoard;
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    private int score;
    private int miss;
    boolean stop = false;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        name = findViewById(R.id.name_of_player);
        playerName();
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    //each setMole method, holds a mole that gives a score if touched
    public void setMole1() {
        ImageButton imageBtn1 = findViewById(R.id.one);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole2() {
        ImageButton imageBtn1 = findViewById(R.id.two);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole3() {
        ImageButton imageBtn1 = findViewById(R.id.three);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole4() {
        ImageButton imageBtn4 = findViewById(R.id.four);
        imageBtn4.setImageResource(R.drawable.mole);
        imageBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }


    public void setMole5() {
        ImageButton imageBtn1 = findViewById(R.id.five);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole6() {
        ImageButton imageBtn1 = findViewById(R.id.six);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole7() {
        ImageButton imageBtn1 = findViewById(R.id.seven);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole8() {
        ImageButton imageBtn1 = findViewById(R.id.eight);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    public void setMole9() {
        ImageButton imageBtn1 = findViewById(R.id.nine);
        imageBtn1.setImageResource(R.drawable.mole);
        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                score++;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = false;
        }
    }

    //Start the stopwatch running when the Start button is clicked.
    public void onClickResume(View view) {
        running = true;
        stop = false;
        resetClick();
    }

    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickPause(View view) {
        running = false;
        stop = true;
        resetClick();
    }

    //Reset the stopwatch running when the reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
        miss = 0;
        score = 0;
        clearBoard();
        scoreBoard = findViewById(R.id.scoreBoard);
        scoreBoard.setText("Points: " + Integer.toString(score) + "-20");
        missBoard = findViewById(R.id.missBoard);
        missBoard.setText("Miss: " + Integer.toString(miss) + "-10");
        name.setText("Player: " + getIntent().getExtras().getString("NAME"));
        resetClick();
        stop = false;

    }

    //Sets the number of seconds on the timer and controls what moles pop up out of the holes
    private void runTimer() {
        final Handler mainTimer = new Handler();
        mainTimer.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                if (running) {
                    seconds++;
                }
                if (!stop) {
                    Random r = new Random();
                    int i1 = r.nextInt(9 - 1) + 1;
                    if (i1 == 1) {
                        clearBoard();
                        setMole1();
                        resetClick();
                    } else if (i1 == 2) {
                        clearBoard();
                        setMole2();
                        resetClick();
                    } else if (i1 == 3) {
                        clearBoard();
                        setMole3();
                        resetClick();
                    } else if (i1 == 4) {
                        clearBoard();
                        setMole4();
                        resetClick();
                    } else if (i1 == 5) {
                        clearBoard();
                        setMole5();
                        resetClick();
                    } else if (i1 == 6) {
                        clearBoard();
                        setMole6();
                        resetClick();
                    } else if (i1 == 7) {
                        clearBoard();
                        setMole7();
                        resetClick();
                    } else if (i1 == 8) {
                        clearBoard();
                        setMole8();
                        resetClick();
                    } else if (i1 == 9) {
                        clearBoard();
                        setMole9();
                        resetClick();
                    }
                }
                mainTimer.postDelayed(this, 1000);
                resetClick();
                runMissTimer();
                runScoreTimer();
            }
        });
    }

    //this timer keeps track of the scrore
    private void runScoreTimer() {
        final Handler scoreHandler = new Handler();
        scoreHandler.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                if (running) {
                    seconds++;
                }
                if (!stop) {
                    scoreBoard = findViewById(R.id.scoreBoard);
                    scoreBoard.setText("Points: " + Integer.toString(score) + "-20");
                    scoreHandler.postDelayed(this, 200);
                }
                resetClick();
            }
        });
    }

    //this gets called in the mainTimer so that it checks for the winner each tick
    @SuppressLint("SetTextI18n")
    public void checkGameStats() {
        if (miss > 9) {
            stop = true;
            name.setText("Im sorry try again!");
        }
        if (score > 19) {
            stop = true;
            name.setText("Congrats you won!");
        }
    }


    // this timer keeps track of the misses that take place
    private void runMissTimer() {
        final Handler missHandler = new Handler();
        missHandler.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                if (running) {
                    seconds++;
                }
                if (!stop) {
                    missBoard = findViewById(R.id.missBoard);
                    missBoard.setText("Miss: " + Integer.toString(miss) + "-10");
                    missHandler.postDelayed(this, 100);
                    checkGameStats();
                }
            }
        });
    }

    //Sets the name of the player
    public void playerName() {
        name.setText("Player: " + getIntent().getExtras().getString("NAME"));
    }

    //allows the user to click more than once
    public void resetClick() {
        ImageButton imageBtn1 = findViewById(R.id.one);
        ImageButton imageBtn2 = findViewById(R.id.two);
        ImageButton imageBtn3 = findViewById(R.id.three);
        ImageButton imageBtn4 = findViewById(R.id.four);
        ImageButton imageBtn5 = findViewById(R.id.five);
        ImageButton imageBtn6 = findViewById(R.id.six);
        ImageButton imageBtn7 = findViewById(R.id.seven);
        ImageButton imageBtn8 = findViewById(R.id.eight);
        ImageButton imageBtn9 = findViewById(R.id.nine);

        imageBtn1.setEnabled(true);
        imageBtn2.setEnabled(true);
        imageBtn3.setEnabled(true);
        imageBtn4.setEnabled(true);
        imageBtn5.setEnabled(true);
        imageBtn6.setEnabled(true);
        imageBtn7.setEnabled(true);
        imageBtn8.setEnabled(true);
        imageBtn9.setEnabled(true);
    }

    //makes user only be able to click each button once per tick
    public void singleClick() {
        ImageButton imageBtn1 = findViewById(R.id.one);
        ImageButton imageBtn2 = findViewById(R.id.two);
        ImageButton imageBtn3 = findViewById(R.id.three);
        ImageButton imageBtn4 = findViewById(R.id.four);
        ImageButton imageBtn5 = findViewById(R.id.five);
        ImageButton imageBtn6 = findViewById(R.id.six);
        ImageButton imageBtn7 = findViewById(R.id.seven);
        ImageButton imageBtn8 = findViewById(R.id.eight);
        ImageButton imageBtn9 = findViewById(R.id.nine);

        imageBtn1.setEnabled(false);
        imageBtn2.setEnabled(false);
        imageBtn3.setEnabled(false);
        imageBtn4.setEnabled(false);
        imageBtn5.setEnabled(false);
        imageBtn6.setEnabled(false);
        imageBtn7.setEnabled(false);
        imageBtn8.setEnabled(false);
        imageBtn9.setEnabled(false);
    }

    //erases every mole and setts the blank buttons to miss boxes
    public void clearBoard() {
        ImageButton imageBtn1 = findViewById(R.id.one);
        ImageButton imageBtn2 = findViewById(R.id.two);
        ImageButton imageBtn3 = findViewById(R.id.three);
        ImageButton imageBtn4 = findViewById(R.id.four);
        ImageButton imageBtn5 = findViewById(R.id.five);
        ImageButton imageBtn6 = findViewById(R.id.six);
        ImageButton imageBtn7 = findViewById(R.id.seven);
        ImageButton imageBtn8 = findViewById(R.id.eight);
        ImageButton imageBtn9 = findViewById(R.id.nine);
        imageBtn1.setImageResource(R.drawable.black);
        imageBtn2.setImageResource(R.drawable.black);
        imageBtn3.setImageResource(R.drawable.black);
        imageBtn4.setImageResource(R.drawable.black);
        imageBtn5.setImageResource(R.drawable.black);
        imageBtn6.setImageResource(R.drawable.black);
        imageBtn7.setImageResource(R.drawable.black);
        imageBtn8.setImageResource(R.drawable.black);
        imageBtn9.setImageResource(R.drawable.black);

        imageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });

        imageBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });

        imageBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });

        imageBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });
        imageBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });
        imageBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });
        imageBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });
        imageBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });
        imageBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });
        imageBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleClick();
                miss++;
            }
        });


    }
}

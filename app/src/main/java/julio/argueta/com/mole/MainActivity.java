package julio.argueta.com.mole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //variables
    private EditText answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = (EditText) findViewById(R.id.playerName);
    }

    public void gameButton(View v) {
        String string = answer.getText().toString().trim();

        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("NAME", string);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}

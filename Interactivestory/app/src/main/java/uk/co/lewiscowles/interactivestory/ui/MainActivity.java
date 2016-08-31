package uk.co.lewiscowles.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uk.co.lewiscowles.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    protected EditText mNameField;
    protected Button mStartButton;
    protected Button mQuitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText)findViewById(R.id.editAdventurerName);
        mStartButton = (Button)findViewById(R.id.buttonStartAdventure);
        mQuitButton = (Button)findViewById(R.id.buttonExit);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameField.getText().toString();
                if(name.trim().length() > 0) {
                    startStory(name);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.CHOOSE_A_NAME), Toast.LENGTH_LONG).show();
                }
            }
        });
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 42:
                finish();
                break;
        }
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.ADVENTURER_NAME), name);
        startActivity(intent);
    }
}

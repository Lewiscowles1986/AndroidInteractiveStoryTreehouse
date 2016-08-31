package uk.co.lewiscowles.interactivestory.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import uk.co.lewiscowles.interactivestory.R;
import uk.co.lewiscowles.interactivestory.models.Choice;
import uk.co.lewiscowles.interactivestory.models.Page;
import uk.co.lewiscowles.interactivestory.models.Story;

public class StoryActivity extends AppCompatActivity {

    private String ourName = "";
    private Story story;
    private Choice[] mChoices = new Choice[]{};

    private ImageView mImageView;
    private TextView mPageText;
    private Spinner mListView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        ourName = intent.getStringExtra(getString(R.string.ADVENTURER_NAME));
        if(ourName.trim().length() < 1) {
            Toast.makeText(this, getString(R.string.CHOOSE_A_NAME), Toast.LENGTH_LONG).show();
            finishActivity(1);
        }
        story = new Story();
        mImageView = (ImageView)findViewById(R.id.StoryImageView);
        mPageText = (TextView)findViewById(R.id.storyTextView);
        mListView = (Spinner)findViewById(R.id.choiceList);
        mButton = (Button)findViewById(R.id.btnChoice);
        loadPage(0);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(
                    "INFO",
                    String.format(
                        "Item %s Selected",
                        StoryActivity.this.mListView.getSelectedItemPosition()
                    )
                );
                if (mChoices.length > 0) {
                    Choice selectedChoice = mChoices[StoryActivity.this.mListView.getSelectedItemPosition()];
                    loadPage(selectedChoice.getPageId());
                } else {
                    finish();
                }
            }
        });
    }

    private void loadPage(int page_id) {
        // clear list and button
        mListView.setVisibility(Spinner.INVISIBLE);
        mListView.setEnabled(false);

        Page page = story.getPage(page_id);

        mImageView.setImageResource(page.getDrawImage());

        String pageText = getString(page.getTextResource());
        mPageText.setText(String.format(pageText, ourName));


        mChoices = page.getChoices();
        String[] choiceTxt = new String[mChoices.length];
        for (int i = 0; i < mChoices.length; i++) {
            choiceTxt[i] = getString(mChoices[i].getTextResource());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choiceTxt);
        mListView.setAdapter(adapter);

        if (mChoices.length > 0) {
            mListView.setVisibility(Spinner.VISIBLE);
            mListView.setEnabled(true);
        } else {
            mButton.setText(R.string.DONE_BTN_TEXT);
        }
    }
}

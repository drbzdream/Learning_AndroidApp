package com.example.titivoradac.favoritetoys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.titivoradac.favoritetoys.utilities.NetworkUtils;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    // COMPLETED (26) Create an EditText variable called mSearchBoxEditText
    private EditText mSearchBoxEditText;

    // COMPLETED (27) Create a TextView variable called mUrlDisplayTextView
    private TextView mUrlDisplayTextView;
    // COMPLETED (28) Create a TextView variable called mSearchResultsTextView
    private TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // COMPLETED (29) Use findViewById to get a reference to mSearchBoxEditText
        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);

        // COMPLETED (30) Use findViewById to get a reference to mUrlDisplayTextView
        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        // COMPLETED (31) Use findViewById to get a reference to mSearchResultsTextView
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_github_search_results_json);
    }

    private void makeGithubSearchQuery() {
        String  githubQuery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if (menuItemThatWasSelected == R.id.action_search) {
//            Context context = MainActivity.this;
//            String message = "Search clicked";
//            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            makeGithubSearchQuery();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

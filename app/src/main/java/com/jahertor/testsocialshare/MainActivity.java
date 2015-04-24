package com.jahertor.testsocialshare;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.jahertor.socialshare.SocialShare;


/**
 * Basic sample. Click the button for share a placeholder text
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Default behavoir:
            All networks, default images, default UI */

        //ArrayList<Integer> socialNetworks = new ArrayList<>();

        final SocialShare socialShare = new SocialShare(this);
        socialShare.setSubject("I am a subject");
        socialShare.setMessage("And I am a really interesting message for share");

        // When click button, show dialog
        final Button shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build view
                final View view = socialShare.getDefaultShareUI();

                // Do something with the view, for example show in Dialog
                final Dialog d = new Dialog(MainActivity.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.addContentView(view, new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                d.show();
            }
        });

    }
}

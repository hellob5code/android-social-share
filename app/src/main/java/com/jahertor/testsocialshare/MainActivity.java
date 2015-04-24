package com.jahertor.testsocialshare;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.jahertor.socialshare.SocialNetwork;
import com.jahertor.socialshare.SocialShare;

import java.util.ArrayList;


/**
 * Basic sample. Click the button for share a placeholder text
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Integer> networksIWant = new ArrayList<>();
        networksIWant.add(SocialNetwork.WHATSAPP);
        networksIWant.add(SocialNetwork.FACEBOOK);
        networksIWant.add(SocialNetwork.TWITTER);
        networksIWant.add(SocialNetwork.INSTAGRAM);

        final SocialShare socialShare = new SocialShare(this, networksIWant);
        socialShare.setSubject("I am a subject");
        socialShare.setMessage("And I am a really interesting message for share");

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

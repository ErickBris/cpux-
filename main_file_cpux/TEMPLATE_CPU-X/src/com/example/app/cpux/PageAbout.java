package com.example.app.cpux;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.cpux.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A fragment that launches other parts of the demo application.
 */
public class PageAbout extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

     // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
		AdView mAdView = (AdView) rootView.findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
		// Start loading the ad in the background.
		mAdView.loadAd(adRequest);
        
        // Demonstration of a collection-browsing activity.
        rootView.findViewById(R.id.bt_read).setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View view) {
        		Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
            	Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            	try {
            	  startActivity(goToMarket);
            	} catch (ActivityNotFoundException e) {
            		getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
            	}
            }
        });


        return rootView;
    }
}

package com.example.cse.tue_sol;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by erunn on 2017-06-22.
 */

public class TicketFragment extends Fragment implements View.OnClickListener{
    private View view;
    private WebView webView;
    final static String url = "http://team4team4.esy.es/data.php";
    private Button button1, button2;

    String myUrl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ticket, container, false);
        webView = (WebView)view.findViewById(R.id.scene_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());

        if(myUrl == null)
            myUrl = url;
        webView.loadUrl(myUrl);
        button1=(Button)view.findViewById(R.id.bottom_home);
        button1.setOnClickListener(this);
        button2 = (Button)view.findViewById(R.id.bottom_search);
        button2.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        Log.v("aaaaa","oncLick");
        Intent intent = null;
        switch (view.getId()) {
            case R.id.bottom_home:
                intent = new Intent(getActivity(), MainActivity.class);
                break;
            case R.id.bottom_search:
                intent = new Intent(getActivity(), SearchActivity.class);
            default:
                break;
        }
        if(intent != null)
         startActivity(intent);
        getActivity().finish();

    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            myUrl = url;
            view.loadUrl(url);
            return true;
        }
    }
}

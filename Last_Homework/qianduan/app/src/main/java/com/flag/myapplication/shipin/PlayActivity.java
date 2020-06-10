package com.flag.myapplication.shipin;


import android.content.Intent;
import android.os.Bundle;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ProvinceBean provinceBean= (ProvinceBean) getIntent().getSerializableExtra("data");
        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jc_video);
        String uri=   Xutils.BASE_URL+"/"+provinceBean.getUrl()+".mp4";

        jcVideoPlayerStandard.setUp(uri, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "我的视频");

       // jcVideoPlayerStandard.thumbImageView.setImageURI(Uri.parse("http://pic9.nipic.com/20100826/3320946_024307806453_2.jpg"));
//  findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//          startActivity(new Intent(PlayActivity.this,luxiangActivity.class));
//      }
//  });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
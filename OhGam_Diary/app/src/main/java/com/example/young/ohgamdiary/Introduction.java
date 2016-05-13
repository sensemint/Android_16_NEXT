package com.example.young.ohgamdiary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by young on 2016-04-26.
 */
public class Introduction extends Activity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);



        //그냥 우선 넘기기(다 한번에 보려고)
        TextView firstIntroText = (TextView)findViewById(R.id.firstIntroText);
        firstIntroText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Introduction.this, DiaryList.class);
                startActivity(intent);
                finish();
            }
        });
        //그냥 우선 넘기기(다 한번에 보려고)


        //첫 접속에만 가이드 페이지가 나오도록 설정 START
        if(SplashScreen.NECESSITY_OF_GUIDE_PAGE){
            //처음 접속 변수를 false로 만들기 START
            SharedPreferences flagOfGuide = getSharedPreferences(SplashScreen.fileName, 0);
            SharedPreferences.Editor editor = flagOfGuide.edit();
            editor.putBoolean("isFirst",false);
            editor.commit();
            //처음 접속 변수를 false로 만들기 END
        }
        //첫 접속에만 가이드 페이지가 나오도록 설정 START

    }

}

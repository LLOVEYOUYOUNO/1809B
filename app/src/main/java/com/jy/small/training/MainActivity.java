package com.jy.small.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jy.com.libbdmap.training.BdMapActivity;
import jy.com.libeasemob.training.RegisterActivity;
import jy.com.libumengsharelogin.LoginActivity;
import jy.com.libumengsharelogin.ShareActivity;

/*
 * created by taofu on 2019/5/5
 **/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


    }


    public void onClick(View v){
        switch (v.getId()){

            case R.id.btn_start_umeng_share:{
                Intent intent = new Intent(this,ShareActivity.class);
                startActivity(intent);

                int i = 10 / 0;
                break;
            }

            case R.id.btn_start_umeng_login:{
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_start_bdmap:{
                Intent intent = new Intent(this,BdMapActivity.class);
                startActivity(intent);
                break;
            }
            case  R.id.btn_start_easemob:{
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);

                break;
            }
        }
    }
}

package com.jy.small.training;

import android.app.Application;

import android.util.Log;
import com.jy.small.training.utils.Logger;
import jy.com.libbdmap.BdMapUtils;
import jy.com.libeasemob.EasemobUtils;
import jy.com.libjpush.JPushUtils;
import jy.com.libumengsharelogin.MyUmengUtils;

/*
 * created by taofu on 2019/5/7
 **/
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";


    @Override
    public void onCreate() {
        super.onCreate();

        Logger.d("%s onCreate  pid = %s , hashcode = %s ",TAG,android.os.Process.myPid(),this.hashCode());
        MyUmengUtils.initUmeng(this);

        BdMapUtils.init(this);

        JPushUtils.init(this);

        EasemobUtils.init(this);

    }





}

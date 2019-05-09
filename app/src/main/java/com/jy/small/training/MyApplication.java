package com.jy.small.training;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.jy.small.training.utils.Logger;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import jy.com.libbdmap.BdMapUtils;
import jy.com.libjpush.JPushUtils;
import jy.com.libumengsharelogin.MyUmengUtils;

/*
 * created by taofu on 2019/5/7
 **/
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MyUmengUtils.initUmeng(this);

        BdMapUtils.init(this);

        JPushUtils.init(this);
    }





}

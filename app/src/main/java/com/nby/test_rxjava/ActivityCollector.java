package com.nby.test_rxjava;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/19.
 */

public class ActivityCollector {
    public static ArrayList<Activity> activities=new ArrayList<>();
    //添加
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    //移除
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public  static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

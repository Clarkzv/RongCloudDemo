package com.example.gener.rongyundemo;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

public class SealAppContext  {
    private static SealAppContext mRongCloudInstance;
    private Context mContext;
    private static ArrayList<Activity> mActivities;


    public static final String UPDATE_FRIEND = "update_friend";
    public static final String UPDATE_RED_DOT = "update_red_dot";
    public static final String UPDATE_GROUP_NAME = "update_group_name";
    public static final String UPDATE_GROUP_MEMBER = "update_group_member";
    public static final String GROUP_DISMISS = "group_dismiss";


    public SealAppContext(Context mContext) {
        this.mContext = mContext;
//        initListener();
        mActivities = new ArrayList<>();
        SealUserInfoManager.init(mContext);
    }

    /**
     * 初始化 RongCloud.
     *
     * @param context 上下文。
     */
    public static void init(Context context) {

        if (mRongCloudInstance == null) {
            synchronized (SealAppContext.class) {

                if (mRongCloudInstance == null) {
                    mRongCloudInstance = new SealAppContext(context);
                }
            }
        }

    }

    /**
     * 获取RongCloud 实例。
     *
     * @return RongCloud。
     */
    public static SealAppContext getInstance() {
        return mRongCloudInstance;
    }

}

package com.example.gener.rongyundemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.example.gener.rongyundemo.db.Groups;
import com.example.gener.rongyundemo.utils.RongGenerate;

import java.util.List;

import io.rong.common.RLog;
import io.rong.imlib.model.UserInfo;

public class SealUserInfoManager  {
    private static SealUserInfoManager sInstance;
    private final Context mContext;
//    private final AsyncTaskManager mAsyncTaskManager;
//    private final SealAction action;
    static Handler mHandler;
    private List<Groups> mGroupsList;//同步群组成员信息时需要这个数据
    private SharedPreferences sp;

    public static SealUserInfoManager getInstance() {
        return sInstance;
    }

    public SealUserInfoManager(Context context) {
        mContext = context;
//        mAsyncTaskManager = AsyncTaskManager.getInstance(mContext);
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        action = new SealAction(mContext);
        mHandler = new Handler(Looper.getMainLooper());
        mGroupsList = null;
    }
    public static void init(Context context) {

        sInstance = new SealUserInfoManager(context);
    }

    /**
     * app中获取用户头像的接口,此前这部分调用分散在app显示头像的每处代码中,整理写一个方法使app代码更整洁
     * 这个方法不涉及读数据库,头像空时直接生成默认头像
     */
    public String getPortraitUri(UserInfo userInfo) {
        if (userInfo != null) {
            if (userInfo.getPortraitUri() != null) {
                if (TextUtils.isEmpty(userInfo.getPortraitUri().toString())) {
                    if (userInfo.getName() != null) {
                        return RongGenerate.generateDefaultAvatar(userInfo);
                    } else {
                        return null;
                    }
                } else {
                    return userInfo.getPortraitUri().toString();
                }
            } else {
                if (userInfo.getName() != null) {
                    return RongGenerate.generateDefaultAvatar(userInfo);
                } else {
                    return null;
                }
            }

        }
        return null;
    }
}

package com.example.gener.rongyundemo.chatroom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.gener.rongyundemo.R;

import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/**
 * 进入这个界面则为进入聊天室
 * 获取到当前聊天室名单,显示在左侧的连表上
 * 点击进入大厅才能收到和发送聊天信息同时打开大厅界面
 * 点击离开大厅则不再收到大厅信息同时关闭大厅界面
 */
public class ChatRoomOneActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView chatRoomRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room_one);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        RongIM.getInstance().joinChatRoom("Jiang", 50, new RongIMClient.OperationCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(ChatRoomOneActivity.this,"Join The ChatRoom Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Toast.makeText(ChatRoomOneActivity.this,"Join The ChatRoom error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void init() {
        chatRoomRv = findViewById(R.id.rv_chat_member);
        findViewById(R.id.btn_enter_into_hall).setOnClickListener(this);
        findViewById(R.id.btn_leave_hall).setOnClickListener(this);

    }


    public static void start(Context context) {
        context.startActivity(new Intent(context, ChatRoomOneActivity.class));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_enter_into_hall:
//                RongIM.getInstance().startChatRoomChat(ChatRoomOneActivity.this,"Jiang",false);
                ConversationFragment fragment = new ConversationFragment();

                Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                        .appendPath("rc_conversation").appendPath(Conversation.ConversationType.CHATROOM.getName().toLowerCase())
                        .appendQueryParameter(Conversation.ConversationType.CHATROOM.getName(), "true")
                        .appendQueryParameter("targetId", "Jiang").build();

                fragment.setUri(uri);
                FragmentTransaction add = getSupportFragmentManager().beginTransaction().add(R.id.fl_chat_hall, fragment);
                add.commit();

                break;

            case R.id.btn_leave_hall:

                break;
        }
    }
}

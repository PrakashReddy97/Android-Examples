package com.example.chatapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<BaseMessage> mMessageList;


    public MessageAdapter(Context context, List<BaseMessage> messageList) {

        mContext = context;
        mMessageList = messageList;
    }

    public int getItemViewType(int position){


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    private class SentMessageHolder extends RecyclerView.ViewHolder {

        TextView msgText;
        TextView msgTime;

        public SentMessageHolder(@NonNull View itemView) {
            super(itemView);

            msgText = itemView.findViewById(R.id.messagebody_sender);
            msgTime = itemView.findViewById(R.id.sent_message_time);


        }
    }

    private class ReceiveMessageHolder extends RecyclerView.ViewHolder {
        TextView msgText, msgTime, receiverName;
        ImageView receiverPic;

        public ReceiveMessageHolder(@NonNull View itemView) {
            super(itemView);
            msgText = itemView.findViewById(R.id.message_body);
            msgTime = itemView.findViewById(R.id.receive_time);
            receiverName = itemView.findViewById(R.id.message_name);

            receiverPic = itemView.findViewById(R.id.image_profile_sender);



        }
    }
}

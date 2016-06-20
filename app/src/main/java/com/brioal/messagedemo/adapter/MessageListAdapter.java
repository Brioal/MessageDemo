package com.brioal.messagedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brioal.messagedemo.R;
import com.brioal.messagedemo.entity.MessageEntity;
import com.brioal.messagedemo.view.CircleImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brioal on 2016/6/20.
 */

public class MessageListAdapter extends RecyclerView.Adapter {

    private final int TYPE_LEFT = 0;
    private final int TYPE_RIGHT = 1;


    private Context mContext;
    private List<MessageEntity> mList;

    public MessageListAdapter(Context context, List<MessageEntity> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LEFT) {
            View leftiew = LayoutInflater.from(mContext).inflate(R.layout.item_left, parent, false);
            return new LeftViewHolder(leftiew);

        } else {
            View rightView = LayoutInflater.from(mContext).inflate(R.layout.item_right, parent, false);
            return new RightViewHolder(rightView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LeftViewHolder) {
            ((LeftViewHolder) holder).mLeftHead.setImageResource(R.mipmap.ic_left);
            ((LeftViewHolder) holder).mLeftMsg.setText(mList.get(position).getContent());
        } else if (holder instanceof RightViewHolder) {
            ((RightViewHolder) holder).mRightHead.setImageResource(R.mipmap.ic_right);
            ((RightViewHolder) holder).mRightMsg.setText(mList.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return mList.get(position).getType() == 1 ? TYPE_RIGHT : TYPE_LEFT;
    }

    //收到的消息
    class LeftViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_left_head)
        CircleImageView mLeftHead;
        @Bind(R.id.item_left_msg)
        TextView mLeftMsg;

        public LeftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //发送的消息
    class RightViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_right_msg)
        TextView mRightMsg;
        @Bind(R.id.item_right_head)
        CircleImageView mRightHead;
        public RightViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

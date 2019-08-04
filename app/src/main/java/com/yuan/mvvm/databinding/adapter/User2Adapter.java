package com.yuan.mvvm.databinding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yuan.mvvm.R;
import com.yuan.mvvm.databinding.User2ItemBinding;
import com.yuan.mvvm.databinding.bean.User2;
import com.yuan.mvvm.databinding.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class User2Adapter extends RecyclerView.Adapter<User2Adapter.User2ViewHolder> {

    private List<User2> mUser2List = new ArrayList<>();

    public User2Adapter(List<User2> list) {
        mUser2List = list;
    }

    @NonNull
    @Override
    public User2ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        User2ItemBinding user2ItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.user2_item, viewGroup, false);
        return new User2ViewHolder(user2ItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull User2ViewHolder user2ViewHolder, int position) {
        user2ViewHolder.mBinding.setUser2(mUser2List.get(position));
        user2ViewHolder.mBinding.executePendingBindings(); // TODO: 2019/8/4

        // item的点击事件
        user2ViewHolder.mBinding.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(v instanceof TextView ? ((TextView) v).getText().toString() : "");
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mUser2List == null) {
            return 0;
        }
        return mUser2List.size();
    }

    class User2ViewHolder extends RecyclerView.ViewHolder {
        public User2ItemBinding mBinding;

        public User2ViewHolder(@NonNull User2ItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}

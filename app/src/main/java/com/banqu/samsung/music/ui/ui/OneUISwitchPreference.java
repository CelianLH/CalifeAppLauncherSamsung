package com.banqu.samsung.music.ui.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.banqu.samsung.music.R;
import com.banqu.samsung.music.carlifeapplauncher.adapter.Common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreference;

public class OneUISwitchPreference extends SwitchPreference {

    public OneUISwitchPreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public OneUISwitchPreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OneUISwitchPreference(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OneUISwitchPreference(@NonNull Context context) {
        super(context);
    }


    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);


//        TextView titleView = (TextView) holder.findViewById(android.R.id.title);
//        titleView.setTextColor(getContext().getColor(R.color.OneUI_Button_Title_TextColor));
//        TextView summaryView = (TextView) holder.findViewById(android.R.id.summary);
//        summaryView.setTextColor(getContext().getColor(R.color.OneUI_Button_Text_Color));

        ImageView imageView = (ImageView) holder.findViewById(android.R.id.icon);
        if (imageView.getResources() != null) {
            ViewGroup.LayoutParams lp = imageView.getLayoutParams();
            lp.height = getContext().getResources().getDimensionPixelSize(R.dimen.oneui_icon_size);
            lp.width = getContext().getResources().getDimensionPixelSize(R.dimen.oneui_icon_size);
            imageView.setLayoutParams(lp);
            imageView.setBackgroundColor(Common.getRandomColor());
            int padding = getContext().getResources().getDimensionPixelSize(R.dimen.oneui_icon_padding);
            imageView.setPadding(padding, padding, padding, padding);
            Common.setBgRadius(imageView, getContext().getResources().getDimensionPixelSize(R.dimen.oneui_icon_radius));
        }


        if (getParent() != null && getParent().getPreferenceCount() == 1) {
            Common.setBgRadius(holder.itemView, getContext().getResources().getDimensionPixelSize(R.dimen.oneui_radius));
        } else {
            if (getOrder() == 0) {
                Common.setBgRadiusTops(holder.itemView, getContext().getResources().getDimensionPixelSize(R.dimen.oneui_radius));
            } else {
                if (getParent() != null && getOrder() == getParent().getPreferenceCount() - 1) {
                    {
                        Common.setBgRadiusBottoms(holder.itemView, getContext().getResources().getDimensionPixelSize(R.dimen.oneui_radius));
                    }
                }
            }
        }

        holder.itemView.setBackgroundColor(getContext().getColor(R.color.OneUI_Button_BackgroundColor));

    }
}
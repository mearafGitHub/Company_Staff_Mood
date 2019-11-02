package com.example.gebeya_mood.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.views.IntroScreenItem;

import java.util.List;

public class IntroViewPageAdapter extends PagerAdapter {

    Context context;
    List<IntroScreenItem> screens;

    public IntroViewPageAdapter(Context context, List<IntroScreenItem> screens) {
        this.context = context;
        this.screens = screens;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View screenView = inflater.inflate(R.layout.intro_screen_item, null);

        ImageView image = screenView.findViewById(R.id.intro_image);
        TextView title = screenView.findViewById(R.id.intro_title);
        TextView describtion = screenView.findViewById(R.id.intro_describtion);

        image.setImageResource(screens.get(position).getImage());
        title.setText(screens.get(position).getTitle());
        describtion.setText(screens.get(position).getDescribtion());

        container.addView(screenView);

        return screenView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<IntroScreenItem> getScreens() {
        return screens;
    }

    public void setScreens(List<IntroScreenItem> screens) {
        this.screens = screens;
    }

    @Override
    public int getCount() {
        return screens.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
     /*   super.destroyItem(container, position, object);*/
        container.removeView((View) object);
    }
}

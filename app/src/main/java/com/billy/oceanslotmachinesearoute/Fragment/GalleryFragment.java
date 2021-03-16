package com.billy.oceanslotmachinesearoute.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.billy.oceanslotmachinesearoute.Adapter.GalleryAdapter;
import com.billy.oceanslotmachinesearoute.Data.GalleryData;
import com.billy.oceanslotmachinesearoute.Model.GalleryModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends AppCompatActivity {
GalleryModel galleryModel;
GalleryAdapter galleryAdapter;
public static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        gallerydata();
        int resId = R.anim.layout_animation_up_to_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(GalleryFragment.this, resId);
        recyclerView.setLayoutAnimation(animation);
    }

    private void gallerydata(){
        List<GalleryModel> gal = new ArrayList<>();
        for (int i = 0; i < GalleryData.imahe.length; i++){
            gal.add(new GalleryModel(GalleryData.imahe[i]));
        }

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(GalleryFragment.this, R.anim.layout_animation_up_to_down);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(new GridLayoutManager(GalleryFragment.this,2,RecyclerView.VERTICAL,false));
        galleryAdapter = new GalleryAdapter(GalleryFragment.this, gal);
        recyclerView.setAdapter(galleryAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
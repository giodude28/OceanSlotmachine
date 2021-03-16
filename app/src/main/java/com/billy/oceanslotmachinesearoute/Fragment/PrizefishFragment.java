package com.billy.oceanslotmachinesearoute.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import com.billy.oceanslotmachinesearoute.Adapter.PrizefishAdapter;
import com.billy.oceanslotmachinesearoute.Data.PrizefishData;
import com.billy.oceanslotmachinesearoute.Model.PrizefishModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.ArrayList;
import java.util.List;

public class PrizefishFragment extends Fragment {
    PrizefishAdapter prizefishAdapter;
    PrizefishModel prizefishModel;
    public static RecyclerView recyclerView;
    View root;
    Button b;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_prizefish_fragment,container,false);
        fishdata();
        b = root.findViewById(R.id.b1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aw = new Intent(getContext(),GalleryFragment.class);
                startActivity(aw);
            }
        });
        int resId = R.anim.layout_animation_right_to_left;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        return root;
    }

    private void fishdata(){
        List<PrizefishModel> fish = new ArrayList<>();
        for (int i = 0 ; i< PrizefishData.pftitle.length; i++){
            fish.add(new PrizefishModel(PrizefishData.pftitle[i],PrizefishData.pfimage[i],PrizefishData.pfprize[i]));
        }
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_right_to_left);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        prizefishAdapter = new PrizefishAdapter(getContext(),fish);
        recyclerView.setAdapter(prizefishAdapter);
    }
}
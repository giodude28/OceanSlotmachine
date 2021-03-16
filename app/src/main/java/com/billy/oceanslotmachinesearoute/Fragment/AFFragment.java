package com.billy.oceanslotmachinesearoute.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.billy.oceanslotmachinesearoute.Adapter.AdviceFishAdapter;
import com.billy.oceanslotmachinesearoute.Data.AdviceFishData;
import com.billy.oceanslotmachinesearoute.Model.AdviceFishModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.ArrayList;
import java.util.List;

public class AFFragment extends Fragment {
AdviceFishAdapter adviceFishAdapter;
AdviceFishModel adviceFishModel;
public static RecyclerView recyclerView;
    View root;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_a_f_fragment,container,false);
        afdata();

        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        return root;
    }

    private void afdata(){
        List<AdviceFishModel> fish = new ArrayList<>();
        for (int i = 0; i < AdviceFishData.adviceTitle.length; i++){
            fish.add(new AdviceFishModel(AdviceFishData.adviceTitle[i],AdviceFishData.adviceDesc[i],AdviceFishData.adviceImage[i]));
        }

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_down_to_up);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2,RecyclerView.VERTICAL,false));
        adviceFishAdapter = new AdviceFishAdapter(getContext(),fish);
        recyclerView.setAdapter(adviceFishAdapter);
    }
}
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

import com.billy.oceanslotmachinesearoute.Adapter.TermFishAdapter;
import com.billy.oceanslotmachinesearoute.Data.TermFishData;
import com.billy.oceanslotmachinesearoute.Model.TermFishModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.ArrayList;
import java.util.List;

public class TFFragment extends Fragment {
TermFishAdapter termFishAdapter;
TermFishModel termFishModel;
public static RecyclerView recyclerView;
    View root;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_t_f_fragment,container,false);
termdata();
        int resId = R.anim.layout_animation_left_to_right;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resId);
        recyclerView.setLayoutAnimation(animation);
return root;
    }


    private void termdata(){
        List<TermFishModel> term = new ArrayList<>();
        for (int i = 0; i < TermFishData.termtitle.length; i++){
            term.add(new TermFishModel(TermFishData.termtitle[i],TermFishData.termdesc[i]));
        }


        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_left_to_right);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, RecyclerView.VERTICAL,false));
        termFishAdapter = new TermFishAdapter(getContext(),term);
        recyclerView.setAdapter(termFishAdapter);

    }
}
package com.sofia.mytravelmate.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sofia.mytravelmate.AlertDialogsHelper;
import com.sofia.mytravelmate.R;
import com.sofia.mytravelmate.Vacation;
import com.sofia.mytravelmate.VacationAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    public static List<Vacation> vacationList = new ArrayList<>();
    private Context context;
    private VacationAdapter vacationAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        context = root.getContext();

        vacationList.add(new Vacation(1, "Rome with friends", "Rome-Italy", 250, R.drawable.colosseum));
        vacationList.add(new Vacation(2, "Paris with friends", "Paris-France", 250, R.drawable.paris));
        vacationList.add(new Vacation(3, "Visiting Taj-Mahal", "India", 150, R.drawable.tajmahal));
        vacationList.add(new Vacation(4, "Beautiful Berlin", "Germany", 250, R.drawable.germany));
        vacationList.add(new Vacation(4, "Party in Santorini", "Greece", 300, R.drawable.greece));
        vacationList.add(new Vacation(5, "Seeing the Pyramids in Cairo", "Egypt", 152, R.drawable.a2));
        vacationList.add(new Vacation(6, "American Dream", "USA", 1500, R.drawable.newyork));
        vacationList.add(new Vacation(7, "Skying in the Alps", "Austria", 600, R.drawable.mountains));


        vacationAdapter = new VacationAdapter(vacationList, getContext());
        recyclerView = root.findViewById(R.id.recyclerViewVacations);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        vacationAdapter = new VacationAdapter(vacationList, context);
        recyclerView.setAdapter(vacationAdapter);



        return root;

    }



    @Override
    public void onResume() {
        super.onResume();
        vacationAdapter.notifyDataSetChanged();
    }
}
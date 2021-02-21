package com.sofia.mytravelmate.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sofia.mytravelmate.R;
import com.sofia.mytravelmate.Vacation;
import com.sofia.mytravelmate.VacationAdapter;
import com.sofia.mytravelmate.activity.MainActivity;
import com.sofia.mytravelmate.retrofit.GetWeatherService;
import com.sofia.mytravelmate.retrofit.RetrofitClient;
import com.sofia.mytravelmate.retrofit.datamodel.OpenWeatherDto;
import com.sofia.mytravelmate.room.VacationDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    public List<Vacation> vacationList;
    private Context context;
    private VacationAdapter vacationAdapter;
    private VacationDatabase appDB;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        context = root.getContext();

        appDB = VacationDatabase.getInstance(getContext());
        vacationList = new ArrayList<>();
        vacationList = appDB.vacationDao().getVacationList();


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

        vacationList = appDB.vacationDao().getVacationList();
        vacationAdapter = new VacationAdapter(vacationList, context);
        recyclerView.setAdapter(vacationAdapter);
        vacationAdapter.notifyDataSetChanged();
        super.onResume();
    }
}
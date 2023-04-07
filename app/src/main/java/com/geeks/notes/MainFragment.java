package com.geeks.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    NoteAdapter adapter;
    Button add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        add = view.findViewById(R.id.add);
        recyclerView = view.findViewById(R.id.recycler);

        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        List<Note> list = new ArrayList<>();
        list.add(new Note("", "title2", ":description2", ""));
        list.add(new Note("", "title3", ":", ""));
        list.add(new Note("", "title4", ":descrip", ""));
        list.add(new Note("", "title5", ":description2 fg fdsg fdg ", ""));
        adapter.setList(list);

        add.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new AddFragment())
                    .commit();
        });

    }
}
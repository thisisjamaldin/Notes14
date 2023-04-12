package com.geeks.notes;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements NoteAdapter.IOnItem {

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

        if (getArguments()!=null){
            getArguments().getSerializable("note");
        }

        add = view.findViewById(R.id.add);
        recyclerView = view.findViewById(R.id.recycler);

        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);

        Note note = (Note) getArguments().getSerializable("add");
        adapter.addNote(note);

        add.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new AddFragment())
                    .commit();
        });

    }

    @Override
    public void delete(int pos) {
        AlertDialog.Builder alert = new AlertDialog.Builder(requireContext());
        alert.setTitle("Warning");
        alert.setMessage("Are you sure to delete?");
        alert.setPositiveButton("Delete", (dialogInterface, i) -> {
            adapter.delete(pos);
        });
        alert.setNegativeButton("Cancel", null);
        alert.show();
    }

    @Override
    public void share(int pos) {
        adapter.getItem(pos);
    }

    @Override
    public void edit(int pos, Note note) {

    }
}
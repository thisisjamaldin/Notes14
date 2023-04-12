package com.geeks.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AddFragment extends Fragment {

    private String imageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.add);


        if (getArguments() != null){
            button.setText("Edit");
            button.setOnClickListener(v -> {
                Note note = new Note(imageUri, "", "", "");
                Bundle bundle = new Bundle();
                bundle.putSerializable("edit", note);

            });
        } else {
            button.setOnClickListener(v ->{
                Note note = new Note(imageUri, "", "", "");
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", note);

            });
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageUri = data.getData().toString();
    }
}
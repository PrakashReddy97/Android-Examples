package com.example.circularimageview_implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CustomBottomSheetFragment extends BottomSheetDialogFragment {

    private Button camerabtn;
    private Button gallerybtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottomsheet_layout, container, false);

        camerabtn = view.findViewById(R.id.opencamera);
        gallerybtn = view.findViewById(R.id.opengallery);

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetCameraImage getCameraImage = (GetCameraImage) getActivity();
                assert getCameraImage != null;
                getCameraImage.clickCamera();
            }

        });
        return view;

    }

    interface GetCameraImage {
        void clickCamera();
    }
}

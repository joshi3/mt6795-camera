package com.android.camera.ui;

import android.view.View;
import android.view.View.OnClickListener;

import com.android.camera.CameraActivity;
import com.android.camera.R;
import com.android.camera.manager.ModePicker;
import com.android.camera.manager.ViewManager;

import com.android.camera.ui.RotateImageView;
import com.android.camera.Log;

public class FaceBeautyEntryView extends ViewManager implements OnClickListener{
    
    private static final String TAG = "FaceBeautyEntryView";
    private CameraActivity mCameraActivity;

    private RotateImageView mFaceBeautyEntryView;

    public FaceBeautyEntryView(CameraActivity context) {
        super(context,VIEW_LAYER_TOP);
        mCameraActivity = context;
        Log.i(TAG, "[FaceBeautyEntryViews] constractor");
    }

    @Override
    protected View getView() {

        Log.i(TAG, "[getView]...");
        View view = inflate(R.layout.facebeauty_entry);
        mFaceBeautyEntryView = (RotateImageView) view.findViewById(R.id.facebeauty_entry_icon);
        mFaceBeautyEntryView.setImageResource(R.drawable.ic_mode_facebeauty_normal);
        mFaceBeautyEntryView.setOnClickListener(this);

        return view;
    }

    @Override
    public void show() {
        super.show();
        Log.i(TAG, "[show]...");
        if (mFaceBeautyEntryView != null) {
            mFaceBeautyEntryView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hide() {
        super.hide();
        Log.i(TAG, "[hide]...");
        if (mFaceBeautyEntryView != null) {
            mFaceBeautyEntryView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "[onClick]will go to VFB Mode");
        mCameraActivity.getModePicker().setCurrentMode(ModePicker.MODE_FACE_BEAUTY);
    }
}

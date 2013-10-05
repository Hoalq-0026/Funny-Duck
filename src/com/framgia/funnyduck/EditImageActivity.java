package com.framgia.funnyduck;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EditImageActivity extends Activity implements OnClickListener {

	/** Buttons */
	private ImageButton mBtnBack;
	private ImageButton mBtnFinish;
	private ImageButton mBtnDeleteFace;
	private ImageButton mBtnStamp;
	private ImageButton mBtnFaceDetect;
	private ImageButton mBtnUndo;

	/** View */
	private ImageView mImgView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_image);
		initView();
	}

	private void initView() {
		// Initialize Buttons and View
		mBtnBack = (ImageButton) findViewById(R.id.buttonBack);
		mBtnFinish = (ImageButton) findViewById(R.id.buttonFinish);
		mBtnDeleteFace = (ImageButton) findViewById(R.id.button_delete_image);
		mBtnStamp = (ImageButton) findViewById(R.id.button_stamp);
		mBtnFaceDetect = (ImageButton) findViewById(R.id.button_face_detect);
		mBtnUndo = (ImageButton) findViewById(R.id.button_undo);
		mImgView = (ImageView) findViewById(R.id.imgView);

		// Set event listener for buttons
		mBtnBack.setOnClickListener(this);
		mBtnFinish.setOnClickListener(this);
		mBtnDeleteFace.setOnClickListener(this);
		mBtnStamp.setOnClickListener(this);
		mBtnFaceDetect.setOnClickListener(this);
		mBtnUndo.setOnClickListener(this);

		Uri photoUri = this.getIntent().getData();
		mImgView.setImageURI(photoUri);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonBack:
			backToMainActivity();
			break;
		case R.id.buttonFinish:

			break;
		case R.id.button_delete_image:

			break;
		case R.id.button_stamp:

			break;
		case R.id.button_face_detect:

			break;
		case R.id.button_undo:

			break;

		}

	}

	private void backToMainActivity() {
		Intent intent = new Intent(EditImageActivity.this, MainActivity.class);
		startActivity(intent);

	}
}

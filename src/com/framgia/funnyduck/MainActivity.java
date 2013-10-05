package com.framgia.funnyduck;

import com.framgia.funnyducky.constant.AppConstant;
import com.framgia.funnyducky.utils.Utils;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private ImageButton BtnCamera;
	private ImageButton BtnAlbum;
	private ImageButton BtnOther;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	/**
	 * This function to use initialize view components.
	 */
	private void initView() {
		// initialize buttons
		BtnCamera = (ImageButton) findViewById(R.id.buttonCamera);
		BtnAlbum = (ImageButton) findViewById(R.id.buttonAlbum);
		BtnOther = (ImageButton) findViewById(R.id.buttonOther);

		// set onClick Listener for buttons
		BtnAlbum.setOnClickListener(this);
		BtnCamera.setOnClickListener(this);
		BtnOther.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.buttonCamera:
			openCameraToTakePhoto();
			break;
		case R.id.buttonAlbum:
			openGallery();
			break;
		case R.id.buttonOther:
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse(AppConstant.TAKASU_HOME_PAGE));
			startActivity(intent);
			break;
		}
	}

	/**
	 * This function is used to process event click camera button.
	 */
	private void openCameraToTakePhoto() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		Utils.deleteStempFilePhoto();
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Utils.getPhotoUri());
		startActivityForResult(intent, AppConstant.TAKE_PICTURE_REQUEST);

	}

	/**
	 * This function is used to process event click album button.
	 */
	private void openGallery() {
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");
		startActivityForResult(intent, AppConstant.SELECT_PICTURE_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != RESULT_OK) {
			return;
		}
		switch (requestCode) {
		case AppConstant.TAKE_PICTURE_REQUEST:
			if (Utils.checkStemFilePhotoExisted()) {
				Intent intent = new Intent(MainActivity.this,
						EditImageActivity.class);
				intent.setData(Utils.getPhotoUri());
				startActivity(intent);
			}
			break;
		case AppConstant.SELECT_PICTURE_REQUEST:
			Intent intent = new Intent(MainActivity.this,
					EditImageActivity.class);
			intent.setData(data.getData());
			startActivity(intent);
			break;
		}
	}

}

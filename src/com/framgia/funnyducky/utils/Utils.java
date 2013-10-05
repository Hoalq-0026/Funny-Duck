package com.framgia.funnyducky.utils;

import java.io.File;
import java.io.IOException;

import com.framgia.funnyducky.constant.AppConstant;

import android.net.Uri;
import android.os.Environment;

public class Utils {
	private static final String TAG = "FunnyDucky";

	private static boolean checkDeviceStorage() {
		// get external storage state
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		}
		return false;
	}

	public static Uri getPhotoUri() {
		if (!checkDeviceStorage()) {
			return null;
		}
		File rootFolder = Environment.getExternalStorageDirectory();
		File tempPhoto = new File(rootFolder.getAbsolutePath()
				+ AppConstant.STEMP_FILE_JPG);
		try {
			if (!tempPhoto.exists()) {

				tempPhoto.createNewFile();
			}
			Uri tempPhotoUri = Uri.fromFile(tempPhoto);
			return tempPhotoUri;
		} catch (IOException e) {
			e.printStackTrace();
			return Uri.EMPTY;
		}
	}

	public static void deleteStempFilePhoto() {
		File rootFolder = Environment.getExternalStorageDirectory();
		File tempPhoto = new File(rootFolder.getAbsolutePath()
				+ AppConstant.STEMP_FILE_JPG);
		if (tempPhoto.exists()) {
			tempPhoto.delete();
		}
	}

	public static boolean checkStemFilePhotoExisted() {
		File rootFolder = Environment.getExternalStorageDirectory();
		File tempPhoto = new File(rootFolder.getAbsolutePath()
				+ AppConstant.STEMP_FILE_JPG);
		if (tempPhoto.exists()) {
			return true;
		}
		return false;
	}
}

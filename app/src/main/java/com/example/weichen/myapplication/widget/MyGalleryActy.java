package com.example.weichen.myapplication.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.adapter.ImageBaseAdapter;
import com.example.weichen.myapplication.item.ImageItem;

public class MyGalleryActy extends Activity {

	private Gallery gallery;
	private ImageSwitcher imageS;
	private ImageBaseAdapter imageBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_gallery);
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
		
	}


	private void initVar() {
		
		List<ImageItem> imageList = new ArrayList<ImageItem>();
		int[] imageIds = new int[] {
				R.mipmap.shuangzi, R.mipmap.shuangyu, R.mipmap.tiancheng,
				R.mipmap.tianxie, R.mipmap.sheshou, R.mipmap.juxie, R.mipmap.shuiping,
				R.mipmap.shizi, R.mipmap.baiyang, R.mipmap.jinniu, R.mipmap.mojie };
		
		ImageItem imageItem;
		for (int i = 0; i < imageIds.length; i++) {
			imageItem = new ImageItem();
			imageItem.setResId(imageIds[i]);
			imageList.add(imageItem);
		}
		
		imageBaseAdapter = new ImageBaseAdapter(MyGalleryActy.this, imageList);
		
	}

	private void findViews() {
		gallery = (Gallery)findViewById(R.id.ag_g_gallery);
		imageS = (ImageSwitcher)findViewById(R.id.ag_is_switcher);
		imageS.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView imageView = new ImageView(MyGalleryActy.this);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT, 
						LayoutParams.WRAP_CONTENT));
				imageView.setScaleType(ScaleType.FIT_CENTER);
				imageView.setBackgroundColor(0x77000000);
				return imageView;
			}
		});
	}

	private void bindViews() {
		gallery.setAdapter(imageBaseAdapter);
		
	}
	
	
	private void setListener() {
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				ImageItem imageItem = (ImageItem)imageBaseAdapter.getItem(position);
				imageS.setImageResource(imageItem.getResId());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
			
		});
		
	}
	
	

}

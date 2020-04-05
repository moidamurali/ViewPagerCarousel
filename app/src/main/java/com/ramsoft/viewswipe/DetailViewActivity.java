package com.ramsoft.viewswipe;
/*
 * 
 * Copyright (C) 2020 Murali Mohan
 * 
 *  */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DetailViewActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.detail_view);
		findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

}

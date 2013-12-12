package com.example.examen.db;



import com.example.examen.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;


public class Editar_TitleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar__title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar__title, menu);
		return true;
	}
	public void onGuardarButtonClicked(View view) {
        Intent intent=new Intent(this,Guardar_TitleActivity.class);
        startActivity(intent);
       
}

	
}




package com.example.examen.db.Listerner;

import com.example.examen.db.LugarActivity;
import com.example.examen.db.PrimerActivity;
import com.example.examen.db.model.Lugar;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

public class ListViewItemClickListerner implements AdapterView.OnItemClickListener{


    private Activity activity;

public ListViewItemClickListerner(Activity activity) {
	this.activity = activity;
}

public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	Lugar l = (Lugar) parent.getItemAtPosition(position);
	
	if(l != null)
	{
		Intent i = new Intent(this.activity, LugarActivity.class);
		i.putExtra("lugar", l);
		this.activity.startActivityForResult(i, PrimerActivity.REQUEST_CODE_UPDATE_LUGAR);			
	}
}

}



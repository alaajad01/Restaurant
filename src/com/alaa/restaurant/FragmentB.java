package com.alaa.restaurant;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View.*;

public class FragmentB extends Fragment{
ListView list;
ImageView im;
//Button b;

@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	View v1=inflater.inflate(R.layout.frb_layout, container, false);
	list=(ListView) v1.findViewById(R.id.listView1);
	im=(ImageView)v1.findViewById(R.id.imageView1);
	im.setImageResource(R.drawable.chef);	
	return v1;
	}

public void ChangeData(int index)
{
	switch(index)
	{
	case 0:{
		ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(), R.array.PizzaContent, android.R.layout.simple_list_item_1);
		list.setAdapter(adapter);
		break;
	}
	case 1:{
		ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(), R.array.SandwishesContent, android.R.layout.simple_list_item_1);
		list.setAdapter(adapter);
		break;
	}
	case 2:{
		ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(), R.array.WDrinksContent, android.R.layout.simple_list_item_1);
		list.setAdapter(adapter);
		break;
	}
	case 3:{
		ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(), R.array.CDrinksContent, android.R.layout.simple_list_item_1);
		list.setAdapter(adapter);
		break;
	}
	}
}
}

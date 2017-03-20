package com.alaa.restaurant;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener
{
	Communicator comm;
	ListView list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v1=inflater.inflate(R.layout.fra_layout, container, false);
		list=(ListView) v1.findViewById(R.id.listView1);
		ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(), R.array.categories, android.R.layout.simple_list_item_1);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		return v1;
	}
	
	public void setComm(Communicator comm) {
		this.comm = comm;
	}
	
	public interface Communicator
	{
		public void respond(int index);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		comm.respond(arg2);
	}
}

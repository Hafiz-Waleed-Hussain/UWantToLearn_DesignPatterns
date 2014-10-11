package com.designpattern.singleton;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TaskList extends ListActivity {

	private ValidationSingleton VALIDATOR = null;
	private EditText mTask = null;
	private Button mAddTask = null;
	private ArrayAdapter<String> adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_list);
		VALIDATOR = ValidationSingleton.getInstance();
		mTask = (EditText) findViewById(R.id.add_task);
		mAddTask = (Button) findViewById(R.id.add_task_btn);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);

		mAddTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String task = mTask.getText().toString();
				if(VALIDATOR.isEmpty(task)){
					Toast.makeText(
							TaskList.this,R.string.please_add_some_task,
							Toast.LENGTH_SHORT).show();

				}else{
					adapter.add(task);
					adapter.notifyDataSetChanged();
					mTask.setText("");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_task_list, menu);
		return true;
	}

}

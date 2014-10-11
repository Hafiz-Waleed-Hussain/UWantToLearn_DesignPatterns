package com.designpattern.singleton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterForm extends Activity {

	private ValidationSingleton VALIDATOR = null;
	private EditText mEmail = null;
	private EditText mPassword = null;
	private Button mSubmit = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		VALIDATOR = ValidationSingleton.getInstance();

		mEmail = (EditText) findViewById(R.id.Email);
		mPassword = (EditText) findViewById(R.id.Password);
		mSubmit = (Button) findViewById(R.id.Submit);

		mSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String email = mEmail.getText().toString();
				String password = mPassword.getText().toString();

				if (!VALIDATOR.isEmailValid(email)) {
					Toast.makeText(RegisterForm.this,

					R.string.please_enter_valid_email, Toast.LENGTH_SHORT)
							.show();
				} else if (!VALIDATOR.isPasswordLengthValid(password, 4)) {
					Toast.makeText(RegisterForm.this,
							R.string.minimum_five_character_required,
							Toast.LENGTH_SHORT).show();

				} else {
					Toast.makeText(RegisterForm.this,
							R.string.register_successfully, Toast.LENGTH_SHORT)
							.show();
					Intent intent = new Intent(RegisterForm.this,
							TaskList.class);
					finish();
					startActivity(intent);

				}
			}
		});

	}



}

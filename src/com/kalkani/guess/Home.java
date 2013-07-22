package com.kalkani.guess;

/*
 * Developed By Rahul B Kalkani 
 */

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Activity implements OnClickListener {

	private ImageButton ibtn_no1 = null;
	private ImageButton ibtn_no2 = null;
	private ImageButton ibtn_no3 = null;
	private ImageButton ibtn_no4 = null;
	private ImageButton ibtn_no5 = null;
	private ImageButton ibtn_no6 = null;
	private ImageButton ibtn_no7 = null;
	private ImageButton ibtn_no8 = null;
	private ImageButton ibtn_no9 = null;
	private ImageButton ibtn_no0 = null;
	private ImageButton ibtn_delete = null;
	private ImageButton ibtn_ok = null;

	private ImageView iv_no1 = null;
	private ImageView iv_no2 = null;
	private ImageView iv_no3 = null;

	private TextView tv_information = null;

	private int current_cursor = 0;
	private int user_number = 0;
	private int random_number = 0;
	private int user_try = 0;

	private Random random = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		initData();

		ibtn_no0.setOnClickListener(this);
		ibtn_no1.setOnClickListener(this);
		ibtn_no2.setOnClickListener(this);
		ibtn_no3.setOnClickListener(this);
		ibtn_no4.setOnClickListener(this);
		ibtn_no5.setOnClickListener(this);
		ibtn_no6.setOnClickListener(this);
		ibtn_no7.setOnClickListener(this);
		ibtn_no8.setOnClickListener(this);
		ibtn_no9.setOnClickListener(this);
		ibtn_delete.setOnClickListener(this);
		ibtn_ok.setOnClickListener(this);
	}

	private void initData() {

		ibtn_no0 = (ImageButton) findViewById(R.id.ibtn_no_0);
		ibtn_no1 = (ImageButton) findViewById(R.id.ibtn_no_1);
		ibtn_no2 = (ImageButton) findViewById(R.id.ibtn_no_2);
		ibtn_no3 = (ImageButton) findViewById(R.id.ibtn_no_3);
		ibtn_no4 = (ImageButton) findViewById(R.id.ibtn_no_4);
		ibtn_no5 = (ImageButton) findViewById(R.id.ibtn_no_5);
		ibtn_no6 = (ImageButton) findViewById(R.id.ibtn_no_6);
		ibtn_no7 = (ImageButton) findViewById(R.id.ibtn_no_7);
		ibtn_no8 = (ImageButton) findViewById(R.id.ibtn_no_8);
		ibtn_no9 = (ImageButton) findViewById(R.id.ibtn_no_9);
		ibtn_delete = (ImageButton) findViewById(R.id.ibtn_delete);
		ibtn_ok = (ImageButton) findViewById(R.id.ibtn_enter);

		iv_no1 = (ImageView) findViewById(R.id.iv_number1);
		iv_no2 = (ImageView) findViewById(R.id.iv_number2);
		iv_no3 = (ImageView) findViewById(R.id.iv_number3);

		tv_information = (TextView) findViewById(R.id.tv_information);
		tv_information.setText("Guess number between 0 and 1000.");

		iv_no1.setVisibility(View.INVISIBLE);
		iv_no2.setVisibility(View.GONE);
		iv_no3.setVisibility(View.GONE);

		current_cursor = 0;

		random = new Random();

		random_number = random.nextInt(999) + 1;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}

	private void enterDigit(int n) {

		if (current_cursor < 3) {
			current_cursor++;
			ImageView number = null;
			switch (current_cursor) {
			case 1:
				number = (ImageView) findViewById(R.id.iv_number1);
				number.setImageResource(getResourceId(n));
				user_number = user_number * 10 + n;
				Log.d("tag", "" + user_number);
				number.setVisibility(View.VISIBLE);
				break;

			case 2:
				number = (ImageView) findViewById(R.id.iv_number2);
				number.setImageResource(getResourceId(n));
				user_number = user_number * 10 + n;
				Log.d("tag", "" + user_number);
				number.setVisibility(View.VISIBLE);
				break;

			case 3:
				number = (ImageView) findViewById(R.id.iv_number3);
				number.setImageResource(getResourceId(n));
				user_number = user_number * 10 + n;
				Log.d("tag", "" + user_number);
				number.setVisibility(View.VISIBLE);
				break;

			default:
				break;
			}
		}

	}

	private void deleteDigit() {

		if (current_cursor <= 3) {
			ImageView number = null;
			switch (current_cursor) {
			case 1:
				number = (ImageView) findViewById(R.id.iv_number1);
				user_number = (int) (user_number / 10);
				Log.d("tag", "" + user_number);
				number.setVisibility(View.INVISIBLE);
				break;

			case 2:
				number = (ImageView) findViewById(R.id.iv_number2);
				user_number = (int) (user_number / 10);
				Log.d("tag", "" + user_number);
				number.setVisibility(View.GONE);
				break;

			case 3:
				number = (ImageView) findViewById(R.id.iv_number3);
				user_number = (int) (user_number / 10);
				Log.d("tag", "" + user_number);
				number.setVisibility(View.GONE);
				break;

			default:
				break;
			}

			current_cursor--;
		}

	}

	private int getResourceId(int n) {
		int id = R.drawable.img_no_0;
		switch (n) {
		case 0:
			id = R.drawable.img_no_0;
			break;
		case 1:
			id = R.drawable.img_no_1;
			break;
		case 2:
			id = R.drawable.img_no_2;
			break;
		case 3:
			id = R.drawable.img_no_3;
			break;
		case 4:
			id = R.drawable.img_no_4;
			break;
		case 5:
			id = R.drawable.img_no_5;
			break;
		case 6:
			id = R.drawable.img_no_6;
			break;
		case 7:
			id = R.drawable.img_no_7;
			break;
		case 8:
			id = R.drawable.img_no_8;
			break;
		case 9:
			id = R.drawable.img_no_9;
			break;
		default:
			break;
		}
		return id;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.ibtn_no_0:

			enterDigit(0);

			break;

		case R.id.ibtn_no_1:

			enterDigit(1);

			break;

		case R.id.ibtn_no_2:

			enterDigit(2);

			break;

		case R.id.ibtn_no_3:

			enterDigit(3);

			break;

		case R.id.ibtn_no_4:

			enterDigit(4);

			break;

		case R.id.ibtn_no_5:

			enterDigit(5);

			break;

		case R.id.ibtn_no_6:

			enterDigit(6);

			break;

		case R.id.ibtn_no_7:

			enterDigit(7);

			break;

		case R.id.ibtn_no_8:

			enterDigit(8);

			break;

		case R.id.ibtn_no_9:

			enterDigit(9);

			break;

		case R.id.ibtn_delete:

			deleteDigit();

			break;

		case R.id.ibtn_enter:

			user_try++;
			if (user_number == random_number) {
				// Toast.makeText(getApplicationContext(), "You won at " +
				// user_try + " try!", Toast.LENGTH_LONG).show();
				final Dialog dialog = new Dialog(Home.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.won_dialog);
				dialog.setCancelable(false);

				TextView tv_dialog = (TextView) dialog
						.findViewById(R.id.tv_won_dialog);
				tv_dialog.setText("You won at " + user_try + " try!");

				Button btn_new = (Button) dialog
						.findViewById(R.id.btn_won_dialog_new);
				Button btn_exit = (Button) dialog
						.findViewById(R.id.btn_won_dialog_exit);

				tv_information.setText("");
				user_try = 0;
				random_number = random.nextInt(999) + 1;

				btn_new.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						tv_information
								.setText("Guess number between 0 and 1000.");
						dialog.dismiss();
					}
				});

				btn_exit.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog.dismiss();
						finish();
					}
				});

				dialog.show();

			} else {

				if (user_number < random_number) {
					tv_information.setText(user_number
							+ " is less than Lucky number.");
				} else {
					tv_information.setText(user_number
							+ " is greater than Lucky number.");
				}
			}

			resetData();

			break;

		default:

			break;
		}

	}

	private void resetData() {

		Log.d("tag", "ResetData Function");

		iv_no1.setVisibility(View.INVISIBLE);
		iv_no2.setVisibility(View.GONE);
		iv_no3.setVisibility(View.GONE);

		user_number = 0;
		current_cursor = 0;

	}

}

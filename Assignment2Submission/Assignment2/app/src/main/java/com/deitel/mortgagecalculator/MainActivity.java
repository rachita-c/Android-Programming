package com.deitel.mortgagecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private static final String PURCHASE_PRICE = "PURCHASE_PRICE";
	private static final String DOWN_PAYMENT = "DOWN_PAYMENT";
	private static final String INTEREST_RATE = "INTEREST_RATE";
	private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT";
	
	private double currentPurchasePrice; //purchase price entered by user
	private double currentDownPayment; //down payment entered by user
	private float currentInterestRate; //interest rate entered by user
	private double currentCustomPercent; //years amount set by seekbar
	
	private EditText monthlypayment10editText; // displays 10 years mortgage amount
	private EditText monthlypayment20editText; // displays 20 years mortgage amount
	private EditText monthlypayment30editText; // displays 30 years
	private TextView customyearstextView; // textview displaying custom years by seekbar
	private EditText custompaymenteditText; // custom payment display
	private EditText purchasepriceeditText; // insert purchase price
	private EditText downpaymenteditText; // insert down payment amount
	private EditText interestrateeditText; //insert interest rate
	
	// Called when the activity is first created.
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState); // call superclass's version
		setContentView(R.layout.main);
		
		// check if app just started or is being restored from memory
	      if ( savedInstanceState == null ) // the app just started running
	      {
	         currentPurchasePrice = 0.0;
	         currentDownPayment = 0.0;
	         currentInterestRate = 0.0f;
	         currentCustomPercent = 15; 
	      } // end if
	      else // app is being restored from memory, not executed from scratch
	      {
	         // initialize to saved amount
	         currentPurchasePrice = savedInstanceState.getDouble(PURCHASE_PRICE); 
	         currentDownPayment = savedInstanceState.getDouble(DOWN_PAYMENT);
	         currentInterestRate = savedInstanceState.getFloat(INTEREST_RATE);
	         currentCustomPercent = savedInstanceState.getInt(CUSTOM_PERCENT); 
	      } // end else

	// get references to 10, 20, 30 year EditText's
	monthlypayment10editText = (EditText) findViewById (R.id.monthlypayment10editText);
	monthlypayment20editText = (EditText) findViewById (R.id.monthlypayment20editText);
	monthlypayment30editText = (EditText) findViewById (R.id.monthlypayment30editText);
	
	// get the TextView displaying the custom years TextView
	customyearstextView = (TextView) findViewById(R.id.customyearstextView);
	
	// get the custom payment EditText
	custompaymenteditText = (EditText) findViewById(R.id.custompaymenteditText);
	
	// get purchase price, downpayment and interest rate EditText
	purchasepriceeditText = (EditText) findViewById (R.id.purchasepriceeditText);
	downpaymenteditText = (EditText) findViewById (R.id.downpaymenteditText);
	interestrateeditText = (EditText) findViewById (R.id.interestrateeditText);
	
	// get the TextWatcher's
	purchasepriceeditText.addTextChangedListener(purchasepriceeditTextWatcher);
	downpaymenteditText.addTextChangedListener(downpaymenteditTextWatcher);
	interestrateeditText.addTextChangedListener(interestrateeditTextWatcher);
	
    // get the SeekBar used to set the custom tip amount
    SeekBar customSeekBar = (SeekBar) findViewById(R.id.seekBar);
    customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
	
	}
	
	private void updateStandard()
	{
		float interest = currentInterestRate * .01f / 12;
		float interest1 = interest + 1;
		
		// calculate 10 year mortgage
		double tenYearMonthly = (currentPurchasePrice - currentDownPayment) 
				* (interest * (Math.pow(interest1,120)) 
						/ (Math.pow(interest1, 120)- 1));
		
		// set monthlypayment10editText to tenYearMonthly
		monthlypayment10editText.setText(String.format("%.02f", tenYearMonthly));
		
		// calculate 20 year mortgage
		double twentyYearMonthly = (currentPurchasePrice - currentDownPayment) 
				* (interest * (Math.pow(interest1,240)) 
						/ (Math.pow(interest1, 240)- 1));
		
		// set monthlypayment10editText to tenYearMonthly
		monthlypayment20editText.setText(String.format("%.02f", twentyYearMonthly));
		
		// calculate 30 year mortgage
		double thirtyYearMonthly = (currentPurchasePrice - currentDownPayment) 
				* (interest * (Math.pow(interest1,360)) 
						/ (Math.pow(interest1, 360)- 1));
		
		// set monthlypayment10editText to tenYearMonthly
		monthlypayment30editText.setText(String.format("%.02f", thirtyYearMonthly));
	}
	
	// updates the custom amount 
	private void updateCustom()
	{
		float interest = currentInterestRate * .01f / 12;
		float interest1 = interest + 1;
		
		// set customyearstextView to match seekBar
		customyearstextView.setText(CUSTOM_PERCENT);
		
		// calculate custom years mortgage amount
		double customYearMonthly = (currentPurchasePrice - currentDownPayment) 
				* (interest * (Math.pow(interest1,120)) 
						/ (Math.pow(interest1, 120)- 1));
		
		// set monthlypayment10editText to tenYearMonthly
		custompaymenteditText.setText(String.format("%.02f", customYearMonthly));
	}
	
	// save values of edit texts and seek bar
	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		
		outState.putDouble(CUSTOM_PERCENT, currentCustomPercent);
		outState.putDouble(DOWN_PAYMENT, currentDownPayment);
		outState.putDouble(INTEREST_RATE, currentInterestRate);
		outState.putDouble(PURCHASE_PRICE, currentPurchasePrice);
	}
	
	   // called when the user changes the position of SeekBar
	   private OnSeekBarChangeListener customSeekBarListener = 
	      new OnSeekBarChangeListener() 
	   {
	      // update currentCustomPercent, then call updateCustom
	      @Override
	      public void onProgressChanged(SeekBar seekBar, int progress,
	         boolean fromUser) 
	      {
	         // sets currentCustomPercent to position of the SeekBar's thumb
	         currentCustomPercent = seekBar.getProgress();
	         updateCustom(); // update EditTexts for custom tip and total
	      } // end method onProgressChanged

	      @Override
	      public void onStartTrackingTouch(SeekBar seekBar) 
	      {
	      } // end method onStartTrackingTouch

	      @Override
	      public void onStopTrackingTouch(SeekBar seekBar) 
	      {
	      } // end method onStopTrackingTouch
	   }; // end OnSeekBarChangeListener
	
	// event-handling object that responsed to edit text events
	private TextWatcher purchasepriceeditTextWatcher = new TextWatcher()
	{
		// called when the user enters a number
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			// convert purchasepriceeditTextWatcher text to double
			try
			{
				currentPurchasePrice = Double.parseDouble(s.toString());
			}
			catch (NumberFormatException e)
			{
				currentPurchasePrice = 0.0;
			}
			updateStandard();
			updateCustom();
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
	};	
		
	private TextWatcher downpaymenteditTextWatcher = new TextWatcher ()
	{
		// called when the user enters a number
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			// convert text to double
			try
			{
				currentDownPayment = Double.parseDouble(s.toString());
			}
			catch (NumberFormatException e)
			{
				currentDownPayment = 0.0;
			}
			updateStandard();
			updateCustom();
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private TextWatcher interestrateeditTextWatcher = new TextWatcher ()
	{
		// called when the user enters a number
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			// convert purchasepriceeditTextWatcher text to double
			try
			{
				currentInterestRate = Float.parseFloat(s.toString());
			}
			catch (NumberFormatException e)
			{
				currentInterestRate = 0.0f;
			}
			updateStandard();
			updateCustom();
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
	};	
}

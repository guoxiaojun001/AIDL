package com.fuyun.myquoteclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.fuyun.quoteservice.IQuoteService;

public class MainActivity extends Activity implements OnClickListener{
	private IQuoteService mQuoteService;
	private TextView mBindBtn;
	private TextView mGetMsgBtn;
	private TextView mUnBindBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mBindBtn   = (TextView)findViewById(R.id.bind);
		mGetMsgBtn = (TextView)findViewById(R.id.get_msg);
		mUnBindBtn = (TextView)findViewById(R.id.un_bind);
		mBindBtn.setOnClickListener(this);
		mGetMsgBtn.setOnClickListener(this);
		mUnBindBtn.setOnClickListener(this);
		mGetMsgBtn.setEnabled(false);
	}

	@Override
	public void onClick(View v) {
		Log.d("AAA","onClick = " + IQuoteService.class.getName());
		System.out.println(IQuoteService.class.getName());
		if (v.getId() == R.id.bind){
			bindService(new Intent(IQuoteService.class.getName()), mConn, Context.BIND_AUTO_CREATE);
			mBindBtn.setEnabled(false);
			mUnBindBtn.setEnabled(true);
			mGetMsgBtn.setEnabled(true);
			
		}else if (v.getId() == R.id.get_msg){
			dspQuoteMsg();
			
		}else if (v.getId() == R.id.un_bind){
			unbindService(mConn);
			mBindBtn.setEnabled(true);
			mUnBindBtn.setEnabled(false);
			mGetMsgBtn.setEnabled(false);
		}
	}
	
	private void dspQuoteMsg(){
		try {
			Toast.makeText(this, mQuoteService.getName(), Toast.LENGTH_LONG).show();
			mQuoteService.Name();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private ServiceConnection mConn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			mQuoteService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d("AAA","client onServiceConnected");
			mQuoteService = IQuoteService.Stub.asInterface(service);
			Log.d("AAA","mQuoteService = " + mQuoteService);
			dspQuoteMsg();
		}
	};

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unbindService(mConn);
	}
	
}

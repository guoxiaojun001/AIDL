package com.fuyun.quoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class QuoteService extends Service{
	public class IQuoteServiceImpl extends IQuoteService.Stub{
		@Override
		public String getName() throws RemoteException {
			// TODO Auto-generated method stub
			return "Kevin Dan";
		}

		@Override
		public void Name() throws RemoteException {
			// TODO Auto-generated method stub
			Log.d("AAA","NameNameNameNameName = ");
		}
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d("AAA","service start = ");
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent){
		return new IQuoteServiceImpl();
	}

}

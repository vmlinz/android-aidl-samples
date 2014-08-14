package net.aminzai.AIDL_Sample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class AidlSampleService extends Service {
	private final static String TAG = "AidlSampleService";

	private RemoteCallbackList<IAidlSampleActivityCmd> aidlActivityCmd = new RemoteCallbackList<IAidlSampleActivityCmd>();
	@Override
	public IBinder onBind(Intent arg0) {
		Log.i(TAG, "--onBind()--");
		return aidlServiceCmd;
	}

	public IAidlSampleServiceCmd.Stub aidlServiceCmd = new IAidlSampleServiceCmd.Stub(){

		@Override
		public void registerCallback(IAidlSampleActivityCmd cb)
				throws RemoteException {
			aidlActivityCmd.register(cb);
		}

		@Override
		public void unregisterCallback(IAidlSampleActivityCmd cb)
				throws RemoteException {
			aidlActivityCmd.unregister(cb);
		}

		@Override
		public void sendMessage(String str) throws RemoteException {
			Log.i(TAG,"Get Message:"+str);
			sendToast(str);
		}
	};
	
	void sendToast(String str){
		int N = aidlActivityCmd.beginBroadcast();
		for( int i = 0 ; i < N ; i++ ){
			try {
				aidlActivityCmd.getBroadcastItem(i).sendToast(str);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}

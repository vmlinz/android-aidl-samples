package net.aminzai.AIDL_Sample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AidlSampleActivity extends Activity {
	private final static String TAG = "AidlSampleActivity";
	EditText inputText;
	Button sendButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "--onCreate()--");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		Log.i(TAG,"--bindService()--");
		if(aidlServiceCmd == null){
			bindService(new Intent("net.aminzai.AIDL_Sample.IAidlSampleServiceCmd"), serviceConnection, BIND_AUTO_CREATE);
		}
		
		inputText = (EditText) findViewById(R.id.inputText);
		sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					aidlServiceCmd.sendMessage(inputText.getText().toString());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});

	}

	private IAidlSampleServiceCmd aidlServiceCmd = null;
	private ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			aidlServiceCmd = IAidlSampleServiceCmd.Stub.asInterface(service);
			try {
				aidlServiceCmd.registerCallback(aidlActivityCmd);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			aidlServiceCmd = null;
		}

	};

	private void doToast(String str) {
		Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
	}

	public IAidlSampleActivityCmd.Stub aidlActivityCmd = new IAidlSampleActivityCmd.Stub() {

		@Override
		public void sendToast(String str) throws RemoteException {
			doToast(str);
		}

	};

}
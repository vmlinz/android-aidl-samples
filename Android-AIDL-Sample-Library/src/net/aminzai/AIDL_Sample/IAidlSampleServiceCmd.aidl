package net.aminzai.AIDL_Sample;

import net.aminzai.AIDL_Sample.IAidlSampleActivityCmd;

interface IAidlSampleServiceCmd{
	void sendMessage(String str);
	
	void registerCallback(IAidlSampleActivityCmd cb);  
   void unregisterCallback(IAidlSampleActivityCmd cb);  
}
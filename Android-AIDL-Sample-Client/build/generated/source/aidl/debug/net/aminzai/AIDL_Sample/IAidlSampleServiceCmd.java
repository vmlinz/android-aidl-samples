/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/vmlinz/Projects/android/VPNUK-android/Android-AIDL-Sample-Client/src/net/aminzai/AIDL_Sample/IAidlSampleServiceCmd.aidl
 */
package net.aminzai.AIDL_Sample;
public interface IAidlSampleServiceCmd extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements net.aminzai.AIDL_Sample.IAidlSampleServiceCmd
{
private static final java.lang.String DESCRIPTOR = "net.aminzai.AIDL_Sample.IAidlSampleServiceCmd";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an net.aminzai.AIDL_Sample.IAidlSampleServiceCmd interface,
 * generating a proxy if needed.
 */
public static net.aminzai.AIDL_Sample.IAidlSampleServiceCmd asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof net.aminzai.AIDL_Sample.IAidlSampleServiceCmd))) {
return ((net.aminzai.AIDL_Sample.IAidlSampleServiceCmd)iin);
}
return new net.aminzai.AIDL_Sample.IAidlSampleServiceCmd.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_sendMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.sendMessage(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
net.aminzai.AIDL_Sample.IAidlSampleActivityCmd _arg0;
_arg0 = net.aminzai.AIDL_Sample.IAidlSampleActivityCmd.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterCallback:
{
data.enforceInterface(DESCRIPTOR);
net.aminzai.AIDL_Sample.IAidlSampleActivityCmd _arg0;
_arg0 = net.aminzai.AIDL_Sample.IAidlSampleActivityCmd.Stub.asInterface(data.readStrongBinder());
this.unregisterCallback(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements net.aminzai.AIDL_Sample.IAidlSampleServiceCmd
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void sendMessage(java.lang.String str) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(str);
mRemote.transact(Stub.TRANSACTION_sendMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void registerCallback(net.aminzai.AIDL_Sample.IAidlSampleActivityCmd cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void unregisterCallback(net.aminzai.AIDL_Sample.IAidlSampleActivityCmd cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_sendMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void sendMessage(java.lang.String str) throws android.os.RemoteException;
public void registerCallback(net.aminzai.AIDL_Sample.IAidlSampleActivityCmd cb) throws android.os.RemoteException;
public void unregisterCallback(net.aminzai.AIDL_Sample.IAidlSampleActivityCmd cb) throws android.os.RemoteException;
}

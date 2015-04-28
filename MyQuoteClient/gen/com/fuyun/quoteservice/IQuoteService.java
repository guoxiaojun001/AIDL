/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/guoxiaojun/workspaceDemo/MyQuoteClient/src/com/fuyun/quoteservice/IQuoteService.aidl
 */
package com.fuyun.quoteservice;
public interface IQuoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.fuyun.quoteservice.IQuoteService
{
private static final java.lang.String DESCRIPTOR = "com.fuyun.quoteservice.IQuoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.fuyun.quoteservice.IQuoteService interface,
 * generating a proxy if needed.
 */
public static com.fuyun.quoteservice.IQuoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.fuyun.quoteservice.IQuoteService))) {
return ((com.fuyun.quoteservice.IQuoteService)iin);
}
return new com.fuyun.quoteservice.IQuoteService.Stub.Proxy(obj);
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
case TRANSACTION_getName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_Name:
{
data.enforceInterface(DESCRIPTOR);
this.Name();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.fuyun.quoteservice.IQuoteService
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
@Override public java.lang.String getName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void Name() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_Name, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_Name = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public java.lang.String getName() throws android.os.RemoteException;
public void Name() throws android.os.RemoteException;
}

package com.hyphenate.chat;

abstract interface EMEncryptProvider
{
  public abstract byte[] decrypt(byte[] paramArrayOfByte, String paramString);
  
  public abstract byte[] encrypt(byte[] paramArrayOfByte, String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMEncryptProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
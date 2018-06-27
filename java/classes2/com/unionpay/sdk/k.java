package com.unionpay.sdk;

import android.util.Log;

final class k
{
  static void a(String paramString)
  {
    if (UPAgent.LOG_ON) {
      Log.i("UPLog", paramString);
    }
  }
  
  static void a(String paramString, Throwable paramThrowable)
  {
    if (UPAgent.LOG_ON) {
      Log.e("UPLog", paramString, paramThrowable);
    }
  }
  
  static void a(Throwable paramThrowable)
  {
    if (ag.a) {
      paramThrowable.printStackTrace();
    }
  }
  
  static void a(String... paramVarArgs)
  {
    if (ag.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        localStringBuilder.append("\t");
        localStringBuilder.append(str);
        i += 1;
      }
      Log.i("UPLog", localStringBuilder.toString().trim());
    }
  }
  
  static void b(String paramString)
  {
    if (UPAgent.LOG_ON) {
      Log.e("UPLog", paramString);
    }
  }
  
  static void b(String... paramVarArgs)
  {
    if (ag.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        localStringBuilder.append("\t");
        localStringBuilder.append(str);
        i += 1;
      }
      Log.d("UPLog", localStringBuilder.toString().trim());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
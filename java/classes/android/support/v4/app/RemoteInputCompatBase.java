package android.support.v4.app;

import android.os.Bundle;
import java.util.Set;

@Deprecated
class RemoteInputCompatBase
{
  public static abstract class RemoteInput
  {
    protected abstract boolean getAllowFreeFormInput();
    
    protected abstract Set<String> getAllowedDataTypes();
    
    protected abstract CharSequence[] getChoices();
    
    protected abstract Bundle getExtras();
    
    protected abstract CharSequence getLabel();
    
    protected abstract String getResultKey();
    
    public static abstract interface Factory
    {
      public abstract RemoteInputCompatBase.RemoteInput build(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle, Set<String> paramSet);
      
      public abstract RemoteInputCompatBase.RemoteInput[] newArray(int paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/app/RemoteInputCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
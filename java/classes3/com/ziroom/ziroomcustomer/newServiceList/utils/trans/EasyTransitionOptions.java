package com.ziroom.ziroomcustomer.newServiceList.utils.trans;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import java.util.ArrayList;

public class EasyTransitionOptions
{
  private Activity a;
  private View[] b;
  private ArrayList<ViewAttrs> c;
  
  public EasyTransitionOptions(Activity paramActivity, View[] paramArrayOfView)
  {
    this.a = paramActivity;
    this.b = paramArrayOfView;
  }
  
  public static EasyTransitionOptions makeTransitionOptions(Activity paramActivity, View... paramVarArgs)
  {
    return new EasyTransitionOptions(paramActivity, paramVarArgs);
  }
  
  public Activity getActivity()
  {
    return this.a;
  }
  
  public ArrayList<ViewAttrs> getAttrs()
  {
    return this.c;
  }
  
  public void update()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      this.c = new ArrayList();
      View[] arrayOfView = this.b;
      int j = arrayOfView.length;
      int i = 0;
      while (i < j)
      {
        View localView = arrayOfView[i];
        int[] arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        this.c.add(new ViewAttrs(localView.getId(), arrayOfInt[0], arrayOfInt[1], localView.getWidth(), localView.getHeight()));
        i += 1;
      }
    }
  }
  
  public static class ViewAttrs
    implements Parcelable
  {
    public static final Parcelable.Creator<ViewAttrs> CREATOR = new Parcelable.Creator()
    {
      public EasyTransitionOptions.ViewAttrs createFromParcel(Parcel paramAnonymousParcel)
      {
        return new EasyTransitionOptions.ViewAttrs(paramAnonymousParcel);
      }
      
      public EasyTransitionOptions.ViewAttrs[] newArray(int paramAnonymousInt)
      {
        return new EasyTransitionOptions.ViewAttrs[paramAnonymousInt];
      }
    };
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    
    public ViewAttrs(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = paramInt;
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramFloat3;
      this.e = paramFloat4;
    }
    
    protected ViewAttrs(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readFloat();
      this.c = paramParcel.readFloat();
      this.d = paramParcel.readFloat();
      this.e = paramParcel.readFloat();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeFloat(this.b);
      paramParcel.writeFloat(this.c);
      paramParcel.writeFloat(this.d);
      paramParcel.writeFloat(this.e);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/trans/EasyTransitionOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
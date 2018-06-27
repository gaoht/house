package com.b.c.c;

public class j
  extends a<k>
{
  public j(k paramk)
  {
    super(paramk);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 513: 
      return getThumbnailOffsetDescription();
    }
    return getThumbnailLengthDescription();
  }
  
  public String getThumbnailLengthDescription()
  {
    String str = ((k)this.a).getString(514);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
  
  public String getThumbnailOffsetDescription()
  {
    String str = ((k)this.a).getString(513);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
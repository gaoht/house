package com.ziroom.ziroomcustomer.util.c;

import java.io.Serializable;

public class e
  implements Serializable
{
  private a a;
  private b b;
  
  public a getColors()
  {
    return this.a;
  }
  
  public b getImages()
  {
    return this.b;
  }
  
  public void setColors(a parama)
  {
    this.a = parama;
  }
  
  public void setImages(b paramb)
  {
    this.b = paramb;
  }
  
  public class a
    implements Serializable
  {
    private String b;
    private String c;
    
    public a() {}
    
    public String getColor_background()
    {
      return this.b;
    }
    
    public String getColor_text_selectCity()
    {
      return this.c;
    }
    
    public void setColor_background(String paramString)
    {
      this.b = paramString;
    }
    
    public void setColor_text_selectCity(String paramString)
    {
      this.c = paramString;
    }
  }
  
  public class b
    implements Serializable
  {
    private String b;
    private String c;
    private String d;
    
    public b() {}
    
    public String getImage_logo()
    {
      return this.b;
    }
    
    public String getImage_message()
    {
      return this.c;
    }
    
    public String getImage_selectCity_indicate()
    {
      return this.d;
    }
    
    public void setImage_logo(String paramString)
    {
      this.b = paramString;
    }
    
    public void setImage_message(String paramString)
    {
      this.c = paramString;
    }
    
    public void setImage_selectCity_indicate(String paramString)
    {
      this.d = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.ziroom.ziroomcustomer.minsu.chat.a;

public class a
{
  public String a;
  public String b;
  public long c;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(((a)paramObject).a)) {}
      }
      else {
        while (((a)paramObject).a != null) {
          return false;
        }
      }
      if (this.b != null) {
        return this.b.equals(((a)paramObject).b);
      }
    } while (((a)paramObject).b == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String toString()
  {
    return "UserNamePic{name='" + this.a + '\'' + ", pic='" + this.b + '\'' + ", time=" + this.c + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
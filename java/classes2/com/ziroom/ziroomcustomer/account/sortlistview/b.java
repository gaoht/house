package com.ziroom.ziroomcustomer.account.sortlistview;

import java.util.Comparator;

public class b
  implements Comparator<d>
{
  public int compare(d paramd1, d paramd2)
  {
    if ((paramd1.getSortLetters().equals("@")) || (paramd2.getSortLetters().equals("#"))) {
      return -1;
    }
    if ((paramd1.getSortLetters().equals("#")) || (paramd2.getSortLetters().equals("@"))) {
      return 1;
    }
    return paramd1.getSortLetters().compareTo(paramd2.getSortLetters());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/sortlistview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.hyphenate.chat;

import java.util.Random;

class EMRandomDelay
{
  public int timeDelay(int paramInt)
  {
    if (paramInt == 0) {
      return new Random().nextInt(5) + 1;
    }
    if (paramInt == 1) {
      return new Random().nextInt(54) + 6;
    }
    return new Random().nextInt(540) + 60;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMRandomDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
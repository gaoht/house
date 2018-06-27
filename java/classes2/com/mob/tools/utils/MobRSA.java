package com.mob.tools.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

public class MobRSA
{
  private int keySize;
  
  public MobRSA(int paramInt)
  {
    this.keySize = paramInt;
  }
  
  private byte[] decodeBlock(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws Throwable
  {
    return recoveryPaddingBlock(new BigInteger(paramArrayOfByte).modPow(paramBigInteger1, paramBigInteger2).toByteArray());
  }
  
  private byte[] encodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt3)
    throws Throwable
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte.length == paramInt2)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramInt1 == 0) {}
    }
    else
    {
      arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    }
    paramArrayOfByte = new BigInteger(paddingBlock(arrayOfByte, paramInt3));
    if (paramArrayOfByte.compareTo(paramBigInteger2) > 0) {
      throw new Throwable("the message must be smaller than the modulue");
    }
    return paramArrayOfByte.modPow(paramBigInteger1, paramBigInteger2).toByteArray();
  }
  
  private byte[] paddingBlock(byte[] paramArrayOfByte, int paramInt)
    throws Throwable
  {
    if (paramArrayOfByte.length > paramInt - 1) {
      throw new Throwable("Message too large");
    }
    byte[] arrayOfByte = new byte[paramInt];
    arrayOfByte[0] = 1;
    int i = paramArrayOfByte.length;
    arrayOfByte[1] = ((byte)(i >> 24));
    arrayOfByte[2] = ((byte)(i >> 16));
    arrayOfByte[3] = ((byte)(i >> 8));
    arrayOfByte[4] = ((byte)i);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, paramInt - i, i);
    return arrayOfByte;
  }
  
  private byte[] recoveryPaddingBlock(byte[] paramArrayOfByte)
    throws Throwable
  {
    if (paramArrayOfByte[0] != 1) {
      throw new Throwable("Not RSA Block");
    }
    int i = ((paramArrayOfByte[1] & 0xFF) << 24) + ((paramArrayOfByte[2] & 0xFF) << 16) + ((paramArrayOfByte[3] & 0xFF) << 8) + (paramArrayOfByte[4] & 0xFF);
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - i, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public byte[] decode(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws Throwable
  {
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (paramArrayOfByte.available() > 0)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.readInt()];
      paramArrayOfByte.readFully(arrayOfByte);
      localByteArrayOutputStream.write(decodeBlock(arrayOfByte, paramBigInteger1, paramBigInteger2));
    }
    paramArrayOfByte.close();
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] encode(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws Throwable
  {
    int j = this.keySize / 8;
    int i = 0;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    while (paramArrayOfByte.length > i)
    {
      int k = Math.min(paramArrayOfByte.length - i, j - 11);
      byte[] arrayOfByte = encodeBlock(paramArrayOfByte, i, k, paramBigInteger1, paramBigInteger2, j);
      localDataOutputStream.writeInt(arrayOfByte.length);
      localDataOutputStream.write(arrayOfByte);
      i += k;
    }
    localDataOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public BigInteger[] genKeys()
    throws Throwable
  {
    SecureRandom localSecureRandom = new SecureRandom();
    return genKeys(BigInteger.probablePrime(this.keySize / 2 - 1, localSecureRandom), BigInteger.probablePrime(this.keySize / 2 - 1, localSecureRandom), BigInteger.probablePrime(this.keySize / 2, localSecureRandom));
  }
  
  public BigInteger[] genKeys(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    throws Throwable
  {
    if (paramBigInteger3.compareTo(BigInteger.ONE) <= 0) {
      throw new Throwable("e must be larger than 1");
    }
    BigInteger localBigInteger = paramBigInteger1.multiply(paramBigInteger2);
    paramBigInteger1 = localBigInteger.subtract(paramBigInteger1).subtract(paramBigInteger2).add(BigInteger.ONE);
    if (paramBigInteger3.compareTo(paramBigInteger1) >= 0) {
      throw new Throwable("e must be smaller than (p-1)*(q-1)");
    }
    if (paramBigInteger1.gcd(paramBigInteger3).compareTo(BigInteger.ONE) != 0) {
      throw new Throwable("e must be coprime with (p-1)*(q-1)");
    }
    return new BigInteger[] { paramBigInteger3, paramBigInteger3.modInverse(paramBigInteger1), localBigInteger };
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/MobRSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
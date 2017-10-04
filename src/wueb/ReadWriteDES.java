package wueb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.security.Key;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
/**
 *
 * @author Computer
 */
public class ReadWriteDES {
    
    public void encode( byte[] bytes, OutputStream out, String pass ) throws Exception  {
    Cipher c = Cipher.getInstance( "DES" );
    Key k = new SecretKeySpec( pass.getBytes(), "DES" );
    c.init( Cipher.ENCRYPT_MODE, k );

    OutputStream cos = new CipherOutputStream( out, c );
    cos.write( bytes );
    cos.close();
  }

    public byte[] decode( InputStream is, String pass ) throws Exception   {
    Cipher c = Cipher.getInstance( "DES" );
    Key k = new SecretKeySpec( pass.getBytes(), "DES" );
    c.init( Cipher.DECRYPT_MODE, k );

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    CipherInputStream cis = new CipherInputStream( is, c );

    for (int b; ( b = cis.read() ) != -1;)
      bos.write( b );

    cis.close();
    return bos.toByteArray();
  }

  
  public String verschluesseln ( String textUnverschluesselt ) throws Exception   {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    this.encode( textUnverschluesselt.getBytes(), out, "01234567" );
    String s = new BASE64Encoder().encode( out.toByteArray() );
    //System.out.println("verschluesselter Text: " +  s ); 
    return s;
  }
  
  public String entschluesseln ( String textVerschluesselt ) throws Exception   {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] decode = new BASE64Decoder().decodeBuffer( textVerschluesselt );
    InputStream is = new ByteArrayInputStream( decode );
    String s = new String ( decode ( is, "01234567"));
    //System.out.println("entschlüsselter Text ist: " +  s );
    return s;
  }

}

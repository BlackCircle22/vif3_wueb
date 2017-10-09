package wueb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
/**
 *
 * @author Computer
 */
public class ReadWriteDES {
    
    public void encode( byte[] bytes, OutputStream out, String pass )  {
    Cipher c = null;
        try {
            c = Cipher.getInstance( "DES" );
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Fehler 301 - Algorithmus Cipher! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);

        } catch (NoSuchPaddingException ex) {
            System.out.println("Fehler 302 - Algorithmus Cipher (Pad)! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }
    Key k = new SecretKeySpec( pass.getBytes(), "DES" );
        try {
            c.init( Cipher.ENCRYPT_MODE, k );
        } catch (InvalidKeyException ex) {
            System.out.println("Fehler 303 - Falscher Schluessel! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }

    OutputStream cos = new CipherOutputStream( out, c );
        try {
            cos.write( bytes );
        } catch (IOException ex) {
            System.out.println("Fehler 304 - Schreibfehler cos! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }
        try {
            cos.close();
        } catch (IOException ex) {
             System.out.println("Fehler 305 - Schliessenfehler cos! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
       }
  }

    public byte[] decode( InputStream is, String pass )  {
    Cipher c = null;
        try {
            c = Cipher.getInstance( "DES" );
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Fehler 311 - Algorithmus Cipher! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        } catch (NoSuchPaddingException ex) {
            System.out.println("Fehler 312 - Algorithmus Cipher (Pad)! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }
    Key k = new SecretKeySpec( pass.getBytes(), "DES" );
        try {
            c.init( Cipher.DECRYPT_MODE, k );
        } catch (InvalidKeyException ex) {
            System.out.println("Fehler 313 - Falscher Schluessel! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    CipherInputStream cis = new CipherInputStream( is, c );

        try {
            for (int b; ( b = cis.read() ) != -1;)
                bos.write( b );
        } catch (IOException ex) {
            System.out.println("Fehler 314 - Schreiben bos! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }

        try {
            cis.close();
        } catch (IOException ex) {
            System.out.println("Fehler 315 - Schliessen bos! Klasse: " + this.getClass().getSimpleName() + " Code: "+ ex);
        }
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

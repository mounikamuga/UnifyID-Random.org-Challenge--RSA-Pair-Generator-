package Rsagenerator;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
public class RSA_Implementation
{
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int        bitlength = 1024;
    private Random     r;
    public void assignRSA(int x,int y,int z){
    	BigInteger min = BigInteger.valueOf(1);;
    	r = new Random();
    	BigInteger p = BigInteger.valueOf(x);
    	BigInteger q = BigInteger.valueOf(y);
    	BigInteger e = BigInteger.valueOf(z);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        
        e = BigInteger.probablePrime(bitlength / 2, r);
       
       while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
        System.out.println("The following is the public key: "+e);
        System.out.println("the following is the private key "+d);   
    }
}

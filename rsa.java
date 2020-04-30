import java.lang.*;
import java.util.*;
public class rsa{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter value of p and q");
		int p=sc.nextInt();
		int q=sc.nextInt();

		int n=p*q;
		int toitient=(p-1)*(q-1);

		System.out.println("modulus: "+n+"\ntoitient function: "+toitient);


		Random random=new Random();
		rsa rsa=new rsa();

		int e=random.nextInt(toitient-1)+1;
		while(rsa.cal_gcd(e,toitient)!=1)
		{

			e=random.nextInt(toitient-1)+1;
		}
		//e=7;
		System.out.println("Key: "+e);
		System.out.println("Enter message here: ");
		int message=sc.nextInt();

		long ciphertext=(long)(Math.pow(message,e)%n);

		System.out.println("Cipher Text: "+ciphertext);


		//Decryption

		int i=0;
		int val=(1+i*toitient)%e;
		while(val!=0&&i<e)
		{
			i++;
			val=(1+i*toitient)%e;
		}
		int d=(1+i*toitient)/e;
		System.out.println("K value: "+i);
		System.out.println("Private key: "+d);
		long newmessage=(long)(Math.pow(ciphertext,d)%n);

		System.out.println("Decrypted message: "+newmessage);


	}

	int cal_gcd(int a,int b)
	{
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(a==b)
			return a;
		if(a>b)
			return cal_gcd(a-b,b);
		return cal_gcd(a,b-a);
	}
}

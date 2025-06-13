import java.util.Scanner;
public class Leapyear{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n%4==0 && n%100 !=0){
            System.out.println(" is a leap year");
        }else{
            System.out.println(" is not a leap year");
        }
        sc.close();
        }
        }
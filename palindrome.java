public class Main
{
	public static int ispolindrome(String s) {
     	int left=0;
     	int right=s.length()-1;
     	while(left<right){
     	    if(s.charAt(left)!=s.charAt(right))
     	    return 0;
     	    left++;
     	    right--;
     	}
     	return 1;
	}
	public static void main(String[]args){
	    String s="lol";
	    System.out.println(ispolindrome(s));
	}
     	}
	    
	

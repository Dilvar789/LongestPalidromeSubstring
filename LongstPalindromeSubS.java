import java.util.*;
public class LongstPalindromeSubS 
{
	public static String longestPalindrome(String s) {       
        if (s == null ||  s.length() <= 1) return s;        
         
        char[] charArr = s.toCharArray();
        int n = s.length(), max = 1, startIndex = 0 , curr = 0;
        for (int j = 0; j < n - 1; j++) {
            int otherSame = 0;
            while (j + 1 + otherSame < n && charArr[j] == charArr[j + 1 + otherSame]) otherSame++;
            curr = getLength(charArr, j, j + otherSame);
            if(curr > max) {
                max = curr;
                startIndex = j - (curr - otherSame - 1) / 2;
            }
            j += otherSame;                 
          
        }        
        return s.substring(startIndex, startIndex + max);
    }
    
    

    private static int getLength(char[] charArr, int left, int right) {
        int i = 1;
        while (left - i >= 0 && right + i < charArr.length) {
            if(charArr[left - i] != charArr[right + i])  break;
            i++;             
        }
        return right - left + 1  + ((i - 1) * 2);
    } 
	public static void main(String[] args) 
	{
      Scanner sc=new Scanner(System.in);
      String str=sc.next();
      System.out.println(longestPalindrome(str));
      sc.close();
	}
}
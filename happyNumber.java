import java.util.HashSet;

public class happyNumber {
	
	/* sum all digits of input
	 * (mod10) to get last digit
	 * divide by 10 to move decimal point to the left, so we can get the next last digit
	 * */ 
	public static int sumDigit (int input){
	    int sum = 0;
        while (input > 0){
        	int digit = input%10;
            sum += digit*digit;
            input = input/10; 
        }
	    return sum;
	}

	public static void main(String[] args) {
        String line = "22"; /*---------ENTER TEST CASES HERE----ex: 22, 625, 91-------*/ 
        if (line != null) {
            int previous = Integer.parseInt(line);
            int current = sumDigit(previous);
            /* use 2 HashSets for checking repeating patterns
             * 1 for recording the pattern
             * 1 for recording the current loop, when the pattern repeats
             * */
            HashSet<Integer> loopCache = new HashSet<Integer>(); 
            HashSet<Integer> loopCurrent = new HashSet<Integer>(); 
            int cacheHit = 0; // to identify finite loop
            
            /* continuous loop to compute current */
            while (current != previous){
                /*------create cache-------*/ 
            	if (!loopCache.contains(current)) {
                	loopCache.add(current);
                }else{
                	/* first time repeats OR first time hit cache
                	 * clear cache & recreate
                	 */
            		cacheHit++;
            		if (cacheHit == 1) {
	            		loopCache.clear();
	            		loopCache.add(current);	
            		} else if (cacheHit > 1) {
            			loopCurrent.add(current);
	                	System.out.println("Current loop" + loopCurrent.toString());
	                	System.out.println("Cached" + loopCache.toString());
	                	if (loopCurrent.equals(loopCache)) {
	                		break; // if 2 Hashsets equal --> pattern identified, break loop
	                	}
            		}
                }	                
            	previous = current;				// record previous
                current = sumDigit(previous);	// calculate new sum of digits
            }
            
            /*------print result------*/
            if (current != 1){
              System.out.println(0);
            }else{
              System.out.println(current);
            }
        }
	}
}

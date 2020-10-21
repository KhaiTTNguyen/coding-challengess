import java.util.HashSet;

public class happyNumber {
	
	// sum all digits of input
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
        String line = "91"; /*---------ENTER TEST CASES HERE----ex: 22, 625, 91-------*/ 
        if (line != null) {
            int previous = Integer.parseInt(line);
            int current = sumDigit(previous);
            HashSet<Integer> loopCache = new HashSet<Integer>();
            HashSet<Integer> loopCurrent = new HashSet<Integer>();
            int cacheHit = 0; // to identify finite loop
            
            
            while (current != previous){
                // create cache
            	if (!loopCache.contains(current)) {
                	loopCache.add(current);
                }else{
                	/* first time repeats OR hit cache
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
	                		break;
	                	}
            		}
                }	                
            	previous = current;				// record previous
                current = sumDigit(previous);	// calculate new sum of digits
            }
            
            if (current != 1){
              System.out.println(0);
            }else{
              System.out.println(current);
            }
        }
	}
}

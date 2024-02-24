import java.util.*;

public class test {
	
	public static int isPossible(int[] arr, int sum) {
		int prefix = 0;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			prefix += arr[i];
			
			if(prefix == sum) {
				res = i+1;
			}
			else if(map.containsKey(prefix - sum)) {
				res = Math.max(res, i - map.get(prefix - sum));
			}
			
			map.put(prefix, i);
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {5, 8, -4, -4, 9, -2, 2};
		System.out.println(isPossible(arr, 0));

		
		

	}

}
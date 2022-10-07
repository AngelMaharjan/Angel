package stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleets {
	public static int carFleets(int[] position, int[] speed, int target) {
		Stack<Double> stack = new Stack<>();
		int[][] pos_speed = new int[position.length][2];
		
		for(int i = 0; i < position.length; i++) {
			pos_speed[i][0] = position[i];
			pos_speed[i][1] = speed[i];
		}
		
		Arrays.sort(pos_speed, java.util.Comparator.comparingInt(a -> a[0]));
		for(int i = position.length - 1; i >= 0; i--) {
			double currTime = (double)(target - pos_speed[i][0]) / pos_speed[i][1];
			if(!stack.isEmpty() && currTime <= stack.peek()) {
				continue;
			}else {
				stack.push(currTime);	
			}
		}
		
		return stack.size();
	}

	public static void main(String[] args) {
		
		int[] pos = new int[] {10,8,0,5,3};
		int[] speed = new int[] {2,4,1,1,3};
		int target = 12;
		
		
		
		System.out.println("Number of Car Fleets : "+carFleets(pos, speed, target));

	}

}

package BubbleSortStudy;

import java.util.Arrays;

public class main {
	/*
	 * 버블 정렬 공부 (2번)
	 * Bubble Sort: 배열을 여러 번 순회하며 인접한 두 요소를 비교하여
	 *             필요하면 서로 교환(swap)하면서 정렬하는 단순 정렬 알고리즘
	 *             가장 큰(혹은 작은) 값이 "버블처럼" 끝으로 이동
	 * 빅오 -> O(n^2), 공간복잡도 -> O(1), 안정 정렬
	 * 
	 * Study of Bubble Sort (2)
	 * Bubble Sort repeatedly traverses the array, compares adjacent elements,
	 * and swaps them if they are in the wrong order.
	 * The largest (or smallest) elements "bubble" to the end each pass.
	 * Time complexity: O(n^2), Space complexity: O(1), Stable sort
	 */


	public static void main(String[] args) {
		int[] orig = {5, 14, 1, 2, 56, 35, 27};
		
		System.out.println("원본 배열: " + Arrays.toString(orig));
		
		int[] sortresult = bubbleSort(orig);
		System.out.println("버블 정렬 오름차순: " + Arrays.toString(sortresult));
		
		int[] sortresult2 = bubbleSortDesc(orig);
		System.out.println("버블 정렬 내림차순: " + Arrays.toString(sortresult2));
		
	}
		
	public static int[] bubbleSort(int[] input) {	// 오름차순 버블 정렬
		int[] arr = input;
		int lastIndex = arr.length - 1;
		
		int flag;	// 성능을 위해 사용 (없어도 작동은 됨) (불필요한 연산을 제외하기 위한 것)
		
		for (int j = lastIndex; j >= 0; j--) {	// 반복 횟수
			flag = 0;
			
			for (int i = 0; i < lastIndex; i++) {	// 인접 값 비교
				if (arr[i] > arr[i+1]) {		// 왼쪽이 더 크면 swap
					int tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
					
					flag++;
				}
			}
			
			if (flag == 0) {	// 한 번도 swap이 안 발생하면 이미 정렬 완료
				break;
			}
		}
		
		return arr;
	}
	
	public static int[] bubbleSortDesc(int[] input) {	// 내림차순 버블 정렬
		int[] arr = input;
		int lastIndex = arr.length - 1;
		
		for (int j = lastIndex; j >= 0; j--) {
			for (int i = 0; i < lastIndex; i++) {
				
				// 오름차순과 다른 부분
				if (arr[i] < arr[i+1]) {
					int tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		
		return arr;
	}
	

}

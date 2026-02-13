package QuickSortStudy;

import java.util.Arrays;

public class main {
	/*
	 * 퀵 정렬 공부 (5번)
	 * Quick Sort: 기준값(pivot)을 하나 선택한 뒤,
	 *             pivot을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할한 후
	 *             이를 재귀적으로 반복하여 정렬하는 분할 정복 알고리즘
	 *             평균적으로 매우 빠른 정렬 방식
	 * 빅오 -> 평균 O(n log n), 최악 O(n^2), 공간복잡도 -> O(log n), 불안정 정렬
	 * 
	 * Study of Quick Sort (5)
	 * Quick Sort is a divide-and-conquer sorting algorithm that selects a pivot,
	 * partitions the array into elements smaller and larger than the pivot,
	 * and recursively sorts the subarrays.
	 * Average time complexity: O(n log n), Worst case: O(n^2)
	 * Space complexity: O(log n), Unstable sort
	 */

	public static void main(String[] args) {
		int[] orig = {64, 34, 25, 12, 22, 11, 90};
		
		System.out.println("원본 배열: " + Arrays.toString(orig));
		
		quickSort(orig);
		System.out.println("퀵 정렬: " + Arrays.toString(orig));
	}
	
	/*
	 * 전체 구조
	 * quickSort → doQuickSort → partition
	 */
	
	public static void quickSort(int[] input) {
		doQuciSort(input, 0, input.length - 1);
	}
	
	public static void doQuciSort(int[] input, int left, int right) {
		int part = partition(input, left, right);
		
		// 쪼개는 작업을 재귀적으로 진행
		if (left < part - 1) {
			doQuciSort(input, left, part - 1); 	// 좌측 부분 다시 분할
		}
		
		if (part < right) {
			doQuciSort(input, part, right);	// 우측 부분 다시 분할
		}
		
		/*
		 * 왜 이러는가?
		 * 이미 pivot 기준으로 나눠졌기 때문에
		 * 좌측끼리만 정렬, 우측끼리만 정렬
		 * 하면 전체가 정렬된다.
		 */
	}
	
	public static int partition(int[] input, int left, int right) {
		/*
		 * partition이 하는 일
		 * pivot 기준으로 좌측에는 작은 값들, 우측에는 큰 값들로 정리하는 작업
		 */
		
		int pivot = input[(left + right) / 2];		// 기준점 설정
		
		while (left <= right) {		// 분할 시작, 좌측과 우측이 교차하기 전까지 반복
			while (input[left] < pivot) {
				left++;
			}
			
			while (input[right] > pivot) {	// 좌측에서 찾기
				// pivot 보다 작은 값은 그냥 둠, pivot 보다 크거나 같은 값은 나오면 stop
				
				right--;
			}
			
			if (left <= right) {	// 우측에서 찾기
				// pivot 보다 큰 값은 그냥 둠, pivot 보다 작거나 같은 값이 나오면 멈춤 
				
				swap(input, left, right);
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	public static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
		/*
		 * 배열의 i 번째 값과 배열의 j 번째 값을 서로 바꾸는 과정
		 */
	}

}

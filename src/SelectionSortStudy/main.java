package SelectionSortStudy;

import java.util.Arrays;

public class main {
	/*
	 * 선택 정렬 공부 (1번)
	 * Selection Sort: 배열에서 매번 최대값 또는 최소값을 찾아
	 * 				정렬되지 않은 구간의 끝으로 보내면서 정렬하는 단순 정렬 알고리즘
	 * 빅오 -> O(n^2) / 공간복잡도 -> O(1)
	 * 
	 * 
	 * Study of Selection Sort (1)
	 * Selection Sort is a simple sorting algorithm that repeatedly
	 * finds the maximum or minimum element from the unsorted portion
	 * of the array and moves it to the end.
	 * Time complexity: O(n^2), Space complexity: O(1)
	 */

	public static void main(String[] args) {
		int[] orig = {1, 4, 11, 35, 12, 2, 73, 142};
		
		// 원본
		System.out.println("원본 : " + Arrays.toString(orig));
		
		// 오름차순 정렬
		int[] sort_result = selectionSort(orig);
		System.out.println("선택정렬 오름차순: " + Arrays.toString(sort_result));
		
		/*
		 * 원본 배열이 그대로 바뀌는 구조라 
		 * 안전하게 하려면 int[] arr = Arrays.copyOf(input, input.length); 로 하면 됨
		 */
		
		// 내림차순 정렬
		int [] sortresult2 = selectionSortDesc(orig);
		System.out.println("선택정렬 내림차순: " + Arrays.toString(sortresult2));

	}
	
	public static int[] selectionSort(int[] input) {	// 오름차순
		int[] arr = input;	
		int lastIndex = arr.length - 1;		// 뒤에서부터 정렬할 마지막 인덱스
		int maxIndex = 0;
		
		for (int i = lastIndex; i > 0; i--) {
			maxIndex = findMax(arr, lastIndex);	// 0 ~ lastIndex 구간에서 가장 큰 값의 인덱스 찾기
			
			// 가장 큰 값고 맨 뒤에 값을 서로 교환 (swap)
			int tmp = arr[maxIndex];
			arr[maxIndex] = arr[lastIndex];
			arr[lastIndex] = tmp;
			
			// 맨 뒤는 확정이니 다음 반복에서는 범위가 줄어듬
			lastIndex--;
		}
		
		return arr;
	}
	
	public static int findMax(int[] arr, int last) {	// 0 ~ last 범위에서 최대값 찾기
		int max = 0;
		int maxIndex = 0;	// 일단 0번을 최대값으로 지정
		
		for (int i = 0; i <= last; i++) {	// 범위 끝까지 탐색
			if (arr[i] >= arr[maxIndex]) {	// 더 크거나 같으면 인덱스 갱신(같은 값이면 뒤쪽 인덱스 선택)
				max = arr[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;	// 최대값 위치 반환
	}
	
	public static int[] selectionSortDesc(int[] input) {	// 내림차순
		int[] arr = input;		
		int lastIndex = arr.length - 1;
		int maxIndex = 0;
		
		for (int i = lastIndex; i > 0; i--) {	// lastIndex가 0이 될 때까지 반복
			maxIndex = findMin(arr, lastIndex);
			
			// 최소값과 마지막 위치의 값 교환 (swap)
			int tmp = arr[maxIndex];
			arr[maxIndex] = arr[lastIndex];
			arr[lastIndex] = tmp;
			
			lastIndex--;	// 맨 뒤에 확정되었으니 다음 반복부터 범위를 줄임
		}
		
		return arr;
	}
	
	public static int findMin(int[] arr, int last) {  // 0 ~ last까지 최소값 탐색
		int min = 0;
		int minIndex = 0;	// 현재 최소값의 위치, 초기화로 0
		
		// 0 ~ last 범위 탐색
		for (int i = 0; i <= last; i++) {
			if (arr[i] <= arr[minIndex]) {	// 현재 값이 최소값보다 작거나 같으면
				min = arr[i];				// 임시 변수에 저장
				minIndex = i;				// 최소값 인덱스 갱신
			}
		}
		
		return minIndex;
	}

}

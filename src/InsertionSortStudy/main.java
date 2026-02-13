package InsertionSortStudy;

import java.util.Arrays;

public class main {
	/*
	 * 삽입정렬 공부 (3번)
	 * Insertion Sort: 배열을 순회하면서 현재 요소를 이미 정렬된 부분 배열의
	 *                 적절한 위치에 삽입하며 정렬하는 단순 정렬 알고리즘
	 *                 카드 정렬처럼 한 장씩 끼워 넣는 방식
	 * 빅오 -> O(n^2), 공간복잡도 -> O(1), 안정 정렬
	 * 
	 * Study of Insertion Sort (3)
	 * Insertion Sort traverses the array and inserts each element
	 * into its proper position within the already sorted portion of the array.
	 * Works like sorting cards in your hand, one at a time.
	 * Time complexity: O(n^2), Space complexity: O(1), Stable sort
	 */


	public static void main(String[] args) {
		int[] orig = {1, 22, 8, 2, 4, 15};
		
		System.out.println("원본 배열: " + Arrays.toString(orig));
		
		int[] sortresult = insertionSort(orig);
		System.out.println("삽입정렬 오름차순: " + Arrays.toString(sortresult));
		
		int[] sortresult2 = insertionSortDesc(orig);
		System.out.println("삽입정렬 내림차순: " + Arrays.toString(sortresult2));
		
	}
	
	public static int[] insertionSort(int[] input) {	// 오름차순
		int arr[] = input;
		int lastIndex = arr.length;
		
		for (int i = 1; i < lastIndex; i++) {	// i가 1이라 배열의 2번째 부분을 말함
			int tmp = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > tmp) {	
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = tmp;
			
		}
		
		return arr;
	}
	
	public static int[] insertionSortDesc(int[] input) {	// 내림차순
		int arr[] = input;
		int lastIndex = arr.length;
		
		for (int i = 1; i < lastIndex; i++) {
			int tmp = arr[i];
			int j = i - 1;
			
			// 오름차순과 다른 부분
			while (j >= 0 && arr[j] < tmp) {
				arr[j+1] = arr[j];
				j--;
			}
		
			arr[j+1] = tmp;
			
		}
		
		return arr;
	}

}

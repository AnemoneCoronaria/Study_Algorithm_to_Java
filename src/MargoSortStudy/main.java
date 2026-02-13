package MargoSortStudy;

import java.util.Arrays;

public class main {
	/*
	 * 병합 정렬 공부 (4번)
	 * Merge Sort: 분할 정복(Divide and Conquer) 기반의 정렬 알고리즘
	 *             배열을 반으로 계속 나눈 뒤, 정렬하면서 병합하는 방식
	 *             작은 배열 단위로 분할 후 정렬된 상태로 합친다.
	 *
	 * 과정:
	 * 1. 배열을 절반으로 분할
	 * 2. 각각을 재귀적으로 정렬
	 * 3. 두 정렬된 배열을 병합
	 *
	 * 시간복잡도 -> O(n log n)
	 * 공간복잡도 -> O(n) (임시 배열 필요)
	 * 안정 정렬 (Stable Sort)
	 *
	 * Study of Merge Sort (4)
	 * Merge Sort is a divide-and-conquer sorting algorithm.
	 * It recursively splits the array into halves,
	 * sorts them, and then merges the sorted halves.
	 *
	 * Time complexity: O(n log n)
	 * Space complexity: O(n)
	 * Stable sort
	 */


	static int loop_num = 0;	// loop 개수 확인 
	
	public static void main(String[] args) {
		int[] orig = {64, 31, 1, 5, 9, 12, 104};
	
		System.out.println("원본 배열: " + Arrays.toString(orig));
		
		mergeSort(orig, 0, orig.length - 1);	// 배열 전체를 정렬 시작 (left=0, right=6, 0~6 구간을 정렬하라는 의미)
		System.out.println("병합 정렬: " + Arrays.toString(orig));
	}
	
	public static void mergeSort(int[] input, int left, int right) {
		int[] arr = input;
		
		if (left < right) {		// 배열 크기가 2 이상일 때만 실행
			int center = (left + right) / 2;	// 중간값 계산 (Divide and Conquer, 분할 정복)
			mergeSort(arr, left, center);	// 좌측 배열 재귀
			mergeSort(arr, center + 1, right);	// 우측 배열 재귀
			merge(arr, left, center, right);
		}
	}
	
	public static void merge(int[] input, int left, int center, int right) {	//핵심
		int arr[] = input;
		int lLength = center - left + 1;	// 좌측 구간 크기 계산	(+1하는 이유는 0~1은 2개이기 때문)
		int rLength = right - center;		// 우측 구간 크기 계산
		
		int[] leftArr = new int[lLength];
		int[] rightArr = new int[rLength];
		
		System.arraycopy(arr, left, leftArr, 0, lLength);
			// 원본 배열을 반으로 나눠 좌측 부분에 있는 내용을 새로운 배열로 copy 함
		System.arraycopy(arr, center + 1, rightArr, 0, rLength);
		
		int i = 0;		// leftArr index
		int j = 0;		// rightArr index
		int k = left;	// original array location
		
		
		while (i < lLength && j < rLength) {	// 좌우 배열 두 개를 동시에 비교하며 작은 값을 원본 배열에 삽입
			loop_num++;
			
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while (i < lLength) {
			arr[k] = leftArr[i];
			k++;
			i++;
		}
		
		while (j < rLength) {
			arr[k] = rightArr[j];
			k++;
			j++;
		}
		
		System.out.println(loop_num + " loop: " + Arrays.toString(arr));
	}

}

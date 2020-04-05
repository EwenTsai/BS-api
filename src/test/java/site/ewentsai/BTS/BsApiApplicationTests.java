package site.ewentsai.BTS;


import java.util.Arrays;


public class BsApiApplicationTests {

	public static int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		int gap = 1;
		while (gap < arr.length) {
			gap = gap * 3 + 1;
		}
		System.out.println("first gap="+gap);
		while (gap > 0) {
			System.out.println("while - gap="+gap);
			for (int i = gap; i < arr.length; i++) {
				System.out.println("for - i"+ i);
				int tmp = arr[i];
				int j = i - gap;
				while (j >= 0 && arr[j] > tmp) {
					System.out.println("while - j"+j);
					arr[j + gap] = arr[j];
					j -= gap;
				}
				arr[j + gap] = tmp;
			}
			gap = (int) Math.floor(gap / 3);
		}

		return arr;
	}

	public static void main(String[] arg0) throws Exception {
		int[] arr = {0,7,5,9,4,2,8,1,3,6};
		BsApiApplicationTests.sort(arr);
	}
}

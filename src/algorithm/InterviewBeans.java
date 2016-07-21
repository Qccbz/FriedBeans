package algorithm;

public class InterviewBeans {

	/*
	 * 题目：给定一系列x轴的点坐标，例如 {1,3,7,8,9,11}这些坐标升序放在数组中，现在给一根绳子长度为4，问绳子最多能覆盖的点数有多少，
	 * 例如绳子放前面只能覆盖两个点{1,3}，如果放后面能覆盖4个点{7,8,9,11}
	 *
	 */
	public static void ropeProblem() {
		int[] array = { 1, 3, 7, 8, 9, 11 };
		final int ropeLen = 4;

		if (array == null || array.length == 0) {
			return;
		}

		int frontIndex = 1, rearIndex = 0, coverMax = 0;

		while (frontIndex < array.length) {
			while (array[frontIndex] - array[rearIndex] > ropeLen) {
				++rearIndex;
			}
			coverMax = (frontIndex - rearIndex + 1) > coverMax ? (frontIndex - rearIndex + 1) : coverMax;
			++frontIndex;
		}
		System.out.println("begin:" + array[rearIndex] + ",end:" + array[--frontIndex] + ",maxLen:" + coverMax);
	}

}

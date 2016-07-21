package algorithm;

public class InterviewBeans {

	/*
	 * ��Ŀ������һϵ��x��ĵ����꣬���� {1,3,7,8,9,11}��Щ����������������У����ڸ�һ�����ӳ���Ϊ4������������ܸ��ǵĵ����ж��٣�
	 * �������ӷ�ǰ��ֻ�ܸ���������{1,3}������ź����ܸ���4����{7,8,9,11}
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

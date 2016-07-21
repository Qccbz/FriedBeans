package algorithm;

/**
 * 约瑟夫环问题
 * 
 * @author User
 *
 */
public class Josephus {

	/*
	 * 题目描述： 输入一个由随机数组成的数列（数列中每个数均是大于0的整数，长度已知），和初始计数值m。从数列首位置开始计数，计数到m后，
	 * 将数列该位置数值替换计数值m，并将数列该位置数值出列，然后从下一位置从新开始计数，直到数列所有数值出列为止。如果计数到达数列尾段，
	 * 则返回数列首位置继续计数。请编程实现上述计数过程，同时输出数值出列的顺序
	 * 
	 * 比如： 输入的随机数列为：3,1,2,4，初始计数值m=7，从数列首位置开始计数（数值3所在位置）
	 * 第一轮计数出列数字为2，计数值更新m=2，出列后数列为3,1,4，从数值4所在位置从新开始计数
	 * 第二轮计数出列数字为3，计数值更新m=3，出列后数列为1,4，从数值1所在位置开始计数
	 * 第三轮计数出列数字为1，计数值更新m=1，出列后数列为4，从数值4所在位置开始计数 最后一轮计数出列数字为4，计数过程完成。
	 * 输出数值出列顺序为：2,3,1,4。
	 * 
	 */
	public static int[] getArray(int[] arrayInput, int m) {

		int len = arrayInput == null ? 0 : arrayInput.length;
		if (len > 1) {
			int startPos = 0;
			int countNum = m;
			int[] outArray = new int[len];
			int outArrayIndex = 0;
			while (len > 0) {
				// it is the most important point
				startPos = (countNum + startPos - 1) % len;
				countNum = arrayInput[startPos];
				outArray[outArrayIndex++] = countNum;
				// 将元素从数组中删除
				for (int i = startPos; i < len - 1; i++) {
					arrayInput[i] = arrayInput[i + 1];
				}
				len--;
			}
			return outArray;

		} else if (len > 0) {
			return new int[] { arrayInput[0] };
		}
		return null;
	}

}

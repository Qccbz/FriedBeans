package algorithm;

/**
 * Լɪ������
 * 
 * @author User
 *
 */
public class Josephus {

	/*
	 * ��Ŀ������ ����һ�����������ɵ����У�������ÿ�������Ǵ���0��������������֪�����ͳ�ʼ����ֵm����������λ�ÿ�ʼ������������m��
	 * �����и�λ����ֵ�滻����ֵm���������и�λ����ֵ���У�Ȼ�����һλ�ô��¿�ʼ������ֱ������������ֵ����Ϊֹ�����������������β�Σ�
	 * �򷵻�������λ�ü�������������ʵ�������������̣�ͬʱ�����ֵ���е�˳��
	 * 
	 * ���磺 ������������Ϊ��3,1,2,4����ʼ����ֵm=7����������λ�ÿ�ʼ��������ֵ3����λ�ã�
	 * ��һ�ּ�����������Ϊ2������ֵ����m=2�����к�����Ϊ3,1,4������ֵ4����λ�ô��¿�ʼ����
	 * �ڶ��ּ�����������Ϊ3������ֵ����m=3�����к�����Ϊ1,4������ֵ1����λ�ÿ�ʼ����
	 * �����ּ�����������Ϊ1������ֵ����m=1�����к�����Ϊ4������ֵ4����λ�ÿ�ʼ���� ���һ�ּ�����������Ϊ4������������ɡ�
	 * �����ֵ����˳��Ϊ��2,3,1,4��
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
				// ��Ԫ�ش�������ɾ��
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

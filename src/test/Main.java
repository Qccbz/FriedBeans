package test;

import java.io.File;

import algorithm.InterviewBeans;
import algorithm.Josephus;
import file.FileUtils;

public class Main {

	public static void main(String[] args) {

		Main instance = new Main();
		// instance.testFileCopy();
		// instance.testJosephus();
		instance.testInterviewBeans();
	}

	private void testFileCopy() {
		String srcFilePath = new StringBuilder("D:").append(File.separator).append("android_tools")
				.append(File.separator).append("NDK-r10e.rar").toString();
		String desFilePath = new StringBuilder("E:").append(File.separator).append("copy_NDK-r10e.rar").toString();

		long begin = System.currentTimeMillis();
		System.out.println("copy begin: " + begin);
		if (FileUtils.copy(srcFilePath, desFilePath)) {
			System.out.println("copy end: " + (System.currentTimeMillis() - begin));
			System.out.println("copy file success!");
		} else {

		}
	}

	private void testJosephus() {

		int[] input = { 3, 1, 2, 4, 55, 6, 8, 787, 96, 41, 44, 25, 0, 32 };
		int[] output = Josephus.getArray(input, 7);

		if (output != null) {
			for (int i : output) {
				System.out.println(i);
			}
		} else {
			System.out.println("Josephus result null");
		}
	}

	private void testInterviewBeans() {
		InterviewBeans.ropeProblem();
	}
}

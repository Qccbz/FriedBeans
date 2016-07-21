package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import utils.QString;

public class FileUtils {

	// Fastest way to Copy file in Java
	@SuppressWarnings({ "resource", "finally" })
	public static boolean copy(File src, File dest) {

		boolean isCopySuccessful = false;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(src).getChannel();
			outChannel = new FileOutputStream(dest).getChannel();

			// Try to change this but this is the number I tried.. for Windows,
			// 64Mb - 32Kb)
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size) {
				position += inChannel.transferTo(position, maxCount, outChannel);
			}
			isCopySuccessful = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inChannel != null) {
					inChannel.close();
				}
				if (outChannel != null) {
					outChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				return isCopySuccessful;
			}
		}
	}

	public static boolean copy(String srcPath, String desPath) {

		if (QString.isBlank(srcPath) || QString.isBlank(desPath))
			return false;

		File srcFile = new File(srcPath);
		if (srcFile.isFile()) {
			File desFile = new File(desPath);
			if (desFile.exists()) {
				desFile.delete();
			}
			boolean isDestFileExist = false;
			try {
				isDestFileExist = desFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (isDestFileExist) {
				// return copy(srcFile, desFile);
				return copyFile(srcFile, desFile);
			}
		}
		return false;

	}

	@SuppressWarnings("finally")
	public static boolean copyFile(File source, File dest) {
		boolean isCopySuccessful = false;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(dest);

			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			isCopySuccessful = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				return isCopySuccessful;
			}
		}

	}
}

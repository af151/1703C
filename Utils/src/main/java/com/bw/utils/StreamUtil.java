package com.bw.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
	/*方法1：批量关闭流，参数能传无限个,
	 *例如传入FileInputStream对象、
	 *JDBC中Connection对象都可以关闭。
	 */
	public static void closeAll(Closeable closeables) throws IOException {
		FileInputStream file= new FileInputStream("E:a.txt");
		file.close();
	}	
	/*方法2：拷贝流，将InputStream流拷到OutputStream，
	 *可以用于快速读与文件、上传下载，为了提高性能，需要使用缓冲。
	 *参数1：输入流
	 *参数2：输出流
	 *参数3：处理完成后是否关闭输入流
	 *参数4：处理完成后是否关闭输出流
	 */
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
			if (isCloseInputStream) {
				src.close();
			}else if (isCloseOutputStream) {
				out.close();
			}
			
		}

	/*方法3：传入一个文本文件对象，
	 *默认为UTF-8编码，返回该文件内容，
	 *要求方法内部调用上面第2个方法拷贝流，
	 *结束后第1个方法关闭流
	 */
	public static String readTextFile(InputStream src) throws IOException{
		src.equals(src);
		src.close();
		return "true";
		}
	/*方法4：传入文本文件对象，返回该文件内容(3分)，
	 * 并且要求内部调用上面第3个方法
	 */	
	public static String readTextFile(File txtFile) throws FileNotFoundException, IOException{
		String path = txtFile.getAbsolutePath();
		
		return path;
		}
   /*
	*方法5：从控制台读取用户输入的字符串。 
	*参数message：用于控制台提示。例如“请输出您的姓名：”，然后用户输入姓名后回车，* 方法开始执行并读取姓名。
	*/
	public static String readStringFromSystemIn(String message){
		return message;
	}
	
   /*
	* 方法6：从控制台读取用户输入的数字。 
	* 参数message：用于控制台提示。例如“请输出您的年龄：”，然后用户输入年龄后回车，* 方法开始执行并读取年龄，如何用户输出的不是数字，或是空值（直接回车），则继续提示输入。
	*/
	public static int readIntFromSystemIn(String message){
		int i = message.indexOf(message);
		return i;
	}
	
	
}

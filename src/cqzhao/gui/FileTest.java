package cqzhao.gui;
import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File f1 = new File("/Users/lisa/Documents/workspace/JavaLearning");
		printFile(f1, 0);
	}
	
	public static void printFile(File f, int level){
		for(int i=0;i<level;i++){
			if(i==level-1){
				System.out.print("|____");
			}else if(i==0){
				System.out.print("| ");
			}else{
				System.out.print("| ");
				
			}
		}
		System.out.println(f.getName());
		if(f.isDirectory()){
			File[] subfiles = f.listFiles();
			for(File j:subfiles){
				printFile(j, level+1);
			}
		}
	}
}

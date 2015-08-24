package cqzhao.gui;
import java.io.File;
import java.io.FileNotFoundException;

public class FileTest {
	public static void main(String[] args) {
		File f1 = null;
		if(args.length == 0){
			f1 = new File(".");
		}else if(args.length == 1){
			f1 = new File(args[0]);
		}else{
			System.out.println("Warning: Only the first directory is valid!");
		}
		try{
			printFile(f1, 0);
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void printFile(File f, int level) throws FileNotFoundException{
		if(! f.exists()){
			throw new FileNotFoundException(f.getName() + " is Not Found!");
		}
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

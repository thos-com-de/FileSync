package main;

import java.io.File;

import logic.TreeCompare;
import logic.TreeReader;

public class Main {

	public static final File PATH_1 = new File("C:\\Users\\Thomas\\Thomas Dokumente\\5_25-Disketten");
	public static final File PATH_2 = new File("E:\\thomas\\Thomas Dokumente\\5_25-Disketten");

	public static void main(String[] args) {
		TreeReader tree1 = new TreeReader(PATH_1);
		tree1.read();
		System.out.println(PATH_1 + " : " + tree1.getTotalFiles() + " files, total " + tree1.getSize() + " Bytes in "
				+ tree1.getTotalDirs() + " directories.");
		TreeReader tree2 = new TreeReader(PATH_2);
		tree2.read();
		System.out.println(PATH_2 + " : " + tree2.getTotalFiles() + " files, total " + tree2.getSize() + " Bytes in "
				+ tree2.getTotalDirs() + " directories.");

		TreeCompare compare = new TreeCompare();
		compare.compare(tree1.getRoot(), tree2.getRoot());
		compare.compare(tree2.getRoot(), tree1.getRoot());

		compare.testBinary();

		System.out.println("Finish");
	}
}

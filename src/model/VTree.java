package model;

import java.io.File;

public class VTree {
	private VDir root;
	private long totalFiles = Constants.NOT_CALCULATED;
	private long totalDirs = Constants.NOT_CALCULATED;
	private VTree() {
		// nothing to do
	}
	public VTree(VDir vDir) {
		this();
		this.setRoot(vDir);
	}
	public VTree(File path1) {
		this(new VDir(path1));
	}
	public long getTotalFiles() {
		return totalFiles;
	}
	public void setTotalFiles(long totalFiles) {
		this.totalFiles = totalFiles;
	}
	public long getTotalDirs() {
		return totalDirs;
	}
	public void setTotalDirs(long totalDirs) {
		this.totalDirs = totalDirs;
	}
	public void incTotalFiles() {
		this.totalFiles++;
	}
	public void incTotalDirs() {
		this.totalDirs++;
	}	
	public VDir getRoot() {
		return root;
	}
	public void setRoot(VDir vDir) {
		this.root = vDir;
	}
	public long getSize() {
		return this.getRoot().getSize();
	}
}

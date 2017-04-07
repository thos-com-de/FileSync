package model;

import java.io.File;

public class VFile extends AbstractVFile {

	public VFile(File file) {
		super(file);
		this.setSize(file.length());
	}

	public boolean sameSize(VFile vFile2) {
		return this.getSize() == vFile2.getSize();
	}

	public VFile newest(VFile vFile2) {
		return (this.getTime() >= vFile2.getTime()) ? this : vFile2;
	}

	public boolean sameName(VFile vFile2) {
		return this.getName().equals(vFile2.getName());
	}

	private String getName() {
		return this.getFile().getName();
	}

	public boolean sameTime(VFile vFile2) {
		return this.getTime() == vFile2.getTime();
	}

}

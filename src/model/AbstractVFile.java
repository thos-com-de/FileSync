package model;

import java.io.File;

public class AbstractVFile {
	private long size = Constants.NOT_CALCULATED;
	private long time;
	private File file;

	AbstractVFile(File file) {
		this.file = file;
		this.setTime(file.lastModified());
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return this.file.getPath();
	}

}

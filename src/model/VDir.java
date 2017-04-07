package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class VDir extends AbstractVFile {
	private List<VFile> files = new ArrayList<VFile>();
	@Getter
	@Setter
	private List<VDir> dirs = new ArrayList<VDir>();

	public VDir(File file) {
		super(file);
	}

	public void addDir(VDir vDir) {
		this.getDirs().add(vDir);
	}

	public void addFile(VFile vFile) {
		this.getFiles().add(vFile);
		this.setSize(this.getSize() + vFile.getSize());
	}

	public List<VFile> getFiles() {
		return files;
	}

	public void setFiles(List<VFile> files) {
		this.files = files;
	}

	public File[] listIOFiles() {
		return this.getFile().listFiles();
	}

	@Override
	public String toString() {
		return this.getFile().toString();
	}
}

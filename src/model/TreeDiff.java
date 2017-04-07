package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class TreeDiff {
	@Getter
	private List<DiffFile> fileList = new ArrayList<DiffFile>();

	public void add(DiffFile dFile) {
		this.getFileList().add(dFile);
		if (dFile.hasDiff()) {
			System.out.println(dFile);
		}
	}

}

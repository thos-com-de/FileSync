package logic;

import java.util.Iterator;
import java.util.List;

import lombok.Getter;
import model.DiffFile;
import model.TreeDiff;
import model.VDir;
import model.VFile;

public class TreeCompare {
	@Getter
	private TreeDiff treeDiff = new TreeDiff();

	public void compare(VDir vDir1, VDir vDir2) {
		System.out.println("\n" + vDir1);
		List<VFile> files1 = vDir1.getFiles();
		List<VFile> files2 = vDir2.getFiles();
		for (VFile vFile1 : files1) {
			this.getTreeDiff().add(this.find(vFile1, files2));
		}
		List<VDir> subDirs1 = vDir1.getDirs();
		List<VDir> subDirs2 = vDir2.getDirs();
		for (VDir vSubDir1 : subDirs1) {
			boolean found = false;
			for (VDir vSubDir2 : subDirs2) {
				if (vSubDir1.getFile().getName().equals(vSubDir2.getFile().getName())) {
					this.compare(vSubDir1, vSubDir2);
					found = true;
				}
			}
			if (!found) {
				System.err.println(vSubDir1);
			}
		}
	}

	private DiffFile find(VFile vFile, List<VFile> files) {
		for (Iterator<VFile> iterator = files.iterator(); iterator.hasNext();) {
			VFile vListFile = iterator.next();
			if (vFile.sameName(vListFile)) {
				iterator.remove();
				return new DiffFile(vFile, vListFile);
			}
		}
		return new DiffFile(vFile);
	}

	public void testBinary() {
		TreeDiff treeDiff = this.getTreeDiff();
		List<DiffFile> fileList = treeDiff.getFileList();
		for (DiffFile diffFile : fileList) {
			if (diffFile.isSameSize()) {
				if (!diffFile.binaryEqual()) {
					System.out.println("not equal:" + diffFile);
				}
			}
		}
	}

}

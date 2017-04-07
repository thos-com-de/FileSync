package logic;

import java.io.File;

import model.VDir;
import model.VFile;
import model.VTree;

public class TreeReader extends VTree {
	public TreeReader(File path) {
		super(new VDir(path));
	}

	public VDir read() {
		return this.read(this.getRoot());
	}

	protected VDir read(VDir vDir) {
		File[] listFiles = vDir.listIOFiles();
		for (File file : listFiles) {

			if (file.isDirectory()) {
				VDir vSubDir = new VDir(file);
				vDir.addDir(vSubDir);
				// recursive read directory
				VDir subReaded = read(vSubDir);
				// now we have the size and can add it to parent
				vDir.setSize(vDir.getSize() + subReaded.getSize());
				// count sum
				this.incTotalDirs();
			} else {
				VFile vFile = new VFile(file);
				vDir.addFile(vFile);
				// count sum
				this.incTotalFiles();
			}
		}
		return vDir;
	}
}
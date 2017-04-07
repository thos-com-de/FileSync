package model;

import junitx.framework.FileAssert;
import lombok.Getter;
import lombok.Setter;

public class DiffFile {

	@Getter
	@Setter
	VFile vFile1;
	@Getter
	@Setter
	VFile vFile2;
	@Getter
	@Setter
	boolean sameTime;
	@Getter
	@Setter
	boolean sameSize;
	@Getter
	@Setter
	boolean missingIn2;

	public DiffFile(VFile vFile1, VFile vFile2) {
		this.setVFile1(vFile1);
		this.setVFile2(vFile2);
		this.setSameSize(vFile1.sameSize(vFile2));
		this.setSameTime(vFile1.sameTime(vFile2));
	}

	public DiffFile(VFile vFile) {
		this.setVFile1(vFile);
		this.setMissingIn2(true);
	}

	@Override
	public String toString() {
		return (this.isSameTime() ? "=" : "T") + (this.isSameSize() ? "=" : "S") + (this.isMissingIn2() ? "M " : "= ")
				+ this.getVFile1() + " " + this.getVFile2();
	}

	public boolean hasDiff() {
		return !this.isSameSize() || !this.isSameTime() || this.isMissingIn2();
	}

	public boolean binaryEqual() {
		boolean equal = false;
		if (this.sameSize) {
			equal = true;
			try {
				FileAssert.assertBinaryEquals(this.getVFile1().getFile(), this.getVFile2().getFile());
			} catch (junit.framework.AssertionFailedError afe) {
				equal = false;
			}
		}
		return equal;
	}

}

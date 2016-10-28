package com.javarush.test.level31.lesson15.big01;

public class FileProperties {
	private String name;
	private long size;
	private long compressedSize;
	private int compressionMethod;

	public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
		this.name = name;
		this.size = size;
		this.compressedSize = compressedSize;
		this.compressionMethod = compressionMethod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getCompressedSize() {
		return compressedSize;
	}

	public void setCompressedSize(long compressedSize) {
		this.compressedSize = compressedSize;
	}

	public int getCompressionMethod() {
		return compressionMethod;
	}

	public void setCompressionMethod(int compressionMethod) {
		this.compressionMethod = compressionMethod;
	}

	public long getCompressionRatio() {
		return 100 - ((compressedSize * 100) / size);
	}

	@Override
	public String toString() {
		if (size > 0)
			return String.format("%s %f Kb(%f Kb) сжатие: %d%%", name, size / 1024 * 1.0f, compressedSize / 1024 * 1.0f, getCompressionRatio());
		else return name;
	}
}
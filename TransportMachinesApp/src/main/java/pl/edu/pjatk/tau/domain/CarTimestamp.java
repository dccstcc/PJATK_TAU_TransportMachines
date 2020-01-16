package pl.edu.pjatk.tau.domain;

import java.time.LocalDateTime;

public class CarTimestamp extends Car{

	private LocalDateTime readTimestamp;
	private LocalDateTime writeTimestamp;
	private LocalDateTime updateTimestamp;
	private boolean isActiveReadTS;
	private boolean isActiveWriteTS;
	private boolean isActiveUpdateTS;
	
	public LocalDateTime getReadTimestamp() {
		return readTimestamp;
	}
	public void setReadTimestamp(LocalDateTime readTimestamp) {
		this.readTimestamp = readTimestamp;
	}
	public LocalDateTime getWriteTimestamp() {
		return writeTimestamp;
	}
	public void setWriteTimestamp(LocalDateTime writeTimestamp) {
		this.writeTimestamp = writeTimestamp;
	}
	public LocalDateTime getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public boolean isActiveReadTS() {
		return isActiveReadTS;
	}
	public void setActiveReadTS(boolean isActiveReadTS) {
		this.isActiveReadTS = isActiveReadTS;
	}
	public boolean isActiveWriteTS() {
		return isActiveWriteTS;
	}
	public void setActiveWriteTS(boolean isActiveWriteTS) {
		this.isActiveWriteTS = isActiveWriteTS;
	}
	public boolean isActiveUpdateTS() {
		return isActiveUpdateTS;
	}
	public void setActiveUpdateTS(boolean isActiveUpdateTS) {
		this.isActiveUpdateTS = isActiveUpdateTS;
	}
	
	
}

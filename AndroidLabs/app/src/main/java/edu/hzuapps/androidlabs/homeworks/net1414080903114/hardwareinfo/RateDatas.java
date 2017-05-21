package edu.hzuapps.androidlabs.homeworks.net1414080903114.hardwareinfo;

public class RateDatas {
	private float readRate, writeRate, uploadRate, downloadRate;
	public RateDatas(){}
	public void setReadR(float readR){
		this.readRate = readR;
	}
	public float getReadR(){
		return this.readRate;
	}
	public void setWriteR(float writeR){
		this.writeRate = writeR;
	}
	public float getWriteR(){
		return this.writeRate;
	}
	public void setUploadR(float uploadR){
		this.uploadRate = uploadR;
	}
	public float getUploadR(){
		return this.uploadRate;
	}
	public void setDownloadR(float downloadR){
		this.downloadRate = downloadR;
	}
	public float getDownloadR(){
		return this.downloadRate;
	}
	
}

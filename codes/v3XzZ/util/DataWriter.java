package v3XzZ.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Project: mFC
 * 
 * Class: DataWriter
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class DataWriter {
	
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    DataOutputStream data;
	
	public DataWriter() {
		this.data = new DataOutputStream(this.bos);
	}
	
	public void addByte(byte value){
		try {
			this.data.writeByte(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addInt(int value){
		try {
			this.data.writeInt(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DataWriter addBoolean(boolean value){
		try {
			this.data.writeBoolean(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public DataWriter addFloat(float value){
		try {
			this.data.writeFloat(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public void addDouble(double value){
		try {
			this.data.writeDouble(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DataWriter addString(String value){
		try {
			this.data.writeUTF(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public DataWriter addLong(long value){
		try {
			this.data.writeLong(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public byte[] finalizeData(){
		return this.bos.toByteArray();
	}
}

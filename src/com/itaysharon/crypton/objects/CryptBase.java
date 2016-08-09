package com.itaysharon.crypton.objects;

public class CryptBase {

	Header header;
	Body body;
	Checksum checksum;
	
	public CryptBase(Header header, Body body, Checksum checksum) {
		this.header = header;
		this.body = body;
		this.checksum = checksum;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Checksum getChecksum() {
		return checksum;
	}

	public void setChecksum(Checksum checksum) {
		this.checksum = checksum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((checksum == null) ? 0 : checksum.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CryptBase other = (CryptBase) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (checksum == null) {
			if (other.checksum != null)
				return false;
		} else if (!checksum.equals(other.checksum))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CryptBase [header=" + header + ", body=" + body + ", checksum=" + checksum + "]";
	}
}

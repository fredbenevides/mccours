package com.fredbenevides.cursomc.domain.enums;

public enum ClientType {

	NATURALPERSON(1, "Natural Person"), LEGALPERSON(2, "Legal Person");

	private int code;
	private String description;

	private ClientType(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static ClientType toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (ClientType x : ClientType.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid id: " + code);
	}

}
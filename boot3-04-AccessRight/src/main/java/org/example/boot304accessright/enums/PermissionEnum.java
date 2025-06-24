package org.example.boot304accessright.enums;

public enum PermissionEnum {
	USER_ADD("user:add"),
	USER_VIEW("user:view"),
	USER_DELETE("user:delete");

	public String getCode() {
		return code;
	}

	PermissionEnum(String code) {
		this.code = code;
	}

	private final String code;
}

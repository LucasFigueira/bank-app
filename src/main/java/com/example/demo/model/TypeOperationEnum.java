package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeOperationEnum {

	WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT");

	private String value;

	TypeOperationEnum(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static TypeOperationEnum fromValue(String text) {
		for (TypeOperationEnum b : TypeOperationEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}

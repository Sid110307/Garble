package com.sid.garble;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static java.util.Base64.getEncoder;

public class Encrypt {

	static String encryptedValue = "";

	public static void TextEncryption(@NotNull JTextField input, JTextArea output) {
		encryptedValue = "Encrypted Text: " + getEncoder().encodeToString(
				input.getText().getBytes());
		output.append(encryptedValue + "\n");
	}

	public static void FileEncryption(@NotNull JTextField input, JTextArea output) {
		encryptedValue = getEncoder().encodeToString(input.getText().getBytes());
		Main.write("encrypted.txt", Main.currentDateTime + encryptedValue);
		output.append("Encrypted!\n");
	}
}

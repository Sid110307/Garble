package com.sid.garble;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static java.util.Base64.getDecoder;

public class Decrypt {

	static String decryptedValue = "";

	public static void TextDecryption(@NotNull JTextField input, JTextArea output) {
		decryptedValue = "Decrypted Text: " + new String(getDecoder().decode(input.getText()));
		output.append(decryptedValue);
	}

	public static void FileDecryption(@NotNull JTextField input, JTextArea output) {
		decryptedValue = new String(getDecoder().decode(input.getText()));
		Main.write("decrypted.txt", Main.currentDateTime + decryptedValue);
		output.append("Decrypted!\n");
	}
}

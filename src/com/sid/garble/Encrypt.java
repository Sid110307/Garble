package com.sid.garble;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.util.Base64.getEncoder;

public class Encrypt {
	static String encryptedValue = "";

	public static void TextEncryption(@NotNull JTextField input, JTextArea output) {
		encryptedValue = getEncoder().encodeToString(input.getText().getBytes());
		output.append(Main.currentDateTime + "Original: " + input.getText() + "\nEncrypted: " + encryptedValue +
				"\n----------\n\n");
	}

	public static void FileEncryption(@NotNull JTextField input, JTextArea output) {
		encryptedValue = getEncoder().encodeToString(input.getText().getBytes());
		Main.write("garble-encrypt.txt", Main.currentDateTime + "Original: " + input.getText() +
				"\nEncrypted: " + encryptedValue + "\n----------");
		output.append("Encrypted!\n");
	}

	public static void FromFileEncryption(@NotNull JTextArea output) {
		try {
			JFileChooser chooser = new JFileChooser();

			if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				System.out.println("Cancelled encryption.");
			}
			else {
				File file = chooser.getSelectedFile();

				BufferedReader in = new BufferedReader(new FileReader(file));
				String line = in.readLine();
				StringBuilder content = new StringBuilder();

				while (line != null) {
					content.append(line.trim());
					line = in.readLine();
				}

				encryptedValue = getEncoder().encodeToString(content.toString().getBytes());
				output.append(Main.currentDateTime + "Original: " + content + "\nEncrypted: " + encryptedValue +
						"\n----------\n\n");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
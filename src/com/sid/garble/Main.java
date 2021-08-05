package com.sid.garble;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

	public static String currentDateTime = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss")
			.format(new Date());

	public static String releaseNotes =
			"""
			v0.8   - Redesigned GUI and modified credits screen.
			v0.7   - Date and Time for Encrypted/Decrypted data.
			v0.6   - File appending instead of replacing data.
			v0.5   - Optimizations and Bug fixes.
			v0.45  - Created GUI.
			v0.4   - Fixed a Bug where the data was not saving if the file exists.
			v0.3   - Added option to encrypt and decrypt to files.
			v0.25  - Better Encoding/Decoding using Base64.
			v0.2   - Made tabular layout for options.
			v0.15  - Added Base32 Decryption.
			v0.1   - Initial Beta Release. Added Base32 Encryption.
			v0.0.7 - Encryption and Decryption with Character shuffles (Courtesy of GoralKBS).
			v0.0.5 - Added text and number decryption.
			v0.0.3 - Added credits page.
			v0.0.2 - Simple text and number encryption with text replacing.
			v0.0.1 - Initial Alpha Release of Garble.
			""";
	public JPanel root;
	public JTextArea output;
	public JTextField input;
	public JButton textEncryption;
	public JButton textDecryption;
	public JButton fileEncryption;
	public JButton fileDecryption;
	public JButton credits;

	public Main() {
		input.requestFocus();
		output.setEditable(false);

		textEncryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), ""))
				Encrypt.TextEncryption(input, output);
			else JOptionPane.showMessageDialog(null,
					"Please enter text in the input field.");
		});

		textDecryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), ""))
				Decrypt.TextDecryption(input, output);
			else JOptionPane.showMessageDialog(null,
					"Please enter text in the input field.");
		});

		fileEncryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), ""))
				Encrypt.FileEncryption(input, output);
			else JOptionPane.showMessageDialog(null,
					"Please enter text in the input field.");
		});

		fileDecryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), ""))
				Decrypt.FileDecryption(input, output);
			else JOptionPane.showMessageDialog(null,
					"Please enter text in the input field.", "Error", JOptionPane.ERROR_MESSAGE);
		});

		credits.addActionListener(e ->
				JOptionPane.showMessageDialog(null, "Garble is a tool developed by Siddharth P " +
						"Bharadwaj to encrypt and decrypt text. You can also encrypt and decrypt to files.\n" +
						"This tool used the 'Base64' encoding method. For more information, contact me at " +
						"siddharthpb2007@gmail.com.\n\nRelease notes:\n" + releaseNotes + "\n\nLatest Version: v0.8",
				"About Garble", JOptionPane.INFORMATION_MESSAGE));
	}

	public static void main(String[] args) {
		JFrame main = new JFrame("Garble - Encryption and Decryption");
		main.setContentPane(new Main().root);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setMinimumSize(new Dimension(400, 300));
		main.pack();
		main.setVisible(true);
	}

	public static void write(String fileName, String s) {
		try {
			Files.writeString(Path.of("./", fileName),
					s + System.lineSeparator(), CREATE, APPEND
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

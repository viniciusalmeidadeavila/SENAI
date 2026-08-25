package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SegurancaSenha {

    // Criptografa a senha
    public static String criptografar(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar senha", e);
        }
    }

    // Valida se a senha atende aos requisitos
    public static boolean isSenhaValida(String senha) {
        // Mínimo de 13 dígitos
        return senha != null && senha.length() >= 13;
    }
}
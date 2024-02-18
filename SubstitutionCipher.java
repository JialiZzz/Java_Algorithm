import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubstitutionCipher {
    private StringBuilder randomUppercaseString;

    public SubstitutionCipher() {
        List<Character> uppercaseLetters = new ArrayList<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            uppercaseLetters.add(ch);
        }
        // 打乱字母顺序
        Collections.shuffle(uppercaseLetters);

        // 构建字符串
        randomUppercaseString = new StringBuilder();
        for (char ch : uppercaseLetters) {
            randomUppercaseString.append(ch);
        }
    }

    public String encode(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char newChar = (char) (message.charAt(i) - randomUppercaseString.charAt(i % randomUppercaseString.length()));
            encryptedMessage.append(newChar);
        }
        return encryptedMessage.toString();
    }

    public String decode(String message) {
        StringBuilder decodedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char newChar = (char) (message.charAt(i) + randomUppercaseString.charAt(i % randomUppercaseString.length()));
            decodedMessage.append(newChar);
        }
        return decodedMessage.toString();
    }

    public static void main(String[] args) {
        SubstitutionCipher sc = new SubstitutionCipher();
        String sb = "ABCDEF";
        String encrypted = sc.encode(sb);
        System.out.println("encrypted：" + encrypted);

        String decrypted = sc.decode(encrypted);
        System.out.println("decrypted：" + decrypted);
    }
}

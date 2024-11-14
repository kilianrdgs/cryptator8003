package org.example;

public class Enigma {

    public static void crypt(String input, String key) {
        StringBuilder resultWord = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // Transformer chaque lettre en utilisant modifyChar et ajouter le résultat à resultWord
            String transformedChar = modifyChar(String.valueOf(ch), key);
            resultWord.append(transformedChar);
        }

        System.out.println("Mot transformé : " + resultWord.toString());
    }

    public static void decrypt(String messageCrypted, String key){
            crypt(messageCrypted, key);
    }

    private static String modifyChar(String input, String key) {
        String result = input;
        for (int i = 0; i < key.length(); i++) {
            char rollPosition = key.charAt(i); // Utiliser le caractère de `key` directement
            result = roll(result, String.valueOf(rollPosition));
            System.out.println("entrée du roll lettre : " + input + " Roll Position sur la lettre: " + rollPosition + " sortie du roll lettre : " + result);
        }
        // Appliquer une seule fois le miroir après les transformations
        result = modifyCharMirror(result, key);
        return result;
    }

    private static String modifyCharMirror(String input, String key) {
        StringBuilder resultMirror = new StringBuilder();
        String keyMirror = new StringBuilder(key).reverse().toString();

        char charMirror = inverseChar(input.charAt(0));
        System.out.println("mirror input : " + charMirror);
        System.out.println("mirror input : " + keyMirror);
        // Passer le caractère inversé à travers les rouleaux en utilisant la clé inversée
        String transformedMirror = String.valueOf(charMirror);
        for (int i = 0; i < keyMirror.length(); i++) {
            char rollPosition = keyMirror.charAt(i);
            transformedMirror = roll(transformedMirror, String.valueOf(rollPosition));
            System.out.println(transformedMirror);
        }
        return transformedMirror;
    }

    private static String roll(String input, String rollPosition){
        String[] alphabetInput = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; // ALPHABET entrée reste toujours fixe
        String output = "";
        int index = -1;
        String[] alphabetOutput = {}; // déclaration alphabet de sortie

        for (int i = 0; i < alphabetInput.length; i++) { //boucle pour faire correpsondre l'index à la lettre en entrée
            if (alphabetInput[i].equals(input)) {
                index = i;
                break;
            }


        }

        alphabetOutput = switch (rollPosition) {
            case "a" -> new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            case "b" -> new String[]{"b", "a", "d", "c", "f", "e", "h", "g", "j", "i", "l", "k", "n", "m", "p", "o", "r", "q", "t", "s", "v", "u", "x", "w", "z", "y"};
            case "c" -> new String[]{"c", "d", "e", "f", "g", "h", "a", "b", "j", "i", "l", "k", "n", "m", "p", "o", "r", "q", "t", "s", "u", "v", "x", "w", "y", "z"};
            case "d" -> new String[]{"d", "e", "f", "g", "h", "a", "b", "c", "k", "j", "m", "l", "o", "n", "q", "p", "s", "r", "u", "t", "w", "v", "y", "x", "z", "a"};
            case "e" -> new String[]{"e", "f", "g", "h", "a", "b", "c", "d", "l", "m", "i", "j", "p", "o", "n", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a"};
            case "f" -> new String[]{"f", "g", "h", "a", "b", "c", "d", "e", "m", "n", "j", "i", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b"};
            case "g" -> new String[]{"g", "h", "a", "b", "c", "d", "e", "f", "n", "o", "k", "l", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c"};
            case "h" -> new String[]{"h", "a", "b", "c", "d", "e", "f", "g", "o", "p", "l", "m", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d"};
            case "i" -> new String[]{"i", "j", "k", "l", "m", "n", "o", "p", "q", "a", "b", "c", "d", "e", "f", "g", "h", "t", "u", "v", "w", "x", "y", "z", "g", "d"};
            case "j" -> new String[]{"j", "k", "l", "m", "n", "o", "p", "q", "a", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h"};
            case "k" -> new String[]{"k", "l", "m", "n", "o", "p", "q", "r", "b", "c", "d", "e", "f", "g", "h", "i", "j", "s", "t", "u", "v", "w", "x", "y", "z", "a"};
            case "l" -> new String[]{"l", "m", "n", "o", "p", "q", "r", "s", "c", "d", "e", "f", "g", "h", "i", "j", "k", "t", "u", "v", "w", "x", "y", "z", "a", "b"};
            case "m" -> new String[]{"m", "n", "o", "p", "q", "r", "s", "t", "d", "e", "f", "g", "h", "i", "j", "k", "l", "u", "v", "w", "x", "y", "z", "a", "b", "c"};
            case "n" -> new String[]{"n", "o", "p", "q", "r", "s", "t", "u", "e", "f", "g", "h", "i", "j", "k", "l", "m", "v", "w", "x", "y", "z", "a", "b", "c", "d"};
            case "o" -> new String[]{"o", "p", "q", "r", "s", "t", "u", "v", "f", "g", "h", "i", "j", "k", "l", "m", "n", "w", "x", "y", "z", "a", "b", "c", "d", "e"};
            case "p" -> new String[]{"p", "q", "r", "s", "t", "u", "v", "w", "g", "h", "i", "j", "k", "l", "m", "n", "o", "x", "y", "z", "a", "b", "c", "d", "e", "f"};
            case "q" -> new String[]{"q", "r", "s", "t", "u", "v", "w", "x", "h", "i", "j", "k", "l", "m", "n", "o", "p", "y", "z", "a", "b", "c", "d", "e", "f", "g"};
            case "r" -> new String[]{"r", "s", "t", "u", "v", "w", "x", "y", "i", "j", "k", "l", "m", "n", "o", "p", "q", "z", "a", "b", "c", "d", "e", "f", "g", "h"};
            case "s" -> new String[]{"s", "t", "u", "v", "w", "x", "y", "z", "j", "k", "l", "m", "n", "o", "p", "q", "r", "a", "b", "c", "d", "e", "f", "g", "h", "i"};
            case "t" -> new String[]{"t", "u", "v", "w", "x", "y", "z", "a", "k", "l", "m", "n", "o", "p", "q", "r", "s", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
            case "u" -> new String[]{"u", "v", "w", "x", "y", "z", "a", "b", "l", "m", "n", "o", "p", "q", "r", "s", "t", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
            case "v" -> new String[]{"v", "w", "x", "y", "z", "a", "b", "c", "m", "n", "o", "p", "q", "r", "s", "t", "u", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
            case "w" -> new String[]{"w", "x", "y", "z", "a", "b", "c", "d", "n", "o", "p", "q", "r", "s", "t", "u", "v", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
            case "x" -> new String[]{"x", "y", "z", "a", "b", "c", "d", "e", "o", "p", "q", "r", "s", "t", "u", "v", "w", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
            case "y" -> new String[]{"y", "z", "a", "b", "c", "d", "e", "f", "p", "q", "r", "s", "t", "u", "v", "w", "x", "g", "h", "i", "j", "k", "l", "m", "n", "o"};
            case "z" -> new String[]{"z", "a", "b", "c", "d", "e", "f", "g", "q", "r", "s", "t", "u", "v", "w", "x", "y", "h", "i", "j", "k", "l", "m", "n", "o", "p"};

            default -> {
                System.out.println("Position non valide");
                yield new String[]{};
            }
        };

        output = alphabetOutput[index]; // attribue la lettre correspondant à l'index du tableau

        return output;
    }

    public static char inverseChar(char ch) {
            return (char) ('z' - (ch - 'a')); // Calcul de l'inverse
    }
}
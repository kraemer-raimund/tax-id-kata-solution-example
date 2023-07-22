package org.example.tax;

import java.util.stream.IntStream;

final class TaxId {

    public static TaxId parse(String internalValue) throws IllFormedTaxIdException {
        if (!internalValue.matches("[1-9][0-9]{10}")
                || !areAllButOneUnique(internalValue.substring(0, 10))
                || maxDigitOccurrences(internalValue.substring(0, 10)) > 3
                || maxConsecutiveDigitOccurrences(internalValue.substring(0, 10)) > 2
                || !isCheckDigitCorrect(internalValue)) {
            throw new IllFormedTaxIdException(internalValue);
        }

        return null;
    }

    private static boolean areAllButOneUnique(String digits) {
        long nonUniqueDigits = IntStream.rangeClosed('0', '9')
                .map(digit -> countOccurrences(digits, (char) digit))
                .filter(occurrences -> occurrences > 1)
                .count();

        return nonUniqueDigits == 1;
    }

    private static int maxDigitOccurrences(String digits) {
        return IntStream.rangeClosed('0', '9')
                .map(digit -> countOccurrences(digits, (char) digit))
                .max()
                .orElse(0);
    }

    private static int maxConsecutiveDigitOccurrences(String digits) {
        if (digits.isEmpty()) {
            return 0;
        }

        int maxConsecutiveDigitOccurrences = 1;
        int currentDigitOccurrences = 1;
        char currentDigit = digits.charAt(0);

        for (int i = 1; i < digits.length(); i++) {
            if (digits.charAt(i) == currentDigit) {
                currentDigitOccurrences++;
            } else {
                maxConsecutiveDigitOccurrences = Math.max(
                        currentDigitOccurrences, maxConsecutiveDigitOccurrences);
                currentDigit = digits.charAt(i);
                currentDigitOccurrences = 1;
            }
        }

        return maxConsecutiveDigitOccurrences;
    }

    private static int countOccurrences(String string, char character) {
        return (int) string.chars()
                .filter(c -> c == character)
                .count();
    }

    private static boolean isCheckDigitCorrect(String taxId) {
        final var checkDigit = Integer.parseInt(taxId.substring(10, 11));
        return checkDigit == calculateCheckDigit(taxId.substring(0, 10));
    }

    /**
     * @return the check digit according to ISO/IEC 7064, MOD 11,10
     */
    private static int calculateCheckDigit(String digits) {
        var product = 10;

        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.substring(i, i + 1));
            var sum = (digit + product) % 10;
            if (sum == 0) {
                sum = 10;
            }
            product = (sum * 2) % 11;
        }

        return (11 - product) % 10;
    }
}

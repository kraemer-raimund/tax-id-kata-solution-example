package org.example.tax;

import java.util.stream.IntStream;

final class TaxId {

    public static TaxId parse(String internalValue) throws IllFormedTaxIdException {
        if (!internalValue.matches("[1-9][0-9]{10}")) {
            throw new IllFormedTaxIdException(internalValue);
        }

        if (!areAllButOneUnique(internalValue.substring(0, 10))) {
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

    private static int countOccurrences(String string, char character) {
        return (int) string.chars()
                .filter(c -> c == character)
                .count();
    }
}

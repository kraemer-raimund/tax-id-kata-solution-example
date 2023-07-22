package org.example.tax;

final class TaxId {

    public static TaxId parse(String internalValue) throws IllFormedTaxIdException {
        if (internalValue.isEmpty()) {
            throw new IllFormedTaxIdException(internalValue);
        }

        if (internalValue.length() != 11) {
            throw new IllFormedTaxIdException(internalValue);
        }

        for (final var character : internalValue.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllFormedTaxIdException(internalValue);
            }
        }

        return null;
    }
}

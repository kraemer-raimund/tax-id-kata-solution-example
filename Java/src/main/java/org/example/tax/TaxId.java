package org.example.tax;

final class TaxId {

    public static TaxId parse(String internalValue) throws IllFormedTaxIdException {
        if (!internalValue.matches("[1-9][0-9]{10}")) {
            throw new IllFormedTaxIdException(internalValue);
        }

        return null;
    }
}

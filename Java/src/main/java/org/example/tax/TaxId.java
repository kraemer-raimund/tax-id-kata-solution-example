package org.example.tax;

final class TaxId {

    public static TaxId parse(String internalValue) throws IllFormedTaxIdException {
        if (!internalValue.matches("[0-9]{11}")) {
            throw new IllFormedTaxIdException(internalValue);
        }

        return null;
    }
}

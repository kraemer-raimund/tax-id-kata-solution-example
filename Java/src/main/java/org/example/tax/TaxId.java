package org.example.tax;

final class TaxId {

    public static TaxId parse(String taxId) throws IllFormedTaxIdException {
        if (taxId.isEmpty()) {
            throw new IllFormedTaxIdException(taxId);
        }

        if (taxId.length() != 11) {
            throw new IllFormedTaxIdException(taxId);
        }

        for (final var character : taxId.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllFormedTaxIdException(taxId);
            }
        }

        return null;
    }
}

package org.example.tax;

final class TaxId {

    public static TaxId parse(String taxId) throws IllFormedTaxIdException {
        if (taxId.isEmpty()) {
            throw new IllFormedTaxIdException(taxId);
        }

        return null;
    }
}

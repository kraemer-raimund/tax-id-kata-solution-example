package org.example.tax;

final class TaxId {

    public static TaxId parse(String taxId) throws IllFormedTaxIdException {
        throw new IllFormedTaxIdException(taxId);
    }
}

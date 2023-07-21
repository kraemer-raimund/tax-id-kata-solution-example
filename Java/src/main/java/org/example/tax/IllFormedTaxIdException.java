package org.example.tax;

final class IllFormedTaxIdException extends Exception {

    public IllFormedTaxIdException(String providedValue) {
        super("`%s` is not a well-formed tax ID.".formatted(providedValue));
    }
}

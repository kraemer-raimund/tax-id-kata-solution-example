package org.example.tax;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

final class TaxIdTest {

    @Test
    void empty_string_is_not_valid() {
        assertThatExceptionOfType(IllFormedTaxIdException.class)
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse("");
                });
    }
}

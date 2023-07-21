package org.example.tax;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

final class TaxIdTest {

    @Test
    void empty_string_is_not_valid() {
        assertThatExceptionOfType(IllFormedTaxIdException.class)
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse("");
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "11345678904",
            "13345678906",
            "12445678907",
            "12345698991"
    })
    void is_valid(String taxIdInput) {
        assertThatNoException()
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse(taxIdInput);
                });
    }
}

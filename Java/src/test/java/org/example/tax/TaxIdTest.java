package org.example.tax;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

final class TaxIdTest {

    @Test
    void a_well_formed_tax_ID_cannot_be_empty() {
        assertThatExceptionOfType(IllFormedTaxIdException.class)
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse("");
                });
    }

    @Test
    void a_well_formed_tax_ID_must_be_exactly_11_characters_long() {
        assertThatExceptionOfType(IllFormedTaxIdException.class)
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse("12345");
                });
    }

    @Test
    void a_well_formed_tax_ID_can_only_contain_digits() {
        assertThatExceptionOfType(IllFormedTaxIdException.class)
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse("abc 123 $%&");
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "11345678904",
            "13345678906",
            "12445678907",
            "12345698991"
    })
    void is_well_formed(String taxIdInput) {
        assertThatNoException()
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse(taxIdInput);
                });
    }
}

package org.example.tax;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

final class TaxIdTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "12345",
            "abc 123 $%&"
    })
    void a_well_formed_tax_ID_must_contain_exactly_11_digits_and_nothing_else(String taxIdInput) {
        assertThatExceptionOfType(IllFormedTaxIdException.class)
                .isThrownBy(() -> {
                    final var taxId = TaxId.parse(taxIdInput);
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

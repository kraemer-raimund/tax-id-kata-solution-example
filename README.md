# Tax ID Kata

A coding kata that focuses on encapsulation and domain-driven design.

## Design Goals

- If I create or receive a tax ID object, it is just that: A tax ID, not a string or something else.
- The creation of the object fails if it would be based on ill-formed input (user input, file input, network response, etc.).
- As the caller/user of the object, I *don't know and don't want to know* what is inside of it (strings, numbers, algorithms, rules). I can use it "as is".
- A tax ID can be converted to a human-readable string representation, but the resulting string *is not itself* the tax ID.

### Discuss with your peers: What is the main purpose of any ID?
<details>
<summary>Reveal answer</summary>

An ID's main (and often only) purpose is to provide a way to check two **entities** for **identity** (from Latin: "this entity"/"this being"). Often an ID object's only method is `equals()`, thus fulfilling its only purpose. An identity is **inherently immutable**.

An entity's identity is a domain concept, and often separate from the **technical ID** that might be used e.g. by a database.

</details>

## Requirements

- A well-formed tax ID consists of exactly 11 digits.
- The first digit must not be 0.
- In the first 10 digits, one digit occurs either 2 or 3 times, but never 3 times in a row. The other digits are unique.
- The last digit is a check digit which is calculated from the first 10 digits according to the ISO/IEC 7064, MOD 11,10 standard:
  - Start with a "product" of 10.
  - For each of the first 10 digits, update the product as follows:
    ```
    sum := (current_digit + product) MOD 10;
    if sum = 0 then sum := 10;
    product := (sum * 2) MOD 11;
    ```
  - At the end the check digit is the result of `(11 - product) MOD 10`.

Some examples of well-formed IDs (last digit is check digit):
```
11345678904
13345678906
12445678907
12345698991
```

___

© 2023 Raimund Krämer - Use with attribution.

Links to third party sites are included for convenience only and I am not responsible for their contents.

### Hexlet tests and linter status:
[![Actions Status](https://github.com/NastasiyaT/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/NastasiyaT/java-project-78/actions) [![Java CI](https://github.com/NastasiyaT/java-project-78/actions/workflows/java-ci-check.yml/badge.svg?branch=main)](https://github.com/NastasiyaT/java-project-78/actions/workflows/java-ci-check.yml) [![Maintainability](https://api.codeclimate.com/v1/badges/cf2f9fd9a847541c038c/maintainability)](https://codeclimate.com/github/NastasiyaT/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/cf2f9fd9a847541c038c/test_coverage)](https://codeclimate.com/github/NastasiyaT/java-project-78/test_coverage)

### About the project:
It represents a simple schema builder for object validation. Three schemas are available: `StringSchema`, `NumberSchema` and `MapSchema`. They can check if the object isn't empty but also have different features according to the type of an object to validate. You can use all methods in the scheme at once or separately.

#### StringSchema
Schema to validate **String.class** objects. It has two specific methods:
- to define minimum length of the line,
- to verify that the line contains certain symbol or phrase.

#### NumberSchema
Schema to validate **Integer.class** objects. It also has two specific methods:
- to check if the number is positive,
- to verify that the number falls within the defined range.

#### MapSchems
Schema to validate **Map.class** objects. It has two additional methods:
- to define total number of entries,
- to validate entry values according to the schema chosen specifically for every key.
